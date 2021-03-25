package io.javasmithy.controller;

import io.javasmithy.components.Destination;
import io.javasmithy.components.Position;
import io.javasmithy.entities.Background;
import io.javasmithy.components.Sprite;
import io.javasmithy.entities.Drawable;
import io.javasmithy.entities.Movable;
import io.javasmithy.entities.Player;
import io.javasmithy.systems.MoveSystem;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.net.URL;
import java.util.*;

public class MainController implements Initializable {
    private AnimationTimer animationTimer;
    private Stage stage;
    private GraphicsContext gc;
    private MoveSystem moveSystem;
    private Map<String, Drawable> drawables;
    private Map<String, Movable> movables;

    private Player p;
    private Background b;

    @FXML
    private Canvas canvas;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.gc = this.canvas.getGraphicsContext2D();
        initEntities();
        addDrawables();
        addMovables();
        initMoveSystem();
        initAnimationTimer(this.gc);
        addBoundaryDrawEventHandler();
    }
    private void initEntities(){
        this.p = new Player.PlayerBuilder()
                .sprite(new Sprite(new Image(getClass().getResource("/images/player_sprite.png").toExternalForm())))
                .position(new Position(100.0, 100.0))
                .build();
        this.b = new Background.BackgroundBuilder()
                .sprite(new Sprite(new Image(getClass().getResource("/images/city_scene.jpg").toExternalForm())))
                .position(new Position(0.0, 0.0))
                .build();
    }
    private void addDrawables(){
        this.drawables = new HashMap<String, Drawable>();
        drawables.put("background", this.b);
        drawables.put("player", this.p);
    }
    private void addMovables(){
        this.movables = new HashMap<String, Movable>();
        movables.put("player", this.p);
    }
    private void initMoveSystem(){
        this.moveSystem = new MoveSystem(this.movables);
    }
    private void initAnimationTimer(GraphicsContext gc){
        this.animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                drawables.forEach( (k,v) -> {
                    gc.drawImage(v.getSprite().getImage(), v.getPosition().getX(), v.getPosition().getY());
                });
                moveSystem.update();
            }
        };
        this.animationTimer.start();
    }
    private void addBoundaryDrawEventHandler(){
        this.canvas.addEventFilter(MouseEvent.ANY, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED) {
                    double targetX = mouseEvent.getX();
                    double targetY = mouseEvent.getY();
                    movables.get("player").setDestination(new Destination(targetX, targetY));
                }
            }
        });
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }

    @FXML
    private void exit(){
        Platform.exit();
        System.exit(0);
    }



}