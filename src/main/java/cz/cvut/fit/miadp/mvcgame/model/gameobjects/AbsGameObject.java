package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

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

    public abstract void acceptVisitor(IVisitor visitor);

}
