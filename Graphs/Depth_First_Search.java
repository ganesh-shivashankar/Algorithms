import java.util.*;

class GraphNodeDFS
{
	int vertex;
	ArrayList<Integer> edgeList = new ArrayList<Integer>();
}

public class Depth_First_Search 
{
	private static boolean[] m_visited = new boolean[6];
	
	private static void initializeNodes()
	{
		for(int i = 0; i < m_visited.length; i++)
			m_visited[i] = false;
	}
	
	//initialize all nodes as not-visited - outside the method
	private static void DFS_Adj_Matrix(int[][] graph, int source)
	{		
		//mark 'source - v' as visited
		m_visited[source - 1] = true;
		
		System.out.print(source);
				
		//for each of the edges (v, w)
		for(int i = 0; i < graph.length; i++)
		{
			//if(w is not visited)
			if((graph[source - 1][i] == 1) && (!m_visited[i]))
			{
				System.out.print(" -> ");
				
				//DFS_Adj_Matrix(graph, w);
				DFS_Adj_Matrix(graph, i+1);
			}
		}
	}
	
	private static void DFS_Adj_List(ArrayList<GraphNodeDFS> graph_adj_list, int source)
	{
		//set source-v as visited
		m_visited[source - 1] = true;
		System.out.print(source);
		
		//for each (v,w) edge
		ArrayList<Integer> edges = graph_adj_list.get(source - 1).edgeList;
		for(int i = 0; i < edges.size(); i++)
		{
			//if(w is not visited)
			int w = edges.get(i);
			if(!m_visited[w - 1])
			{
				System.out.print(" -> ");
				
				//mark w as visited
				m_visited[w - 1] = true;

				//dfs(graph, w)
				DFS_Adj_List(graph_adj_list, w);
			}
		}
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[][] adj_graph = new int[][] {
			{0, 1, 1, 0, 0, 0},
			{1, 0, 1, 0, 0, 1}, 
			{1, 1, 0, 0, 1, 0},
			{0, 0, 0, 0, 1, 1},
			{0, 0, 1, 1, 0, 1},
			{0, 1, 0, 1, 1, 0}
		};
		
		initializeNodes(); DFS_Adj_Matrix(adj_graph, 1); System.out.println(); //123546
		initializeNodes(); DFS_Adj_Matrix(adj_graph, 2); System.out.println(); //213546
		initializeNodes(); DFS_Adj_Matrix(adj_graph, 3); System.out.println(); //312645
		initializeNodes(); DFS_Adj_Matrix(adj_graph, 4); System.out.println(); //453126
		initializeNodes(); DFS_Adj_Matrix(adj_graph, 5); System.out.println(); //531264
		initializeNodes(); DFS_Adj_Matrix(adj_graph, 6); System.out.println(); //621354
		
		//Source nodes = 1, 2, 3, 4, 5, 6
		ArrayList<GraphNodeDFS> graph_adj_list = new ArrayList<>();
		
		GraphNodeDFS node1 = new GraphNodeDFS();
		node1.vertex = 1;
		node1.edgeList.add(2);
		node1.edgeList.add(3);
		graph_adj_list.add(node1);
				
		GraphNodeDFS node2 = new GraphNodeDFS();
		node2.vertex = 2;
		node2.edgeList.add(1);
		node2.edgeList.add(3);
		node2.edgeList.add(6);
		graph_adj_list.add(node2);
		
		GraphNodeDFS node3 = new GraphNodeDFS();
		node3.vertex = 3;
		node3.edgeList.add(1);
		node3.edgeList.add(2);
		node3.edgeList.add(5);
		graph_adj_list.add(node3);
		
		GraphNodeDFS node4 = new GraphNodeDFS();
		node4.vertex = 4;
		node4.edgeList.add(5);
		node4.edgeList.add(6);
		graph_adj_list.add(node4);
		
		GraphNodeDFS node5 = new GraphNodeDFS();
		node5.vertex = 5;
		node5.edgeList.add(3);
		node5.edgeList.add(4);
		node5.edgeList.add(6);
		graph_adj_list.add(node5);
		
		GraphNodeDFS node6 = new GraphNodeDFS();
		node6.vertex = 6;
		node6.edgeList.add(2);
		node6.edgeList.add(4);
		node6.edgeList.add(5);
		graph_adj_list.add(node6);
		
		System.out.println("------------");
		initializeNodes(); DFS_Adj_List(graph_adj_list, 1); System.out.println(); //123546
		initializeNodes(); DFS_Adj_List(graph_adj_list, 2); System.out.println();  //213546
		initializeNodes(); DFS_Adj_List(graph_adj_list, 3); System.out.println();  //312645
		initializeNodes(); DFS_Adj_List(graph_adj_list, 4); System.out.println();  //453126
		initializeNodes(); DFS_Adj_List(graph_adj_list, 5); System.out.println();  //531264
		initializeNodes(); DFS_Adj_List(graph_adj_list, 6); System.out.println();  //621354
	}
}

