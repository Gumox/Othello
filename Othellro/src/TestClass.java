
public class TestClass {
	public static void main(String args[]){
		int[][] arr ={{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,1,2,0,0,0}
	                  ,{0,0,0,2,1,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
		int player = 1, enemy = 2;
		
		ReversiGame gameTest = new ReversiGame(arr);
		gameTest.check(player,  enemy);
		for(int i = 0; i<8 ;i++){//i=YÃà j=XÃà
			for(int j = 0; j< 8 ;j++){
				System.out.printf("%i",arr[i][j]);
				if(j == 7){
					System.out.println("\n");
				}
				
			}
		}
	}
}
