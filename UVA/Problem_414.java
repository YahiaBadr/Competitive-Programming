package UVA;
import java.io.*;
public class Problem_414
{
	public static void main(String[] args)throws Throwable
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			int n= Integer.parseInt(br.readLine());
			if(n==0)
				break;
			int a[]=new int[n];int max=26;
			for(int j=0;j<n;j++)
			{
				String s=br.readLine();int c=0;
				for(int i=0;i<s.length();i++)
					if(s.charAt(i)==' ')
						c++;
				max=Math.min(max, c);
				a[j]=c;
				c=0;
			}
			int ans=0;
			for(int i=0;i<n;i++)
				ans+=a[i]-max;
			System.out.println(ans);
		}
	}
}
