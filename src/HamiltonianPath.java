public class HamiltonianPath {

    static int height;
    static int width;
    static int[][] M;
    static int size;
    static int[] path;
    static int count = 0;

    public static void main(String[] args) {
        height = Integer.parseInt(args[1]);
        width = Integer.parseInt(args[0]);
        size = height * width;
        M = new int[size][size];
        generateMatrix(width, height);

        HamiltonPath(M, 1, width * (height - 1) + 1);
        System.out.println(count);
    }

    public static void HamiltonPath(int[][] M, int start, int end) {
        path = new int[size];
        path[0] = start;
        findHamiltonpath(M, 0, start, 1, end);
    }

    private static void findHamiltonpath(int[][] M, int x, int y, int l, int end) {
        int i;
        for (i = x; i < size; i++) {
            if (M[i][y - 1] != 0) {
                if (detect(path, i + 1))
                    continue;
                if (i == end - 1 && l != size - 1)
                    continue;
                l++;
                path[l-1] = i + 1;
                if (l == size) {
                    if (i == end - 1) {
                        count++;
                    }
                    l--;
                    continue;
                }
                M[i][y - 1] = M[y - 1][i] = 0;
                findHamiltonpath(M, 0, i + 1, l, end);
                l--;
                M[i][y - 1] = M[y - 1][i] = 1;
            }
        }
        path[l] = 0;
    }

    private static boolean detect(int[] x, int target) {
        boolean t = false;
        for (int i : x) {
            if (i == target) {
                t = true;
                break;
            }
        }
        return t;
    }

    public static void generateMatrix(int width, int height) {
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                populate(i, j);
            }
        }
    }

    /*
     * populate the neighboring indices for the square in "row" row and "col"
     * column of the grid
     */
    public static void populate(int row, int col) {
        int pos = (row - 1) * width + col;
        if (row != 1)
            mark(pos, (row - 2) * width + col);
        if (row != height)
            mark(pos, (row * width + col));
        if (col != width)
            mark(pos, (pos + 1));
        if (col != 1)
            mark(pos, (pos - 1));
    }

    public static void mark(int m, int n) {
        M[m - 1][n - 1] = 1;
    }
}
