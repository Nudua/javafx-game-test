package com.nudua.game.input;

import com.nudua.game.input.devices.InputAdapter;
import com.nudua.game.input.devices.KeyboardInput;
import javafx.scene.Node;
import javafx.scene.Scene;

import java.util.*;

public class InputManager {

    private boolean enabled = true;

    private List<InputAdapter> inputAdapters;
    private Set<String> globalInputState;

    public InputManager(Scene parent) {
        Objects.requireNonNull(parent);

        globalInputState = new HashSet<>();
        inputAdapters = new ArrayList<>();

        initalizeInputAdapters(parent);
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    private void initalizeInputAdapters(Scene parent) {
        // Keyboard
        inputAdapters.add(new KeyboardInput(parent));
    }

    public void update() {
        for(InputAdapter adapter : inputAdapters) {
            if(adapter.isEnabled()) {
                adapter.update(globalInputState);
            }
        }
    }

    public boolean isPressed(String keyName) {
        return globalInputState.contains(keyName);
    }
}
