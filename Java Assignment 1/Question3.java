/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
import java.util.*;
public class Question3
{
       int paths[];
       int nov;
       public static final int MAX_VALUE = 999;
  
    public Question3(int nov)
    {
        this.nov = nov;
        paths = new int[nov + 1];
    }
 
    public void Question3(int source, int am[][])
    {
        for (int node = 1; node <= nov; node++)
        {
            paths[node] = MAX_VALUE;
        }
 
        paths[source] = 0;
        for (int node = 1; node <= nov - 1; node++)
        {
            for (int s= 1; s<= nov; s++)
            {
                for (int d = 1; d<= nov; d++)
                {
                    if (am[s][d] != MAX_VALUE)
                    {
                        if (paths[d] > paths[s]  + am[s][d])paths[d] =paths[s] + am[s][d];
                    }
                }
            }
        }
 
        for (int s= 1; s <= nov;s++)
        {
            for (int d = 1; d <= nov; d++)
            {
                if (am[s][d] != MAX_VALUE)
                {
                    if (paths[d] > paths[s]
                           + am[s][d])
                        System.out.println("The Graph contains negative edge cycle");
                }
            }
        }
 
        for (int v = 1; v <= nov; v++)          // vertex
        {
            System.out.println("distance of source  " + source + " to " + v + " is " + paths[v]);
        }
    }
 
    public static void main(String... arg)
    {
        int nov = 0;           //Number of vertices present
        int source;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        nov=sc.nextInt();
		sc.nextLine();
       
 
        int am[][] = new int[nov + 1][nov + 1];     // matrix
        
        System.out.println("Enter the adjacency matrix");
        for (int s = 1; s<=nov; s++)      // for source nodes
        {
            for (int d = 1; d <= nov; d++)   // destination nodes
            {
                am[s][d] = sc.nextInt();
 	        if (s == d)
                {
                    am[s][d] = 0;
                    continue;
                }
            if (am[s][d] == 0)
                {
                    am[s][d] = MAX_VALUE;                 
                }
            }
        }
 
        System.out.println("Enter the source vertex");
        source = sc.nextInt();
 
        Question3 qt = new Question3(nov);
        qt.Question3(source, am);
        sc.close();	
    }
}
