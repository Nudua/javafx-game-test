package com.nudua.game.graphics;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// Not yet
public class SpriteBatch {

    private GraphicsContext gc;

    public SpriteBatch(GraphicsContext gc) {
        gc = Objects.requireNonNull(gc, "gc cannot be null");
    }

    private Map<String, Image> images;

    public SpriteBatch() {
        images = new HashMap<>();
    }

    public void addImage(String name, InputStream stream) {
        images.put(name, new Image(stream));
    }

    // Lots of overloads for drawing stuff here
    // Rotation, scaling etc.
    public void draw(GraphicsContext gc, Sprite sprite) {


    }
}
