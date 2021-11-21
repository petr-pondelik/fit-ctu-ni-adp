package cz.cvut.fit.miadp.mvcgame.model.gameobjects;


import java.util.List;

import cz.cvut.fit.miadp.mvcgame.state.DoubleShootingMode;
import cz.cvut.fit.miadp.mvcgame.state.IShootingMode;
import cz.cvut.fit.miadp.mvcgame.state.SingleShootingMode;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;


public abstract class AbsCannon extends AbsGameObject {
    
    protected IShootingMode shootingMode;

    protected static IShootingMode SINGLE_SHOOTING_MODE = new SingleShootingMode();
    protected static IShootingMode DOUBLE_SHOOTING_MODE = new DoubleShootingMode();

    protected List<AbsMissile> shootingBatch;

    protected double angle;
    protected double power;

    public abstract void moveUp();
    public abstract void moveDown();
    public abstract void aimUp();
    public abstract void aimDown();
    public abstract void powerUp();
    public abstract void powerDown();

    public abstract void primitiveShoot();


    /* Template method pattern START */

    protected abstract void onShootPreparation();
    protected abstract void onShootStart();
    protected abstract void shoot();
    protected abstract void onShootEnd();
    
    public void performShoot() {
        this.onShootPreparation();
        this.onShootStart();
        this.shoot();
        this.onShootEnd();
    }

    /* Template method pattern END */


    public IShootingMode getShootingMode() {
        return this.shootingMode;
    }

    public List<AbsMissile> getShootingBatch() {
        return this.shootingBatch;
    }

    public double getAngle() {
        return this.angle;
    }

    public double getPower() {
        return this.power;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public void setShootingMode(IShootingMode shootingMode) {
        this.shootingMode = shootingMode;
    }
    
    public void toggleShootingMode() {
        this.shootingMode.switchMode(this);
    }

    @Override
    public void acceptVisitor(IVisitor visitor) {
        visitor.visitCannon(this);        
    }

}
