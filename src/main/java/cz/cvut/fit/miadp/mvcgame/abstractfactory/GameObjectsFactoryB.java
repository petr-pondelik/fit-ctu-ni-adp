package cz.cvut.fit.miadp.mvcgame.abstractfactory;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyB.CannonB;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyB.CollisionB;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyB.EnemyB;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyB.GameInfoB;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyB.MissileB;


public class GameObjectsFactoryB implements IGameObjectsFactory {
    
    private IGameModel model;

    public GameObjectsFactoryB(IGameModel model) {
        this.model = model;
    }

    @Override
    public GameInfoB createGameInfo() {
        return new GameInfoB(new Position(MvcGameConfig.INFO_POS_X, MvcGameConfig.INFO_POS_Y), this.model, true, true, true, true, true);
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
    public MissileB createMissile(double initAngle, double initVelocity) {
        return new MissileB(this.model.getCannonPosition(), initAngle, initVelocity, this.model.getMovingStrategy());
    }

    @Override
    public CollisionB createCollision(Position initialPosition) {
        return new CollisionB(initialPosition);
    }

}
