package p302;

/**
 * Created by senyuanwang on 15/11/8.
 */
public class Solution {
    private static int[] dx = {-1, 0, 0, 1};
    private static int[] dy = {0, -1, 1, 0};

    public int minArea(char[][] image, int x, int y) {
        int m = image.length;
        int n = image[0].length;

        int[] cords = new int[4];
        cords[0] = x;
        cords[1] = y;
        cords[2] = x;
        cords[3] = y;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (image[i][j] == '1') {
                    findCords(image, i, j, cords);
                    break;
                }
            }
        }

        return (cords[2] - cords[0] + 1) * (cords[3] - cords[1] + 1);
    }

    private void findCords(char[][] image, int i, int j, int[] cords) {
        image[i][j] = '2';
        if (i < cords[0]) {
            cords[0] = i;
        }

        if (j < cords[1]) {
            cords[1] = j;
        }

        if (i > cords[2]) {
            cords[2] = i;
        }

        if (j > cords[3]) {
            cords[3] = j;
        }

        for (int k = 0; k < dx.length; k++) {
            int x = dx[k] + i;
            int y = dy[k] + j;

            if (x < 0 || x >= image.length) {
                continue;
            }

            if (y < 0 || y >= image[0].length) {
                continue;
            }

            if (image[x][y] == '1') {
                findCords(image, x, y, cords);
            }
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        char[][] image = {"0010".toCharArray(), "0110".toCharArray(), "0100".toCharArray()};

        System.out.println(solution.minArea(image, 0, 2));
    }
}
