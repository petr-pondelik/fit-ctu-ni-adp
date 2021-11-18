package cz.cvut.fit.miadp.mvcgame.model.gameObjects;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.Vector;

public class Cannon extends GameObject {
    
    //private int power;

    public Cannon(Position initialPosition) {
        this.position = initialPosition;
    }

    public void moveUp() {
        this.move(new Vector(0, -MvcGameConfig.MOVE_STEP));
    }

    public void moveDown() {
        this.move(new Vector(0, MvcGameConfig.MOVE_STEP));
    }

}
