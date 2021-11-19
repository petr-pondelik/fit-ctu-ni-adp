package cz.cvut.fit.miadp.mvcgame.abstractfactory;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyB.CannonB;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyB.CollisionB;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyB.EnemyB;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyB.GameInfoB;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyB.MissileB;


public abstract class GameObjectsFactoryB implements IGameObjectFactory {
    
    @Override
    public GameInfoB createGameInfo(GameModel model) {
        return new GameInfoB(new Position(MvcGameConfig.INFO_POS_X, MvcGameConfig.INFO_POS_Y), model);
    }
    
    @Override
    public CannonB createCannon() {
        return new CannonB(new Position(MvcGameConfig.CANNON_POS_X, MvcGameConfig.CANNON_POS_Y), this);
    }

    @Override
    public EnemyB createEnemy(Position initialPosition) {
        return new EnemyB(initialPosition);
    }

    @Override
    public MissileB createMissile(Position initialPosition) {
        return new MissileB(initialPosition);
    }

    @Override
    public CollisionB createCollision(Position initialPosition) {
        return new CollisionB(initialPosition);
    }

}