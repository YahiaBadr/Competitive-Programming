package UVA;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Problem_11849
{
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

	public static void main(String[] args)throws Throwable
	{
		Scanner sc= new Scanner();
		while(true)
		{
			int ans=0;
			int n=sc.nextInt();
			int m=sc.nextInt();
			if(m==0 && n==0)
				break;
			if(m==0 || n==0)
			{
				System.out.println(0);
				continue;
			}
			HashSet<Integer> hs=new HashSet<>();
			while(n-->0)
				hs.add(sc.nextInt());
			while(m-->0)
			{
				int tmp=sc.nextInt();
				if(hs.contains(tmp))
					ans++;
			}
			System.out.println(ans);
		}
	}
}
