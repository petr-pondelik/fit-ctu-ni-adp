package cz.cvut.fit.miadp.mvcgame.abstractfactory;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA.CannonA;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA.CollisionA;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA.EnemyA;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA.GameInfoA;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA.MissileA;


public class GameObjectsFactoryA implements IGameObjectFactory {

    @Override
    public GameInfoA createGameInfo(GameModel model) {
        return new GameInfoA(new Position(MvcGameConfig.INFO_POS_X, MvcGameConfig.INFO_POS_Y), model);
    }
    
    @Override
    public CannonA createCannon() {
        return new CannonA(new Position(MvcGameConfig.CANNON_POS_X, MvcGameConfig.CANNON_POS_Y), this);
    }

    @Override
    public EnemyA createEnemy(Position initialPosition) {
        return new EnemyA(initialPosition);
    }

    @Override
    public MissileA createMissile(Position initialPosition) {
        return new MissileA(initialPosition);
    }

    @Override
    public CollisionA createCollision(Position initialPosition) {
        return new CollisionA(initialPosition);
    }

}
