package cz.cvut.fit.miadp.mvcgame.model;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.GameObjectsFactoryA;
import cz.cvut.fit.miadp.mvcgame.abstractfactory.GameObjectsFactoryB;
import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.command.AbsGenericGameCommand;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCollision;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsGameInfo;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsGameObject;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;
import cz.cvut.fit.miadp.mvcgame.state.IShootingMode;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;
import cz.cvut.fit.miadp.mvcgame.strategy.RealisticMovingStrategy;
import cz.cvut.fit.miadp.mvcgame.strategy.SimpleMovingStrategy;


public class GameModel implements IGameModel {

    private List<IObserver> observers;
    private IGameObjectFactory goFactoryA;
    private IGameObjectFactory goFactoryB;
    private IMovingStrategy movingStrategy;

    private int score;
    private AbsGameInfo gameInfo;

    private AbsCannon cannon;
    private List<AbsEnemy> enemies = new ArrayList<>();
    private List<AbsMissile> missiles = new ArrayList<>();
    private List<AbsCollision> collisions = new ArrayList<>();

    private Queue<AbsGenericGameCommand> unexecutedCmds = new LinkedBlockingQueue<>();
    private Stack<AbsGenericGameCommand> executedCmds = new Stack<>();

    public GameModel() {
        this.observers = new ArrayList<IObserver>();
        this.goFactoryA = new GameObjectsFactoryA(this);
        this.goFactoryB = new GameObjectsFactoryB(this);
        this.movingStrategy = new SimpleMovingStrategy();
        this.score = 0;
        this.gameInfo = this.goFactoryA.createGameInfo();
        this.cannon = this.goFactoryA.createCannon();
        this.generateEnemies();
    }

    private void generateEnemies() {

        Random rand = new Random();

        for (int i = 0; i < MvcGameConfig.ENEMIES_CNT; i++) {

            boolean canAddEnemy = false;

            int x = 0, y = 0;

            while(!canAddEnemy) {
                x = MvcGameConfig.ENEMIES_MIN_X + rand.nextInt(MvcGameConfig.ENEMIES_MAX_X - MvcGameConfig.ENEMIES_MIN_X);
                y = MvcGameConfig.ENEMIES_MIN_Y + rand.nextInt(MvcGameConfig.ENEMIES_MAX_Y - MvcGameConfig.ENEMIES_MIN_Y);

                if (this.enemies.size() < 1) {
                    canAddEnemy = true;
                }

                boolean validDistance = true;

                for (AbsEnemy enemy : this.enemies) {
                    double dist = Math.sqrt( Math.pow(enemy.getPosition().getX() - x, 2) + Math.pow(enemy.getPosition().getY() - y, 2) );
                    if (dist < MvcGameConfig.ENEMIES_MIN_DISTANCE) { validDistance = false; }
                }

                if (validDistance) { canAddEnemy = true; }
            }

            double enemyRand = Math.random();

            this.enemies.add(
                enemyRand < 0.5 ? this.goFactoryA.createEnemy(new Position(x,y)) : this.goFactoryB.createEnemy(new Position(x,y))
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

    public Position getCannonPosition() {
        return new Position(this.cannon.getPosition().getX(), this.cannon.getPosition().getY());
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
        this.executeCmds();
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
        }
    }

    public void toggleShootingMode() {
        this.cannon.toggleShootingMode();
    }

    private class Memento {
        private int score;
        private IMovingStrategy movingStrategy;
        private Position cannonPosition;
        private double cannonPower;
        private double cannonAngle;
        private IShootingMode shootingMode;
        private List<AbsEnemy> enemies;
    }

    public Object createMemento() {
        Memento m = new Memento();
        m.score = this.score;
        m.movingStrategy = this.movingStrategy;
        m.cannonPosition = this.getCannonPosition();
        m.cannonPower = this.getCannon().getPower();
        m.cannonAngle = this.getCannon().getAngle();
        m.shootingMode = this.getCannon().getShootingMode();
        m.enemies = new ArrayList<>(this.enemies);
        return m;
    }

    public void setMemento(Object memento) {
        Memento m = (Memento) memento;
        this.score = m.score;
        this.movingStrategy = m.movingStrategy;
        this.cannon.setPosition(m.cannonPosition);
        this.cannon.setAngle(m.cannonAngle);
        this.cannon.setPower(m.cannonPower);
        this.cannon.setShootingMode(m.shootingMode);
        this.enemies.clear();
        this.enemies.addAll(m.enemies);
    }

    @Override
    public void registerCommand(AbsGenericGameCommand cmd) {
        this.unexecutedCmds.add(cmd);
    }

    @Override
    public void undoLastCommand() {
        if (this.executedCmds.isEmpty()) { return; }
        AbsGenericGameCommand cmd = this.executedCmds.pop();
        cmd.unexecute();
        this.notifyObservers();
    }

    public void executeCmds() {
        while(!this.unexecutedCmds.isEmpty()) {
            AbsGenericGameCommand cmd = this.unexecutedCmds.poll();
            try {
                cmd.doExecute();
                this.executedCmds.push(cmd);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

}
