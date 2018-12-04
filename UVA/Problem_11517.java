package UVA;
//import java.util.*;
import java.io.*;
public class Problem_11517
{
	static int [] a;
	static int price;
	static int sum;
	static String s;
	static boolean f;
	static int c;
	public static void get(int i, int c1, int sum1, String s1 )
	{
		if(i==a.length || sum1>= price)
		{
			if(sum1==price)
			{
				sum=sum1;
				if(c1<c)
					s=s1;
			}
			else if(sum1>price && (sum==0 || sum1<sum))
			{
					sum=sum1;
					s1=""+sum1+" "+c;
			}
		}
		else
		{
			get(i+1,c+1,sum1+a[i],"");
			get(i+1,c,sum1,"");
		}
	}
	public static void main(String[] args) throws Throwable
	{
		//Scanner sc= new Scanner(System.in);
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int n= Integer.parseInt(bf.readLine());
		while(n-->0)
		{
			price=Integer.parseInt(bf.readLine());
			int n2=Integer.parseInt(bf.readLine());
			a= new int [n2];
			for(int i=0;i<n2;i++)
				a[i]=Integer.parseInt(bf.readLine());
			sum=0;
			s="";
			f=false;
			//get(0,0,0);
			pw.println(s);
			
			
		}
		pw.flush();
		pw.close();
	}
}
