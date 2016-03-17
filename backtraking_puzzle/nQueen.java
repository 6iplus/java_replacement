package CPE593;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class nQueen {
    public List<List<String>> solveNQueens(int n) {
    
    List<List<String>> ret = new ArrayList<>();
    if (n <= 0) return ret;
    char[][] curr = new char[n][n];
    for (char[] row : curr) {
        Arrays.fill(row, '.');
    }
    boolean[] col_occupied = new boolean[n];
    helper(ret, curr, col_occupied, 0, n);
    return ret;
}
private void helper(List<List<String>> ret, char[][] curr, boolean[] col_occupied, int r, int n) {
    if (r == n) {
        List<String> list = new ArrayList<String>();
        for (char[] row : curr) {
            list.add(new String(row));
        }
        ret.add(list);
        return;
    }
    for (int i=0; i<n; i++) {
        if (isValid(curr, col_occupied, r, i, n)){
            curr[r][i] = 'Q';
            col_occupied[i] = true;
            helper(ret, curr, col_occupied, r+1, n);
            curr[r][i] = '.';
            col_occupied[i] = false;
        }
    }
}
private boolean isValid(char[][]curr, boolean[] col_occupied, int row, int col, int n) {
    if (col_occupied[col]) return false;
    for (int i=1; row-i>=0 && col-i>=0; i++) {
        if (curr[row-i][col-i] == 'Q') return false;
    }
    for (int i=1; row-i>=0 && col+i<n; i++) {
        if (curr[row-i][col+i] == 'Q') return false;
    }
    return true;
    }
}

