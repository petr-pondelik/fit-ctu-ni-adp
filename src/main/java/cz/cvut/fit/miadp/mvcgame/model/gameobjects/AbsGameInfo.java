package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public abstract class AbsGameInfo extends AbsGameObject {
    
    protected boolean showScore;
    protected boolean showPower;
    protected boolean showAngle;
    protected boolean showMovingStrategy;
    protected boolean showShootingMode;

    public abstract String getText();

    @Override
    public void acceptVisitor(IVisitor render) {
        render.visitGameInfo(this);        
    }

}
