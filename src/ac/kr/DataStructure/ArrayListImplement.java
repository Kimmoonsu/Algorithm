package ac.kr.DataStructure;

public class ArrayListImplement {
	final static int MAX_SIZE = 100;
	private int[] data;
	int length;
	
	public ArrayListImplement()
	{
		super();
		this.length = 0;
		data = new int[MAX_SIZE];
	}
	public ArrayListImplement(int size)
	{
		this.length = 0;
		data = new int[size];
	}
	
	public void add(int data)
	{
		int size = this.data.length;
		if (this.length == size)
			copyArray(data, size);
		else
			this.data[this.length] = data;
		this.length++;
	}
	public void add(int index, int data)
	{
		int size = this.data.length;
		if (this.length == size)
			copyArrayWithIndex(index, data, size);
		else
		{
			for (int i = this.length-1; i > index-1; i--)
				this.data[i+1] = this.data[i];
			this.data[index] = data;
		}
		this.length ++;
	}
	private void copyArray(int data, int size)
	{
		int newSize  = size + 1;
		int[] newArray = new int[newSize];
		newArray[newSize-1] = data;
		for (int i = 0 ; i < size; i ++)
			newArray[i] = this.data[i];
		this.data = new int[newSize];
		for (int i = 0 ; i < newArray.length; i++)
			this.data[i] = newArray[i];
	}
	private void copyArrayWithIndex(int index, int data, int size)
	{
		int newSize = size + 1;
		int[] newArray = new int[newSize];
		
		newArray[index-1] = data;
		//인덱스를 중심으로 이전데이터 복사
		for (int i = 0 ; i < index-1; i++)
			newArray[i] = this.data[i];
		//인덱스를 중심으로 이후데이터 복사
		for (int i = newSize-1; i > index-1; i--)
			newArray[i] = this.data[i-1];
		
		this.data = new int[newSize];
		
		for (int i = 0 ; i < newArray.length; i++)
			this.data[i] = newArray[i];
	}
	public int get(int index)
	{
		return this.data[index];
	}
	
	public static void main(String[] args) {
		ArrayListImplement arr = new ArrayListImplement();
		arr.add(0);
		arr.add(1);
		arr.add(3);
		arr.add(2,2);
		for (int i = 0 ; i < arr.length; i ++)
			System.out.println(" i : " + i + " " + arr.get(i));
		
	}
}
