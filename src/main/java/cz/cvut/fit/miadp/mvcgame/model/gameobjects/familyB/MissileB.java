package cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyB;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;


public class MissileB extends AbsMissile {
    
    IMovingStrategy movingStrategy;

    public MissileB(Position initialPosition, double initAngle, double initVelocity, IMovingStrategy movingStrategy) {
        super(initialPosition, initAngle, initVelocity);
        this.movingStrategy = movingStrategy;
    }

    @Override
    public void move() {
        this.movingStrategy.updatePosition(this);
    }

}
