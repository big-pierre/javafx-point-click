package io.javasmithy.entities;

import io.javasmithy.components.Destination;
import io.javasmithy.components.Position;

public interface Movable {
    Position getPosition();
    void setDestination(Destination destination);
    void move();

}
