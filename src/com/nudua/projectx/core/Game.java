package com.nudua.projectx.core;

import com.nudua.game.Core.GameEngine;
import com.nudua.game.Core.GameObject;
import com.nudua.game.Core.Vector2D;
import com.nudua.game.graphics.Sprite;
import com.nudua.game.graphics.SpriteBatch;
import com.nudua.game.input.InputManager;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game extends GameEngine {

    //private final SpriteBatch spritebatch;
    private final InputManager inputManager;

    private final List<GameObject> gameObjects;
    private Player player1;

    public Game(GridPane parent, Scene scene, int width, int height) {
        super(parent, width, height);

        inputManager = new InputManager(scene);
        gameObjects = new ArrayList<>();

        loadResources();
    }

    private void loadResources() {
        createGameObjects();
        createPlayer1();
    }

    private void createPlayer1() {

        // Path to images are relative from the package from where the class is located.
        Image p1Image = new Image(getClass().getResourceAsStream("../resources/sprites/player1.png"));

        Sprite p1Sprite = new Sprite("player1", p1Image, new Rectangle(160, 160));

        player1 = new Player(p1Sprite, Vector2D.Zero(), new Rectangle(getWidth(), getHeight()));
    }

    private void createGameObjects() {
        String sprite1ImagePath = "../resources/sprites/sprite1.png";

        Image sprite1Image = new Image(getClass().getResourceAsStream(sprite1ImagePath));

        Sprite sprite = new Sprite("sprite1", sprite1Image, new Rectangle(128, 128));

        GameObject myBox = new SimpleGameObject(sprite, Vector2D.Zero(), new Rectangle(0 , 0, getWidth(), getHeight()));

        gameObjects.add(myBox);
    }

    protected void draw() {
        GraphicsContext gc = getGraphicsContext();

        // Clear  the entire screen
        gc.setFill(Color.CORNFLOWERBLUE);
        gc.fillRect(0,0,getWidth(),getHeight());

        gc.setFill(Color.BLACK);
        gc.fillText("Use the arrow keys to move the player object!", 100, 100);

        // Draw all our gameobjects
        for(GameObject gameObject : gameObjects) {
            gameObject.draw(getGraphicsContext());
        }

        // Special handling for player1 is usually needed
        player1.draw(getGraphicsContext());
    }

    protected void update() {
        // Update input to the most recent state
        if(inputManager.isEnabled()) {
            inputManager.update();
        }

        // Update all our gameobjects
        for(GameObject gameObject : gameObjects) {
            gameObject.update();
        }

        // Update player1 here because we need access to the inputManager
        player1.update(inputManager);

    }
}
