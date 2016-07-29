package cci;

public class FindRoute 
{
	private static boolean dfs(int start, int end, int[][] graph, boolean[] visited) 
	{
		visited[start] = true;		
		for(int i = 0; i < graph.length; i++)
		{
			if((graph[start][i] == 1) && !visited[i])
			{
				if(i == end)
					return true;
				else if (dfs(i, end, graph, visited))
					return true;
			}
		}		
		return false;
	}
	
	private static void findRoute(int start, int end, int[][] graph)
	{
		if((start < -1) || (end < -1) || (start > graph.length) || (end > graph.length)) {
			System.out.println("Invalid nodes.");
			return;
		}
		
		if(start == end) {
			System.out.println("Start node is same as end node");
			return;
		}
		
		boolean[] visited = new boolean[graph.length];
				
		if(dfs(start, end, graph, visited))
			System.out.println("Route exists between " + start + " and " + end);
		else
			System.out.println("No route exists between " + start + " and " + end);
	}
	
	public static void main(String[] args) 
	{
		int[][] graph = new int[][]{
			{0,1,0,0,0,0},
			{0,0,1,0,0,0},
			{0,0,0,1,1,0},
			{1,0,0,0,1,1},
			{0,0,0,0,0,0},
			{0,0,0,0,1,0}
		};

		findRoute(0, 0, graph); //A -> A
		findRoute(8, 5, graph); 
		findRoute(0, 5, graph); //A -> F
		findRoute(5, 2, graph); //F -> C
	}
}
