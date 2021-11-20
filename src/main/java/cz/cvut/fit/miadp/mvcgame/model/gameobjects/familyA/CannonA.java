package cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA;

import java.util.ArrayList;
import java.util.List;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.state.SingleShootingMode;


public class CannonA extends AbsCannon {
    
    private IGameObjectFactory goFact;

    private List<AbsMissile> shootingBatch;


    public CannonA(Position initialPosition, IGameObjectFactory goFact) {
        this.position = initialPosition;

        this.goFact = goFact;
        this.shootingMode = new SingleShootingMode();

        this.angle = MvcGameConfig.INIT_ANGLE;
        this.power = MvcGameConfig.INIT_POWER;

        this.shootingBatch = new ArrayList<>();
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
        this.angle += MvcGameConfig.ANGLE_STEP;
    }

    @Override
    public void aimDown() {
        this.angle -= MvcGameConfig.ANGLE_STEP;
    }

    @Override
    public void powerUp() {
        this.power += MvcGameConfig.POWER_STEP;        
    }

    @Override
    public void powerDown() {
        this.power -= MvcGameConfig.POWER_STEP;
    }

    public void primitiveShoot() {
        this.shootingBatch.add(this.goFact.createMissile(new Position(this.position.getX(), this.position.getY()), this.angle, this.power));
    }

    @Override
    public List<AbsMissile> shoot() {
        this.shootingBatch.clear();
        // Use current state to shoot
        this.shootingMode.shoot(this);
        return this.shootingBatch;
    }

}
