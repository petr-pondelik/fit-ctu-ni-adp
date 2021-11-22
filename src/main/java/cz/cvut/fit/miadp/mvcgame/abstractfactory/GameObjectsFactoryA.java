package cz.cvut.fit.miadp.mvcgame.abstractfactory;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA.CannonA;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA.CollisionA;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA.EnemyA;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA.GameInfoA;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA.MissileA;


public class GameObjectsFactoryA implements IGameObjectsFactory {

    private IGameModel model;

    public GameObjectsFactoryA(IGameModel model) {
        this.model = model;
    }

    @Override
    public GameInfoA createGameInfo() {
        return new GameInfoA(new Position(MvcGameConfig.INFO_POS_X, MvcGameConfig.INFO_POS_Y), this.model, true, true, true, true, true);
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
    public MissileA createMissile(double initAngle, double initVelocity) {
        return new MissileA(this.model.getCannonPosition(), initAngle, initVelocity, this.model.getMovingStrategy());
    }

    @Override
    public CollisionA createCollision(Position initialPosition) {
        return new CollisionA(initialPosition);
    }

}
