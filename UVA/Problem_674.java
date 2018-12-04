package UVA;
import java.util.*;
public class Problem_674
{
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		int sol[]= new int[7490];
		for(int j=0;j<7490;j++)
			sol[j]=1;
		int coins[]={5,10,25,50};
		for(int i=0;i<4;i++)
		{
			for(int j=coins[i];j<7490;j++)
				sol[j]+=sol[j-coins[i]];
		}
		while(sc.hasNext())
		{
			int t=sc.nextInt();
			System.out.println(sol[t]);
		}
	sc.close();
	}
}