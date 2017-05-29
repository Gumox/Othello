import java.util.Scanner;

public class ReversiTestForText {
	public static void main(String args[]){
		int[][] arr ={{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,1,2,0,0,0}
	                  ,{0,0,0,2,1,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
		 //Y,X
		int gameCount = 0;
		int amount = 0;
		int player = 1, enemy = 2, save = 0;
		int x = 0,y = 0;
		
		Scanner scan = new Scanner(System.in);
		
		ReversiGame gameTest = new ReversiGame(arr);
		while(gameCount < 2 && gameCount > -1){
			gameTest.check(player,  enemy);
			gameTest.countGrayPoint(arr);
			if(gameCount != 0){
				if(gameTest.getGrayPoint() != 0){
					gameCount = 0;
				}
			}

			System.out.println("  01234567 ");
			System.out.println("----------");
			for(int i = 0; i<8 ;i++){//i=YÃà j=XÃà
				System.out.printf("%i¤Ó",i);
				for(int j = 0; j< 8 ;j++){
					if(arr[i][j] == 0){
						System.out.println("o");
					}else if(arr[i][j] == 1){
						System.out.println("B");
					}else if(arr[i][j] == 2){
						System.out.println("W");
					}else if(arr[i][j] == 3){
						System.out.println("O");
					}
					if(j == 8){
						System.out.println("\n");
					}
				}
			}
			System.out.printf("Black: %i White : %i\n", gameTest.countBPoint(arr),gameTest.countWPoint(arr));
			if(gameTest.getGrayPoint() == 0){
				gameCount++;
				save = player;
				player = enemy;
				enemy = player;
			}else if(gameTest.getGrayPoint() != 0){
				System.out.println("Enter Point: ");
				amount = scan.nextInt();
				y = amount/10;
				x = amount - (y*10);
				gameTest.putStone(x, y, player, enemy);
			}
		}
	}
}
