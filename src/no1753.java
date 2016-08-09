import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class no1753 {
	final int MAX_V= 20001;
	final int MAX_E= 300001;
	int START;
	int END;
	Node nodes[] = new Node[MAX_V];
	PriorityQueue<Node> Q = new PriorityQueue<Node>(MAX_E,
			new Comparator<Node>() {
				public int compare(Node node1, Node node2) {
					return node1.distance - node2.distance;
				}
			});

	class Node {
		List<Edge> edges = new ArrayList<Edge>();
		int index;
		int distance = Integer.MAX_VALUE;;

		Node(int index) {
			this.index = index;
		}
	}

	class Edge {
		Node to;
		int weight;

		Edge(Node to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}

	void init() throws Exception {
		FastScanner sc = new FastScanner();
		int N = sc.nextInt();
		int M = sc.nextInt();
		for (int i = 0; i <= N; i++)
			nodes[i] = new Node(i);
		START = sc.nextInt();
		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();
			nodes[from].edges.add(new Edge(nodes[to], weight));
		}
		//END = sc.nextInt();
		nodes[START].distance = 0;
		Q.add(nodes[START]);
		dijkstra();
		for (int i = 1; i <= N; i++)
			System.out.println(nodes[i].distance == Integer.MAX_VALUE? "INF" : nodes[i]);
	}

	void dijkstra() {
		while (!Q.isEmpty()) {
			Node node = Q.poll();
			for (Edge edge : node.edges) {
				Node next = edge.to;
				if (next.distance > node.distance + edge.weight) {
					next.distance = node.distance + edge.weight;
					Q.add(next);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		new no1753().init();
	}

	static class FastScanner {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int nextInt() throws Exception {
			if (st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(in.readLine());
			}
			return Integer.parseInt(st.nextToken());
		}
	}
}
