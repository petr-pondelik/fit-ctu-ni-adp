package cz.cvut.fit.miadp.mvcgame.strategy;

import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;

public interface IMovingStrategy {
    
    public String getName();
    void updatePosition(AbsMissile missile);

}
