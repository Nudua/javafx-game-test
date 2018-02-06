package com.nudua.game.Core;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TimelineBuilder;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

public abstract class GameEngine {

    private Timeline gameLoop;
    private Canvas canvas;

    public GameEngine(GridPane parent, int width, int height) {
        canvas = new Canvas(width, height);
        parent.add(canvas, 0,1,1,1);

        buildAndSetGameLoop();
    }

    public int getWidth() {
        return (int)canvas.getWidth();
    }

    public int getHeight() {
        return (int)canvas.getHeight();
    }

    protected GraphicsContext getGraphicsContext() {
        return canvas.getGraphicsContext2D();
    }

    public void start() {
        gameLoop.play();
    }

    public void stop() {
        gameLoop.stop();
    }

    protected void setSize(double width, double height) {
        canvas.setWidth(width);
        canvas.setHeight(height);
    }

    private void buildAndSetGameLoop() {

        final int framesPerSecond = 60;

        final Duration oneFrameAmt = Duration.millis(1000 / framesPerSecond);
        final KeyFrame oneFrame = new KeyFrame(oneFrameAmt, event -> {
            update();
            draw();
        });

        // sets the game world's game loop (Timeline)
        gameLoop = TimelineBuilder.create()
                .cycleCount(Animation.INDEFINITE)
                .keyFrames(oneFrame)
                .build();
    }


    protected abstract void update();

    protected abstract void draw();


}
