import java.util.Scanner;

public class no2605_2 {
	private int arr[];
	private int data[];
	private int size;
	public no2605_2()
	{
		
	}
	void init()
	{
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();
		arr = new int[size];
		data = new int[size];
		for (int i = 0; i< size; i ++)
			arr[i] = sc.nextInt();
	}
	void add(int index, int data)
	{
		for (int i = size-1; i > index; i--)
		{
			this.data[i] = this.data[i-1];
		}
		this.data[index] = data;
	}
	void func()
	{
		for (int i = 0 ; i < size; i ++)
		{
			add(i-arr[i], i+1);	
		}
		for (int j = 0 ; j < size; j ++)
			System.out.print(data[j] + " ");
		System.out.println();
	}
	public static void main(String[] args) {
		no2605_2 m = new no2605_2();
		m.init();
		m.func();
	}
}