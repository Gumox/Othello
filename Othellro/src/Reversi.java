
public class Reversi {
	private int arr[][] ;
	private int point;
	private int i = 0, j = 0;
	public Reversi(int[][] a){
		arr = a;
	}
	public void checkR(int b,int c){ // b�� ���� player c��  enemy
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

	
	public void changeStoneHorizon(int x,int y,int player,int enemy){ // ���μ� �� �ٲٱ�
		arr[x][y] = player;                                         // Gp�� player�� �ٲٱ�
		i = x-1;                                                     
		while(arr[i][y] == enemy && point == 0&& i <= 0){                    // üũ���� 
			i--;                                    
			if(arr[i][y] == player){       // �÷��̾��� �ٸ� �� ã��
				point = 1;
				i++;                       // �Դ� �������� �ٽ� ��
			}
		}
		while(arr[i][y] == enemy){         // �Դ� ���⿡ �ִ� ���� ���� ���̾����
			arr[i][y] = player;            // ������ �ٲ�
			i++;                           // ����, ���� ���� �� ���� ��ġ���� �Դٸ� ���� ���� �ƴϱ� ������ ���� 
		}
		i = x+1;
		while(arr[i][y] == enemy && point == 1 && i < 8){ // �ٸ� �������� üũ����
			i++;
			if(arr[i][y] == player){ // �÷��̾��� �ٸ� ���� ã�Ƽ� �������� ��������
				point = 0;
				i--;
			}
		}
		while(arr[i][y] == enemy){
			arr[i][y] = player;
			i--;
		}
		i = 0;                              //i�� ���� 
	}	
	public void changeStoneVertical(int x,int y ,int player,int enemy){ // ���μ� �� �ٲٱ�
		arr[x][y] = player;                                            // Gp�� player�� �ٲٱ�
		j = y-1;                                                     
		while(arr[x][j] == enemy && point == 0&& j <= 0){                    // üũ���� 
			j--;                                    
			if(arr[x][j] == player){       // �÷��̾��� �ٸ� �� ã��
				point = 1;
				j++;                       // �Դ� �������� �ٽ� ��
			}
		}
		while(arr[x][j] == enemy){         // �Դ� ���⿡ �ִ� ���� ���� ���̾����
			arr[x][j] = player;            // ������ �ٲ�
			j++;                           // ����, ���� ���� �� ���� ��ġ���� �Դٸ� ���� ���� �ƴϱ� ������ ���� 
		}
		j = x+1;
		while(arr[x][j] == enemy && point == 1 && j < 8){ // �ٸ� �������� üũ����
			j++;
			if(arr[x][j] == player){ // �÷��̾��� �ٸ� ���� ã�Ƽ� �������� ��������
				point = 0;
				j--;
			}
		}
		while(arr[x][j] == enemy){
			arr[x][j] = player;
			j--;
		}
		j = 0;                              //j�� ���� 
	}
	public void changeStoneDagonal(int x,int y ,int player,int enemy){ // �밢�� �� �ٲٱ�
		arr[x][y] = player;       // Gp�� player�� �ٲٱ�
		i = x -1;
		j = y-1;                                                     
		while(arr[i][j] == enemy && point == 0&& i <= 0 && j <= 0){                    // üũ���� 
			i--;
			j--;
			if(arr[i][j] == player){       // �÷��̾��� �ٸ� �� ã��
				point = 1;
				i++;
				j++;                       // �Դ� �������� �ٽ� ��
			}
		}
		while(arr[i][j] == enemy){         // �Դ� ���⿡ �ִ� ���� ���� ���̾����
			arr[i][j] = player;            // ������ �ٲ�
			i++;
			j++;                           // ����, ���� ���� �� ���� ��ġ���� �Դٸ� ���� ���� �ƴϱ� ������ ���� 
		}
		i = x+1;
		j = y+1;
		while(arr[i][j] == enemy && point == 1 && i < 8 && j <8){ // �ٸ� �������� üũ����
			i++;
			j++;
			if(arr[i][j] == player){ // �÷��̾��� �ٸ� ���� ã�Ƽ� �������� ��������
				point = 0;
				i--;
				j--;
			}
		}
		while(arr[i][j] == enemy){
			arr[i][j] = player;
			i--;
			j--;
		}
		i++;
		j++;
		i = 0;
		j = 0;//j�� ���� 
	}
	public void changeStoneDifferentDagonal(int x,int y ,int player,int enemy){ // �밢�� �� �ٲٱ�
		arr[x][y] = player;       // Gp�� player�� �ٲٱ�
		i = x+1;
		j = y-1;                                                     
		while(arr[i][j] == enemy && point == 0&& i <= 8 && j <= 0){                    // üũ���� 
			i++;
			j--;
			if(arr[i][j] == player){       // �÷��̾��� �ٸ� �� ã��
				point = 1;
				i--;
				j++;                       // �Դ� �������� �ٽ� ��
			}
		}
		while(arr[i][j] == enemy){         // �Դ� ���⿡ �ִ� ���� ���� ���̾����
			arr[i][j] = player;            // ������ �ٲ�
			i--;
			j++;                           // ����, ���� ���� �� ���� ��ġ���� �Դٸ� ���� ���� �ƴϱ� ������ ���� 
		}
		i = x-1;
		j = y+1;
		
		while(arr[i][j] == enemy && point == 1 && i < 8 && j <0){ // �ٸ� �������� üũ����
			i++;
			j--;
			if(arr[i][j] == player){ // �÷��̾��� �ٸ� ���� ã�Ƽ� �������� ��������
				point = 0;
				i--;
				j++;
			}
		}
		while(arr[i][j] == enemy){
			arr[i][j] = player;
			i--;
			j++;
		}
		i++;
		j--;
		i = 0;
		j = 0;//j�� ���� 
	}
	

}
