package chapter5;

import java.util.Scanner;

public class Bfsdfs5_10 {

	public static int n,m;
	public static int[][] graph = new int[1000][1000];
	
	//dfs로 특정 노드를 방문하고 연결된 모든 노드들도 방문
	public static boolean dfs(int x, int y){
		//주어진 범위를 벗어나는 경우에는 즉시 종료
		if(x <= -1 || x >= n || y <= -1 || y>=m){
			return false;
		}
		
		
		//현재 노드를 방문하지 않았다면
		if(graph[x][y] == 0){
			System.out.println("x : " + x + " y : " + y);

			//방문 처리
			graph[x][y] = 1;
			//상, 하, 좌, 우 재귀적 호출
			dfs(x -1, y);
			dfs(x , y-1);
			dfs(x+1 , y);
			dfs(x , y +1);
			return true;
		}
		
		return false;
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
        
     // 모든 노드(위치)에 대하여 음료수 채우기
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 현재 위치에서 DFS 수행
                if (dfs(i, j)) {
                	System.out.println("i : " + i + " j : " + j);
                    result += 1;
                }
            }
        }
        System.out.println(result); // 정답 출력 
	}
}
