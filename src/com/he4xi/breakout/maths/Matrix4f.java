package com.he4xi.breakout.maths;

/**
 * Shit is seriously getting real now.
 * 4 X 4 matrix in COLUMN MAJOR ORDER.
 * Created by Rando on 20.12.2016.
 */
public class Matrix4f {
    public float[] matrix = new float[4 * 4]; // This is 1D array because OpenGL doesn't use 2D arrays.

    /**
     * This creates identity matrix (primary diagonal from left top to down bottom is all 1's and others are 0's).
     * @return identity matrix.
     */
    public static Matrix4f identity() {
        Matrix4f result = new Matrix4f();

        // Sets all elements to 0 (unnecessary actually, all 0 by default).
        for (int i = 0; i < 4 * 4; i++) {
            result.matrix[i] = 0.0f;
        }

        // Set main/primary diagonal to 1's.
        // Column Major Order.
        result.matrix[0 + 0 * 4] = 1.0f; // Set 1st element to 0 (row + column * width).
        result.matrix[1 + 1 * 4] = 1.0f; // (row + column * numRows).
        result.matrix[2 + 2 * 4] = 1.0f; // (row + column * numRows).
        result.matrix[3 + 3 * 4] = 1.0f; // (row + column * numRows).

        return result;
    }
}
