package de.firecreeper82.main;

import de.firecreeper82.window.Window;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Main extends Canvas implements Runnable{
    private static final long serialVersionUID = -3436459427505269359L;

    public static String name;
    public static Main instance;
    public static Handler handler;

    private Thread thread;
    private boolean running;

    private Window window;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        instance = this;
        name = "Platformer";

        handler = new Handler();
        window = new Window();
    }



    public void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1) {
                //calling tick method
                tick();
                delta--;
            }
            if(running)
                //calling render method
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("Current FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    public void stop() {
        try{
            thread.join();
            running = false;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(2);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        handler.render(g);

        g.dispose();
        bs.show();
    }

    public void tick() {
        handler.tick();
    }
}
