
public class ShortestPath_Dijkstra 
{
	private static int[][] m_Adj_Matrix;
	
	private void shortestPath(int origin, int destination)
	{
		
	}
	
	public static void main(String[] args) 
	{
		m_Adj_Matrix = new int[][] {
			{0, 2, 5, 4, 0, 0, 0, 0},  //O -> A B C
			{2, 0, 2, 0, 7, 0, 12, 0}, //A -> O B F
			{5, 2, 0, 1, 4, 3, 0, 0},  //B -> O A C D E
			{4, 0, 1, 0, 0, 4, 0, 0},  //C -> O B E
			{0, 7, 4, 0, 0, 1, 0, 5},  //D -> A B E T
			{0, 0, 3, 4, 1, 0, 0, 7},  //E -> B C D T
			{0, 12, 0, 0, 0, 0, 0, 3}, //F -> A T
			{0, 0, 0, 0, 5, 7, 3, 0}   //T -> D E F
		};		
	
//		shortestPath(O, E); // (8 - OBE) -> O 2 5
//		shortestPath(O, T); // (13 - OABDT) -> O 1 2 4 7
//		shortestPath(A, C); // (3 - ABC) -> 1 2 3
//		shortestPath(C, F);	// (13 - CBDTF) -> 3 2 4 7 6

	}
}
