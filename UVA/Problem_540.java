package UVA;
import java.io.*;
import java.util.*;
public class Problem_540
{
	static int k=0;
	public static void main(String[] args) throws Throwable
	{
		Scanner sc=new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		ArrayList<Integer> z=new ArrayList<Integer>();
		int[][] a;
		int t= sc.nextInt();
		int n;
		int m=0;
		while(t!=0)
		{	
			for(int i=0;i<t;i++)
			{
				n=sc.nextInt();
				a= new int[t][n];
				for(int j=0;j<n;j++)
				{
					a[t][n]=sc.nextInt();
				}
			}
			String y=sc.nextLine();
			while(!(y.equals("STOP")))
			{
				if(y.equals("DEQUEUE"))
				{
					z.remove(z.size()-1);
				}
				else
				{
					y=y.substring(8);
					m=Integer.parseInt(y);
				}
					
			}System.out.println(m);
		}
		pw.close();
		sc.close();
	}

}
