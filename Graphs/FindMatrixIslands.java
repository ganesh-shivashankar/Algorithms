import java.util.*;

class bNode
{
	public bNode(int row, int col) {
		this.row = row;
		this.col = col;
	}
	int row;
	int col;
}

public class FindMatrixIslands 
{
	private static int[][] m_matrix;
	private static boolean[][] m_visited;
	
	private static int m_RowCount = 0;
	private static int m_ColCount = 0;
	
	private static boolean validNode(int rowNum, int colNum)
	{
		if((rowNum < 0) || (rowNum > m_RowCount-1))
			return false;
		
		if((colNum < 0) || (colNum > m_ColCount-1))
			return false;			
		
		return true;
	}
	
	private static void dfs(int row, int col)
	{
		//mark 'source element - v' as visited
		m_visited[row][col] = true;
		
		//edge list
		//(row-1, col-1) (row-1, col) (row-1, col+1)
		//(row, col-1)   (row, col)   (row, col+1)
		//(row+1, col-1)  (row+1, col) (row+1, col+1)
		
		int[] adj_row = new int[] {row-1, row-1, row-1, row, row, row+1, row+1, row+1};
		int[] adj_col = new int[] {col-1, col, col+1, col-1, col+1, col-1, col, col+1};
		int neighboring_nodes = 8;
		
		//for each edge (v, w)
		for(int i = 0; i < neighboring_nodes; i++)
		{
			int rowNum = adj_row[i];
			int colNum = adj_col[i];
			
			//if(valid-node) and (not visited)
			if(validNode(rowNum, colNum) && (!m_visited[rowNum][colNum]))
			{
				//mark w as visited
				m_visited[rowNum][colNum] = true;
				
				//if(not-water)
				if(m_matrix[rowNum][colNum] == 1)
					//dfs(matrix, row, col)
					dfs(rowNum, colNum);
			}
		}
	}
	
	private static int getIslandCount_using_dfs()
	{
		m_visited = new boolean[m_RowCount][m_ColCount];
		for(int i = 0; i < m_matrix.length; i++)
			for(int j = 0; j < m_matrix[0].length; j++)
				m_visited[i][j] = false;
		
		int count = 0;
		
		for(int i = 0; i < m_matrix.length; i++)
			for(int j = 0; j < m_matrix[i].length; j++)
				if(!m_visited[i][j])
				{
					dfs(i, j);
					count++;
				}
		
		return count;
	}
	
	private static void bfs(int row, int col)
	{
		//mark node - S (row, col) as visited
		m_visited[row][col] = true;
		
		//Initialize a queue. Add S to the queue
		LinkedList<bNode> queue = new LinkedList<bNode>();
		bNode node = new bNode(row, col);
		queue.add(node);
		
		//while the Q is not empty
		while(!queue.isEmpty())
		{
			//get 1st element from Q - v
			bNode elem = queue.remove();			
			int v = elem.row;
			int w = elem.col;
								
			//declare 8 adjoining edges
			int[] adj_row = new int[] {v-1, v-1, v-1, v, v, v+1, v+1, v+1};
			int[] adj_col = new int[] {w-1, w, w+1, w-1, w+1, w-1, w, w+1};
			int neighboring_nodes = 8;
			
			//for each edge (v, w) 
			for(int i = 0; i < neighboring_nodes; i++)
			{
				int rowNum = adj_row[i];
				int colNum = adj_col[i];
				
				//if w is a valid node and is not visited
				if(validNode(rowNum, colNum) && (!m_visited[rowNum][colNum]))
				{
					//mark w as visited
					m_visited[rowNum][colNum] = true;
					
					//if w is 1
					if(m_matrix[rowNum][colNum] == 1)
					{
						bNode newNode = new bNode(rowNum, colNum);
						
						//add w to Q
						queue.add(newNode);
					}
				}
			}
		}
	}

	private static int getIslandCount_using_bfs()
	{
		//mark all nodes as not-visited
		m_visited = new boolean[m_RowCount][m_ColCount];
		for(int i = 0; i < m_matrix.length; i++)
			for(int j = 0; j < m_matrix[0].length; j++)
				m_visited[i][j] = false;		
		
		int count = 0;
		
		for(int i = 0; i < m_matrix.length; i++)
			for(int j = 0; j < m_matrix[i].length; j++)
				if(!m_visited[i][j])
				{
					bfs(i, j);					
					count++;
				}
		
		return count;
	}	
	
	public static void main(String[] args) 
	{
		m_matrix = new int[][] {
			{1, 0, 1, 1, 0, 0, 0, 1, 0},
			{1, 0, 0, 1, 1, 0, 0, 1, 1},
			{0, 0, 1, 0, 0, 0, 0, 1, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 1, 1, 0, 1, 0, 0},
			{1, 1, 0, 1, 1, 0, 1, 0, 1},
		};
		
//		m_matrix = new int[][] {
//			{1, 0, 1},
//			{0, 0, 1}
//		};
		
		m_RowCount = m_matrix.length;
		m_ColCount = m_matrix[0].length;
		
		System.out.println("Using DFS : "  + getIslandCount_using_dfs());
		System.out.println("Using BFS : "  + getIslandCount_using_bfs());
	
	}
}
