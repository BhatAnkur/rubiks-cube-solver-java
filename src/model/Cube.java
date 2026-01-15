package model;

import java.util.Arrays;

/**
 * Represents a 2x2 Rubik's Cube.
 * Each cube has 6 faces with 4 stickers each (24 total).
 */
public class Cube {

    private final char[] state;

    // Constructor for solved cube
    public Cube() {
        this.state = new char[]{
                'W','W','W','W', // Up
                'Y','Y','Y','Y', // Down
                'R','R','R','R', // Front
                'O','O','O','O', // Back
                'G','G','G','G', // Left
                'B','B','B','B'  // Right
        };
    }

    // Copy constructor
    public Cube(char[] state) {
        this.state = Arrays.copyOf(state, state.length);
    }

    // Defensive copy
    public Cube copy() {
        return new Cube(this.state);
    }

    /**
     * Applies a move and returns a NEW cube (immutability).
     */
    public Cube applyMove(Move move) {
        Cube newCube = this.copy();

        switch (move) {
            case R -> rotateRight(newCube.state);
            case R_PRIME -> {
                rotateRight(newCube.state);
                rotateRight(newCube.state);
                rotateRight(newCube.state);
            }
            case U -> rotateUp(newCube.state);
            case U_PRIME -> {
                rotateUp(newCube.state);
                rotateUp(newCube.state);
                rotateUp(newCube.state);
            }
            case F -> rotateFront(newCube.state);
            case F_PRIME -> {
                rotateFront(newCube.state);
                rotateFront(newCube.state);
                rotateFront(newCube.state);
            }
        }

        return newCube;
    }

    // ---------------- Rotations ----------------

    private void rotateRight(char[] s) {
        cycle(s, 1, 9, 5, 21);
        cycle(s, 3, 11, 7, 23);
    }

    private void rotateUp(char[] s) {
        cycle(s, 0, 16, 8, 20);
        cycle(s, 1, 17, 9, 21);
    }

    private void rotateFront(char[] s) {
        cycle(s, 2, 18, 4, 22);
        cycle(s, 3, 19, 5, 23);
    }

    private void cycle(char[] s, int a, int b, int c, int d) {
        char temp = s[a];
        s[a] = s[d];
        s[d] = s[c];
        s[c] = s[b];
        s[b] = temp;
    }

    /**
     * Checks if cube is solved.
     */
    public boolean isSolved() {
        for (int i = 0; i < 24; i += 4) {
            char color = state[i];
            for (int j = i; j < i + 4; j++) {
                if (state[j] != color) return false;
            }
        }
        return true;
    }

    // Required for HashMap / HashSet (BFS)
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Cube)) return false;
        Cube other = (Cube) obj;
        return Arrays.equals(this.state, other.state);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(state);
    }
}
