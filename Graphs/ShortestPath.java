import java.util.*;

public class ShortestPath 
{
	private static int O = 0;
	private static int A = 1;
	private static int B = 2;
	private static int C = 3;
	private static int D = 4;
	private static int E = 5;
	private static int F = 6;
	private static int T = 7;
	
	private static int[][] m_Adj_Matrix;
	
	//Shortest path using BFS works only when edge length = 1. For more generic case, use Dijkstra's algorithm
	private static void shortestPath_BFS(int origin, int destination)
	{
		int distance = 0;
		
		if(origin == destination)
		{
			System.out.println("Distance : " + distance + ". Path : " + origin);
			return;
		}
		
		Hashtable<Integer, Integer> connectivity_list = new Hashtable<Integer, Integer>();
		boolean[] visited = new boolean[m_Adj_Matrix.length];
		
		boolean pathFound = false;
						
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(origin);
		visited[origin] = true;
		
		while(!queue.isEmpty())
		{
			int node = queue.remove();
			
			if(node == destination)
			{
				pathFound = true;
				queue.clear();
				break;
			}
			
			for(int i = 0; i < m_Adj_Matrix.length; i++)
				if(!visited[i] && (m_Adj_Matrix[node][i] == 1))
				{
					visited[i] = true;
					connectivity_list.put(i, node);//destination, source (destination <- source)
					
					if(i == destination)
					{
						pathFound = true;
						break;
					}
					
					queue.add(i);
				}
			
			if(pathFound)
			{
				queue.clear();
				break;
			}
		}
		
		if(pathFound)
		{	
			StringBuilder sb = new StringBuilder();
			
			int end = destination;
			sb.append(end + " > ");
			
			int start = connectivity_list.get(end);
			sb.append(start);
			distance++;
			
			while(start != origin)
			{
				start = connectivity_list.get(start);
				sb.append(" > " + start);
				distance++;
			}
			
			//System.out.println(sb.reverse().toString());
			System.out.println("Distance : " + distance + ". Path : " + sb.reverse().toString());
		}
		else
		{
			System.out.println("No path exists between " + origin + " and " + destination);
		}
	}
	
	public static void main(String[] args) 
	{
		//graph is given at http://optlab-server.sce.carleton.ca/POAnimations2007/DijkstrasAlgo.html
		
		//path from O to E : 2
		//path from T to O : 4
		m_Adj_Matrix = new int[][] {
			{0, 1, 1, 1, 0, 0, 0, 0}, //O -> A B C
			{1, 0, 1, 0, 1, 0, 1, 0}, //A -> O B F
			{1, 1, 0, 1, 1, 1, 0, 0}, //B -> O A C D E
			{1, 0, 1, 0, 0, 1, 0, 0}, //C -> O B E
			{0, 1, 1, 0, 0, 1, 0, 1}, //D -> A B E T
			{0, 0, 1, 1, 1, 0, 0, 1}, //E -> B C D T
			{0, 1, 0, 0, 0, 0, 0, 1}, //F -> A T
			{0, 0, 0, 0, 1, 1, 1, 0}  //T -> D E F
		};
		
		shortestPath_BFS(O, E); //(OBE) 0 > 2 > 5
		shortestPath_BFS(O, T); //(OADT) 0 > 1 > 4 > 7
		shortestPath_BFS(A, C); //(AOC) 1 > 0 > 3
		shortestPath_BFS(C, F); //(COAF) 3 > 0 > 1 > 6
	}
}
