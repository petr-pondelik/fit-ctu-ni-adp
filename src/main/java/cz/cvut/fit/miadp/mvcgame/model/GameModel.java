package cz.cvut.fit.miadp.mvcgame.model;

import java.util.ArrayList;
import java.util.List;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.GameObjectsFactoryA;
import cz.cvut.fit.miadp.mvcgame.abstractfactory.GameObjectsFactoryB;
import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCollision;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsGameInfo;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsGameObject;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.observer.IObservable;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;
import cz.cvut.fit.miadp.mvcgame.strategy.RealisticMovingStrategy;
import cz.cvut.fit.miadp.mvcgame.strategy.SimpleMovingStrategy;


public class GameModel implements IObservable {

    private List<IObserver> observers;
    private IGameObjectFactory goFactory;
    private IMovingStrategy movingStrategy;

    private int score;
    private AbsGameInfo gameInfo;

    private AbsCannon cannon;
    private List<AbsEnemy> enemies = new ArrayList<>();
    private List<AbsMissile> missiles = new ArrayList<>();
    private List<AbsCollision> collisions = new ArrayList<>();


    public GameModel() {
        this.observers = new ArrayList<IObserver>();
        this.goFactory = new GameObjectsFactoryA(this);
        this.movingStrategy = new SimpleMovingStrategy();
        this.score = 0;
        this.gameInfo = this.goFactory.createGameInfo();
        this.cannon = this.goFactory.createCannon();
        this.generateEnemies();
    }

    private void generateEnemies() {
        for (int i = 0; i < MvcGameConfig.ENEMIES_CNT; i++) {
            this.enemies.add(
                this.goFactory.createEnemy( new Position((int) (Math.random() * 500 + 400), (int) (Math.random() * 500 + 150) ) )
            );
        }
    }

    public IMovingStrategy getMovingStrategy() {
        return this.movingStrategy;
    }

    public int getScore() {
        return this.score;
    }

    public AbsGameInfo getGameInfo() {
        return this.gameInfo;
    }

    public AbsCannon getCannon() {
        return this.cannon;
    }

    public List<AbsEnemy> getEnemies() {
        return this.enemies;
    }

    public List<AbsMissile> getMissiles() {
        return this.missiles;
    }

    public List<AbsGameObject> getGameObjects() {
        List<AbsGameObject> go = new ArrayList<>();
        go.add(this.gameInfo);
        go.add(this.cannon);
        go.addAll(this.enemies);
        go.addAll(this.missiles);
        go.addAll(this.collisions);
        return go;
    }

    public void moveCannonUp() {
        this.cannon.moveUp();
        this.notifyObservers();
    }

    public void moveCannonDown() {
        this.cannon.moveDown();
        this.notifyObservers();
    }

    public void aimCannonUp() {
        this.cannon.aimUp();
    }

    public void aimCannonDown() {
        this.cannon.aimDown();
    }

    public void cannonPowerUp() {
        this.cannon.powerUp();
    }

    public void cannonPowerDown() {
        this.cannon.powerDown();
    }

    public void cannonShoot() {
        this.missiles.addAll(this.cannon.shoot());
        this.notifyObservers();
    }

    public void timeTick() {
        this.update();
    }

    public void update() {
        this.moveMissiles();
    }

    private void moveMissiles() {
        for (AbsMissile missile : this.missiles) {
            missile.move();
        }
        this.destroyMissiles();
        this.notifyObservers();
    }

    private void destroyMissiles() {
        List<AbsMissile> toRemove = new ArrayList<>();
        for (AbsMissile missile : this.missiles) {
            if (missile.getPosition().getX() > MvcGameConfig.SCENE_WITH) {
                toRemove.add(missile);
            }
        }
        this.missiles.removeAll(toRemove);
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

    public void toggleMovingStrategy() {
        if (this.movingStrategy instanceof SimpleMovingStrategy) {
            this.movingStrategy = new RealisticMovingStrategy();
        } else if (this.movingStrategy instanceof RealisticMovingStrategy) {
            this.movingStrategy = new SimpleMovingStrategy();
        } else {

        }
    }

    public void toggleShootingMode() {
        this.cannon.toggleShootingMode();
    }

}
