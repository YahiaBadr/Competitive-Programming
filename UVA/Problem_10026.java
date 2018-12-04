package UVA;

import java.io.*;
import java.util.*;

class pairs implements Comparable<pairs>
{
	double time,fine;int index;double ratio;
	public pairs(int t,int f,int i)
	{
		time=t;fine=f;index=i;ratio=fine/time;
	}
	@Override
	public int compareTo(pairs o) {
		// TODO Auto-generated method stub
		if(ratio>o.ratio)
			return -1;
		if(ratio<o.ratio)
			return 1;
		return index-o.index;
	}
}
public class Problem_10026 {
	static String sol;
	static int n,min;
	static boolean[]f;
	static pairs[]a;
//	public static void sol(int d,int i,int sum,String s)
//	{
//		if(sum>min)
//			return;
//		if(i==n)
//		{
//			if(sum<min)
//			{	
//				sol=s;
//				min=sum;
//			}
//			return;
//		}
//		for(int j=0;j<n;j++)
//		{
//			if(!f[j])
//			{
//				int tmp=0;
//				if(d+a[j].time>a[j].time)
//					tmp+=a[j].fine*(d);
//				f[j]=true;
//				sol(d+a[j].time,i+1,sum+tmp,s+a[j].index+" ");
//				f[j]=false;
//			}
//		}
//	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int t=sc.nextInt();
		while(t-->0)
		{
			sol="";
			min=100000000;
			n=sc.nextInt();
			a=new pairs[n];
			f=new boolean[n];
			for(int i=0;i<n;i++)
				a[i]=new pairs(sc.nextInt(),sc.nextInt(),i+1);
			Arrays.sort(a);
			for(int i=0;i<n;i++)
				sol+=a[i].index+" ";
			pw.println(sol.substring(0, sol.length()-1));
			if(t>0)
				pw.println();
			
		}
		pw.close();
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		String nextLine() throws IOException {
			return br.readLine();
		}

		boolean hasnext() throws IOException {
			return br.ready();
		}

	}
}
