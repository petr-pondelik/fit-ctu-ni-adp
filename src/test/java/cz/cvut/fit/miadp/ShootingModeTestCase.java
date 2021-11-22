package cz.cvut.fit.miadp;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.state.DoubleShootingMode;
import cz.cvut.fit.miadp.mvcgame.state.SingleShootingMode;


public class ShootingModeTestCase {
    
    /* Test if single shooting mode calls cannon's primitiveShoot only once. */
    @Test
    public void singleShoot() {
        AbsCannon cannon = mock(AbsCannon.class);
        SingleShootingMode shootingMode = new SingleShootingMode();
        shootingMode.shoot(cannon);
        verify(cannon, times(1)).primitiveShoot();
    }

    /* Test if double shooting mode calls cannon's primitiveShoot twice. */
    @Test
    public void doubleShoot() {
        AbsCannon cannon = mock(AbsCannon.class);
        DoubleShootingMode shootingMode = new DoubleShootingMode();
        shootingMode.shoot(cannon);
        verify(cannon, times(2)).primitiveShoot();
    }

    /* Test if single shooting mode's switchMode switches cannon into double shooting mode. */
    @Test
    public void singleSwitchMode() {
        AbsCannon cannon = mock(AbsCannon.class);
        SingleShootingMode shootingMode = new SingleShootingMode();
        shootingMode.switchMode(cannon);
        ArgumentCaptor<DoubleShootingMode> argument = ArgumentCaptor.forClass(DoubleShootingMode.class);
        verify(cannon, times(1)).setShootingMode(argument.capture());
    }

    /* Test if double shooting mode's switchMode switches cannon into single shooting mode. */
    @Test
    public void doubleSwitchMode() {
        AbsCannon cannon = mock(AbsCannon.class);
        DoubleShootingMode shootingMode = new DoubleShootingMode();
        shootingMode.switchMode(cannon);
        ArgumentCaptor<SingleShootingMode> argument = ArgumentCaptor.forClass(SingleShootingMode.class);
        verify(cannon, times(1)).setShootingMode(argument.capture());
    }

}
