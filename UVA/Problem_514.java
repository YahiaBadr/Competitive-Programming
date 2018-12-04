package UVA;
import java.util.*;
public class Problem_514
{
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		while(true)
		{
			int n=sc.nextInt();
			if(n==0)
				break;
			while(true)
			{
				int[] a= new int[n];
				a[0]=sc.nextInt();
				if(a[0]==0)
					break;
				for(int i=1;i<n;i++)
					a[i]=sc.nextInt();
				Stack<Integer> st=new Stack<>();
				int i=0;
				for(int j=1;j<=n;j++)
				{
					st.push(j);
					if(st.peek()==a[i])
					{
						st.pop();
						i++;
						for(int z=i;z<n && !st.isEmpty();z++)
						{
							if(a[z]==st.peek())
							{
								st.pop();
								i++;
							}
							else break;
						}	
					}
					
				}
				while(i<n && !st.isEmpty())
				{
					if(a[i]==st.peek())
					{
						st.pop();
					}
					i++;
				}
				if(st.isEmpty())
					System.out.println("Yes");
				else
					System.out.println("No");
			}
			System.out.println();
		}
		sc.close();
	}
}
