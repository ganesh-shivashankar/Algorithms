package cci;

import java.util.*;

class DepthFirstSearch
{
	private static final int NONE = 0;
	private static final int PROGRESS = 1;
	private static final int VISITED = 2;

	private int[][] m_Graph;
	private int[] m_Visited;
	private LinkedList<Integer> m_Dependency = new LinkedList<Integer>();
	
	public DepthFirstSearch(int[][] graph, int[] visited)
	{
		m_Graph = graph;
		m_Visited = visited;
	}
	
	public LinkedList<Integer> getDependency()
	{
		return m_Dependency;
	}
	
	public int[] getVisited()
	{
		return m_Visited;
	}
	
	//DFS(int source)
	//{
	//	mark source-v as 'visited'
	//	foreach of v,w edge
	//		if(w is not visited)
	//			dfs(w)
	//}
	
	public boolean DFS(int startIndex)
	{
		//Mark 'startIndex' - v as 'PROGRESS'
		m_Visited[startIndex] = PROGRESS;
		m_Dependency.add(startIndex);
		
		//for each v, w edge
		for(int i = 0; i < m_Graph.length; i++)
		{
			//if(w is 'NONE')
			if((m_Graph[startIndex][i] == 1) && (m_Visited[i] == NONE))
			{
				boolean isCyclic = DFS(i);
				if (isCyclic)
					return true;
			}
			//else if(w is 'PROGRESS')
			else if((m_Graph[startIndex][i] == 1) && (m_Visited[i] == PROGRESS))
			{
				//graph is cyclic. return true;
				return true;
			}				
		}
		
		return false;
	}
}

public class ProjectDependency 
{
	private static final int PROGRESS = 1;
	private static final int VISITED = 2;
	
	private static int[][] createDependencyMatrix(ArrayList<String> projects, String[][] dependencies)
	{
		int n = projects.size();		
		int[][] graph = new int[n][n];
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				graph[i][j] = 0;
				
		for(int i = 0; i < dependencies.length; i++)
		{
			int key_index = projects.indexOf(dependencies[i][0]);
			int value_index = projects.indexOf(dependencies[i][1]);			
			graph[key_index][value_index] = 1;
		}
		
		//print matrix
		for(int i = 0; i < graph.length; i++)
		{
			for(int j = 0; j < graph.length; j++)
				System.out.print(graph[i][j] + " ");
			System.out.println();
		}
		
		return graph;
	}
	
	//Implement logic using DFS : Topological Sort
	private static void findProjectOrder(int[][] graph, ArrayList<String> projects)
	{
		int n = graph.length;
		int[] visited = new int[n];
		
		for(int i = 0; i < n; i++)
			visited[i] = 0;
		
		boolean isCyclic = false;
		LinkedList<String> projectDependencies = new LinkedList<String>();
		
		for(int i = 0; i < n; i++)
		{
			DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph, visited);
			isCyclic = depthFirstSearch.DFS(i);
		
			if(isCyclic)
				break;
			else 
			{
				visited = depthFirstSearch.getVisited();
				LinkedList<Integer> dependencyDFS = depthFirstSearch.getDependency();
				
				//set all the PROGRESS to VISITED
				for(int j = 0; j < n; j++)
					if(visited[j] == PROGRESS)
						visited[j] = VISITED;
				
				for(int j = dependencyDFS.size()-1; j >= 0; j--)
					projectDependencies.addFirst(projects.get(dependencyDFS.get(j)));
			}
		}
		
		if(isCyclic)
			System.out.println("There is no topological sort order / dependency order as there is a cyclic dependency");
		else
		{
			for(int i = 0; i < projectDependencies.size(); i++)
				System.out.print(projectDependencies.get(i) + " ");
		}
	}
	
	public static void main(String[] args) 
	{
		ArrayList<String> projects = new ArrayList<String>(Arrays.asList("aa", "bb", "cc", "dd", "ee", "ff"));
		String[][] dependencies = new String[][]{
			{"aa", "dd"},
			{"ff", "bb"},
			{"bb", "dd"},
			{"ff", "aa"},
			{"dd", "cc"},
		};

		int[][] graph = createDependencyMatrix(projects, dependencies);
		
		findProjectOrder(graph, projects);
		
		//----------------------------------------------------------------------------
		
		System.out.println();
		
		ArrayList<String> projects2 = new ArrayList<String>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"));
		String[][] dependencies2 = new String[][]{
			{"a", "e"},
			{"b", "a"},
			{"b", "e"},
			{"b", "h"},
			{"c", "a"},
			{"d", "g"},
			{"f", "a"},
			{"f", "b"},
			{"f", "c"}
		};

		int[][] graph2 = createDependencyMatrix(projects2, dependencies2);
		
		findProjectOrder(graph2, projects2);
	}
}
