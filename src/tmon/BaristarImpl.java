package tmon;
import java.util.LinkedHashMap;


public interface BaristarImpl {
	void addOrder(LinkedHashMap<String, Object> menu);
	void currentStatePrint();
	void makeProduct();
	void ready();
}
