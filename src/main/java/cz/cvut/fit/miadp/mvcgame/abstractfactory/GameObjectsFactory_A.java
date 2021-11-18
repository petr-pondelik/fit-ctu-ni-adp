package cz.cvut.fit.miadp.mvcgame.abstractfactory;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.family_A.Cannon_A;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.family_A.Missile_A;


public class GameObjectsFactory_A implements IGameObjectFactory {

    @Override
    public Cannon_A createCannon() {
        return new Cannon_A(new Position(MvcGameConfig.CANNON_POS_X, MvcGameConfig.CANNON_POS_Y), this);
    }

    @Override
    public Missile_A createMissile() {
        // TODO: Fix missile's default position - parametrize create missile on the factory level
        return new Missile_A(new Position(MvcGameConfig.CANNON_POS_X, MvcGameConfig.CANNON_POS_Y));
    }

}
