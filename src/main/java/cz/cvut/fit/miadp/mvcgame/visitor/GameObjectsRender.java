package cz.cvut.fit.miadp.mvcgame.visitor;

import cz.cvut.fit.miadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCollision;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsGameInfo;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;


public class GameObjectsRender implements IVisitor {

    private IGameGraphics gc;

    public void setGraphicsContext(IGameGraphics gc) {
        this.gc = gc;
    }

    @Override
    public void visitGameInfo(AbsGameInfo gameInfo) {
       this.gc.drawText(gameInfo.getText(), gameInfo.getPosition());
    }

    @Override
    public void visitCannon(AbsCannon cannon) {
        this.gc.drawImage("images/cannon.png", cannon.getPosition());
    }

    @Override
    public void visitEnemy(AbsEnemy enemy) {
        this.gc.drawImage("images/enemy1.png", enemy.getPosition());
    }

    @Override
    public void visitMissile(AbsMissile missile) {
        this.gc.drawImage("images/missile.png", missile.getPosition());
    }

    @Override
    public void visitCollision(AbsCollision collision) {
        this.gc.drawImage("images/collision.png", collision.getPosition());
    }

}
