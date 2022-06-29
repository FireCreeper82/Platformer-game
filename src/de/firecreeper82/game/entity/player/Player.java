package de.firecreeper82.game.entity.player;

import de.firecreeper82.game.entity.EntityObject;

import java.awt.*;

public class Player extends EntityObject {
    public Player(int width, int height, int x, int y) {
        super(width, height, x, y);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.drawRect(x, y, width, height);
    }
}
