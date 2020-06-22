public class Main {

    public static void main(String[] args) {
        int[][] sudoku1 = { {5, 3, 4, 6, 7, 8, 9, 1, 2},
                            {6, 7, 2, 1, 9, 5, 3, 4, 8},
                            {1, 9, 8, 3, 4, 2, 5, 6, 7},
                            {8, 5, 9, 7, 6, 1, 4, 2, 3},
                            {4, 2, 6, 8, 5, 3, 7, 9, 1},
                            {7, 1, 3, 9, 2, 4, 8, 5, 6},
                            {9, 6, 1, 5, 3, 7, 2, 8, 4},
                            {2, 8, 7, 4, 1, 9, 6, 3, 5},
                            {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        int[][] sudoku2 = { {5, 3, 4, 6, 7, 8, 9, 1, 2},
                            {6, 7, 2, 1, 9, 5, 3, 4, 8},
                            {1, 9, 0, 3, 4, 2, 5, 6, 7},
                            {8, 5, 9, 7, 6, 1, 4, 2, 3},
                            {4, 2, 6, 8, 5, 3, 7, 9, 1},
                            {7, 1, 3, 9, 2, 4, 0, 5, 6},
                            {9, 6, 1, 5, 3, 7, 2, 8, 4},
                            {2, 8, 1, 4, 1, 9, 6, 3, 5},
                            {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        System.out.println(validSolution(sudoku1));
        System.out.println(validSolution(sudoku2));
    }

    public static boolean validSolution(int[][] grid){
        if(grid.length != 9 || grid[0].length != 9){
            return false;
        }
        for (int i = 0; i < 9; i++) {
            boolean[] a = new boolean[9];
            for(int z = 0; z < 9; z++){
                a[z] = false;
            }
            for(int j = 0; j < 9; j++) {
                if(grid[i][j] == 0){
                    return false;
                } else {
                    if(a[j] == false) {
                        a[j] =true;
                    } else {
                        return false;
                    }
                }
            }
        }
        for (int j = 0; j < 9; j++) {
            boolean[] a = new boolean[9];
            for(int z = 0; z < 9; z++){
                a[z] = false;
            }
            for(int i = 0; i < 9; i++) {
                if(grid[i][j] != 0){
                    if(a[i] == false) {
                        a[i] =true;
                    } else {
                        return false;
                    }
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            boolean[] a = new boolean[9];
            for(int z = 0; z < 9; z++){
                a[z] = false;
            }
            for(int j = i % 3 * 3; j < i % 3 * 3 + 3; j++) {
                for (int z = i % 3 * 3; z < i % 3 * 3 + 3; z++) {
                    if (grid[j][z] != 0) {
                        if(a[grid[j][z] - 1] == false) {
                            a[grid[j][z] - 1] = true;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
