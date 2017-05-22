import java.util.*;

public class Reversi {
	private int arr[][];
	private int arr1[][];
	private int point;
	private int i = 0, j = 0;
	public Reversi(int[][] a){
		arr = a;
	}
	public void checkR(int b,int c){ // b는 현재 차레의 말 c는  상대 말
		for(int i = 0;i < 8 ; i++){
			if(arr[i][j] == b){      // 0,0부터 찾기시작
				while(j < 7){        // 오른쪽으로 1씩 움직이면서 Gp를 놓을 장소를 찾는다 		
					j++;
					if(arr[i][j] == c && arr[i][j+1] == 0){
						arr[i][j+1] = 3;
					}
				}
				j = 0;               // j 값을 리셋 i에 +1 된 상태로 넘어간다	
			}
		}
	}

	public void checkD(int b,int c){
				for(int j = 0;j < 8 ; j++){
					if(arr[i][j] == b){      // 0,0부터 찾기시작
						while(i < 7){        // Y축으로 -1씩 움직이면서 Gp를 놓을 장소를 찾는다 		
							i++;
							if(arr[i][j] == c && arr[i+1][j] == 0){
								arr[i+1][j] = 3;
							}
						}
					j = 0;
			}
		}
	}
	
	public void checkLD(int b,int c){
		for(int i = 7; i >= 0 ; i--){
			for(int j =0; j<8; j++){
				if(i<7){
					j = 0;
				}
				if(arr[i][j] == b){      // 0,0부터 찾기시작
					while(j < 7){        // X축으로 +1 Y축으로 -1씩 움직이면서 Gp를 놓을 장소를 찾는다 		
						i++;
						j++;
						if(arr[i][j] == c && arr[i-1][j+1] == 0){
							arr[i-1][j+1] = 3;
						}
					}
				}	
				j = 0;
			}
		}				
	}
	public void checkRD(int b,int c){
		for(int i = 0; i < 8 ; i++){
			for(int j =0; j<8; j++){
				if(i>0){
					j = 0;
				}
				if(arr[i][j] == b){      // 0,0부터 찾기시작
					while(j < 7){        // X축으로 +1 Y축으로 -1씩 움직이면서 Gp를 놓을 장소를 찾는다 		
						i++;
						j++;
						if(arr[i][j] == c && arr[i+1][j+1] == 0){
							arr[i+1][j+1] = 3;
						}
					}
				}	
				j = 0;
			}
		}				
	}

	private void putStone(int x,int y,int player,int enemy){
		if(arr[x][y] == 3){
			
		}
	}

}
