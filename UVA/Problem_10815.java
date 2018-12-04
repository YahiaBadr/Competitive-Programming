package UVA;
import java.util.*;
import java.io.*;
public class Problem_10815
{
	public static String check(String s)
	{
		String r="";
		for(int i=0;i<s.length();i++)
		{
			if((int)s.charAt(i)<='z' && (int)s.charAt(i)>='a')
				r+=""+s.charAt(i);
			else
				r+=" ";
		}
		return r;
	}
	public static void main(String[] args)throws Throwable
	{
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		TreeSet<String> h=new TreeSet<>();
		//while(true)
		while(bf.ready())
		{
			String s= bf.readLine();
//			if(s.equals("0"))
//				break;
			String s1[]=s.split(" ");
			for(int i=0;i<s1.length;i++)
			{
				String tmp=s1[i].toLowerCase();
				String tmp1[]=check(tmp).split(" ");
				for(int j=0;j<tmp1.length;j++)
					h.add(tmp1[j]);
			}
			//Iterator i=h.iterator();
			//System.out.println(h);
		}
		//System.err.println(h);
		for(String s2: h)
		{
			if(s2.equals(""))
				continue;
			else
				System.out.println(s2);
		}
	}
}
