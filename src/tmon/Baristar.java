package tmon;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Baristar implements BaristarImpl {
	int current_state = 0;
	int americano, espresso, juice, latte;
	String menu;
	int time, count;
	LinkedHashMap<String, Integer> time_table;
	List<LinkedHashMap<String, Object>> order_list = new ArrayList<LinkedHashMap<String, Object>>();
	public Baristar(LinkedHashMap<String, Integer> time_table) {
		this.time_table = time_table;
	}
	@Override
	public void addOrder(LinkedHashMap<String, Object> order_map) {
		this.order_list.add(order_map);
	}
	@Override
	public void currentStatePrint() {
		
	}
	@Override
	public void makeProduct() {
		if (order_list.size() == 0) {
			System.out.println("쉬는 중입니다.");
			return;
		}
		time--;
		if (time == 0) {
			System.out.println("주문하신 " + menu + " " + order_list.get(0).get("count") + "잔 나왔습니다. ");
			order_list.remove(0);	
			if (order_list.size() == 0 ) return;
			menu = (String) order_list.get(0).get("beverageID");
			count = (int) order_list.get(0).get("count");
			time = time_table.get(menu) * count;
		} else {
			System.out.println(menu + "를 만드는 중입니다.");
		}
	}
	@Override
	public void ready() {
		if (order_list.size() == 0) return;
		menu = (String) order_list.get(0).get("beverageID");
		count = (int) order_list.get(0).get("count");
		time = time_table.get(menu) * count;
	}
}
