package io.javasmithy.entities;

import io.javasmithy.components.Destination;
import io.javasmithy.components.Position;
import io.javasmithy.components.Sprite;


public class Player implements Drawable, Movable {
    private Sprite sprite;
    private Position position;
    private Destination destination;

    public Player(Sprite sprite, Position position) {
        this.sprite = sprite;
        this.position = position;
    }

    public Player(PlayerBuilder builder){
        this.sprite = builder.sprite;
        this.position = builder.position;
        this.destination = builder.position.toDestination();
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public Position getPosition() {
        return position;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    @Override
    public void move() {
        this.position.update(this.destination);
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public static class PlayerBuilder {
        private Sprite sprite;
        private Position position;

        public PlayerBuilder sprite(Sprite sprite){
            this.sprite = sprite;
            return this;
        }
        public PlayerBuilder position(Position position){
            this.position = position;
            return this;
        }
        public Player build(){
            return new Player(this);
        }

    }


}
