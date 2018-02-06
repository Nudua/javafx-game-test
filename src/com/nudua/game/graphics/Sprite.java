package com.nudua.game.graphics;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

import java.util.Objects;

public class Sprite {

    private String name;
    private Rectangle bounds;

    // Ideally you would load all the images into a single Map<String, Image> then fetch it from there instead of having it directly in the Sprite class
    private Image image;

    public Sprite(String name, Image image, Rectangle bounds) {
        //Objects.requireNonNull will throw a NullPointerException if the parameter is null
        this.name = Objects.requireNonNull(name);
        this.bounds = Objects.requireNonNull(bounds);
        this.image = Objects.requireNonNull(image);
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public String getName() {
        return name;
    }

    public Image getImage() {
        return image;
    }
}
