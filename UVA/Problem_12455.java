package UVA;
import java.util.*;
public class Problem_12455
{
	static boolean pos=false;
	public static void check(ArrayList<Integer> arr,int m,int min, int target)
	{
		if(min==target)
		{
			pos=true;
			return;
		}
		else
		{
			for(int i=m;i<arr.size();i++)
				if(min+arr.get(i)<=target)
					check(arr,i+1,min+arr.get(i),target);
			
		}
	}
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		int n= sc.nextInt();
		for(int j=0;j<n;j++)
		{
			pos=false;
			int t=sc.nextInt();
			int p=sc.nextInt();
			ArrayList<Integer> arr= new ArrayList<Integer>();
			for(int i=0;i<p;i++)
			{
				arr.add(sc.nextInt());
			}
			Collections.sort(arr);
			check(arr,0,0,t);
			if(pos==true)
				System.out.println("YES");
			else
				System.out.println("NO");	
		}
		sc.close();
	}
}
