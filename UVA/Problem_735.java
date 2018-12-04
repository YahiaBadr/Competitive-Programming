package UVA;
import java.util.*;
public class Problem_735
{
	static int[] a={0,1,2,3,4,5,6,7,8,9,10,11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 24, 26, 27, 28, 30, 32, 33, 34, 36, 38, 39, 40, 42, 45, 48, 50, 51, 54, 57, 60};;
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		while(true)
		{	
			TreeSet<String> m= new TreeSet<String>();
			int sum= sc.nextInt();
			int ans=0;
			if(sum<1)
			{
				System.out.println("END OF OUTPUT");
				break;
			}
			for(int i=0;i<a.length;i++)
				for(int j=0;j<a.length;j++)
					for(int k=0;k<a.length;k++)
					{
						if(a[i]+a[j]+a[k]==sum)
							{
								ans++;
								ArrayList<Integer> x= new ArrayList<Integer>();
								x.add(a[i]);x.add(a[j]);x.add(a[k]);
								Collections.sort(x);
								String s=""+x.get(0)+""+x.get(1)+""+x.get(2);
								m.add(s);
							}
					}
			if(ans!=0)
			{
				System.out.println("NUMBER OF COMBINATIONS THAT SCORES "+sum+" IS "+m.size()+".");
				System.out.println("NUMBER OF PERMUTATIONS THAT SCORES "+sum+" IS "+ans+".");
			}
			else
			{
				System.out.println("THE SCORE OF "+sum +" CANNOT BE MADE WITH THREE DARTS.");
			}
			System.out.println("**********************************************************************");
		}		
		sc.close();
	}
}
