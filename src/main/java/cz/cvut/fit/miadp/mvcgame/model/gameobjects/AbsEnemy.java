package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public abstract class AbsEnemy extends AbsGameObject {    

    @Override
    public void acceptVisitor(IVisitor visitor) {
        visitor.visitEnemy(this);
    }

}
