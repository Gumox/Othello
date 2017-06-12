import java.util.Scanner;

public class ReversiTestForText {
	public static void main(String args[]){
		int[][] arr ={{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,1,2,0,0,0}
	                  ,{0,0,0,2,1,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
		 //Y,X
		int gameCount = 0;
		int amount = 0;
		int player = 1, enemy = 2, save = 0;
		int x = 0,y = 0,zerosp = 60;
		
		Scanner scan = new Scanner(System.in);
		
		ReversiGame gameTest = new ReversiGame(arr);
		while(gameCount < 2&&zerosp!=0){
			gameTest.RecountStone();
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
			if(player == 1){
				System.out.println("Black Turn");
			}else if(player == 2){
				System.out.println("White Turn");
			}
			if(gameTest.getGrayPoint() == 2){
				gameCount++;
				save = player;
				player = enemy;
				enemy = player;
			}else if(gameTest.getGrayPoint() != 0){
				System.out.printf("Enter Point: ");
				amount = scan.nextInt();
				y = amount/10;
				x = amount - (y*10);
				if(arr[y][x]!=3){
					System.out.println("Can`t put stone this place");
				}else if(arr[y][x]==3){
					gameTest.putStone(x, y, player, enemy);
					save = player;
					player = enemy;
					enemy = save;
					zerosp--;
				}
			}else if(gameCount == 2){
				break;
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
