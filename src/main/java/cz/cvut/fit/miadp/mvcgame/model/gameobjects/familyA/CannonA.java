package cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;


public class CannonA extends AbsCannon {
    
    private IGameObjectFactory goFact;

    public CannonA(Position initialPosition, IGameObjectFactory goFact) {
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
    public void aimUp() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void aimDown() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public AbsMissile shoot() {
        return this.goFact.createMissile(new Position(this.position.getX(), this.position.getY()));
    }

}
