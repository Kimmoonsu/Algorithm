import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class test {
	static int MAX_N = 1001;
	static int MAX_M = 100001;
	static int N;
	static int M;
	static int START;
	static int END;
	static Node[] NODES = new Node[MAX_N];
	static PriorityQueue<Node> Q = new PriorityQueue<Node>(MAX_N,
			new Comparator<Node>() {
				public int compare(Node node1, Node node2) {
					return node1.distance - node2.distance;
				}
			});
	static class Edge {
		Node to;
		int weigth;
		Edge(Node to, int weight) {
			this.to = to;
			this.weigth = weight;
		}
	}
	static class Node {
		int index;
		int distance = Integer.MAX_VALUE;
		List<Edge> edges = new ArrayList<Edge>();
		Node(int index) {
			this.index = index;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		for (int i = 0; i <= N; i++) {
			NODES[i] = new Node(i);
		}
		for (int row = 0; row < M; row++)
		{
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weigth = sc.nextInt();
			NODES[from].edges.add(new Edge(NODES[to],weigth));
		}
		START = sc.nextInt();
		END = sc.nextInt();
		NODES[START].distance = 0;
//		Q.add(NODES[START]);1
//		while (!Q.isEmpty()) {
//			Node node = Q.poll();
//			for (Edge edge : node.edges) {
//				Node next = edge.to;
//				if (next.distance > node.distance + edge.weigth) {
//					next.distance = node.distance + edge.weigth;
//					Q.add(next);
//				}
//			}
//		}
		Q.add(NODES[START]);
		while (!Q.isEmpty())
		{
			Node node = Q.poll();
			System.out.println("size : " +node.edges.size());
			System.out.println("node index : " + node.index);
			for (Edge edge : node.edges) {
				Node next = edge.to;
				System.out.println("to distance : " +next.distance);
				System.out.println("me distance : " + node.distance);
				System.out.println("to weigth : " + edge.weigth);
				if (next.distance > node.distance + edge.weigth) {
					next.distance = node.distance + edge.weigth;
					System.out.println("change to distance: " + next.distance);
					Q.add(next);
				}
			}
		}
		//System.out.println(NODES[END].distance);
	}
}
