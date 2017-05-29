
public class ReversiGame extends Reversi {
	public int grayPoint = 0;
	public int countW =0, countB=0;

	public ReversiGame(int[][] a) {
		super(a);
	}
	public void check(int player, int enemy){
		checkR(player,enemy);
		checkD(player,enemy);
		checkRD(player,enemy);
		checkLD(player,enemy);
	}
	public void putStone(int x,int y ,int player,int enemy){
		if(arr[y][x]==3){
			arr[y][x] = player;
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
	public int getGrayPoint(){
		return grayPoint;
	}
	public void setZeroGraypoint(){
		grayPoint = 0;
	}
	public int countBPoint(int[][] arr){
		for(int i = 0; i < 8; i++){
			for(int j = 0; j<8;j++){
				if(arr[i][j] == 3){
					countB++;
				}
			}
		}
		return countW;
	}
	public int countWPoint(int[][] arr){
		for(int i = 0; i < 8; i++){
			for(int j = 0; j<8;j++){
				if(arr[i][j] == 3){
					countW++;
				}
			}
		}
		return countW;
	}
	

}
