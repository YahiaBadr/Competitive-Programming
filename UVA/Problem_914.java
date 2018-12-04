package UVA;

import java.io.*;
import java.util.*;

public class Problem_914 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		ArrayList<Integer>p=new ArrayList<>();
		boolean f[]=new boolean[1000001];
		f[0]=true;
		f[1]=true;
		for(int i=2;i<f.length;i++)
			if(!f[i])
			{
				p.add(i);
				for(int j=i+i;j<f.length;j+=i)
					f[j]=true;
			}
		int t=sc.nextInt();
		big:while(t-->0)
		{
			int l=sc.nextInt(),r=sc.nextInt();boolean find=false;
			for(int i=l;i<=r;i++)
			{
				if(!f[i])
				{
					l=i;
					find=true;
					break;
				}
			}
//			System.out.println(l);
			HashMap<Integer, Integer>hm=new HashMap<>();
			if(!find)
			{
				pw.println("No jumping champion");
				continue big;
			}
			int first=l,max=-1,sol=-1;boolean rep=false;
			for(int i=p.indexOf(l)+1;i<p.size() && p.get(i)<=r;i++)
			{
//				System.out.println(i);
				int second=p.get(i);
				int diff=second-first;
				int val=hm.getOrDefault(diff, 0)+1;
//				System.out.println(second+" - "+first+" = "+diff +" --> "+val);
				hm.put(diff, val);
				if(max<val)
				{	
					max=val;
					sol=diff;
					rep=false;
				}
				else if(max==val)
				{
					rep=true;
				}
				first=second;
			}
			if(max>0 && !rep)
				pw.println("The jumping champion is "+sol);
			else
				pw.println("No jumping champion");
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
