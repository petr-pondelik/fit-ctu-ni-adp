package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;


public abstract class AbsCannon extends AbsGameObject {
    
    //private int power;

    public abstract void moveUp();
    public abstract void moveDown();
    public abstract void aimUp();
    public abstract void aimDown();
    public abstract AbsMissile shoot();

    @Override
    public void acceptVisitor(IVisitor visitor) {
        visitor.visitCannon(this);        
    }

}
