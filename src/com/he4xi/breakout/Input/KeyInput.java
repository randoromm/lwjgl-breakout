package com.he4xi.breakout.Input;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWKeyCallbackI;

/**
 * Key input class.
 * Created by Rando on 19.12.2016.
 */
public class KeyInput implements GLFWKeyCallbackI{
     public static boolean[] keys = new boolean[65536];

    @Override
    public void invoke(long window, int key, int scancode, int action, int mods) {
        keys[key] = action == GLFW.GLFW_RELEASE ? false : true;
//        if (action == GLFW.GLFW_PRESS || action == GLFW.GLFW_REPEAT) {
//            keys[key] = true;
//        } else {
//            keys[key] = false;
//        }
    }
}
