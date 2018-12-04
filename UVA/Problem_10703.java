package UVA;
import java.util.*;
import java.io.*;
public class Problem_10703
{
	public static void main(String[] args)throws Throwable
	{
		Scanner sc= new Scanner();
		while(true)
		{
			int x=sc.nextInt();
			int y=sc.nextInt();
			int c= sc.nextInt();
			if(x==y&&y==c&& c==0)
				break;
			boolean [][]f=new boolean[x+1][y+1];
			while(c-->0)
			{
				int x1=sc.nextInt(); int y1=sc.nextInt();
				int x2=sc.nextInt(); int y2=sc.nextInt();
				for(int i=Math.min(x1, x2);i<=Math.max(x1, x2);i++)
				{
					for(int j=Math.min(y1, y2);j<=Math.max(y1, y2);j++)
						f[i][j]=true;
				}
			}
			int ans=0;
			for(int i=1;i<=x;i++)
				for(int j=1;j<=y;j++)
					if(!f[i][j])
						ans++;
			if(ans==0)
				System.out.println("There is no empty spots.");
			else if(ans==1)
				System.out.println("There is one empty spot.");
			else
				System.out.println("There are "+ans+" empty spots.");
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
	        boolean hasnext() throws IOException{
	        	return br.ready();
	        }

	    }

}
