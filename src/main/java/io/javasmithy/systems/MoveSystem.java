package io.javasmithy.systems;

import io.javasmithy.entities.Movable;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MoveSystem {
    private Map<String, Movable> movableMap;
    private ExecutorService pool;

    public MoveSystem(Map<String, Movable> movableMap){
        this.movableMap = movableMap;
        this.pool = Executors.newFixedThreadPool(1);
    }

    public void update(){
        this.pool.execute(new MoveTask(movableMap));
    }

}
