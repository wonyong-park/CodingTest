package problem.chapter12;

public class 자물쇠와열쇠 {

    public static void main(String[] args) {
        자물쇠와열쇠 s = new 자물쇠와열쇠();
        int[][] key = {
                {0, 0, 0},
                {1, 0, 0},
                {0, 1, 1}
        };

        int[][] lock = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        System.out.println(s.solution(key, lock));
    }

    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;

        //총 4번회전시키는 key
        for (int i = 0; i < 4; i++) {
            key = rotate90(key);

            int[][] temp = new int[lock.length * 3][lock.length * 3];
            for (int j = 0; j < lock.length; j++) {
                for (int k = 0; k < lock.length; k++) {
                    temp[j + lock.length][k + lock.length] = lock[j][k];
                }
            }

            /*
            for (int j = 0; j < temp.length; j++) {
                for (int k = 0; k < temp.length; k++) {
                    System.out.print(temp[j][k] + " ");
                }
                System.out.println();
            }
             */



            for (int j = 0; j < temp.length- key.length + 1; j++) {
                for (int k = 0; k < temp.length- key.length + 1; k++) {
                    int[][] temp2 = new int[temp.length][temp.length];
                    for (int l = 0; l < temp.length; l++) {
                        for (int m = 0; m < temp.length; m++) {
                            temp2[l][m] = temp[l][m];
                        }
                    }

                    //값 더해주는 부분
                    for (int a = 0; a < key.length; a++) {
                        for (int b = 0; b < key.length; b++) {
                            temp2[j + a][k + b] += key[a][b];
                        }
                    }

                    //확인 부분
                    boolean open = true;
                    for (int a = 0; a < lock.length; a++) {
                        for (int b = 0; b < lock.length; b++) {
                            if (temp2[a + lock.length][b + lock.length] != 1) {
                                open = false;
                            }
                        }
                    }

                    if (open) {
                        answer = true;
                        break;
                    }

                    /*
                    for (int a = 0; a < temp2.length; a++) {
                        for (int b = 0; b < temp2.length; b++) {
                            System.out.print(temp2[a][b] + " ");
                        }
                        System.out.println();
                    }
                    System.out.println("=================");
                     */
                }
            }


        }

        return answer;
    }

    private int[][] rotate90(int[][] key) {
        int[][] temp = new int[key.length][key.length];

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                temp[j][temp.length - i - 1] = key[i][j];
            }
        }

        /*
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }
         */

        return temp;
    }
}
