package com.he4xi.breakout.maths;

/**
 * Shit is getting real.
 * Created by Rando on 20.12.2016.
 */
public class Vector3f {

    public float x, y, z; // z component is render order (higher is on top).

    public Vector3f() {
        // This is actually unnecessary. They would be 0 by default anyways.
        x = 0.0f;
        y = 0.0f;
        z = 0.0f;
    }

    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
