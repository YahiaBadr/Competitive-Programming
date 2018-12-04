package UVA;
import java.util.*;
import java.io.*;
public class Problem_11062
{
	public static String check(String s)
	{
		String r="";
		for(int i=0;i<s.length();i++)
		{
			if(((int)s.charAt(i)<='z' && (int)s.charAt(i)>='a') || s.charAt(i)=='-')
				r+=""+s.charAt(i);
			else
				r+=" ";
		}
		return r;
	}
	public static void main(String[] args)throws Throwable
	{
		Scanner sc= new Scanner();
		TreeSet<String> ts=new TreeSet<>();
		ArrayList<String> s1=new ArrayList<>();
		//while(sc.hasnext())
		while(true)
		{
			String s=sc.nextLine();
			if(s.equals("0"))
				break;
			s1.add(s);
		}	
		String x="";
		for(int i=0;i<s1.size();i++)
			{
				String tmp=s1.get(i).toLowerCase();
				String tmp1[]=check(tmp).split(" ");
				for(int j=0;j<tmp1.length;j++)
				{
					if(!tmp1[j].isEmpty() && tmp1[j].charAt(tmp1[j].length()-1)=='-')
					{
						x+=tmp1[j].substring(0,tmp1[j].length()-1);
					}
					else if(!x.isEmpty())
					{
						ts.add(x+tmp1[j]);
						x="";
					}
					else
						ts.add(tmp1[j]);
				}
			}
		for(String s2: ts)
		{
			if(s2.equals(""))
				continue;
			else
				System.out.println(s2);
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
