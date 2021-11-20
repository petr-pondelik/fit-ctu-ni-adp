package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public abstract class AbsEnemy extends AbsGameObject {    

    protected String type;

    public String getType() {
        return this.type;
    }

    @Override
    public void acceptVisitor(IVisitor visitor) {
        visitor.visitEnemy(this);
    }

}
