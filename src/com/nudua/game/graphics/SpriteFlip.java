package com.nudua.game.graphics;

// Not yet
public enum SpriteFlip {
    NONE(1 << 0),
    HORIZONTAL(1 << 1),
    VERTICAL(1 << 2);

    private final long flags;

    SpriteFlip(long flags) {
        this.flags = flags;
    }

    public long getFlags() {
        return flags;
    }
}
