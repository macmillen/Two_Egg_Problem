public class TwoEggProblem {
    public static void main(String[] args) {
        System.out.println(minEggDrops(1387, 4));
    }

    static int minEggDrops(int height, int eggs) {
        int[][] M = new int[height + 1][eggs + 1];
        for (int h = 1; h <= height; h++)
            M[h][1] = h;
        for (int e = 2; e <= eggs; e++)
            M[1][e] = 1;
        for (int e = 2; e <= eggs; e++) {
            for (int h = 2; h <= height; h++) {
                int minrest = Integer.MAX_VALUE;
                for (int i = 1; i <= h; i++) {
                    int rest = 0;
                    if (h - i <= 0)
                        rest = M[i - 1][e - 1];
                    else if (i - 1 <= 0)
                        rest = M[h - i][e];
                    else
                        rest = Math.max(M[h - i][e], M[i - 1][e - 1]);
                    minrest = Math.min(minrest, rest);
                }
                M[h][e] = minrest + 1;
            }
        }
        return M[height][eggs];
    }
}
