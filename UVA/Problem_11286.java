package UVA;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Problem_11286
{
	public static void main(String[] args)throws Throwable
	{
		Scanner sc= new Scanner();
		while(true)
		{
			double n=sc.nextDouble();
			if(n==0)
				break;
			int tmp=(int)n;
			HashMap<String,Integer> hs=new HashMap<>();
			while(tmp-->0)
			{
				PriorityQueue<Integer> ts=new PriorityQueue<>();
				ts.add(sc.nextInt());
				ts.add(sc.nextInt());
				ts.add(sc.nextInt());
				ts.add(sc.nextInt());
				ts.add(sc.nextInt());
				String s="";
				while(!ts.isEmpty())
					s+=""+ts.poll();
				if(hs.containsKey(s))
					hs.put(s,hs.get(s)+1);
				else
					hs.put(s,1);
					
			}
			int ans=0;
			int max=0;
			for(Map.Entry<String, Integer> e:hs.entrySet())
			{
				if(max<e.getValue())
				{
					max=e.getValue();
					ans=max;
				}
				else if(max==e.getValue())
					ans+=max;
			}
			System.out.println(ans);
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
