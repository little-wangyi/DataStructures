package recursion;

public class MiGong {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 7; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][0] = 1;
        map[3][1] = 1;
        map[2][2] = 1;
        map[1][2] = 1;
        setWay(map, 1, 1);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    //迷宫策略是下 右 上 左
    public static boolean setWay(int[][] map, int i, int j) {
        //迷宫终点，如果到了终点 return true
        if (map[6][5] == 2) {
            return true;
        }
        //说明还没有走过
        if (map[i][j] == 0) {
            map[i][j] = 2;
            if (setWay(map, i + 1, j)) {
                return true;
            } else if (setWay(map, i, j + 1)) {
                return true;
            } else if (setWay(map, i - 1, j)) {
                return true;
            } else if (setWay(map, i, j - 1)) {
                return true;
            } else {
                map[i][j] = 3;
                return false;
            }
        } else {
            return false;
        }
    }
}