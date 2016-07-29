import java.util.ArrayList;
import java.util.LinkedList;

class GraphNode
{
	public int vertex;
	public ArrayList<Integer> edgeList = new ArrayList<Integer>();
}

public class Breadth_First_Search 
{
	
	//Implement BFS using an adjacency matrix
	//Should be a square adjacency matrix
	private static void BFS_Adjacency_Matrix(int[][] graph, int sourceNode)
	{
		//set all nodes initially unexplored
		boolean[] visited = new boolean[] { false, false, false, false, false, false };
				
		//mark 'sourceNode' as explored
		visited[sourceNode - 1] = true;
		
		//set Q = queue, initialize with 'sourceNode'
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(sourceNode - 1);
		
		//while(Q is not empty)
		while(!queue.isEmpty())
		{
			//remove the front element from the queue - 'v'
			int v = queue.remove();
			System.out.print(v + 1);
			
			//for each edge (v, w)
			for(int w = 0; w < graph.length; w++)
			{
				//if w is unexplored
				if((graph[v][w] == 1) && !visited[w])
				{
					//mark 'w' as explored
					visited[w] = true;
					
					//add 'w' to the end of the queue
					queue.add(w);
				}
			}
			
			if(!queue.isEmpty())
				System.out.print(" -> ");
		}
		
		System.out.println("");
	}
	
	//Implement breadth first search using adjacency list
	private static void BFS_Adjacency_List(ArrayList<GraphNode> graph, int sourceNode)
	{
		//set all nodes as 'not visited'
		boolean[] visited = new boolean[graph.size()];
		for(int i = 0; i < graph.size(); i++)
			visited[i] = false;
		
		visited[sourceNode - 1] = true;
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(sourceNode - 1);
		
		while(!queue.isEmpty())
		{
			int vertex = queue.remove();
			System.out.print(vertex + 1);
			
			GraphNode node = graph.get(vertex);
			for(int i = 0; i < node.edgeList.size(); i++)
			{
				int w = node.edgeList.get(i);
				
				if(!visited[w - 1])
				{
					visited[w - 1] = true;
					queue.add(w - 1);
				}
			}
			
			if(!queue.isEmpty())
				System.out.print(" -> ");
		}
		
		System.out.println("");
	}
	
	public static void main(String[] args) 
	{
		int graph_adjacency_matrix[][] = new int[][]{ {0, 1, 1, 0, 0, 0},
 								     				  {1, 0, 1, 0, 0, 1}, 
 								     				  {1, 1, 0, 0, 1, 0},
 								     				  {0, 0, 0, 0, 1, 1},
 								     				  {0, 0, 1, 1, 0, 1},
 								     				  {0, 1, 0, 1, 1, 0} };
		
		//Source nodes = 1, 2, 3, 4, 5, 6								     
		BFS_Adjacency_Matrix(graph_adjacency_matrix, 1); //123654
		BFS_Adjacency_Matrix(graph_adjacency_matrix, 2); //213654
		BFS_Adjacency_Matrix(graph_adjacency_matrix, 3); //312564
		BFS_Adjacency_Matrix(graph_adjacency_matrix, 4); //456321
		BFS_Adjacency_Matrix(graph_adjacency_matrix, 5); //534612
		BFS_Adjacency_Matrix(graph_adjacency_matrix, 6); //624513
		
		System.out.println("---------------------------");
		
		//Source nodes = 1, 2, 3, 4, 5, 6
		ArrayList<GraphNode> graph_adj_list = new ArrayList<>();
		
		GraphNode node1 = new GraphNode();
		node1.vertex = 1;
		node1.edgeList.add(2);
		node1.edgeList.add(3);
		graph_adj_list.add(node1);
				
		GraphNode node2 = new GraphNode();
		node2.vertex = 2;
		node2.edgeList.add(1);
		node2.edgeList.add(3);
		node2.edgeList.add(6);
		graph_adj_list.add(node2);
		
		GraphNode node3 = new GraphNode();
		node3.vertex = 3;
		node3.edgeList.add(1);
		node3.edgeList.add(2);
		node3.edgeList.add(5);
		graph_adj_list.add(node3);
		
		GraphNode node4 = new GraphNode();
		node4.vertex = 4;
		node4.edgeList.add(5);
		node4.edgeList.add(6);
		graph_adj_list.add(node4);
		
		GraphNode node5 = new GraphNode();
		node5.vertex = 5;
		node5.edgeList.add(3);
		node5.edgeList.add(4);
		node5.edgeList.add(6);
		graph_adj_list.add(node5);
		
		GraphNode node6 = new GraphNode();
		node6.vertex = 6;
		node6.edgeList.add(2);
		node6.edgeList.add(4);
		node6.edgeList.add(5);
		graph_adj_list.add(node6);
		
		BFS_Adjacency_List(graph_adj_list, 1); //123654
		BFS_Adjacency_List(graph_adj_list, 2); //213654
		BFS_Adjacency_List(graph_adj_list, 3); //312564
		BFS_Adjacency_List(graph_adj_list, 4); //456321
		BFS_Adjacency_List(graph_adj_list, 5); //534612
		BFS_Adjacency_List(graph_adj_list, 6); //624513
	}
}
