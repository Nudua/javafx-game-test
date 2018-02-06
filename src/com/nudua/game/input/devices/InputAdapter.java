package com.nudua.game.input.devices;

import java.util.Set;

public interface InputAdapter {

    boolean isEnabled();
    void setEnabled(boolean enabled);

    void update(Set<String> digitalInput);
}
