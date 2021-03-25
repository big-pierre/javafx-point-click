package io.javasmithy.entities;

import io.javasmithy.components.Position;
import io.javasmithy.components.Sprite;

public interface Drawable {
    Sprite getSprite();
    Position getPosition();
}
