package UVA;
import java.util.*;
import java.io.*;
public class Problem_11995 
{
	static class Mycom implements Comparator<Integer>
	{

		@Override
		public int compare(Integer x, Integer y) {
			// TODO Auto-generated method stub
			if(x==y)
				return 0;
			return x<y?y:x;
		}
		
	}
	public static void main(String[] args)throws Throwable
	{
		Scanner sc= new Scanner();
		//while(sc.hasnext())
		while(true)
		{
			int n=sc.nextInt();
			boolean sf=true,qf=true,pqf=true;
			Stack <Integer>st=new Stack<>();
			Queue<Integer>q=new LinkedList<>();
			PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
			while(n-->0)
			{
				int com=sc.nextInt();
				int x=sc.nextInt();
				//System.out.println("com "+com+" x "+x);
				if(com==1)
				{
						st.add(x);
						q.add(x);
						pq.add(x);
				}
				else
				{
					if(st.isEmpty())
					{
						sf=false;pqf=false;qf=false;
						//System.out.println("all "+x);
					}
					else
					{
						int sx=st.pop();
						int qx=q.poll();
						int pqx=pq.poll();
						if(sf && x!=sx)
							sf=false;
						if(qf && qx!=x)
							qf=false;
						if(pqf && pqx!=x)
							pqf=false;
					}
				}
			}
			//System.out.println(sf + "" +qf + pqf);
			if((sf && qf) || (sf && pqf) || (qf && pqf))
				System.out.println("not sure");
			else if(sf)
				System.out.println("stack");
			else if(qf)
				System.out.println("queue");
			else if(pqf)
				System.out.println("priority queue");
			else
				System.out.println("impossible");
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
