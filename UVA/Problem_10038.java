package UVA;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
public class Problem_10038
{
	public static void main(String[] args) throws Throwable
	{
		PrintWriter pw = new PrintWriter(System.out);
		Scanner sc =new Scanner(System.in);
		while(sc.hasNextInt()){
		String s= sc.nextLine();
		String[] a = s.split(" ");

		int x[]=new int[Integer.parseInt(a[0])];
		for(int i=0;i<a.length-2;i++)
			x[i]=Math.abs(Integer.parseInt(a[i+1])-Integer.parseInt(a[i+2]));
		boolean f=true;Arrays.sort(x);
		for(int i=0;i<x.length-1 && f;i++)
		{
			if(Math.abs(x[i]-x[i+1])!=1)
			{
				f=false;
			}
		}
		if(f)
			pw.println("Jolly");
		else
			pw.println("Not jolly");
		}
		pw.flush();
		pw.close();
		sc.close();
	}	
}