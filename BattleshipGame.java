import java.util.Arrays;
import java.util.Random;

public class BattleshipGame{
    public static void main(String){
        int gameBoardLength = 4;
        char water = "_";
        char ship = "s";
        char hit = 'X';
        char miss = "O";
        int shipNumber = 3;

        char[][] gameBoard = createGameBoard(gameBoardLength, water, ship, shipNumber);
        printGameBoard(gameBoard, water, ship);

        int undectectedShipNumber = shipNumber;
        while (undectectedShipNumber > 0) {
            int[] guessCoordinates = getUserCoordinates(gameBoardLength);
             char locationViewUpdate = evaluateGuessAndGetTarget();
            if (locationViewUpdate == hit) {
                undectectedShipNumber--;
            }
            gameBoard = updatedGameBoard();
            printGameBoard(gameBoard, water, ship);
        }
    }

    private static int[] getUserCoordinates(int gameBoardLength){
        int row;
        int col;
        do{
            System.out.print("Row:");
            row = new Scanner(System.in).nextInt();
        }while (row < 0 || row > gameBoardLength + 1);
        do{
            System.out.print("Column: ");
            col = new Scanner(System.in).nextInt();
        } while (col < 0 || col > gameBoardLength + 1);
        return new int[]{row -1, col - 1};
        
        
    }


    private static void printGameBoard(char[][] gameBoard, char water, char ship) {
        int gameBoardLength = gameBoard.length;
        System.out.print(" ");
        for (int i = 0; i < gameBoardLength; i++){
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for(int row = 0; row < gameBoardLength; row++) {
            System.out.print(row + 1 + " ");
            for (col = 0; col < gameBoardLength; col++){
                char position = gameBoard[row][col];

                if (position == ship){
                    System.out.print(water + " ");
                }else{
                    System.out.print(position + " ");
                }
            }
            System.out.println();
            
        }
        System.out.println();
    }

private static char[][] gameBoard = createGameBoard(int gameBoardLength, char water, char ship, int shipNumber) {
        char[][] gameBoard = new char [gameBoardLength][gameBoardLength];
        for (char[] row : gameBoard){
            Arrays.fill(row, water);
        } 
        return placeShips(gameBoard, shipNumber, water, ship);
        }
     private static char[][] placeShips = createGameBoard(int gameBoardLength, char water, char ship, int shipNumber) {
            int placeShips = 0;
            int gameBoardLength = gameBoard.length;
            while (placeShips < shipNumber){
                int[] location = generateShipCoordinates(gameBoardLength);

                char possiblePlacement = gameBoard[location[0]][location[1]];
                if(possiblePlacement == water) {
                    gameBoard[location[0]][location[i]] = ship;  
                    placeShips++;
                }
                return gameBoard;
            }
        }

    private private static int[] generateShipCoordinates(int gameBoardLength) {
            int[] coordinates = new int[2];
            for (int i =0; i < coordinates.length; i++) {
                coordinates[i] = new Random().nextInt(game)
            }
            return coordinates;
        }

    }
