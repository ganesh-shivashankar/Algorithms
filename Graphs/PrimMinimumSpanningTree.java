
public class PrimMinimumSpanningTree 
{
	private static int getMinIndex(int[] key, boolean[] visited)
	{
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		
		for(int i = 0; i < key.length; i++)
		{
			if(!visited[i] && (key[i] < min))
			{
				min = key[i];
				minIndex = i;
			}
		}
		
		return minIndex;
	}
	
	//Algorithm to find the minimum spanning tree of a connected, undirected graph
	//O(m log n) or O(m + n log n) : Greedy algorithm - polynomial time
	private static void minSpanningTree(int[][] graph)
	{
		int numVertices = graph.length;
		
		int[] parent = new int[numVertices];
		int[] key = new int[numVertices];		
		boolean[] visited = new boolean[numVertices];
		
		//Initialize all keys to infinity, all parents to zero and no nodes are present in MST
		for(int i = 0; i < numVertices; i++)
		{
			key[i] = Integer.MAX_VALUE;
			parent[i] = 0;
			visited[i] = false;
		}
		
		//set the key for the first node as 0; 
		key[0] = 0;
		parent[0] = -1;
		
		//for each of the vertices, assign keys and pick the min-weight vertex
		for(int i = 0; i < numVertices; i++)
		{
			//pick min-weight vertex v and add it to MST
			int v = getMinIndex(key, visited);
			
			visited[v] = true;
			
			//for each of v's adjacent vertices w, update key value if 'weight v-w from graph' < key[w].
			//Consider only those vertices which are not yet included in MST
			for(int j = 0; j < numVertices; j++)
			{
				if((graph[v][j] > 0) && (graph[v][j] < key[j]) && !visited[j])
				{
					parent[j] = v;
					key[j] = graph[v][j];
				}
			}
		}
		
		//print the minimum spanning tree
        System.out.println("Edge   Weight");
        for (int i = 1; i < numVertices; i++)
            System.out.println(parent[i] + " - " + i + "    " + graph[i][parent[i]]);
	}
	
	public static void main(String[] args) 
	{
		int[][] graph = new int[][] {
			{0, 4, 0, 0, 0, 0, 0, 8, 0},
			{4, 0, 8, 0, 0, 0, 0,11, 0},
			{0, 8, 0, 7, 0, 4, 0, 0, 2},
			{0, 0, 7, 0, 9,14, 0, 0, 0},
			{0, 0, 0, 9, 0,10, 0, 0, 0},
			{0, 0, 4,14,10, 0, 2, 0, 0},
			{0, 0, 0, 0, 0, 2, 0, 1, 6},
			{8,11, 0, 0, 0, 0, 1, 0, 7},
			{0, 0, 2, 0, 0, 0, 6, 7, 0}
		};
		
		minSpanningTree(graph);
	}
}
