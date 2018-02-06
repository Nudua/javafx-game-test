package com.nudua.projectx.core;

import com.nudua.game.Core.GameObject;
import com.nudua.game.Core.Vector2D;
import com.nudua.game.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class SimpleGameObject extends GameObject {

    private Rectangle screenBounds;

    // Logic
    private double speed;
    private boolean goRight;
    private boolean goUp;

    public SimpleGameObject(Sprite sprite, Vector2D position, Rectangle screenBounds) {
        super(sprite, position);
        this.screenBounds = screenBounds;

        speed = 7;
        goRight = true;
        goUp = false;

        enabled = true;
    }

    @Override
    public void update() {
        // Don't update if this object isn't enabled
        if(!enabled) {
            return;
        }

        int width = (int)screenBounds.getWidth();
        int height = (int)screenBounds.getHeight();

        //right = true;

        // Bounce if we're outside the bounds of the screen on the x-axis
        if(position.getX() >= width - sprite.getBounds().getWidth()) {
            goRight = false;
        }
        else if(position.getX() <= 0) {
            goRight = true;
        }

        // Bounce if we're outside the bounds of the screen on the y-axis
        if(position.getY() >= height - sprite.getBounds().getHeight()) {
            goUp = true;
        }
        else if(position.getY() <= 0) {
            goUp = false;
        }

        double actualSpeed = goRight ? speed : -speed;

        double actualSpeedY = goUp ? -speed : speed;

        // add velocity to the sprite
        position.addX(actualSpeed);
        position.addY(actualSpeedY);

    }

    @Override
    public void draw(GraphicsContext gc) {
        // Don't draw if this object isn't enabled
        if(!enabled) {
            return;
        }

        gc.drawImage(sprite.getImage(), position.getX(), position.getY());
    }

}
