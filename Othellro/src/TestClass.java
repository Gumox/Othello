import java.util.Scanner;

public class TestClass {
	public static void main(String args[]){
		int[][] arr ={{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,2,0,2},{0,0,0,1,1,1,2,2}
	                  ,{2,2,2,1,2,1,2,2},{0,0,1,1,1,1,1,2},{0,0,0,0,0,1,2,2},{0,0,0,0,0,2,2,2}};
		int gameCount = 0;
		int amount = 0;
		int player = 2, enemy = 1, save = 0;
		int x = 0,y = 0;
		
		ReversiGame gameTest = new ReversiGame(arr);
		//gameTest.checkRU(player,  enemy);
		//gameTest.PrintStone();
				
		Scanner scan = new Scanner(System.in);	
		
		while(gameCount < 2){
			gameTest.ResetGP();
			gameTest.check(player,  enemy);
			gameTest.countGrayPoint(arr);
			if(gameCount != 0){
				if(gameTest.getGrayPoint() != 0){
					gameCount = 0;
				}
			}
			gameTest.PrintStone();
			System.out.printf("Black: %s White : %s\n", gameTest.countBPoint(arr),gameTest.countWPoint(arr));
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
				save = player;
				player = enemy;
				enemy = save;
			}
		}
		if(gameTest.countBPoint(arr)>gameTest.countWPoint(arr)){
			System.out.println("Black Win");
		}else if(gameTest.countBPoint(arr)<gameTest.countWPoint(arr)){
			System.out.println("White Win");
		}else if(gameTest.countBPoint(arr)==gameTest.countWPoint(arr)){
			System.out.println("Drow");
		}
	}
}
