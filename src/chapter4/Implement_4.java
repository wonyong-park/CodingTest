package chapter4;

import java.util.Scanner;

//실전 문제 : 게임 개발
public class Implement_4 {

	public static int n, m, x, y, direction;
	//방문한 위치 파악
	public static int[][] d = new int[50][50];
	//전체 맵 정보
	public static int[][] arr = new int[50][50];
	
	//북, 동, 남, 서 방향 정의
	public static int dx[] = {-1, 0, 1, 0};
	public static int dy[] = {0, 1, 0, -1};
	
	//왼쪽으로 회전
	public static void turn_left(){
		direction -= 1;
		if(direction == -1) direction = 3;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//n x m
		n = sc.nextInt();
		m = sc.nextInt();
		
		//현재 캐릭터의 x좌표, y좌표, 방향;
		x = sc.nextInt();
		y = sc.nextInt();
		direction = sc.nextInt();
		//현재 좌표 방문 처리
		d[x][y] = 1;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int cnt = 1;
		int turn_time = 0;
		
		while(true){
			//왼쪽으로 회전
			turn_left();
			int nx = x + dx[direction];
			int ny = y + dy[direction];
			
			//회전한 이후 왼쪽방향에 아직 가보지않은 칸이 존재하는경우
			if(d[nx][ny] == 0 && arr[nx][ny] == 0){
				d[nx][ny] = 1;
				x = nx;
				y = ny;
				cnt++;
				turn_time = 0;
				continue;
			}else{
				turn_time++;
			}
			
			if(turn_time == 4){
				nx = x - dx[direction];
				ny = y - dy[direction];
				
				//뒤로 갈 수 있다면 이동
				if(arr[nx][ny] == 0){
					x = nx;
					y = ny;
				}else break;
				turn_time = 0;
			}
			
		}
		
		System.out.println(cnt);
		
	}
}
