
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
					while(arr[i][j] == enemy){
						j++;
					}
					if(arr[i][j] == 0&&arr[i][j-1]==enemy){
						arr[i][j] = 3;
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
					while(arr[i][j] == enemy){
						j--;
					}
					if(arr[i][j] == 0&&arr[i][j+1]== enemy){
						arr[i][j] = 3;
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
					while(arr[i][j] == enemy){
						i++;
					}
					if(arr[i][j] == 0&&arr[i-1][j]==enemy){
						arr[i][j] = 3;
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
					while(arr[i][j] == enemy){
						i--;
					}
					if(arr[i][j] == 0&&arr[i+1][j]==enemy){
						arr[i][j] = 3;
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
					i++;
					j++;
					if(arr[i][j] == player){
						i++;
						j++;
						while(arr[i][j] == enemy){
							i++;
							j++;
						}
						if(arr[i][j]==0 && arr[i-1][j-1]==enemy){
							arr[i][j]=3;
						}
					}
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
					i--;
					j++;
					if(arr[i][j] == player){
						i--;
						j++;
						while(arr[i][j] == enemy){
							i--;
							j++;
						}
						if(arr[i][j]==0&&arr[i+1][j-1]==enemy){
							arr[i][j]=3;
						}
					}
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
					i++;
					j--;
					if(arr[i][j] == player){
						i++;
						j--;
						while(arr[i][j] == enemy){
							i++;
							j--;
						}
						if(arr[i][j]==0&&arr[i-1][j+1]==enemy){
							arr[i][j]=3;
						}
					}
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
					i--;
					j--;
					if(arr[i][j] == player){
						i--;
						j--;
						while(arr[i][j] == enemy){
							i--;
							j--;
						}
						if(arr[i][j]==0&&arr[i+1][j+1]==enemy){
							arr[i][j]=3;
						}
					}
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
		while(iy<8&&iy>-1&&arr[iy][x] == enemy&&point==0){                    // üũ���� 
			iy++;                                    
			if(arr[iy][x] == player){       // �÷��̾��� �ٸ� �� ã��
				point = 1;
				iy--;                       // �Դ� �������� �ٽ� ��
			}
		}
		while(iy<8&&iy>-1&&arr[iy][x] == enemy){         // �Դ� ���⿡ �ִ� ���� ���� ���̾����
			arr[iy][x] = player;            // ������ �ٲ�
			iy--;                           // ����, ���� ���� �� ���� ��ġ���� �Դٸ� ���� ���� �ƴϱ� ������ ���� 
		}
		iy = y-1;
		while(iy<8&&iy>-1&&arr[iy][x] == enemy &&point==1){ // �ٸ� �������� üũ����
			iy--;
			if(arr[iy][x] == player){ // �÷��̾��� �ٸ� ���� ã�Ƽ� �������� ��������
				point = 0;
				iy++;
			}
		}
		while(iy<8&&iy>-1&&arr[iy][y] == enemy){
			arr[iy][y] = player;
			iy++;
		}
		iy = 0;                              //i�� ���� 
	}	
	public void changeStoneHorizon(int x,int y ,int player,int enemy){ // ���μ� �� �ٲٱ�

		arr[y][x] = player;                                            // Gp�� player�� �ٲٱ�
		jx = x+1;                                                     
		while(jx<8 &&jx>-1&&arr[y][jx] == enemy &&point==0){                    // üũ���� 
			jx++;                                    
			if(arr[y][jx] == player){       // �÷��̾��� �ٸ� �� ã��
				point = 1;
				jx--;                       // �Դ� �������� �ٽ� ��
			}
		}
		while(jx<8 &&jx>-1&&arr[y][jx] == enemy){         // �Դ� ���⿡ �ִ� ���� ���� ���̾����
			arr[y][jx] = player;            // ������ �ٲ�
			jx--;                           // ����, ���� ���� �� ���� ��ġ���� �Դٸ� ���� ���� �ƴϱ� ������ ���� 
		}
		jx = x-1;
		while(jx<8 &&jx>-1&&arr[y][jx] == enemy&&point==1){ // �ٸ� �������� üũ����
			jx--;
			if(arr[y][jx] == player){ // �÷��̾��� �ٸ� ���� ã�Ƽ� �������� ��������
				point = 0;
				jx++;
			}
		}
		while(jx<8 &&jx>-1&&arr[y][jx] == enemy){
			arr[y][jx] = player;
			jx++;
		}
		jx = 0;                              //j�� ���� 
	}
	public void changeStoneDagonal(int x,int y ,int player,int enemy){ // �밢�� �� �ٲٱ�
		arr[y][x] = player;       // Gp�� player�� �ٲٱ�
		iy = y +1;
		jx = x+1;                                                     
		while(iy>-1&& jx<8&&jx>-1&&arr[iy][jx] == enemy&&point==0&&iy<8){                    // üũ���� 
			iy--;
			jx--;
			if(arr[iy][jx] == player){       // �÷��̾��� �ٸ� �� ã��
				point = 1;
				iy++;
				jx++;                       // �Դ� �������� �ٽ� ��
			}
		}
		while(iy>-1&& jx<8&&jx>-1&&arr[iy][jx] == enemy){         // �Դ� ���⿡ �ִ� ���� ���� ���̾����
			arr[iy][jx] = player;            // ������ �ٲ�
			iy++;
			jx++;                           // ����, ���� ���� �� ���� ��ġ���� �Դٸ� ���� ���� �ƴϱ� ������ ���� 
		}
		iy = y-1;
		jx = x-1;
		while(iy>-1&& jx<8&&jx>-1&&arr[iy][jx] == enemy&&point==1){ // �ٸ� �������� üũ����
			iy++;
			jx++;
			if(arr[iy][jx] == player){ // �÷��̾��� �ٸ� ���� ã�Ƽ� �������� ��������
				point = 0;
				iy--;
				jx--;
			}
		}
		while(iy>-1&& jx<8&&jx>-1&&arr[iy][jx] == enemy){
			arr[iy][jx] = player;
			iy--;
			jx--;
		}
		iy++;
		jx++;
		iy = 0;
		jx = 0;//j�� ���� 
	}
	public void changeStoneDifferentDagonal(int x,int y ,int player,int enemy){ // �밢�� �� �ٲٱ�
		arr[y][x] = player;       // Gp�� player�� �ٲٱ�
		iy = y-1;
		jx = x+1;                                                     
		while(iy<8&&iy>-1&& jx<8&&jx>-1&&arr[iy][jx] == enemy && point == 0){                    // üũ���� 
			iy++;
			jx--;
			if(arr[iy][jx] == player){       // �÷��̾��� �ٸ� �� ã��
				point = 1;
				iy--;
				jx++;                       // �Դ� �������� �ٽ� ��
			}
		}
		while(iy>-1&& jx<8&&jx>-1&&arr[iy][jx] == enemy){         // �Դ� ���⿡ �ִ� ���� ���� ���̾����
			arr[iy][jx] = player;            // ������ �ٲ�
			iy--;
			jx++;                           // ����, ���� ���� �� ���� ��ġ���� �Դٸ� ���� ���� �ƴϱ� ������ ���� 
		}
		iy = y+1;
		jx = x-1;
		
		while(iy<8&&iy>-1&& jx<8&&jx>-1&&arr[iy][jx] == enemy && point == 1){ // �ٸ� �������� üũ����
			iy++;
			jx--;
			if(arr[iy][jx] == player){ // �÷��̾��� �ٸ� ���� ã�Ƽ� �������� ��������
				point = 0;
				iy--;
				jx++;
			}
		}
		while(iy>-1&& jx<8&&jx>-1&&arr[iy][jx] == enemy){
			arr[iy][jx] = player;
			iy--;
			jx++;
		}
		iy++;
		jx--;
		iy = 0;
		jx = 0;//j�� ���� 
	}
	

}
