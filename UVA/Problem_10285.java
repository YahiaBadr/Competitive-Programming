package UVA;

import java.io.*;
import java.util.*;

public class Problem_10285
{
    static int r,c, grid[][],dp[][];
    static int[] dx= {-1,1,0,0};
    static int[] dy= {0,0,-1,1};
    public static int fun(int i, int j)
    {
        if(dp[i][j]!=-1)
            return dp[i][j];
        int ans=0;
        for(int z=0;z<4;z++)
        {
            int x=i+dx[z],y=j+dy[z];
            if(valid(x,y,grid[i][j]))
            {
                ans=Math.max(ans,fun(x,y));
            }
        }
        return dp[i][j]=ans+1;
    }
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner();
        PrintWriter pw = new PrintWriter(System.out);
        int t=sc.nextInt();
        while(t-->0)
        {
            String s=sc.next();
            s+=": ";
            r=sc.nextInt();c=sc.nextInt();
            grid=new int[r][c];
            dp=new int[r][c];
            for(int i=0;i<r;i++)
            {
                Arrays.fill(dp[i],-1);
                for (int j = 0; j < c; j++)
                    grid[i][j] = sc.nextInt();
            }
            int ans=-1;
            for(int i=0;i<r;i++)
                for(int j=0;j<c;j++)
                    ans=Math.max(ans,fun(i,j));
            pw.println(s+ans);
        }
        pw.close();
    }
    static boolean valid(int i,int j,int cur)
    {
        return i<r && i>=0 && j<c && j>=0 && cur>grid[i][j];
    }
//    public static int dijkstra_grid(int i,int j,int end_i,int end_j)
//    {
//        Queue<Integer>qi=new LinkedList<>(),qj=new LinkedList<>();
//        qi.add(i);qj.add(j);
//        grid[i][j]='X';
//        int[] dx= {-1,1,0,0};
//        int[] dy= {0,0,-1,1};
//        int dist[][]=new int[r][c];
//        for(int []a:dist)
//            Arrays.fill(a, (int)1e9);
//        dist[i][j]=0;
//        while(!qi.isEmpty())
//        {
//            int ci=qi.poll(),cj=qj.poll();
//            for(int k=0;k<4;k++)
//            {
//                int x=ci+dx[k],y=cj+dy[k];
//                if(valid(x,y)&& grid[x][y]!='X' && dist[ci][cj]+1<dist[x][y])//we are not checking about visited we check if it is block
//                {
//                    qi.add(x);
//                    qj.add(y);
//                    dist[x][y]=dist[ci][cj]+1;
//                }
//            }
//        }
//        return dist[end_i][end_j];
//    }
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
