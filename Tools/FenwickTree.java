package Tools;

import java.util.Arrays;

public class FenwickTree
{
	int[]a;
	int[]ft;
	public FenwickTree(int[]a)
	{
		this.a=a;
		ft=new int[a.length+1];
		build();
	}
	public void build()
	{
		for(int i=0;i<a.length;i++)
			increment(i,a[i]);//since all values are zeros
	}
	public void increment(int i,int v)
	{
		i++;//since ft is index 1 based;
		while(i<ft.length)
		{
			ft[i]+=v;
			i+=(i&(-i));
		}
	}
	public void update(int i,int v)
	{
		int diff=v-a[i];
		a[i]=v;
		increment(i,diff);
	}
	public int query(int l,int r)
	{
		l++;r++;
		return prefix(r)-prefix(l-1);
	}
	public int prefix(int n)
	{
		int x=0;
		while(n>0)
		{
			x+=ft[n];
			n-=(n&(-n));
		}
		return x;
	}
	public String toString()
	{
		String s="";
		for(int i=1;i<ft.length;i++)
			s+=ft[i]+" ";
		return s;
	}
	public static void main(String[] args)
	{
		int[]a= {2,1,1,3,2,3,4,5,6,7,8,9};
		FenwickTree ft=new FenwickTree(a);
		System.out.println(Arrays.toString(ft.ft));
		System.out.println(ft.query(3,6));
	}
}
