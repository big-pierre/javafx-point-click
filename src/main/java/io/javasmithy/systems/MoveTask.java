package io.javasmithy.systems;

import io.javasmithy.entities.Movable;

import java.util.Map;

public class MoveTask implements Runnable {
    private Map<String, Movable> movableMap;

    public MoveTask(Map<String, Movable> movableMap){
        this.movableMap = movableMap;
    }

    @Override
    public void run() {
        movableMap.forEach((k,v) -> {
            v.move();
        });
    }
}
