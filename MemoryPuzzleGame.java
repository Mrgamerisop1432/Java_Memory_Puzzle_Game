import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class MemoryPuzzleGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Grid size and time to memorize
        final int gridSize = 4;
        final int timeToMemorize = 5; // seconds

        // Generate a random grid
        int[][] grid = new int[gridSize][gridSize];
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = random.nextInt(100); // Random numbers between 0-99
            }
        }

        // Display the grid for the player to memorize
        System.out.println("Memorize this grid:");
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }

        try {
            Thread.sleep(timeToMemorize * 1000); // Pause for memorization
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Clear the screen (simulate by printing blank lines)
        System.out.println("\n".repeat(50));
        System.out.println("Now, recall the grid!");

        // Input the grid from the player
        int[][] playerGrid = new int[gridSize][gridSize];
        for (int i = 0; i < gridSize; i++) {
            System.out.println("Enter row " + (i + 1) + " (space-separated numbers):");
            for (int j = 0; j < gridSize; j++) {
                playerGrid[i][j] = scanner.nextInt();
            }
        }

        // Check the answers
        int score = 0;
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (grid[i][j] == playerGrid[i][j]) {
                    score++;
                }
            }
        }

        // Display the results
        System.out.println("\nOriginal Grid:");
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("\nYour Input:");
        for (int[] row : playerGrid) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("\nYour Score: " + score + "/" + (gridSize * gridSize));

        if (score == gridSize * gridSize) {
            System.out.println("Excellent memory!");
        } else if (score > (gridSize * gridSize) / 2) {
            System.out.println("Good job, keep practicing!");
        } else {
            System.out.println("Better luck next time!");
        }

        scanner.close();
    }
}
