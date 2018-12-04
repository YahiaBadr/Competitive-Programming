package UVA;

import java.io.*;
import java.util.*;


public class Problem_10090 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		while(true)
		{
			long n=sc.nextInt();
			if(n==0)
				break;
			long c1=sc.nextInt(),n1=sc.nextInt();
			long c2=sc.nextInt(),n2=sc.nextInt();
			Triple egcd=egcd(n1,n2);
			double g=egcd.g;
			double mul=n/g;
			if((long)mul!=mul)
				pw.println("failed");
			else
			{				
				long sol1=(long)mul*egcd.x,sol2=(long)mul*egcd.y;
				long m1=sol1,m2=sol2;//without n1 & n2
				//n1*m1+n2*m2=n ---->> n1*(m1+(k*n2)/g)+n2*(m2-(k*n1)/g)=n
				//so we need m1`=(m1+(k*n2)/g)
				// 			 m2`=(m2-(k*n1)/g)
				//	c=c1*m1`+c2*m2` to be minimum and m1`>=0 ,m2`>=0
				// (m1+(k*n2)/g)>=0 
				// k*n2/g >=-m1   --->  k>= -m1*g/n2
				// (m2-(k*n1)/g)>=0
				// m2 >= k*n1/g    --->  k<= m2*n1/g
				// -m1*g/n2 <= k <= m2*n1/g  && k must be int and g/n2 is not int as g/n1
				// so for some reason
				// ceil(-m1 * g/n2) <= k <= floor(m2 * g/n1).
				long ceil=(long)Math.ceil(-m1 * g/n2),floor=(long)Math.floor(m2 * g/n1);
				if(ceil>floor)
				{
					pw.println("failed");
					continue;
				}
				double sol1c=(m1+(ceil*n2)/g),sol2c=(m2-(ceil*n1)/g);
				double sol1f=(m1+(floor*n2)/g),sol2f=(m2-(floor*n1)/g);
				double cc=c1*sol1c+c2*sol2c,cf=c1*sol1f+c2*sol2f;
				if(cc<cf)
					pw.println((long)sol1c+" "+(long)sol2c);
				else
					pw.println((long)sol1f+" "+(long)sol2f);
			}
				
		}
		pw.close();
	}
	public static long gcd(long a,long b)
	{
		if(b==0)
			return a;
		return gcd(b, a%b);
	}
	public static long lcm(long a,long b)
	{
		//a*b=gcd(a,b)*lcm(a,b)
		return a*(b/gcd(a, b));
	}
	public static Triple egcd(long n,long m)
	{
		if(m==0)
			return new Triple(1, 0, n);
		Triple t=egcd(m,n%m);//m',r',g
		long mm=t.x;
		long r=t.y;
		t.y=mm-n/m*r;
		t.x=r;
		return t;
	}
	static class Triple
	{
		long x,y,g;
		public Triple(long xx,long yy,long gg)
		{
			x=xx;y=yy;g=gg;
		}
	}
	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		String nextLine() throws IOException {
			return br.readLine();
		}

		boolean hasnext() throws IOException {
			return br.ready();
		}

	}
}
//long lcm=lcm(n1,n2);
//if(sol1<0)
//{
//	long nn2=sol2/(lcm/n2);
//	sol2=sol2%(lcm/n2);
//	sol1=sol1+(nn2*lcm/n1);
//}
//if(sol2<0)
//{
//	long nn1=sol1/(lcm/n1);
//	sol1=sol1%(lcm/n1);
//	sol2=sol2+(nn1*lcm/n2);
//}
//if(sol1>=0 && sol2>=0)
//{
//	if(c1>c2 || (c1==c2 && n2>n1))
//	{
//		long nn1=sol1/(lcm/n1);
//		sol1=sol1%(lcm/n1);
//		sol2=sol2+(nn1*lcm/n2);
//	}
//	if(sol1<sol2 && c1<c2)
//	{
//		long nn2=sol2/(lcm/n2);
//		sol2=sol2%(lcm/n2);
//		sol1=sol1+(nn2*lcm/n1);
//	}
//	if(swap)
//		pw.println(sol2+" "+sol1);//number of boxes
//	else
//		pw.println(sol1+" "+sol2);//number of boxes
//}
//else
//	pw.println("failed");