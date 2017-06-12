
public class TestClass {
	public static void main(String args[]){
		int[][] arr ={{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,2,2,0,0,0}
	                  ,{0,0,0,2,2,2,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
		int player = 1, enemy = 2;
		
		ReversiGame gameTest = new ReversiGame(arr);
		gameTest.checkRU(player,  enemy);
		gameTest.PrintStone();
				
			
		
	}
}
