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

    public abstract void moveUp();
    public abstract void moveDown();
    public abstract void aimUp();
    public abstract void aimDown();
    public abstract void powerUp();
    public abstract void powerDown();

    public abstract List<AbsMissile> shoot();
    public abstract void primitiveShoot();

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
