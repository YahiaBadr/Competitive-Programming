package UVA;
import java.util.*;
public class Problem_541
{
	public static void main(String[] args)
	{
		Scanner sc= new Scanner (System.in);
		while(true)
		{
			int n=sc.nextInt();
			if(n==0)
				break;
			int[][] a= new int[n][n];
			int []sumr=new int[n];int c=0;
			int []sumc=new int[n];
			for(int i=0;i<n;i++)
			{
				int tmp=0;
				for(int j=0;j<n;j++)
				{
					a[i][j]=sc.nextInt();
					tmp+=a[i][j];
				}
				sumr[c++]=tmp;
			}c=0;
//			for(int i=0;i<n;i++)
//			System.out.println(Arrays.toString(a[i]));
			for(int i=0;i<n;i++)
			{
				int tmp=0;
				for(int j=0;j<n;j++)
					tmp+=a[j][i];
				//System.out.println(tmp);
				sumc[c++]=tmp;
			}
			int rc=0;
			int cc=0;
			int isol=-1;
			int jsol=-1;
			boolean f=true;
			for(int i=0;i<n && f;i++)
			{
				if(sumr[i]%2!=0)
				{
					isol=i+1;
					if(rc==1)
						f=false;
					rc++;
					
				}
				if(sumc[i]%2!=0)
				{
					jsol=i+1;
					if(cc==1)
						f=false;
					cc++;
				}	
			}
			//System.out.println(Arrays.toString(sumc));
			if(isol==-1 && jsol==-1)
				System.out.println("OK");
			else if((isol==-1 && jsol!=-1) || (isol!=-1 && jsol==-1))
				System.out.println("Corrupt");
			else if(f)
				System.out.println("Change bit ("+isol+","+jsol+")");
			else
				System.out.println("Corrupt");
		}
		sc.close();
	}
}
