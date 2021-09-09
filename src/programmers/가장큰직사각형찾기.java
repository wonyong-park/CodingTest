package programmers;

public class 가장큰직사각형찾기 {
    public int solution(int [][]board){
        int row = board.length + 1;
        int col = board[0].length + 1;
        int[][] map = new int[row][col];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                map[i + 1][j + 1] = board[i][j];
            }
        }

        int val = 0;

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if(map[i][j] != 0){
                    map[i][j] = Math.min(Math.min(map[i][j - 1], map[i - 1][j]), map[i - 1][j - 1]) + 1;
                    val = Math.max(map[i][j], val);
                }
            }
        }

        return val * val;
    }
}
