import java.util.*;

public class Reversi {
	private int arr[][];
	private int arr1[][];
	private int point;
	private int i = 0, j = 0;
	public Reversi(int[][] a){
		arr = a;
	}
	public void checkR(int b,int c){ // b�� ���� ������ �� c��  ��� ��
		for(int i = 0;i < 8 ; i++){
			if(arr[i][j] == b){      // 0,0���� ã�����
				while(j < 7){        // ���������� 1�� �����̸鼭 Gp�� ���� ��Ҹ� ã�´� 		
					j++;
					if(arr[i][j] == c && arr[i][j+1] == 0){
						arr[i][j+1] = 3;
					}
				}
				j = 0;               // j ���� ���� i�� +1 �� ���·� �Ѿ��	
			}
		}
	}
	public void checkL(int b,int c){ // b�� ���� ������ �� c��  ��� ��
		for(int i = 7;i >= 0 ; i--){
			for(int j = 7;j >= 0 ; j--){
				if(arr[i][j] == b){  //7,7���� ã�����
					point = j;       
					while(j >= 0 ){	 // �������� -1�� �����̸� Gp�� ������Ҹ� ã�´�						
						j--;
						if(arr[i][j] == b && arr[i][j-1] == c){
							arr[i][j-1] = 3;
						}
					}
				}
				j = 0;               // j ���� ���� i�� -1 �� ���·� �Ѿ��	
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
