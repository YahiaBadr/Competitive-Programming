package UVA;
import java.util.*;
public class Problem_1260
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		while(t-->0)
		{
			int n=sc.nextInt();
			int []x= new int [n];
			int c=0;
			for(int i=0;i<n;i++)
			{
				x[i]=sc.nextInt();
				for(int j=0;j<i;j++)
				{
					if(x[i]>=x[j])
						c++;
				}
				
			}
			System.out.println(c);
		}
		sc.close();
	}

}
