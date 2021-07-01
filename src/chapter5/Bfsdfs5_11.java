package chapter5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node10{
	
	private int x;
	private int y;
	
	public Node10(int x, int y) {
		this.x =x;
		this.y =y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
}

public class Bfsdfs5_11 {

	public static int n,m;
	public static int[][] graph = new int[201][201];
	
	//이동할 4방향 상 하 좌 우
	public static int dx[] = {-1, 1, 0, 0};
	public static int dy[] = {0, 0, -1, 1};
	
	public static int bfs(int x, int y){
		Queue<Node10> q = new LinkedList<>();
		q.offer(new Node10(x, y));
		
		//q가 빌떄까지 반복
		while(!q.isEmpty()){
			Node10 node = q.poll();
			x = node.getX();
			y = node.getY();
			
			//현재 위치에거 4가지 방향으로의 위치 확인
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				//미로 공간을 벗어난 경우
				if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				//벽인경우 무시
				if(graph[nx][ny] == 0) continue;
				//해당 노드를 처음 방문하는 경우에만 최단 거리 기록
				if(graph[nx][ny] == 1){
					graph[nx][ny] = graph[x][y]+1;
					q.offer(new Node10(nx,ny));
				}
			}
			
		}
		
		return graph[n-1][m-1];
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

        // N, M을 공백을 기준으로 구분하여 입력 받기
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); // 버퍼 지우기

        // 2차원 리스트의 맵 정보 입력 받기
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        // BFS를 수행한 결과 출력
        System.out.println(bfs(0, 0));
	}
}
