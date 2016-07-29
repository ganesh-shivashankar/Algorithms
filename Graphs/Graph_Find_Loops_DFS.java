
public class Graph_Find_Loops_DFS 
{
	private static boolean[] m_visited;
	private static boolean[] m_backpath;
	private static int[][] m_graph;
			
	private static boolean checkCycleUsingDFS(int sourceVertex)
	{
		//check for self-path for a vertex
		if(m_graph[sourceVertex][sourceVertex] == 1)
			return true;
			
		//set S as visited
		m_visited[sourceVertex] = true;
		
		//set S as in the back-path in [R]
		m_backpath[sourceVertex] = true;
		
		//for each node (S, W)
		for(int i = 0; i < m_graph.length; i++)
		{
			//no need to check the same vertex
			if(sourceVertex == i)
				continue;
				
			//if there is a path to W
			if(m_graph[sourceVertex][i] == 1)
			{
				//if 'W is visited' and 'is in back-path', cycle exists
				if(m_visited[i] && m_backpath[i])
					return true;
				else if(!m_visited[i]) //if W not visited
				{
					//mark W as visited and set the node as present in back-path
					m_visited[i] = true;
					m_backpath[i] = true;
					
	            	//DFS(W)
					if (checkCycleUsingDFS(i))
						return true;
				}
			}
		}
		
		//Set S as not in back-path
		m_backpath[sourceVertex] = false;
		
		return false;
	}
	
	private static boolean hasCycle()
	{
		//All nodes are set as not-visited
		m_visited = new boolean[m_graph.length];

		//All nodes are set as 'not-in' back-path [R]
		m_backpath = new boolean[m_graph.length];
		
		//for each of the node S in the graph, perform DFS. Initialize 'has-cycle = false'
		for(int i = 0; i < m_graph.length; i++)
			if(!m_visited[i])
				if(checkCycleUsingDFS(i))
					return true;
		
		return false;		
	}
	
	public static void main(String[] args) 
	{
		//non-directed graph, unit-weights
//		int [][] graph1 = new int[][]{
//			{0, 0, 0, 0},
//			{0, 0, 0, 0},
//			{0, 0, 0, 0},
//			{0, 0, 0, 0}
//		};
		
		//directed graph, unit-weights
		//m_graph = new int[][]{
		//	{0, 1, 1, 0},
		//	{0, 0, 1, 0},
		//	{1, 0, 0, 1},
		//	{0, 0, 0, 1}
		//};
		
		//directed graph, unit-weights
		m_graph = new int[][]{
			{0,0,0,0,0,0,1,0}, //1 -> 7
			{0,0,0,0,0,1,0,0}, //2 -> 6
			{1,0,0,0,1,0,0,0}, //3 -> 1 5
			{0,0,0,0,0,1,0,0}, //4 -> 6
			{0,1,0,1,0,0,0,0}, //5 -> 2 4
			{0,0,0,0,0,0,0,1}, //6 -> 8
			{0,1,0,0,0,0,0,1}, //7 -> 2 8
			{0,0,0,0,0,0,0,0}, //8
		};

		//non-directed graph, unit-weights
		m_graph = new int[][]{
			{0, 0, 1, 1, 0}, 
			{1, 0, 0, 0, 0},
			{1, 0, 0, 0, 0},
			{0, 0, 0, 0, 1},
			{0, 0, 0, 0, 0}
		};
		
		if(hasCycle())
			System.out.println("Has cycle.");
		else
			System.out.println("No cycle.");
	}
}
