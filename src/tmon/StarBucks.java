package tmon;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


public class StarBucks implements Runnable {
	List<LinkedHashMap<String, Object>> order_list = new ArrayList<LinkedHashMap<String, Object>>();
	String[] menu = {"espresso", "americano", "juice", "latte"};
	int count[] = {3,2,1,4};		
	int time[][] = {
			{2,3,4,4},
			{2,4,5,4},
			{2,3,5,4},
			{2,3,5,5}
	};
	Baristar[] baristar;	
	void open() {
		System.out.println("Open StarBucks");
		baristar = new Baristar[4];
		addMenu(menu, count);
		for (int i = 0; i < 4; i++) {
			LinkedHashMap<String, Integer> time_table = new LinkedHashMap<String, Integer>();
			for (int j = 0; j < 4; j++) {
				time_table.put(menu[j], time[i][j]);
			}
			baristar[i] = new Baristar(time_table);
		}
		loadbalancing();
		run();
	}
	void loadbalancing() {
		System.out.println(order_list.toString());
		for (int i = 0 ; i < order_list.size(); i++) {
			baristar[i].addOrder(order_list.get(i));
		}
		for (int i = 0 ; i < 4; i ++) {
			baristar[i].ready();
		}
	}
	void close() {
		System.out.println("Close StarBucks");
	}
	
	void addMenu(String[] menu, int[] count) {
		for (int i = 0; i < menu.length; i++) {			
			LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
			map.put("beverageID", menu[i]);
			map.put("count", count[i]);
			order_list.add(map);
		}
	}
	void printView() {
		for (int i = 0 ; i < 4; i++) {
			switch (i) {
			case 0 : System.out.print("A : ");
			break;
			case 1 : System.out.print("B : ");
			break;
			case 2 : System.out.print("C : ");
			break;
			case 3 : System.out.print("D : ");
			break;
			}
//			System.out.println("의 상태");
			baristar[i].makeProduct();
			
		}
	}
	public static void main(String[] args) {
		new StarBucks().open();
	}
	@Override
	public void run() {
		int time = 0;
		while(time ++ < 30) {
			try {
				Thread.currentThread();
				Thread.sleep(1000);
				System.out.println("========"+time+"=========");
				printView();
				System.out.println("=================");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

