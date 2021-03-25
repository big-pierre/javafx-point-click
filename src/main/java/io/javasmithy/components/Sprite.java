package io.javasmithy.components;

import javafx.scene.image.Image;

public class Sprite {
    private Image image;

    public Sprite(Image image){
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
