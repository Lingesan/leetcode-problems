class Solution {
    public void solveSudoku(char[][] board) {
        solveSudokuRecursive(board);
    }
    
    private boolean solveSudokuRecursive(char[][] board){
        for(int i = 0; i < 9;i++){
            for(int j = 0; j < 9;j++){
                if(board[i][j] != '.'){
                    continue;
                }
                for(char val='1';val<='9';val++){
                    if(isValidCharacter(board,i,j,val)){
                        board[i][j] = val;
                        if(solveSudokuRecursive(board)){
                            return true ;
                        } else {
                            board[i][j] = '.';
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }
    
    private boolean isValidCharacter(char[][] board, int i, int j, char val){
        return isValidRow(board[i], val) && isValidColumn(board,j, val) && isValidSubBox(board,i,j,val);
    }
       
    private boolean isValidRow(char[] row, char value){
        for(char cell: row){
            if(cell == value){
                return false;
            }
        }
        return true;
    }
    
    private boolean isValidColumn(char[][] board,int columnIndex, char value){
        
        for(char[] row: board){
            if(row[columnIndex] == value){
                return false;
            }
        }
        return true;
    }
    
    private boolean isValidSubBox(char[][] board, int rowIndex, int columnIndex, char value){
        int k = rowIndex / 3;
        int l = columnIndex / 3;
        for(int i = k*3; i< k*3 + 3;i++){
            for( int j = l * 3; j < l*3 +3;j++){
                if(board[i][j] == value){
                    return false;
                }
            }
        }
        return true;
    }
}