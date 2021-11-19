package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;


public abstract class AbsMissile extends AbsLifetimeLimitedGameObject {
    
    private double initAngle;
    private int initVelocity;

    protected AbsMissile(Position initialPosition, double initAngle, int initVelocity) {
        super(initialPosition);
        this.initAngle = initAngle;
        this.initVelocity = initVelocity;
    }

    public double getInitAngle() {
        return initAngle;
    }

    public int getInitVelocity() {
        return initVelocity;
    }
    

    @Override
    public void acceptVisitor(IVisitor visitor) {
        visitor.visitMissile(this);
    }

    public abstract void move();

}
