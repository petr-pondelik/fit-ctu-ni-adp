package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitable;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;


public abstract class AbsGameObject implements IVisitable {
    
    protected Position position;

    public void move(Vector v) {
        this.position.add(v);
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean hasCollided(Position position) {
        boolean xInt = hasIntersect(position.getX(), this.getPosition().getX());
        boolean yInt = hasIntersect(position.getY(), this.getPosition().getY());
        return xInt && yInt;
    }

    private boolean hasIntersect(int pointA, int pointB) {
        int freedom = MvcGameConfig.HITBOX_SIZE;
        if (pointA < pointB) {
            return (pointA + freedom) >= pointB;
        }
        return (pointA - freedom) <= pointB;
    }

    public abstract void acceptVisitor(IVisitor visitor);

}
