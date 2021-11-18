package cz.cvut.fit.miadp.mvcgame.model;

import java.util.ArrayList;
import java.util.List;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.Cannon;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.Collision;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.Enemy;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.GameInfo;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.Missile;
import cz.cvut.fit.miadp.mvcgame.observer.IObservable;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;


public class GameModel implements IObservable {

    private List<IObserver> observers;

    private int score;
    private GameInfo gameInfo;

    private Cannon cannon;
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private ArrayList<Collision> collisions = new ArrayList<>();
    private ArrayList<Missile> missiles = new ArrayList<>();


    public GameModel() {
        this.score = 0;
        this.gameInfo = new GameInfo(new Position(MvcGameConfig.INFO_POS_X, MvcGameConfig.INFO_POS_Y), this);
        this.cannon = new Cannon(new Position(MvcGameConfig.CANNON_POS_X, MvcGameConfig.CANNON_POS_Y));
        this.generateEnemies();
        this.observers = new ArrayList<IObserver>();
    }

    private void generateEnemies() {
        for (int i = 0; i < MvcGameConfig.ENEMIES_CNT; i++) {
            this.enemies.add(
                new Enemy( new Position((int) (Math.random() * 500 + 400), (int) (Math.random() * 500 + 150) ) )
            );
        }
    }

    public int getScore() {
        return this.score;
    }

    public GameInfo getGameInfo() {
        return this.gameInfo;
    }

    public Cannon getCannon() {
        return this.cannon;
    }

    public ArrayList<Enemy> getEnemies() {
        return this.enemies;
    }

    public void moveCannonUp() {
        this.cannon.moveUp();
        this.notifyObservers();
    }

    public void moveCannonDown() {
        this.cannon.moveDown();
        this.notifyObservers();
    }

    public void update() {
        // TODO
        // this.moveMissiles()
    }

    @Override
    public void registerObserver(IObserver obs) {
        if(!this.observers.contains(obs)) {
            this.observers.add(obs);
        }
    }

    @Override
    public void unregisterObserver(IObserver obs) {
        if (this.observers.contains(obs)) {
            this.observers.remove(obs);
        }
    }

    @Override
    public void notifyObservers() {
        for (IObserver obs : this.observers) {
            obs.update();
        }
    }

}
