package UVA;

import java.io.*;
import java.util.*;

public class Problem_11420 {
//	public static int dp(boolean l,String cu,int cl)
//	{
//		if(dp.containsKey(cu))
//			return dp.get(cu);
//		if(cu.length()>=n)
//		{
//			if(cl==s)
//			{	
//				if(!dp.containsKey(cu))
//				{
//					sol.add(cu);
//					dp.put(cu, 1);
//					return 1;
//				}
//				return 0;
//			}
//			dp.put(cu, 0);
//			return 0;
//		}
//		if(l)
//		{
//			if(cl<s)
//				dp.put(cu,dp(true,cu+"L",cl+1)+dp(false,cu+"U",cl));
//			else
//				dp.put(cu, dp(false,cu+"U",cl));
//		}
//		else
//		{
//			dp.put(cu,dp(true,cu+"L",cl)+dp(false,cu+"U",cl));
//		}
//		return dp.get(cu);
//	}
	public static long call(int l,int sec,int f)
	{
		if(l==1)
		{
			if(sec>l)
				return 0;
			if(sec==1 && f==1)
				return 1;
			if(sec==1 && f==0)
				return 0;
			if(sec==0 && f==1)
				return 0;
			if(sec==0 && f==0)
				return 1;
		}
		if(dpp[l][sec][f]!=-1)
			return dpp[l][sec][f];
		if(sec==0)
		{
			if(f==1)
				dpp[l][sec][f]=call(l-1,0,0);
			else
				dpp[l][sec][f]=call(l-1,0,1)+call(l-1,0,0);
			return dpp[l][sec][f];
		}
		if(f==1)
			dpp[l][sec][f]=call(l-1,sec-1,1)+call(l-1,sec,0);
		else
			dpp[l][sec][f]=call(l-1,sec,1)+call(l-1,sec,0);
		return dpp[l][sec][f];
	}
	static int n,s;
//	static HashSet<String>hs,sol;
//	static HashMap<String, Integer>dp;
	static long[][][]dpp;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
//		hs=new HashSet<>();sol=new HashSet<>();
		dpp=new long[70][70][2];
		for(int i=1;i<70;i++)
		{
			for(int j=0;j<70;j++)
			{
				Arrays.fill(dpp[i][j],-1);
			}
		}
		for(int i=1;i<70;i++)
			for(int j=1;j<70;j++)
				for(int k=0;k<2;k++)
					call(i,j,k);
//		System.out.println(Arrays.deepToString(dpp));
//		System.out.println("done");
		
		while(true)
		{
			n=sc.nextInt();s=sc.nextInt();
			if(n<=0 && s<0)
				break;
			pw.println((long)(call(n,s,0)+call(n,s,1)));
//			pw.println(dp(true,"",0));
//			Iterator<String>i=sol.iterator();
//			Iterator<String>i=dp.keySet().iterator();
//			while(i.hasNext())
//			{
//				String s=i.next();
//				pw.println(s+" "+dp.get(s));
//			}
			
			
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
