package Leetcode;

import java.util.*;

public class shortestPathAllKeys {
    public static void main(String[] args) {
        Solution S = new Solution();
        String[] grid = {"@.a.#","###.#","b.A.B"};
        S.shortestPathAllKeys(grid);
    }
}
class Solution {
    int dx[]={1,-1,0,0};
    int dy[]={0,0,-1,1};

    public int shortestPathAllKeys(String[] grid) {
        int max=0;
        int x=0;
        int y=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length();j++)
            {
                char curr=grid[i].charAt(j);
                if(curr>='a' && curr<='f')
                {
                    max=Math.max(max,curr-'a'+1);
                }
                if(curr=='@')
                {
                    x=i;
                    y=j;
                }
            }
        }
        //SEE As it's given that the alphabets are to be chosen in the same order
        //so that's why we have the max with us
        //let's say max alphabet is c
        //so our max will be 4
        //and how we will confirm all abc are collected
        //so we will represent each alphabet as a bit in integer keys
        //so as we get c it is 100 as we get 'a' it becomes 101
        //as we get b it becomes 111
        //and that's why we store our max as (max chat pos+1)
        //so we can check that if (1<<max)-1==keys then all the keys are collected
        Queue<int[]> q=new LinkedList<>();
        int maxsize=(1<<max)+1;
        //now to represent the visited array we need to keep x,y and key
        //coz this ensures that we don't visit a cell with same state .i.e having same
        //keys
        boolean visited[][][]=new boolean[grid.length][grid[0].length()][maxsize];
        q.add(new int[]{x,y,0});
        q.add(null);
        visited[x][y][0]=true;
        int dist=0;
        while(!q.isEmpty())
        {
            int curr[]=q.poll();
            if(curr==null){
                dist++;
                if(!q.isEmpty())
                {
                    q.add(null);
                }
                continue;
            }
            //condition if we got all the keys
            if(curr[2]==(1<<max)-1){return dist;}

            //key of our current state
            int keys=curr[2];
            //moving in 4 directions
            for(int i=0;i<4;i++)
            {
                int newX=curr[0]+dx[i];
                int newY=curr[1]+dy[i];
                if(newX<0 || newY<0 || newX>=grid.length || newY>=grid[0].length() || grid[newX].charAt(newY)=='#')
                {
                    continue;
                }
                char ch=grid[newX].charAt(newY);
                if(ch>='A' && ch<='F' && !visited[newX][newY][keys])
                {

                    int pos=(ch-'A');
                    //checking if we got a capital letter then are we having a key for it
                    //if yes we can add that cell to our queue
                    if(((1<<pos)&(keys))!=0)
                    {
                        q.add(new int[]{newX,newY,keys});
                        visited[newX][newY][keys]=true;
                    }

                }
                else if(ch>='a' && ch<='f')
                {
                    //if we got a key
                    //then marking it's corresponding bit

                    int pos=(ch-'a');
                    int newkeys=(1<<pos)|keys;

                    if(!visited[newX][newY][newkeys])
                    {
                        q.add(new int[]{newX,newY,newkeys});
                        visited[newX][newY][newkeys]=true;
                    }
                }
                else{
                    //means we got a '.' or '@' so checking if visited
                    //if not then add it to our queue
                    if(!visited[newX][newY][keys])
                    {
                        q.add(new int[]{newX,newY,keys});
                        visited[newX][newY][keys]=true;
                    }
                }
            }

        }
        return -1;
    }
}