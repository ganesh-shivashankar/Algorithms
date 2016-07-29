import java.util.*;

public class Depth_First_Search_SelfLoop {
	
	//adjacency list
	private static LinkedList<Integer>[] m_graph;
	
	private static boolean[] m_visited;
	
	public static void DFS(int origin)
	{
		m_visited[origin] = true;
		System.out.print(origin + " ");

		while(!m_graph[origin].isEmpty())
		{			
			int node = m_graph[origin].remove();

			if(!m_visited[node])
			{
				m_visited[node] = true;
				DFS(node);
			}
		}
	}
	
	private static void setupGraph()
	{
		m_graph[0].clear();
		m_graph[0].add(1);
		m_graph[0].add(2);

		m_graph[1].clear();
		m_graph[1].add(2);
		
		m_graph[2].clear();
		m_graph[2].add(0);
		m_graph[2].add(3);
		
		m_graph[3].clear();
		m_graph[3].add(3);
		
		System.out.println(); 
		for(int i = 0; i < 4; i++)
			m_visited[i] = false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated meth	od stub

		m_graph = new LinkedList[4];

		//node-0
		m_graph[0] = new LinkedList();
				
		//node-1
		m_graph[1] = new LinkedList();
		
		//node-2
		m_graph[2] = new LinkedList();
		
		//node-3
		m_graph[3] = new LinkedList();
		
		m_visited = new boolean[4];
		
		setupGraph(); DFS(2); //2 0 1 3
		setupGraph(); DFS(0); //0 1 2 3
		setupGraph(); DFS(1); //1 2 0 3
		setupGraph(); DFS(3); //3
	}

}
