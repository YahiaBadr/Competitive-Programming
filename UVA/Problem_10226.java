package UVA;
import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
public class Problem_10226
{
	public static void main(String[] args) throws Throwable
	{
		PrintWriter pw = new PrintWriter(System.out);
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat df=new DecimalFormat("0.0000");
		int n= Integer.parseInt(bf.readLine());
		bf.readLine();
		String s;
		while(n!=0)
		{
			double t=0;
			TreeMap<String,Integer> map=new TreeMap<String,Integer>();
			while((s = bf.readLine()) != null)
			{
				//s=bf.readLine();
				if(s.length()==0)
					break;
				else
				{
					t++;
					if(map.containsKey(s))
						map.put(s, map.get(s)+1);
					else
						map.put(s, 1);
				}
			}
			while(!map.isEmpty())
			{
				pw.println(map.firstKey()+" "+df.format((map.get(map.firstKey())/t)*100));
				map.remove(map.firstKey());
			}
			n--;
			if (n!=0) 
				pw.println();
		}
		pw.flush();
		pw.close();
		
	}

}
