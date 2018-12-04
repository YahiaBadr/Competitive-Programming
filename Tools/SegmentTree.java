package Tools;

import java.util.Scanner;

public class SegmentTree
{
	int[]sgt;
	int[]a;
	int[]lazy;
	int n;
	public SegmentTree(int[]a)
	{
		int log=(int)(Math.ceil(Math.log(a.length)/Math.log(2)));
		n=1<<log;
		sgt=new int[n<<1];//index 0 is unused
		lazy=new int[n<<1];
		this.a=a;
//		for(int i=0;i<a.length;i++)
//			sgt[a.length+i]=a[i];
//		builditer();
		buildrec(1,n,1);
	}
	public void builditer()
	{
		for(int i=a.length-1;i>0;i--)
			sgt[i]=sgt[i*2]+sgt[i*2+1];
	}
	public void buildrec(int l,int r,int n)
	{
		if(l==r)
		{	
			if(l-1<a.length)//l-1 because our array is zero indexed
				sgt[n]=a[l-1];
			return;
		}
		int mid=(r+l)/2;
		buildrec(l,mid,2*n);
		buildrec(mid+1,r,2*n+1);
		sgt[n]=sgt[2*n]+sgt[2*n+1];
	}
	public int query(int l,int r)//take zero index parameters
	{
		return query(1,n,1,l+1,r+1);
	}
	public int query(int s,int e,int i,int l,int r)
	{
		if(l<=s && r>=e)
			return sgt[i];
		if(r<s || l>e)
			return 0;
		int mid=e+s>>1;
		if(lazy[i]!=0)
			propagate(i,(e-s+1)/2);
		int left=query(s,mid,i*2,l,r);
		int right=query(mid+1,e,i*2+1,l,r);
		return left+right;
	}
	public void increment_rec(int l,int r,int idx,int i,int val)
	{
		if(l==r)
		{
			sgt[i]+=val;
			return;
		}
		int mid=l+r>>1;
		propagate(i,(r-l+1)/2);
		if(idx<=mid)
			increment_rec(l,mid,idx,i<<1,val);
		else
			increment_rec(mid+1,r,idx,i<<1|1 ,val);
		sgt[i]=sgt[i<<1]+sgt[i<<1|1];
	}
	public void increment_iter(int idx,int v)//array zero indexed
	{
		idx+=n;
		while(idx>0)
		{
			sgt[idx]+=v;
			idx>>=1;
		}
	}
	public void update(int idx,int v)//array zero indexed
	{
		int diff=v-a[idx];
//		increment_iter(idx, diff);
		a[idx]=v;
		increment_rec(1, n, idx, 1, diff);
	}
	public void increment_range(int l,int r,int v)
	{
		increment_range(l+1, r+1, 1, n, v, 1);
	}
	public void increment_range(int l,int r,int s,int e,int v,int i)
	{
		if(l<=s && r>=e)
		{
			sgt[i]+=v*(r-l+1);
			lazy[i]+=v;
			return;
		}
		if(l>r || r<s)
			return;
		int mid=e+s>>1;
		if(lazy[i]!=0)
			propagate(i,(e-s+1)/2);
		if(l<=mid)
			increment_range(l, r, s, mid, v, i<<1);
		if(e>=mid+1)
			increment_range(l, r, mid+1, e, v, i<<1|1);
		sgt[i]=sgt[i<<1]+sgt[i<<1|1];
	}
	public void propagate(int i,int mid)
	{
		sgt[i*2]+=lazy[i]*mid;
		sgt[i*2+1]+=lazy[i]*mid;
		lazy[i*2]+=lazy[i];
		lazy[i*2+1]+=lazy[i];
		lazy[i]=0;
		return;
	}
	public String toString()
	{
		String s="";
//		int level=1;
		for(int i=1;i<sgt.length;i++)
		{
			s+=sgt[i]+" ";
		}
		return s;
	}
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		int[]a= new int[sc.nextInt()];
		for(int i=0;i<a.length;i++)a[i]=sc.nextInt();
		SegmentTree sgt=new SegmentTree(a);
		System.out.println(sgt);
		sgt.increment_range(0, 0, -1);
		System.out.println(sgt);
//		System.out.println(sgt);
//		System.out.println(sgt.query(3,4));
//		System.out.println(sgt);
		sc.close();
	}
}
