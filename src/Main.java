import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of grid in format 'X, Y', where X is width and Y is height:");
        String sizeAnswer = scanner.nextLine();
        String[] size = sizeAnswer.split(", ");

        int xSizeCol = Integer.parseInt(size[0]);
        int ySizeRow = Integer.parseInt(size[1]);

        try {

            // create grid with correct size
            Grid grid = new Grid(ySizeRow, xSizeCol);

            // create String array that we fill with rows for the grid
            String[] inputRows = new String[ySizeRow];
            System.out.println("You should enter " + ySizeRow + " sequences whit 0 and/or 1 and length " + xSizeCol + ":");
            for (int i = 0; i < ySizeRow; i++) {
                System.out.println("Sequence " + (i + 1) + ":");
                String inputRow = scanner.nextLine();
                inputRows[i] = inputRow;
            }

            // fill grid whit green and red cells from String array
            grid.fillGrid(inputRows);

            GreenVsRed game = new GreenVsRed(grid);
            System.out.println("Enter in format 'X, Y, N', where X is column, Y is row of coordinate of cell and N is number generation:");
            String inputGameAnswer = scanner.nextLine();
            String[] inputGame = inputGameAnswer.split(", ");
            int xCoordinateCol = Integer.parseInt(inputGame[0]);
            int yCoordinateRow = Integer.parseInt(inputGame[1]);
            int nGeneration = Integer.parseInt(inputGame[2]);

            int resultGame = game.play(yCoordinateRow, xCoordinateCol, nGeneration);
            System.out.println("Number of generation: " + resultGame);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
