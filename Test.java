package aa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		Test test =  new Test();
		
		System.out.println(test.solveNQueens(4));


	}
	
	
	
	
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] row : board){
            Arrays.fill(row, '.');
        }
        List<List<String>> result = new ArrayList<>();
        dfs(board, 0, result);
        return result;
    }
    
    private void dfs(char[][] board, int colIndex, List<List<String>> result){
        if(colIndex == board.length){
            result.add(construct(board));
            return;
        }
        //在當前位置能夠放置皇后的情況下，向下一列遞歸。
        for(int rowIndex = 0; rowIndex < board.length; rowIndex++){
            if(validate(board, rowIndex, colIndex)){
                board[rowIndex][colIndex] = 'Q';
                dfs(board, colIndex + 1, result);
                board[rowIndex][colIndex] = '.';
            }
        }
    }
    
    //判斷當前位置(rowIndex,colIndex)是否能夠放置皇后
    private boolean validate(char[][] board, int rowIndex, int colIndex){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < colIndex; j++){
                if(board[i][j] == 'Q' && (colIndex - j == Math.abs(rowIndex - i) || rowIndex == i)){
                    return false;
                }
            }
        }
        return true;
    }

    private List<String> construct(char[][] board){
        List<String> result = new LinkedList<>();
        for(char[] rows : board){
            result.add(new String(rows));
        }
        return result;
    }

}
