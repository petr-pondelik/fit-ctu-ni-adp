package cz.cvut.fit.miadp.mvcgame.model.gameObjects;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.Vector;


public abstract class AbsGameObject {
    
    protected Position position;

    public AbsGameObject(Position initialPosition) {
        this.position = initialPosition;
    }

    public void move(Vector v) {
        this.position.add(v);
    }

    public Position getPosition() {
        return this.position;
    }

}
