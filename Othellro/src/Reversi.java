
public class Reversi {
	protected int arr[][] ;
	private int point=0;
	private int k = 0, l = 0 ,iy =0,jx=0;
	public Reversi(int[][] a){
		arr = a;
	}
	public void checkR(int player,int enemy){ // b는 현재 player c는  enemy
		for(int i = 0;i < 8 ; i++){			
			for(int j =0;j<8;j++){           // 0,0부터 찾기시작// 아래로 1씩 움직이면서 Gp를 놓을 장소를 찾는다 	
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
	public void checkL(int player,int enemy){ // b는 현재 player c는  enemy
		for(int i = 0;i < 8 ; i++){			
			for(int j = 7 ;j > -1;j--){           // 0,0부터 찾기시작// 아래로 1씩 움직이면서 Gp를 놓을 장소를 찾는다 	
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

	public void checkD(int player,int enemy){ // b는 현재 player c는  enemy
		for(int j = 0;j < 8 ; j++){			
			for(int i =0;i<8;i++){           // 0,0부터 찾기시작// 아래로 1씩 움직이면서 Gp를 놓을 장소를 찾는다 	
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
			for(int i =7;i>-1;i--){           // 7,0부터 찾기시작// 위로 1씩 움직이면서 Gp를 놓을 장소를 찾는다 	
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

	
	public void changeStoneVertical(int x,int y,int player,int enemy){ // 가로선 돌 바꾸기
		arr[y][x] = player;                                         // Gp를 player로 바꾸기
		iy = y+1;                                                     
		while(iy<8&&iy>-1&&arr[iy][x] == enemy&&point==0){                    // 체크시작 
			iy++;                                    
			if(arr[iy][x] == player){       // 플레이어의 다른 돌 찾음
				point = 1;
				iy--;                       // 왔던 방향으로 다시 감
			}
		}
		while(iy<8&&iy>-1&&arr[iy][x] == enemy){         // 왔던 방향에 있던 돌은 적의 돌이어야함
			arr[iy][x] = player;            // 내돌로 바꿈
			iy--;                           // 진행, 만일 내가 둔 돌의 위치까지 왔다면 적의 돌이 아니기 때문에 멈춤 
		}
		iy = y-1;
		while(iy<8&&iy>-1&&arr[iy][x] == enemy &&point==1){ // 다른 방향으로 체크시작
			iy--;
			if(arr[iy][x] == player){ // 플레이어의 다른 돌을 찾아서 루프에서 빠져나옴
				point = 0;
				iy++;
			}
		}
		while(iy<8&&iy>-1&&arr[iy][y] == enemy){
			arr[iy][y] = player;
			iy++;
		}
		iy = 0;                              //i값 리셋 
	}	
	public void changeStoneHorizon(int x,int y ,int player,int enemy){ // 세로선 돌 바꾸기

		arr[y][x] = player;                                            // Gp를 player로 바꾸기
		jx = x+1;                                                     
		while(jx<8 &&jx>-1&&arr[y][jx] == enemy &&point==0){                    // 체크시작 
			jx++;                                    
			if(arr[y][jx] == player){       // 플레이어의 다른 돌 찾음
				point = 1;
				jx--;                       // 왔던 방향으로 다시 감
			}
		}
		while(jx<8 &&jx>-1&&arr[y][jx] == enemy){         // 왔던 방향에 있던 돌은 적의 돌이어야함
			arr[y][jx] = player;            // 내돌로 바꿈
			jx--;                           // 진행, 만일 내가 둔 돌의 위치까지 왔다면 적의 돌이 아니기 때문에 멈춤 
		}
		jx = x-1;
		while(jx<8 &&jx>-1&&arr[y][jx] == enemy&&point==1){ // 다른 방향으로 체크시작
			jx--;
			if(arr[y][jx] == player){ // 플레이어의 다른 돌을 찾아서 루프에서 빠져나옴
				point = 0;
				jx++;
			}
		}
		while(jx<8 &&jx>-1&&arr[y][jx] == enemy){
			arr[y][jx] = player;
			jx++;
		}
		jx = 0;                              //j값 리셋 
	}
	public void changeStoneDagonal(int x,int y ,int player,int enemy){ // 대각선 돌 바꾸기
		arr[y][x] = player;       // Gp를 player로 바꾸기
		iy = y +1;
		jx = x+1;                                                     
		while(iy>-1&& jx<8&&jx>-1&&arr[iy][jx] == enemy&&point==0&&iy<8){                    // 체크시작 
			iy--;
			jx--;
			if(arr[iy][jx] == player){       // 플레이어의 다른 돌 찾음
				point = 1;
				iy++;
				jx++;                       // 왔던 방향으로 다시 감
			}
		}
		while(iy>-1&& jx<8&&jx>-1&&arr[iy][jx] == enemy){         // 왔던 방향에 있던 돌은 적의 돌이어야함
			arr[iy][jx] = player;            // 내돌로 바꿈
			iy++;
			jx++;                           // 진행, 만일 내가 둔 돌의 위치까지 왔다면 적의 돌이 아니기 때문에 멈춤 
		}
		iy = y-1;
		jx = x-1;
		while(iy>-1&& jx<8&&jx>-1&&arr[iy][jx] == enemy&&point==1){ // 다른 방향으로 체크시작
			iy++;
			jx++;
			if(arr[iy][jx] == player){ // 플레이어의 다른 돌을 찾아서 루프에서 빠져나옴
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
		jx = 0;//j값 리셋 
	}
	public void changeStoneDifferentDagonal(int x,int y ,int player,int enemy){ // 대각선 돌 바꾸기
		arr[y][x] = player;       // Gp를 player로 바꾸기
		iy = y-1;
		jx = x+1;                                                     
		while(iy<8&&iy>-1&& jx<8&&jx>-1&&arr[iy][jx] == enemy && point == 0){                    // 체크시작 
			iy++;
			jx--;
			if(arr[iy][jx] == player){       // 플레이어의 다른 돌 찾음
				point = 1;
				iy--;
				jx++;                       // 왔던 방향으로 다시 감
			}
		}
		while(iy>-1&& jx<8&&jx>-1&&arr[iy][jx] == enemy){         // 왔던 방향에 있던 돌은 적의 돌이어야함
			arr[iy][jx] = player;            // 내돌로 바꿈
			iy--;
			jx++;                           // 진행, 만일 내가 둔 돌의 위치까지 왔다면 적의 돌이 아니기 때문에 멈춤 
		}
		iy = y+1;
		jx = x-1;
		
		while(iy<8&&iy>-1&& jx<8&&jx>-1&&arr[iy][jx] == enemy && point == 1){ // 다른 방향으로 체크시작
			iy++;
			jx--;
			if(arr[iy][jx] == player){ // 플레이어의 다른 돌을 찾아서 루프에서 빠져나옴
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
		jx = 0;//j값 리셋 
	}
	

}
