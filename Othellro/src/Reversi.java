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
	public void checkL(int b,int c){ // b는 현재 차레의 말 c는  상대 말
		for(int i = 7;i >= 0 ; i--){
			for(int j = 7;j >= 0 ; j--){
				if(arr[i][j] == b){  //7,7부터 찾기시작
					point = j;       
					while(j >= 0 ){	 // 왼쪽으로 -1씩 움직이며 Gp를 놓으장소를 찾는다						
						j--;
						if(arr[i][j] == b && arr[i][j-1] == c){
							arr[i][j-1] = 3;
						}
					}
				}
				j = 0;               // j 값을 리셋 i에 -1 된 상태로 넘어간다	
			}
		}
	}
	public void checkU(int[][] a,int b){
		for(int i = 0;i < 8 ; i++){
			for(int j = 0;j < 8 ; j++){
				
			}
		}
	}
	public void checkD(int[][] a,int b){
		for(int i = 0;i < 8 ; i++){
			for(int j = 0;j < 8 ; j++){
				
			}
		}
	}
	public void checkRU(int[][] a,int b){
		for(int i = 0;i < 8 ; i++){
			for(int j = 0;j < 8 ; j++){
				
			}
		}
	}
	public void checkLU(int[][] a,int b){
		for(int i = 0;i < 8 ; i++){
			for(int j = 0;j < 8 ; j++){
				
			}
		}
	}
	public void checkRD(int[][] a,int b){
		for(int i = 0;i < 8 ; i++){
			for(int j = 0;j < 8 ; j++){
				
			}
		}
	}
	public void checkLD(int[][] a,int b){
		for(int i = 0;i < 8 ; i++){
			for(int j = 0;j < 8 ; j++){
				
			}
		}
	}

	private void putStone(){
		
	}

}
