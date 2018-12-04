package UVA;
import java.util.*;
import java.io.*;
public class Problem_299
{
	public static void main(String[] args)throws Throwable
	{
		Scanner sc= new Scanner();
		int n= sc.nextInt();
		while(n-->0)
		{
			int l=sc.nextInt();
			int[] a=new int[l];
			for(int i=0;i<l;i++)
				a[i]=sc.nextInt();
			int c=0;int ans=0;
			for(int i=0;i<l-1;i++)
			{
				if(a[i]>a[i+1])
				{	
					for(int j=i;j<l-c-1;j++)
					{
					
						if(j==l-1)
							break;
						if(a[j]>a[j+1])
						{	
							int t=a[j];
							a[j]=a[j+1];
							a[j+1]=t;
							ans++;
						}	
					}
					c++;
					i=-1;
				}	
			}
			System.out.println("Optimal train swapping takes "+ans+" swaps." );
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
