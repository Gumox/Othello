
public class ReversiGame extends Reversi {
	public int grayPoint = 0;
	public int countW =0, countB=0,zeroSp=0;

	public ReversiGame(int[][] a) {
		super(a);
	}
	public void check(int player, int enemy){
		checkR(player,enemy);
		checkL(player,enemy);
		checkD(player,enemy);
		checkU(player,enemy);
		checkRD(player,enemy);
		checkRU(player,enemy);
		checkLD(player,enemy);
		checkLU(player,enemy);
	}
	public void putStone(int x,int y ,int player,int enemy){
		if(arr[y][x]==3){
			changeStoneHorizon(x,y,player,enemy);
			changeStoneVertical(x,y,player,enemy);
			changeStoneDagonal(x,y,player,enemy);
			changeStoneDifferentDagonal(x,y,player,enemy);
		}
	}
	public void countGrayPoint(int[][] arr){
		for(int i = 0; i < 8; i++){
			for(int j = 0; j<8;j++){
				if(arr[i][j] == 3){
					grayPoint++;
				}
			}
		}
	}
	public void ResetGP(){
		for(int i = 0; i < 8; i++){
			for(int j = 0; j<8;j++){
				if(arr[i][j] == 3){
					arr[i][j]=0;
				}
			}
		}
	}
	public int getGrayPoint(){
		return grayPoint;
	}
	public void setZeroGraypoint(){
		grayPoint = 0;
	}
	public int countBPoint(int[][] arr){
		for(int i = 0; i < 8; i++){
			for(int j = 0; j<8;j++){
				if(arr[i][j] == 1){
					countB++;
				}
			}
		}
		return countB;
	}
	public int countWPoint(int[][] arr){
		for(int i = 0; i < 8; i++){
			for(int j = 0; j<8;j++){
				if(arr[i][j] == 2){
					countW++;
				}
			}
		}
		return countW;
	}
	public void PrintStone(){
		System.out.println("   01234567 ");
		System.out.println("----------");
		for(int i = 0; i<8 ;i++){//i=YÃà j=XÃà
			System.out.printf("%s¤Ó",i);
			for(int j = 0; j< 8 ;j++){
				if(arr[i][j] == 0){
					System.out.printf(".");
				}else if(arr[i][j] == 1){
					System.out.printf("B");
				}else if(arr[i][j] == 2){
					System.out.printf("W");
				}else if(arr[i][j] == 3){
					System.out.printf("*");
				}

			}
			System.out.println(" ");
		}
	}
	public void RecountStone(){
		countW = 0;
		countB = 0;
	}
	
	
	public int getZeroSp(int[][] arr) {
		for(int i = 0;i<8;i++){
			for(int j = 0 ; j<8;j++){
				if(arr[i][j]==0){
					zeroSp++;
				}
			}
		}
		return zeroSp;
	}
	public void resetZeroSp(){
		zeroSp=0;
	}

}
