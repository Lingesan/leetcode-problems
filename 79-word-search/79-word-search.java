class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int startIndex = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                boolean matchFound = checkRecursively(board, word, startIndex, visited, i, j);
                if (matchFound) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkRecursively(char[][] board, String word, int index, boolean[][] visited, int x, int y) {
        if (word.length() == index) {
            return true;
        }
        if (x >= board.length || x < 0 || y >= board[0].length || y < 0 || visited[x][y]
                || word.charAt(index) != board[x][y]) {
            return false;
        }
        visited[x][y] = true;
        boolean matchFound = checkRecursively(board, word, index + 1, visited, x + 1, y) ||
                checkRecursively(board, word, index + 1, visited, x - 1, y) ||
                checkRecursively(board, word, index + 1, visited, x, y + 1) ||
                checkRecursively(board, word, index + 1, visited, x, y - 1);
        visited[x][y] = matchFound;
        return matchFound;

    }
}