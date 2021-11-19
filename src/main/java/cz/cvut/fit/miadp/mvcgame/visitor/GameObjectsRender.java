package cz.cvut.fit.miadp.mvcgame.visitor;

import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCollision;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsGameInfo;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class GameObjectsRender implements IVisitor {

    private GraphicsContext gc;

    public void setGraphicsContext(GraphicsContext gc) {
        this.gc = gc;
    }

    @Override
    public void visitGameInfo(AbsGameInfo gameInfo) {
       this.gc.fillText(gameInfo.getText(), gameInfo.getPosition().getX(), gameInfo.getPosition().getY());
    }

    @Override
    public void visitCannon(AbsCannon cannon) {
        this.gc.drawImage(new Image("images/cannon.png"), cannon.getPosition().getX(), cannon.getPosition().getY());
    }

    @Override
    public void visitEnemy(AbsEnemy enemy) {
        this.gc.drawImage(new Image("images/enemy1.png"), enemy.getPosition().getX(), enemy.getPosition().getY());
    }

    @Override
    public void visitMissile(AbsMissile missile) {
        this.gc.drawImage(new Image("images/missile.png"), missile.getPosition().getX(), missile.getPosition().getY());
    }

    @Override
    public void visitCollision(AbsCollision collision) {
        this.gc.drawImage(new Image("images/collision.png"), collision.getPosition().getX(), collision.getPosition().getY());
    }

}
