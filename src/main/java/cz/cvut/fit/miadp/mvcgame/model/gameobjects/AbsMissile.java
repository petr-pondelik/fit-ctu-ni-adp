package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;


public abstract class AbsMissile extends AbsLifetimeLimitedGameObject {
    
    private double initAngle;
    private double initVelocity;

    protected AbsMissile(Position initialPosition, double initAngle, double initVelocity) {
        super(initialPosition);
        this.initAngle = initAngle;
        this.initVelocity = initVelocity;
    }

    public double getInitAngle() {
        return initAngle;
    }

    public double getInitVelocity() {
        return initVelocity;
    }
    

    @Override
    public void acceptVisitor(IVisitor visitor) {
        visitor.visitMissile(this);
    }

    public abstract void move();

}
