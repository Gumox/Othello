
public class Reversi {
	private int arr[][] ;
	private int point;
	private int i = 0, j = 0;
	public Reversi(int[][] a){
		arr = a;
	}
	public void checkR(int b,int c){ // b는 현재 player c는  enemy
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

	
	public void changeStoneHorizon(int x,int y,int player,int enemy){ // 가로선 돌 바꾸기
		arr[x][y] = player;                                         // Gp를 player로 바꾸기
		i = x-1;                                                     
		while(arr[i][y] == enemy && point == 0&& i <= 0){                    // 체크시작 
			i--;                                    
			if(arr[i][y] == player){       // 플레이어의 다른 돌 찾음
				point = 1;
				i++;                       // 왔던 방향으로 다시 감
			}
		}
		while(arr[i][y] == enemy){         // 왔던 방향에 있던 돌은 적의 돌이어야함
			arr[i][y] = player;            // 내돌로 바꿈
			i++;                           // 진행, 만일 내가 둔 돌의 위치까지 왔다면 적의 돌이 아니기 때문에 멈춤 
		}
		i = x+1;
		while(arr[i][y] == enemy && point == 1 && i < 8){ // 다른 방향으로 체크시작
			i++;
			if(arr[i][y] == player){ // 플레이어의 다른 돌을 찾아서 루프에서 빠져나옴
				point = 0;
				i--;
			}
		}
		while(arr[i][y] == enemy){
			arr[i][y] = player;
			i--;
		}
		i = 0;                              //i값 리셋 
	}	
	public void changeStoneVertical(int x,int y ,int player,int enemy){ // 세로선 돌 바꾸기
		arr[x][y] = player;                                            // Gp를 player로 바꾸기
		j = y-1;                                                     
		while(arr[x][j] == enemy && point == 0&& j <= 0){                    // 체크시작 
			j--;                                    
			if(arr[x][j] == player){       // 플레이어의 다른 돌 찾음
				point = 1;
				j++;                       // 왔던 방향으로 다시 감
			}
		}
		while(arr[x][j] == enemy){         // 왔던 방향에 있던 돌은 적의 돌이어야함
			arr[x][j] = player;            // 내돌로 바꿈
			j++;                           // 진행, 만일 내가 둔 돌의 위치까지 왔다면 적의 돌이 아니기 때문에 멈춤 
		}
		j = x+1;
		while(arr[x][j] == enemy && point == 1 && j < 8){ // 다른 방향으로 체크시작
			j++;
			if(arr[x][j] == player){ // 플레이어의 다른 돌을 찾아서 루프에서 빠져나옴
				point = 0;
				j--;
			}
		}
		while(arr[x][j] == enemy){
			arr[x][j] = player;
			j--;
		}
		j = 0;                              //j값 리셋 
	}
	public void changeStoneDagonal(int x,int y ,int player,int enemy){ // 대각선 돌 바꾸기
		arr[x][y] = player;       // Gp를 player로 바꾸기
		i = x -1;
		j = y-1;                                                     
		while(arr[i][j] == enemy && point == 0&& i <= 0 && j <= 0){                    // 체크시작 
			i--;
			j--;
			if(arr[i][j] == player){       // 플레이어의 다른 돌 찾음
				point = 1;
				i++;
				j++;                       // 왔던 방향으로 다시 감
			}
		}
		while(arr[i][j] == enemy){         // 왔던 방향에 있던 돌은 적의 돌이어야함
			arr[i][j] = player;            // 내돌로 바꿈
			i++;
			j++;                           // 진행, 만일 내가 둔 돌의 위치까지 왔다면 적의 돌이 아니기 때문에 멈춤 
		}
		i = x+1;
		j = y+1;
		while(arr[i][j] == enemy && point == 1 && i < 8 && j <8){ // 다른 방향으로 체크시작
			i++;
			j++;
			if(arr[i][j] == player){ // 플레이어의 다른 돌을 찾아서 루프에서 빠져나옴
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
		j = 0;//j값 리셋 
	}
	public void changeStoneDifferentDagonal(int x,int y ,int player,int enemy){ // 대각선 돌 바꾸기
		arr[x][y] = player;       // Gp를 player로 바꾸기
		i = x+1;
		j = y-1;                                                     
		while(arr[i][j] == enemy && point == 0&& i <= 8 && j <= 0){                    // 체크시작 
			i++;
			j--;
			if(arr[i][j] == player){       // 플레이어의 다른 돌 찾음
				point = 1;
				i--;
				j++;                       // 왔던 방향으로 다시 감
			}
		}
		while(arr[i][j] == enemy){         // 왔던 방향에 있던 돌은 적의 돌이어야함
			arr[i][j] = player;            // 내돌로 바꿈
			i--;
			j++;                           // 진행, 만일 내가 둔 돌의 위치까지 왔다면 적의 돌이 아니기 때문에 멈춤 
		}
		i = x-1;
		j = y+1;
		
		while(arr[i][j] == enemy && point == 1 && i < 8 && j <0){ // 다른 방향으로 체크시작
			i++;
			j--;
			if(arr[i][j] == player){ // 플레이어의 다른 돌을 찾아서 루프에서 빠져나옴
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
		j = 0;//j값 리셋 
	}
	

}
