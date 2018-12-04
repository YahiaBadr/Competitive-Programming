package UVA;
import java.util.*;
import java.io.*;
public class Problem_10264
{
	public static void main(String[] args)throws Throwable
	{
		Scanner sc= new Scanner();
		//while(sc.hasnext())
		{
			int in=sc.nextInt();
			int n=(int)Math.pow(2,in);
			int[] a=new int[n];
			for(int i=0;i<n;i++)
				a[i]=sc.nextInt();
			int[] nei= new int[n];
			for(int i=0;i<n;i++)
			{	
				int tmp1=a[i];
				int z=1;
				while(z<n)
				{
					int tmp=i^z;
					tmp1+=a[tmp];
					z=z<<1;
				}
				nei[i]=tmp1;
			}
			int max=0;
			for(int i=0;i<n;i++)
			{	
				int z=1;
				while(z<n)
				{
					int neib=i^z;
					int tmp=nei[i]+nei[neib]-a[i]-a[neib];
					if(max<tmp)
						max=tmp;
					z<<=1;
				}
				
			}
			System.out.println(max);
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
