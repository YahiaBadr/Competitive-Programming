package UVA;
import java.io.*;
import java.util.*;
public class Problem_11988
{
	public static void main(String[] args)throws Throwable
	{
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(new OutputStreamWriter(System.out));
		//while(bf.ready())
		{	
			Deque<String> deq=new LinkedList<>();
			String s=bf.readLine();
			//String ans="";
			StringBuilder b=new StringBuilder();
			//Stack<Character> st= new Stack<>();
			boolean f=false;
			for(int i=0;i<s.length();i++)
			{
				if(s.charAt(i)=='[')
				{
					if(f){
						deq.addFirst(b.toString());
						b=new StringBuilder();
					}
					f=true;
					continue;
				}
				else if(s.charAt(i)==']')
				{
					if(f){
						deq.addFirst(b.toString());
						b=new StringBuilder();
					}
					f=false;
					continue;
				}
				if(!f)
				{
					deq.addLast(s.charAt(i)+"");
				}
				else
				{
					b.append(s.charAt(i));
				}	
			}
			pw.print(b);
			while(!deq.isEmpty())
				pw.print(deq.removeFirst());
			pw.println();
		}
		pw.flush();
		pw.close();
	}
}
