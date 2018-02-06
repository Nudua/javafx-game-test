package com.nudua.projectx.core;

import com.nudua.game.Core.GameObject;
import com.nudua.game.Core.Vector2D;
import com.nudua.game.graphics.Sprite;
import com.nudua.game.input.InputManager;
import com.nudua.game.input.devices.KeyboardInput;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Player extends GameObject {

    private Rectangle screenBounds;

    // Logic
    private double speed;

    public Player(Sprite sprite, Vector2D position, Rectangle screenBounds) {
        super(sprite, position);
        this.screenBounds = screenBounds;

        speed = 7;

        enabled = true;
    }


    public void update(InputManager inputManager) {
        // Don't update if this object isn't enabled
        if(!enabled) {
            return;
        }

        // Very simple movement, doesn't check for any bounds
        if(inputManager.isPressed(KeyboardInput.Defaults.RIGHT)) {
            position.addX(speed);
        } else if(inputManager.isPressed(KeyboardInput.Defaults.LEFT)) {
            position.addX(-speed);
        }

        if(inputManager.isPressed(KeyboardInput.Defaults.UP)) {
            position.addY(-speed);
        } else if(inputManager.isPressed(KeyboardInput.Defaults.DOWN)) {
            position.addY(speed);
        }

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
