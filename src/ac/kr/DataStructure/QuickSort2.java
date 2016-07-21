package ac.kr.DataStructure;

public class QuickSort2 {
	public static void main(String[] args) {
		int a[] = {69, 10, 30, 2, 16, 8, 31, 22};
		sort s = new sort();
		System.out.println("정렬할 원소 :");
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
		s.quickSort(a, 0, 7);
	}
}
class sort
{
	public int partition(int a[], int begin, int end)
	{
		int L, R, pivot;
		pivot = (begin+end)/2;
		L = begin;
		R = end;
		while (L < R)
		{
			while ( (a[L] < a[pivot]) && (L < R)) L++;
			while ( (a[R] >= a[pivot]) && (L < R)) R--;
			if (L < R)
			{
				int temp = a[L];
				a[L] = a[R];
				a[R] = temp;
			}
		}
		int temp = a[pivot];
		a[pivot] = a[R];
		a[R] = temp;
		System.out.println("정렬시작");
		for (int i = 0 ; i < a.length; i ++)
			System.out.print(a[i] + " ");
		System.out.println();
		return L;
	}
	public void quickSort(int a[], int begin, int end)
	{
		if(begin < end)
		{
			int p = partition(a, begin, end);
			quickSort(a, begin, p-1);
			quickSort(a, p+1, end);
		}
	}
}
