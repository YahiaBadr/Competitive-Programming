package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_10324
{
	public static void main(String[] args) throws IOException, Throwable
	{
		Scanner sc= new Scanner();
		int c=1;
		while(sc.ready())
		{	
		String s= sc.nextLine();
		if(s.equals(""))
			break;
		int n=sc.nextInt();
		System.out.println("Case "+c+":");
		while(n-->0)
		{
			boolean f=false;
			int max=sc.nextInt();
			int min=sc.nextInt();
			if(min>max)
			{
				int tmp=min;
				min=max;
				max=tmp;
			}
			for(int i=min;i<max ;i++)
			{
				if(s.charAt(i)!=s.charAt(i+1))
				{
					f=true;
					break;
				}
			}
			if(f)
				System.out.println("No");
			else
				System.out.println("Yes");
		}
		c++;
		}
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
    
    boolean ready() throws Throwable
    {
    	return br.ready();
    }

}
}
