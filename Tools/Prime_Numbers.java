package Tools;

import java.io.PrintWriter;
import java.util.*;

public class Prime_Numbers
{
	public static int gcd(int a,int b)
	{
		return b==0?a:gcd(b, a%b);
	}
	public static int lcm(int a,int b)
	{
		//a*b=gcd(a,b)*lcm(a,b)
		return a*(b/gcd(a, b));
	}
	static class Triple
	{
		int x,y,g;
		public Triple(int xx,int yy,int gg)
		{
			x=xx;y=yy;g=gg;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return x+" "+y+" "+g;
		}
	}
	public static Triple egcd(int n,int m)
	{
		if(m==0)
			return new Triple(1, 0, n);
		Triple t=egcd(m,n%m);//m',r',g
		int mm=t.x;
		int r=t.y;
		t.y=mm-n/m*r;
		t.x=r;
		return t;
	}
	static int []pf;
	static HashSet<Integer>[]div;
	static HashSet<Integer> hs ;
	static ArrayList<Integer>p;
	public static void modified_seive(int size)
	{
		boolean f[]=new boolean[size];
		f[0]=true;
		f[1]=true;
		for(int i=2;i<f.length;i++)
		{	
			if(!f[i])
			{
				p.add(i);
				hs.add(i);
				for(int j=i,z=1;i * z<f.length;z++)
				{
					f[j]=true;
					int tmp = i * z;
					j = tmp;
//					pf[j]++;//the only add to be modified
				}
			}
		}
	}
	public static int Nod(int x)
	{
		if(hs.contains(x))
			return 2;
		int i=0;int r=1,xx=1,np=0;
		while(i<p.size() && p.get(i)<=Math.sqrt(x))
		{
			int n=x,pr=p.get(i++),tmp=1;
			while(n%pr==0 && n>=pr)
			{
				n/=pr;
				tmp++;
				xx*=pr;
			}
			r*=tmp;
			np+=tmp-1;
		}
		if(x!=xx)
		{
			r*=2;
			r+=np-np;
			np++;
		}
//		return np;//np=number of primefactors in x
		return r;//r=number of divisors in x
	}
	public static int[] factors(int n)
	{
		int[]a=new int[n];
		for(int i=2;i<a.length;i++)
		{
			if(a[i]==0)
				a[i]=1;//means prime number
			for(int j=2,k=i*j;k<a.length && j<=i;j++,k=i*j)
				if(a[j]==1)	
					a[k]=a[i]+a[j];
		}
		//Array a contains the number of factors of each i
//		for(int i=2;i<a.length;i++)
//			a[i]+=a[i-1];
		//here the number of factors of each i!
		return a;
	}
	public static int get_powers(int n, int p)//the power of the prime number p in n!
	{
	   int res = 0;
	   n/=p;
	   while(n>0)
	   {
		   res+=n;
		   n/=p;
	   }
	    return res;
	}
	static long div(long n)
	{
		long ans=0;
		long left=1;
		long right;
		while(left<=n)
		{
			long z=n/left;
			right=n/z;
			ans+=1l*(right+left)*(right-left+1)*z;
			left=right+1;
		}
		return ans;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter pw=new PrintWriter(System.out);
		p=new ArrayList<>();
		hs=new HashSet<>();
		modified_seive(1000001);
		sc.close();
		pw.close();
	}
}
