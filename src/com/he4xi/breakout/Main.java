package com.he4xi.breakout;


import com.he4xi.breakout.Input.KeyInput;
import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLCapabilities;

import static org.lwjgl.glfw.GLFW.*; // Imports every static method from GLFW class. Stuff for window and input.
import static org.lwjgl.opengl.GL11.*; // Imports all static methods from. OpenGL shit.
import static org.lwjgl.system.MemoryUtil.*; // For null pointer addresses.


/**
 * Video at 28:06.
 * LWJGL game making test.
 * Breakout clone perhaps.
 * Created by Rando on 19.12.2016.
 */
public class Main implements Runnable{

    private int width = 1280;
    private int height = 720;

    private Thread thread;
    private boolean running = false;

    private long window; // Identifier/ ID for window (GLFW is written in C, no objects there).

    public void start() {
        running = true;
        thread = new Thread(this, "Game thread");
        thread.start();
    }

    public void init() {
        // Handle if it doesn't initialize correctly.
        if (!glfwInit()) {
            //TODO: handle it
            return;
        }

        glfwWindowHint(GL_TRUE, GLFW_RESIZABLE); // Kinda like parameters, hinting GLFW how to open our window.
        window = glfwCreateWindow(width, height, "Breakout", NULL, NULL);
        if (window == NULL) {
            // TODO: Handle
            return;
        }

        // Following sets the window in middle of the screen.
        GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        glfwSetWindowPos(window, (vidMode.width() - width) / 2, (vidMode.height() - height) / 2);

        glfwSetKeyCallback(window, new KeyInput()); // Could use lambda to pass in 'function' maybe.

        glfwMakeContextCurrent(window);
        glfwShowWindow(window);
        GL.createCapabilities(); // Let LWJGL know we made context current in this thread. Read javadoc.

        glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        glEnable(GL_DEPTH_TEST); // Enables specified OpenGL state.
        System.out.println("OpenGL: " + glGetString(GL_VERSION));
    }

    public void run() {
        init();
        while (running) {
            update();
            render();

            if (glfwWindowShouldClose(window)) {
                running = false;
            }
        }
    }

    private void render() {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // Clears both.
        glfwSwapBuffers(window);
    }

    private void update() {
        glfwPollEvents(); // Processes all pending events.
        if (KeyInput.keys[GLFW_KEY_RIGHT]) {
            System.out.println("RIGHT");
        }
        if (KeyInput.keys[GLFW_KEY_LEFT]) {
            System.out.println("LEFT");
        }
    }

    public static void main(String[] args) {
        new Main().start();
        System.out.println("LWJGL Version " + Version.getVersion() + " is working.");
    }
}
