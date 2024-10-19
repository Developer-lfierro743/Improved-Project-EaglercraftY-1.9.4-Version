package com.xojang.eaglecrafty.core;

import org.lwjgl.opengl.GL11;
import org.lwjgl.glfw.GLFW;

public abstract class GameLoop {
    private boolean running;
    private long window;
    private int frames;
    private long lastTime;
    private Jframe fpsLabel;

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
        lastTime = System.nanoTime();
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
        frames++;
        if (fpsLabel != null) {
            fpsLabel.setText("FPS: " + getFPS());
        }

        public void stop(){
            running = false;
        }

        public int getFPS() {
            long currentTime = System.nanoTime();
            long deltaTime = currentTime - lastTime;
            lastTime = currentTime;
            int fps = (int) (frames / (deltaTime / 1e9));
            frames = 0;
            return fps;
        }
    }

    public void stop() {
        running = false;
    }

    public int getFPS() {
        long currentTime = System.nanoTime();
        long deltaTime = currentTime - lastTime;
        lastTime = currentTime;
        int fps = (int) (frames / (deltaTime / 1e9));
        frames = 0;
        return fps;
    }
}