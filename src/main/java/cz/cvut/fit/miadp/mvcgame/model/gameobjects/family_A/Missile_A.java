package cz.cvut.fit.miadp.mvcgame.model.gameobjects.family_A;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.visitor.GameObjectsRender;


public class Missile_A extends AbsMissile {
    
    public Missile_A(Position initialPosition) {
        this.position = initialPosition;
    }

    @Override
    public void acceptVisitor(GameObjectsRender render) {
        render.visitMissile(this);
    }

}
