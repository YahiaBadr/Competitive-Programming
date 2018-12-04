package UVA;
import java.text.DecimalFormat;
import java.util.*;
public class Problem_147
{
	public static void main(String[] args)
	{
		DecimalFormat df= new DecimalFormat("0.00");
		Scanner sc= new Scanner(System.in);
		long[] s=new long [6001];
		s[0]=1;
		int[] c={1,2,4,10,20,40,100,200,400,1000,2000};
		for(int i=0;i<11;i++)
		{
			for(int j=c[i];j<6001;j++)
			{
				s[j]+=s[j-c[i]];
			}
		}
		while(true)
		{
			double x= sc.nextDouble();
			x=x*20;
			if(x==0.00)
				break;
			
			System.out.printf("%6s%17s\n", df.format(x/20), s[(int) x]);
		}
		//System.out.println(Arrays.toString(s));
	sc.close();
	}
}
