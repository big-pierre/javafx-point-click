package io.javasmithy.components;

import java.util.Objects;

public class Position {
    private double x;
    private double y;

    public Position(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void move(double x2, double y2){
        this.x = x2;
        this.y = y2;
    }

    public void update(Destination d){
        x += (this.x < d.getX()) ? 1 : -1;
        y += (this.y < d.getY()) ? 1 : -1;
    }

    public Destination toDestination(){
        return new Destination(this.x, this.y);
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Double.compare(position.x, x) == 0 && Double.compare(position.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
