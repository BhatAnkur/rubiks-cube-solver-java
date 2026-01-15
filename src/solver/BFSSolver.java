package solver;

import model.Cube;
import model.Move;

import java.util.*;

/**
 * Solves a 2x2 Rubik's Cube using Breadth-First Search (BFS).
 */
public class BFSSolver {

    /**
     * Solves the cube and returns the shortest sequence of moves.
     */
    public List<Move> solve(Cube start) {

        Queue<Cube> queue = new LinkedList<>();
        Map<Cube, Cube> parent = new HashMap<>();
        Map<Cube, Move> moveUsed = new HashMap<>();

        // Initialize BFS
        queue.add(start);
        parent.put(start, null);

        while (!queue.isEmpty()) {

            Cube current = queue.poll();

            // Goal test
            if (current.isSolved()) {
                return reconstructPath(current, parent, moveUsed);
            }

            // Explore neighbors
            for (Move move : Move.values()) {
                Cube next = current.applyMove(move);

                if (!parent.containsKey(next)) {
                    parent.put(next, current);
                    moveUsed.put(next, move);
                    queue.add(next);
                }
            }
        }

        return Collections.emptyList();
    }

    /**
     * Reconstructs the solution path.
     */
    private List<Move> reconstructPath(
            Cube end,
            Map<Cube, Cube> parent,
            Map<Cube, Move> moveUsed
    ) {
        List<Move> path = new ArrayList<>();
        Cube current = end;

        while (parent.get(current) != null) {
            path.add(moveUsed.get(current));
            current = parent.get(current);
        }

        Collections.reverse(path);
        return path;
    }
}
