package UVA;
import java.io.*;
import java.util.StringTokenizer;
public class Problem_11462
{
	public static void main(String[] args)throws Throwable
	{
		Scanner sc= new Scanner();
		PrintWriter pw= new PrintWriter(new OutputStreamWriter(System.out));
		while(true)
		{
			int n= sc.nextInt();
			if(n==0)
				break;
			int[] a= new int[101];
			while(n-->0)
				a[sc.nextInt()]++;
			boolean fir=true;
			for(int i=1;i<101;i++)
			{	for(int j=0;j<a[i];j++)
				{
					if(fir)
					{
						fir=false;
						pw.print(i);
					}
					else
						pw.print(" "+i);
				}
			}
			pw.println();
		}
		pw.flush();
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
        boolean hasnext() throws IOException{
        	return br.ready();
        }

    }

}
