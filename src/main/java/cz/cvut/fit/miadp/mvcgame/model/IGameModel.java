package cz.cvut.fit.miadp.mvcgame.model;

import java.util.List;

import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsGameInfo;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsGameObject;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.observer.IObservable;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;


public interface IGameModel extends IObservable {
    
    public void moveCannonUp();
    public void moveCannonDown();
    public void aimCannonUp();
    public void aimCannonDown();
    public void cannonPowerUp();
    public void cannonPowerDown();
    public void cannonShoot();
    public void toggleMovingStrategy();
    public void toggleShootingMode();

    public int getScore();
    public AbsGameInfo getGameInfo();
    public AbsCannon getCannon();
    public List<AbsEnemy> getEnemies();
    public List<AbsMissile> getMissiles();
    public List<AbsGameObject> getGameObjects();

    public void update();
    public void timeTick();

    public IMovingStrategy getMovingStrategy();
    public Object createMemento();
    public void setMemento(Object memento);

}
