import java.util.*;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            pac[i][0] = true; 
            atl[i][n-1] = true; 
        }
        for (int j = 0; j < n; j++) {
            pac[0][j] = true; 
            atl[m-1][j] = true;
        }

        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!pac[i][j] && canFlow(heights, pac, i, j)) {
                        pac[i][j] = true;
                        changed = true;
                    }
                    if (!atl[i][j] && canFlow(heights, atl, i, j)) {
                        atl[i][j] = true;
                        changed = true;
                    }
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (pac[i][j] && atl[i][j])
                    res.add(Arrays.asList(i, j));
        return res;
    }

    private boolean canFlow(int[][] h, boolean[][] reachable, int i, int j) {
        int m = h.length, n = h[0].length;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (x >= 0 && x < m && y >= 0 && y < n && reachable[x][y] && h[i][j] >= h[x][y])
                return true;
        }
        return false;
    }
}
