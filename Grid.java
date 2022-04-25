package tictactoe;

public class Grid {
    public final int n = 3;
    char[][] grid;
    int countX;
    int countO;
    int turn;

    public Grid() {
        grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = ' ';
            }
        }
        countX = 0;
        countO = 0;
        turn = 0;
    }

    public char getState() {
        //count wins: three in a row horizontal:
        String wins = "";
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][0] != ' ') {
                return grid[i][0];
            }
        }

        //count wins: three in a row vertical:
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == grid[1][j] && grid[1][j] == grid[2][j] && grid[0][j] != ' ') {
                return grid[0][j];
            }
        }

        //count wins: three in a row diagonal
        if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] != ' ') {
            return grid[0][0];
        }
        if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[0][2] != ' ') {
            return grid[0][2];
        }

        if (turn >= 9) {
            return 'D'; //draw
        }
        return 'C'; //continue


    }

    public char whosTurn() {
        return turn % 2 == 0 ? 'X' : 'O';
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append("---------\n");
        for (int i = 0; i < n; i++) {
            str.append("| ");
            for (int j = 0; j < n; j++) {
                str.append(String.format("%c ", grid[i][j]));
            }
            str.append("|\n");
        }
        str.append("---------\n");
        return str.toString();
    }

    public char getAt(int i, int j) {
        return grid[i][j];
    }

    public void setAt(int i, int j, char c) {
        grid[i][j] = c;
    }

    public int getCountX() {
        return countX;
    }

    public void setCountX(int countX) {
        this.countX = countX;
    }

    public int getCountO() {
        return countO;
    }

    public void setCountO(int countO) {
        this.countO = countO;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
}
