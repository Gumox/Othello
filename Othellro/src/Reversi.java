
public class Reversi {
	protected int arr[][] ;
	private int point=0;
	private int k = 0, l = 0 ,iy =0,jx=0;
	public Reversi(int[][] a){
		arr = a;
	}
	public void checkR(int player,int enemy){ // b�� ���� player c��  enemy
		for(int i = 0;i < 8 ; i++){			
			for(int j =0;j<8;j++){           // 0,0���� ã�����// �Ʒ��� 1�� �����̸鼭 Gp�� ���� ��Ҹ� ã�´� 	
				if(arr[i][j] == player){
					j++;
					while(j<8&&arr[i][j] == enemy){
						j++;
					}
					if(j<8&&arr[i][j] == 0&&arr[i][j-1]==enemy){
						arr[i][j] = 3;
					}else {
						j--;
					}
				}
			}
		}
	}
	public void checkL(int player,int enemy){ // b�� ���� player c��  enemy
		for(int i = 0;i < 8 ; i++){			
			for(int j = 7 ;j > -1;j--){           // 0,0���� ã�����// �Ʒ��� 1�� �����̸鼭 Gp�� ���� ��Ҹ� ã�´� 	
				if(arr[i][j] == player){
					j--;
					while(j>-1&&arr[i][j] == enemy){
						j--;
					}
					if(j>-1&&arr[i][j] == 0&&arr[i][j+1]== enemy){
						arr[i][j] = 3;
					}else {
						j++;
					}
				}
			}
		}
	}

	public void checkD(int player,int enemy){ // b�� ���� player c��  enemy
		for(int j = 0;j < 8 ; j++){			
			for(int i =0;i<8;i++){           // 0,0���� ã�����// �Ʒ��� 1�� �����̸鼭 Gp�� ���� ��Ҹ� ã�´� 	
				if(arr[i][j] == player){
					i++;
					while(i<8&&arr[i][j] == enemy){
						i++;
					}
					if(i<8&&arr[i][j] == 0&&arr[i-1][j]==enemy){
						arr[i][j] = 3;
					}else {
						i--;
					}
				}
			}
		}
	}
	public void checkU(int player,int enemy){ // 
		for(int j = 0;j < 8 ; j++){			
			for(int i =7;i>-1;i--){           // 7,0���� ã�����// ���� 1�� �����̸鼭 Gp�� ���� ��Ҹ� ã�´� 	
				if(arr[i][j] == player){
					i--;
					while(i>-1&&arr[i][j] == enemy){
						i--;
					}
					if(i>-1&&arr[i][j] == 0&&arr[i+1][j]==enemy){
						arr[i][j] = 3;
					}else {
						i++;
					}
				}
			}
		}
	}
	
	public void checkRD(int player,int enemy){
		for(int i = 0;i < 8 ; i++){			
			for(int j =0;j<8;j++){
				k = i;
				l = j;
				if(i>7){
					break;
				}
				while(i<7&&j<7){
					if(i<8&&j<8&&arr[i][j] == player){
						i++;
						j++;
						while(i<8&&j<8&&arr[i][j] == enemy){
							i++;
							j++;
						}
						if(i<8&&j<8&&arr[i][j]==0 && arr[i-1][j-1]==enemy){
							arr[i][j]=3;
						}else {
							i--;
							j--;
						}
					}
					i++;
					j++;
				}
				i = k;
				if(k>0){
					i++;
				}
				j = l;
			}
		}
	}
	public void checkRU(int player,int enemy){
		for(int j = 0;j < 8 ; j++){			
			for(int i =7;i>-1;i--){
				if(j>0){
					i = 0;
				}
				k = i;
				l = j;
				while(i>0&&j<7){
					if(i>-1&&j<8&&arr[i][j] == player){
						i--;
						j++;
						while(i>-1&&j<8&&arr[i][j] == enemy){
							i--;
							j++;
						}
						if(i>-1&&j<8&&arr[i][j]==0&&arr[i+1][j-1]==enemy){
							arr[i][j]=3;
						}else {
							i++;
							j--;
						}
					}
					i--;
					j++;
				}
				i = k;
				j = l;
				if(l>0){
					j++;
				}
			}
		}
	}
	public void checkLD(int player,int enemy){
		for(int i = 0;i < 8 ; i++){			
			for(int j =7;j>-1;j--){
				if(i>0){
					j = 7;
				}
				k = i;
				l = j;
				if(i>7){
					break;
				}
				while(i<7&&j>0){
					if(i<8&&j>-1&&arr[i][j] == player){
						i++;
						j--;
						while(i<8&&j>-1&&arr[i][j] == enemy){
							i++;
							j--;
						}
						if(i<8&&j>-1&&arr[i][j]==0&&arr[i-1][j+1]==enemy){
							arr[i][j]=3;
						}else {
							i--;
							j++;
						}
					}
					i++;
					j--;
				}
				i = k;
				if(k>0){
					i++;
				}
				j = l;
			}
		}
	}
	public void checkLU(int player,int enemy){
		for(int j = 7;j > -1 ; j--){			
			for(int i =7;i>-1;i--){
				if(j<7){
					i = 7;
				}
				k = i;
				l = j;
				if(j<0){
					break;
				}
				while(i>0&&j>0){
					if(i>-1&&j>-1&&arr[i][j] == player){
						i--;
						j--;
						while(i>-1&&j>-1&&arr[i][j] == enemy){
							i--;
							j--;
						}
						if(i>-1&&j>-1&&arr[i][j]==0&&arr[i+1][j+1]==enemy){
							arr[i][j]=3;
						}else {
							i++;
							j++;
						}
					}
					i--;
					j--;
				}
				i = k;
				j = l;
				if(j<7){
					j--;
				}
			}
		}
	}

	
	public void changeStoneVertical(int x,int y,int player,int enemy){ // ���μ� �� �ٲٱ�
		arr[y][x] = player;                                         // Gp�� player�� �ٲٱ�
		iy = y+1;                                                     
		while(iy<8&&iy>-1&&arr[iy][x] == enemy&&point == 0){                    // üũ���� �Ʒ�����
			iy++;                                    
			if(iy<8&&iy>-1&&arr[iy][x] == player){       // �÷��̾��� �ٸ� �� ã��
				point = 1;
				iy--;                       // �Դ� �������� �ٽ� ��
			}
		}
		while(iy<8&&iy>-1&&arr[iy][x] == enemy){         // �Դ� ���⿡ �ִ� ���� ���� ���̾����
			arr[iy][x] = player;            // ������ �ٲ�
			iy--;                           // ����, ���� ���� �� ���� ��ġ���� �Դٸ� ���� ���� �ƴϱ� ������ ���� 
		}
		point = 0;
		iy = y-1;
		while(iy<8&&iy>-1&&arr[iy][x] == enemy &&point == 0){ // �ٸ� �������� üũ����
			iy--;
			if(iy<8&&iy>-1&&arr[iy][x] == player){ // �÷��̾��� �ٸ� ���� ã�Ƽ� �������� ��������
				point = 1;
				iy++;
			}
		}
		while(iy<8&&iy>-1&&arr[iy][x] == enemy){
			arr[iy][x] = player;
			iy++;
		}
		point = 0;
		iy = 0;                              //i�� ���� 
	}	
	public void changeStoneHorizon(int x,int y ,int player,int enemy){ // ���μ� �� �ٲٱ�

		arr[y][x] = player;                                            // Gp�� player�� �ٲٱ�
		jx = x+1;                                                     
		while(jx<8 &&jx>-1&&arr[y][jx] == enemy&&point == 0){                    // üũ���� 
			jx++;                                    
			if(jx<8 &&jx>-1&&arr[y][jx] == player){       // �÷��̾��� �ٸ� �� ã��
				point = 1;
				jx--;                       // �Դ� �������� �ٽ� ��
			}
		}
		while(jx<8 &&jx>-1&&arr[y][jx] == enemy){         // �Դ� ���⿡ �ִ� ���� ���� ���̾����
			arr[y][jx] = player;            // ������ �ٲ�
			jx--;                           // ����, ���� ���� �� ���� ��ġ���� �Դٸ� ���� ���� �ƴϱ� ������ ���� 
		}
		point = 0;
		jx = x-1;
		while(jx<8 &&jx>-1&&arr[y][jx] == enemy&&point == 0){ // �ٸ� �������� üũ����
			jx--;
			if(jx<8 &&jx>-1&&arr[y][jx] == player){ // �÷��̾��� �ٸ� ���� ã�Ƽ� �������� ��������
				point = 1;
				jx++;
			}
		}
		while(jx<8 &&jx>-1&&arr[y][jx] == enemy){
			arr[y][jx] = player;
			jx++;
		}
		point = 0;
		jx = 0;                              //j�� ���� 
	}
	public void changeStoneDagonal(int x,int y ,int player,int enemy){ // �밢�� �� �ٲٱ�
		arr[y][x] = player;       // Gp�� player�� �ٲٱ�
		iy = y+1;
		jx = x+1;                                                     
		while(iy>-1&&iy<8&& jx<8&&jx>-1&&arr[iy][jx] == enemy&&point == 0){                    // üũ���� 
			iy++;
			jx++;
			if(iy>-1&&iy<8&& jx<8&&jx>-1&&arr[iy][jx] == player){       // �÷��̾��� �ٸ� �� ã��
				point = 1;
				iy--;
				jx--;                       // �Դ� �������� �ٽ� ��
			}
		}
		while(iy>-1&&iy<8&& jx<8&&jx>-1&&arr[iy][jx] == enemy){         // �Դ� ���⿡ �ִ� ���� ���� ���̾����
			arr[iy][jx] = player;            // ������ �ٲ�
			iy--;
			jx--;                           // ����, ���� ���� �� ���� ��ġ���� �Դٸ� ���� ���� �ƴϱ� ������ ���� 
		}
		point = 0;
		iy = y-1;
		jx = x-1;
		while(iy>-1&&iy<8&& jx<8&&jx>-1&&arr[iy][jx] == enemy&&point == 0){ // �ٸ� �������� üũ����
			iy--;
			jx--;
			if(iy>-1&&iy<8&& jx<8&&jx>-1&&arr[iy][jx] == player){ // �÷��̾��� �ٸ� ���� ã�Ƽ� �������� ��������
				point = 1;
				iy++;
				jx++;
			}
		}
		while(iy>-1&&iy<8&& jx<8&&jx>-1&&arr[iy][jx] == enemy){
			arr[iy][jx] = player;
			iy++;
			jx++;
		}
		point = 0;
		iy = 0;
		jx = 0;//j�� ���� 
	}
	public void changeStoneDifferentDagonal(int x,int y ,int player,int enemy){ // �밢�� �� �ٲٱ�
		arr[y][x] = player;       // Gp�� player�� �ٲٱ�
		iy = y-1;
		jx = x+1;                                                     
		while(iy<8&&iy>-1&& jx<8&&jx>-1&&arr[iy][jx] == enemy&&point == 0){                    // üũ���� 
			iy--;
			jx++;
			if(iy<8&&iy>-1&& jx<8&&jx>-1&&arr[iy][jx] == player){       // �÷��̾��� �ٸ� �� ã��
				point = 1;
				iy++;
				jx--;                       // �Դ� �������� �ٽ� ��
			}
		}
		while(iy>-1&& jx<8&&jx>-1&&arr[iy][jx] == enemy){         // �Դ� ���⿡ �ִ� ���� ���� ���̾����
			arr[iy][jx] = player;            // ������ �ٲ�
			iy++;
			jx--;                           // ����, ���� ���� �� ���� ��ġ���� �Դٸ� ���� ���� �ƴϱ� ������ ���� 
		}
		point = 0;
		iy = y+1;
		jx = x-1;
		
		while(iy<8&&iy>-1&& jx<8&&jx>-1&&arr[iy][jx] == enemy&&point == 0){ // �ٸ� �������� üũ����
			iy++;
			jx--;
			if(iy<8&&iy>-1&& jx<8&&jx>-1&&arr[iy][jx] == player){ // �÷��̾��� �ٸ� ���� ã�Ƽ� �������� ��������
				point = 1;
				iy--;
				jx++;
			}
		}
		while(iy<8&&iy>-1&& jx<8&&jx>-1&&arr[iy][jx] == enemy){
			arr[iy][jx] = player;
			iy--;
			jx++;
		}
		point = 0;
		iy = 0;
		jx = 0;//j�� ���� 
	}
	

}
