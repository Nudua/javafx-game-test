package com.nudua.game.input;

import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

// Not yet
public class InputBinding {

    private String name;

    private Set<String> bindings;

    public InputBinding(String name) {
        if(name == null || "".equals(name)) {
            throw new InvalidParameterException();
        }

        this.name = name;

        this.bindings = new HashSet<>(bindings);
    }

    public void addBinding(String button) {
        bindings.add(button);
    }

    public Set<String> getBindings() {
        return bindings;
    }


}
