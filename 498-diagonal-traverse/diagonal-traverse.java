class Solution {
    public static int[] findDiagonalOrder(int[][] mat) {
        int i = 0, j = 0, m = mat.length, n = mat[0].length;
        int p = 0, len = n * m;
        int[] res = new int[len];

        while (p < len) {
            while (i >= 0 && j < n && p < len)
                res[p++] = mat[i--][j++];

            i++;
            j--;
            if (j + 1 >= n)
                i++;
            else
                j++;

            while (i < m && j >= 0 && p < len)
                res[p++] = mat[i++][j--];

            i--;
            j++;
            if (i + 1 >= m)
                j++;
            else
                i++;
        }
        return res;
    }
}
