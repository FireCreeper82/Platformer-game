package de.firecreeper82.window;

import de.firecreeper82.main.Main;
import de.firecreeper82.window.states.GameWindow;

public class Window {
    private GameWindow gameWindow;
    public static STATE gameState;

    public enum STATE {
        menu,
        game,
        ai
    }

    public Window() {
        gameWindow = new GameWindow();
        gameWindow.openWindow();
        Main.instance.start();
        gameState = STATE.game;
    }
}
