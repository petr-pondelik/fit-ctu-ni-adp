package cz.cvut.fit.miadp.mvcgame.state;

import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;


public class SingleShootingMode implements IShootingMode {

    @Override
    public String getName() {
        return "SingleShootingMode";
    }

    @Override
    public void shoot(AbsCannon cannon) {
        cannon.primitiveShoot();
    }

    @Override
    public void switchMode(AbsCannon cannon) {
        cannon.setShootingMode(new DoubleShootingMode());
    }

}
