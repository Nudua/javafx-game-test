package com.nudua.game.Core;

import com.nudua.game.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;

import java.util.Objects;

public abstract class GameObject {

    protected boolean enabled;

    protected Sprite sprite;
    protected Vector2D position;

    public GameObject(Sprite sprite, Vector2D position) {
        this.sprite = Objects.requireNonNull(sprite, "sprite cannot be null");
        this.position = Objects.requireNonNull(position, "position cannot be null");
    }

    // Do something with this
    public void update() {}

    // SpriteBatch as a parameter instead?
    public abstract void draw(GraphicsContext gc);
}
