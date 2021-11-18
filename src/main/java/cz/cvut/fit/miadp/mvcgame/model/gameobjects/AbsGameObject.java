package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.visitor.GameObjectsRender;


public abstract class AbsGameObject {
    
    protected Position position;

    public void move(Vector v) {
        this.position.add(v);
    }

    public Position getPosition() {
        return this.position;
    }

    public abstract void acceptVisitor(GameObjectsRender render);

}
