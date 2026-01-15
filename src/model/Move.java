package model;

/**
 * Represents all valid moves on a 2x2 Rubik's Cube.
 */
public enum Move {
    R,        // Right face clockwise
    R_PRIME,  // Right face counter-clockwise
    U,        // Up face clockwise
    U_PRIME,  // Up face counter-clockwise
    F,        // Front face clockwise
    F_PRIME   // Front face counter-clockwise
}
