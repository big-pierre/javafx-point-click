package io.javasmithy.entities;

import io.javasmithy.components.Position;
import io.javasmithy.components.Sprite;

public class Background implements Drawable {
    Sprite sprite;
    Position position;

    public Background(BackgroundBuilder b){
        this.sprite = b.sprite;
        this.position = b.position;
    }

    public Background(Sprite sprite, Position position) {
        this.sprite = sprite;
        this.position = position;
    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public static class BackgroundBuilder {
        private Sprite sprite;
        private Position position;

        public BackgroundBuilder sprite(Sprite sprite){
            this.sprite = sprite;
            return this;
        }
        public BackgroundBuilder position(Position position){
            this.position = position;
            return this;
        }
        public Background build(){
            return new Background(this);
        }

    }
}
