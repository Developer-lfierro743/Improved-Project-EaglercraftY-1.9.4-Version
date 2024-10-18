package com.xojang.eaglecrafty.core;

import org.lwjgl.opengl.GL11;
import org.lwjgl.glfw.GLFW;

public abstract class GameLoop {
    private boolean running;
    private long window;

    public static void start(long window) {
        GameLoop loop = new GameLoop() {
            @Override
            protected void update() {
                // Default implementation for update()
            }
        };
        loop.window = window;
        loop.running = true;
        loop.run();
    }

    public void run() {
        while (running) {
            update();
            render();
        }
    }

    protected abstract void update();

    private void render() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
        GLFW.glfwSwapBuffers(window);
        GLFW.glfwPollEvents();
    }

    public void stop() {
        running = false;
    }
}