package cz.cvut.fit.miadp.mvcgame.proxy;

import java.util.List;

import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsGameInfo;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsGameObject;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;


public class GameModelProxy implements IGameModel {

    private IGameModel subject;

    public GameModelProxy(IGameModel model) {
        this.subject = model;
    }

    @Override
    public void moveCannonUp() {
        this.subject.moveCannonUp();        
    }

    @Override
    public void moveCannonDown() {
        this.subject.moveCannonDown();        
    }

    @Override
    public void aimCannonUp() {
        this.subject.aimCannonUp();        
    }

    @Override
    public void aimCannonDown() {
        this.subject.aimCannonDown();        
    }

    @Override
    public void cannonPowerUp() {
        this.subject.cannonPowerUp();        
    }

    @Override
    public void cannonPowerDown() {
        this.subject.cannonPowerDown();        
    }

    @Override
    public void cannonShoot() {
        this.subject.cannonShoot();        
    }

    @Override
    public void toggleMovingStrategy() {
        this.subject.toggleMovingStrategy();
    }

    @Override
    public void toggleShootingMode() {
        this.subject.toggleShootingMode();
    }

    @Override
    public int getScore() {
        return this.subject.getScore();
    }

    @Override
    public AbsGameInfo getGameInfo() {
        return this.subject.getGameInfo();
    }

    @Override
    public AbsCannon getCannon() {
        return this.subject.getCannon();
    }

    @Override
    public List<AbsEnemy> getEnemies() {
        return this.subject.getEnemies();
    }

    @Override
    public List<AbsMissile> getMissiles() {
        return this.subject.getMissiles();
    }

    @Override
    public List<AbsGameObject> getGameObjects() {
        return this.subject.getGameObjects();
    }

    @Override
    public void update() {
        this.subject.update();
    }

    @Override
    public void timeTick() {
        this.subject.timeTick();   
    }

    @Override
    public IMovingStrategy getMovingStrategy() {
        return this.subject.getMovingStrategy();
    }

    @Override
    public Object createMemento() {
        return this.subject.createMemento();
    }

    @Override
    public void setMemento(Object memento) {
        this.subject.setMemento(memento);
    }

    @Override
    public void registerObserver(IObserver obs) {
        this.subject.registerObserver(obs);
    }

    @Override
    public void unregisterObserver(IObserver obs) {
        this.subject.unregisterObserver(obs);
    }

    @Override
    public void notifyObservers() {
        this.subject.notifyObservers();   
    }
    
}
