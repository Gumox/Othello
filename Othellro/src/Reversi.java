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

	public void checkD(int b,int c){
				for(int j = 0;j < 8 ; j++){
					if(arr[i][j] == b){      // 0,0���� ã�����
						while(i < 7){        // Y������ -1�� �����̸鼭 Gp�� ���� ��Ҹ� ã�´� 		
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
				if(arr[i][j] == b){      // 0,0���� ã�����
					while(j < 7){        // X������ +1 Y������ -1�� �����̸鼭 Gp�� ���� ��Ҹ� ã�´� 		
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
				if(arr[i][j] == b){      // 0,0���� ã�����
					while(j < 7){        // X������ +1 Y������ -1�� �����̸鼭 Gp�� ���� ��Ҹ� ã�´� 		
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
