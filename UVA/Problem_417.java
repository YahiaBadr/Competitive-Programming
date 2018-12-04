package UVA;
import java.util.*;
import java.io.*;
public class Problem_417
{
	
	static class MyComparator implements Comparator<String>
	{
		@Override
		public int compare(String o1, String o2)
		{
			if(o1.length()>o2.length())
				return 1;
			else if(o1.length()<o2.length())
				return -1;
			return o1.compareTo(o2);
		}
	}

	static TreeSet<String> ts=new TreeSet<>(new MyComparator());
	public static void rec(String s)
	{
		if(s.length()==6)
			return;
		int i;
		if(s.equals(""))
			i=(int)'a';
		else
			i=(int)s.charAt(s.length()-1)+1;
		for(;i<=(int)'z';i++)
		{
			ts.add(s+(char)i);
			rec(s+(char)i);
		}
	}
	public static boolean check(String s)
	{
		for(int i=0;i<s.length()-1;i++)
		{
			if((int)s.charAt(i)>=(int)s.charAt(i+1))
				return false;
		}
		return true;
	}
	public static void main(String[] args)throws Throwable
	{
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		rec("");
//		int j=0;
		while(bf.ready())
//		while(true)
		{
			String s=bf.readLine();
			if(s.equals("0"))
				break;
			if(!check(s))
			{
				System.out.println(0);
				continue;
			}
			int i=1;
			
			for(String z:ts)
			{
				if(z.equals(s))
					System.out.println(i);
				i++;
			}	
		}
	}
}
