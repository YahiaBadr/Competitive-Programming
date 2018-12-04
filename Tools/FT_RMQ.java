package Tools;

import java.util.Scanner;

public class FT_RMQ
{

	static int N = (int)1e5 + 5;
	static int ft[]=new int[N];
	static int n;
	static int get(int idx)
	{
	    int ret = ft[idx];
	    while (idx > 0)
	    {
	        ret = Math.min(ret, ft[idx]);
	        idx -= (idx & -idx);
	    }
	    return ret;
	}

	static void update(int idx, int val)
	{
	    while (idx <= n)
	    {
	        ft[idx] = Math.min(ft[idx], val);
	        idx += (idx & -idx);
	    }
	}

	static void main(String[]args)
	{

		Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    while (t-->0)
	    {
	        n=sc.nextInt();
	        for (int i = 0; i <= n; i++)
	            ft[i] = N;
	        int x[]=new int [n + 1];int [] y=new int[n + 1];
	        for (int i = 0; i < n; i++)
	        {
	            int p=sc.nextInt();
	            x[p]=sc.nextInt();y[p]=sc.nextInt();
	        }
	        int cnt = n;
	        for (int i = 1; i <= n; i++)
	        {
	            int mn = get(x[i]);
	            if (mn < y[i])
	                cnt--;
	            update(x[i], y[i]);
	        }
	        System.out.println(cnt);
	        sc.close();
	    }
	}
}
