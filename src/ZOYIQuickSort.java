import java.util.Scanner;


public class ZOYIQuickSort {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int arr[] = new int[num];
		for (int i = 0 ; i < num; i++)
			arr[i] = sc.nextInt();
		Sorting s = new Sorting();
		s.quickSort(arr, 0, arr.length-1);
	}
}

class Sorting
{
	
	public int partition(int a[], int begin, int end)
	{
		int L, R, pivot;
		pivot = (begin + end)/2;
		L = begin;
		R = end;
		while(L < R)
		{
			while ((a[L] < a[pivot]) && (L < R)) L ++;
			while ((a[R] >= a[pivot]) && (L < R)) R--;
			if (L < R)
			{
				int temp = a[L];
				a[L] = a[R];
				a[R] = temp;
			}
		}
		int temp = a[R];
		a[R] = a[pivot];
		a[pivot] = temp;
		for (int i = 0 ; i < a.length; i ++)
		{
			System.out.print(a[i] + " ");
		}
		System.out.println();
		return L;
	}
	public void quickSort(int a[], int begin, int end)
	{
		if (begin < end)
		{
			int p = partition(a, begin, end);
			quickSort(a, begin, p-1);
			quickSort(a, p+1, end);
		}
	}
}
