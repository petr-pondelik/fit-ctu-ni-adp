package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public abstract class AbsGameInfo extends AbsGameObject {
    
    public abstract String getText();

    @Override
    public void acceptVisitor(IVisitor render) {
        render.visitGameInfo(this);        
    }

}
