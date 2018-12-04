package UVA;
import java.util.*;
import java.io.*;
public class Problem_10295
{
	public static void main(String[] args)throws Throwable
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String n1= br.readLine();
		String ns[]=n1.split(" ");
		int m=Integer.parseInt(ns[0]);
		int n=Integer.parseInt(ns[1]);
		HashMap<String,Integer> hm=new HashMap<>();
		while(m-->0)
		{
			String s=br.readLine();
			String s1[]=s.split(" ");
			hm.put(s1[0],Integer.parseInt(s1[1]));
		}
		while(n-->0)
		{
			int ans=0;
			String s="";String tmp=br.readLine();
			while(!tmp.equals("."))
			{
				s+=tmp+" ";
				tmp=br.readLine();
			}
			//System.out.println(s);
			String s1[]=s.split(" ");
			for(int i=0;i<s1.length;i++)
			{
				if(hm.containsKey(s1[i]))
					ans+=hm.get(s1[i]);
			}
			System.out.println(ans);
		}
		
	}
}
