package Tools;

import java.io.*;
import java.util.*;

public class Printf {
	public static void main(String[] args) throws IOException {
		PrintWriter pw = new PrintWriter(System.out);
		int x=2;
		long l=(long)1e12;
		double f=2.5;
		pw.printf("%3d\n",10);//print in cell of 3
		pw.printf("%d\n",x);//Integer
		pw.printf("%f\n", f);//Float && Double //"%.3f" to 3 decimal places 
		pw.printf("%s\n", l);//String
		
		pw.close();
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
