package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.visitor.GameObjectsRender;

public class Collision extends AbsLifetimeLimitedGameObject {

    Collision(Position initialPosition) {
        super(initialPosition);
    }

    @Override
    public void acceptVisitor(GameObjectsRender render) {
        // TODO Auto-generated method stub
        
    }
    
}
