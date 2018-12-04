package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_11661
{
	public static void main(String[] args) throws Throwable
	{
		Scanner sc= new Scanner();
		while(true)
		{
			int l=sc.nextInt();
			if(l==0)
				break;
			String s=sc.nextLine();
			if(s.contains("Z"))
			{
				System.out.println(0);
				continue;
			}
//			int max=2000001;
			int d=2000009;
			int resd=2000009;
			for(int i=0;i<l;i++)
			{
				if(s.charAt(i)=='D')
					d=i;
				if(d<2000009)
				{
					if(s.charAt(i)=='R')
						if(i-d<resd)
							resd=i-d;
				}
			}
			int r=2000009;
			int resr=2000009;
			for(int i=0;i<l;i++)
			{
				if(s.charAt(i)=='R')
					r=i;
				if(r<2000009)
				{
					if(s.charAt(i)=='D')
						if(i-r<resr)
							resr=i-r;
				}
			}
			System.out.println(resr>resd?resd:resr);
		}
	}
	static class Scanner 
	{
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
	    
	    boolean ready() throws Throwable
	    {
	    	return br.ready();
	    }

	}
}
