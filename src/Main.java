import java.util.List;
import java.util.Random;

import model.Cube;
import model.Move;
import solver.BFSSolver;

/**
 * Entry point for the Rubik's Cube Solver application.
 */
public class Main {

    public static void main(String[] args) {

        // Step 1: Create a solved cube
        Cube cube = new Cube();

        // Step 2: Randomly scramble the cube
        Random random = new Random();
        Move[] moves = Move.values();

        int scrambleLength = 3; // keep small for fast BFS
        System.out.print("Scramble: ");

        for (int i = 0; i < scrambleLength; i++) {
            Move randomMove = moves[random.nextInt(moves.length)];
            cube = cube.applyMove(randomMove);
            System.out.print(randomMove + " ");
        }

        System.out.println();
        System.out.println("Solving using BFS...");

        // Step 3: Solve the cube using BFS
        BFSSolver solver = new BFSSolver();
        List<Move> solution = solver.solve(cube);

        // Step 4: Print solution
        System.out.println("Solution found in " + solution.size() + " moves:");
        for (Move move : solution) {
            System.out.print(move + " ");
        }
        System.out.println();
    }
}
