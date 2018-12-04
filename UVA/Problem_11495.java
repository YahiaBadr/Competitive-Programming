package UVA;
import java.util.*;
public class Problem_11495
{
	static int inv=0;
	public static void merge(int []a , int start, int end)
	{
		int mid=(start+end)/2 +1;int i=0;int con=mid;int k=start;
		int tm[]=new int[end-start+1];
		while(start<con && mid<=end)
		{
			if(a[start]>a[mid])
			{
				tm[i++]=a[mid++];
				inv+=con-start;
			}
			else
				tm[i++]=a[start++];
		}
		while(mid<=end)
			tm[i++]=a[mid++];
		while(start<con)
			tm[i++]=a[start++];
		for(int j=0;j<tm.length;j++)
			a[k++]=tm[j];
	}
	public static void rec(int []a, int start,int end)
	{
		int mid=(end+start) /2;
		if(start<end)
		{
			rec(a,start,mid);
			rec(a,mid+1,end);
			merge(a,start,end);
		}
	}
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		while(true)
		{
			inv=0;
			int n=sc.nextInt();
			if(n==0)
				break;
			int[]a=new int[n];
			for(int i=0;i<n;i++)
				a[i]=sc.nextInt();
		rec(a,0,a.length-1);
		if(inv%2==0)
			System.out.println("Carlos");
		else
			System.out.println("Marcelo");
		}
		sc.close();
	}
}
