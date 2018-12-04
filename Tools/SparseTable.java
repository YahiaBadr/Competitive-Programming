package Tools;

import java.util.Arrays;
import java.util.Scanner;


public class SparseTable
{
	int[]a;
	int st[][];
	public SparseTable(int[]a)
	{
		this.a=a;
		int n=a.length;
		st=new int[n][30];
		for(int i=0;i<n;i++)
			st[i][0]=a[i];
		for(int j=1;(1<<j)<=n;j++)
			for(int i=0;i+(1<<j)<=n;i++)
				st[i][j]=Math.min(st[i][j-1], st[i+(1<<j-1)][j-1]);

	}
	public int query(int l,int r)
	{
		int length=r-l+1;
		int log=(int)(Math.log(length)/Math.log(2));//which column
		System.out.println(log);
		return Math.min(st[l][log],st[r-(1<<log)+1][log]);
	}
	public String toString()
	{
		String s="";
		for(int i=0;i<st.length;i++)
			s+=Arrays.toString(st[i])+"\n";
		return s;
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();sc.nextInt();
		int[]a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		SparseTable st=new SparseTable(a);
		System.out.println(st);
		System.out.println(st.query(0,7));
		System.out.println(st.query(1, 6));
//		System.out.println(st.query(7, 8));
		sc.close();
	}
	
}
