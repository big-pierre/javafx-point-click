package io.javasmithy.components;

import java.util.Objects;

public class Destination {
    private double x;
    private double y;

    public Destination(double destinationX, double destinationY) {
        this.x = destinationX;
        this.y = destinationY;
    }

    public double getX() {
        return x;
    }

    public void setX(double destinationX) {
        this.x = destinationX;
    }

    public double getY() {
        return y;
    }

    public void setY(double destinationY) {
        this.y = destinationY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destination that = (Destination) o;
        return Double.compare(that.x, x) == 0 && Double.compare(that.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
