class Spreadsheet {
    private int[][] grid; // stores cell values
    private int rows;

    public Spreadsheet(int rows) {
        this.rows = rows;
        grid = new int[rows][26]; // rows x 26 columns
    }

    public void setCell(String cell, int value) {
        int[] pos = getPosition(cell);
        grid[pos[0]][pos[1]] = value;
    }

    public void resetCell(String cell) {
        int[] pos = getPosition(cell);
        grid[pos[0]][pos[1]] = 0;
    }

    public int getValue(String formula) {
        // formula looks like "=X+Y"
        String exp = formula.substring(1); // remove '='
        String[] parts = exp.split("\\+");
        return getOperandValue(parts[0]) + getOperandValue(parts[1]);
    }

    // --- helpers ---
    private int getOperandValue(String s) {
        if (Character.isLetter(s.charAt(0))) {
            int[] pos = getPosition(s);
            return grid[pos[0]][pos[1]];
        } else {
            return Integer.parseInt(s);
        }
    }

    private int[] getPosition(String cell) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        return new int[]{row, col};
    }
}
