package cz.cvut.fit.miadp.mvcgame.model.gameobjects.family_A;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.visitor.GameObjectsRender;


public class Cannon_A extends AbsCannon {
    
    private IGameObjectFactory goFact;

    public Cannon_A(Position initialPosition, IGameObjectFactory goFact) {
        this.position = initialPosition;
        this.goFact = goFact;
    }

    @Override
    public void moveUp() {
        this.move(new Vector(0, - MvcGameConfig.MOVE_STEP));
    }

    @Override
    public void moveDown() {
        this.move(new Vector(0, MvcGameConfig.MOVE_STEP));
    }

    @Override
    public AbsMissile shoot() {
        return this.goFact.createMissile();
    }

    @Override
    public void acceptVisitor(GameObjectsRender render) {
        render.visitCannon(this);        
    }

}
