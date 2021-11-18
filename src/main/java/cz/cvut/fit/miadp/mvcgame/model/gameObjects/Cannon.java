package cz.cvut.fit.miadp.mvcgame.model.gameObjects;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.Vector;

public class Cannon extends AbsGameObject {
    
    //private int power;

    public Cannon(Position initialPosition) {
        super(initialPosition);
    }

    public void moveUp() {
        this.move(new Vector(0, -MvcGameConfig.MOVE_STEP));
    }

    public void moveDown() {
        this.move(new Vector(0, MvcGameConfig.MOVE_STEP));
    }

}
