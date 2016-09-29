
public class ThreadTest {
	public static boolean state = true;
	public static int cnt = 1;
	public static class CreateThread extends Thread implements Runnable {
		CreateThread() {}
		@Override
		public void run() {
			while (state) {
				System.out.println(cnt);
				cnt++;
				if (cnt == 10) state = false;
				
			}
		}
	}
	public static void main(String[] args) {
		CreateThread c_t = new CreateThread();
		c_t.start();
	}
}
