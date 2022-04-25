package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        Grid grid = new Grid();
        System.out.println(grid);

        while (grid.getState() == 'C') {
            getUserInput(grid, scanner);
            System.out.println(grid);
        }

        switch (grid.getState()) {
            case 'X':
                System.out.println("X wins");
                break;
            case 'O':
                System.out.println("O wins");
                break;
            case 'D':
                System.out.println("Draw");
                break;
        }
    }


    public static void getUserInput(Grid grid, Scanner scanner) {
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Enter the coordinates: ");
            String inputCoordI = scanner.next();
            String inputCoordJ = scanner.next();

            int coordI;
            int coordJ;

            //check input: digits
            if (inputCoordI.matches("\\d") && inputCoordJ.matches("\\d")) {
                coordI = Integer.parseInt(inputCoordI) - 1;
                coordJ = Integer.parseInt(inputCoordJ) - 1;
            } else {
                System.out.println("You should enter numbers!");
                continue;
            }

            //check input: in grid
            if (coordI >= 0 && coordI < 3 && coordJ >= 0 && coordJ < 3) {
                if (grid.getAt(coordI, coordJ) == ' ') {
                    grid.setAt(coordI, coordJ, grid.whosTurn());
                    validInput = true;
                    grid.setTurn(grid.getTurn() + 1);
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            } else {
                System.out.println("Coordinates should be from 1 to 3!");
            }
        }
    }
}
