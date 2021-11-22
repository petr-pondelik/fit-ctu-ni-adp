package cz.cvut.fit.miadp;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Test;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectsFactory;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA.CannonA;


public class CannonTestCase {

    /* Test if model moves correctly. */
    @Test
    public void cannonMoveA() {
        Position initPos = new Position(100, 200);
        IGameObjectsFactory goFactory = mock(IGameObjectsFactory.class);
        CannonA cannon = new CannonA(new Position(initPos.getX(), initPos.getY()), goFactory);
        Position cannonInitPos = new Position(cannon.getPosition().getX(), cannon.getPosition().getY());
        cannon.moveUp();
        cannon.moveUp();
        Position cannonUpPos = new Position(cannon.getPosition().getX(), cannon.getPosition().getY());
        cannon.moveDown();
        cannon.moveDown();
        cannon.moveDown();
        cannon.moveDown();
        Position cannonDownPos = new Position(cannon.getPosition().getX(), cannon.getPosition().getY());
        Assert.assertEquals(initPos.getX(), cannonInitPos.getX());
        Assert.assertEquals(initPos.getY(), cannonInitPos.getY());
        Assert.assertEquals(initPos.getX(), cannonUpPos.getX());
        Assert.assertEquals(initPos.getY() - 2 * MvcGameConfig.MOVE_STEP, cannonUpPos.getY());
        Assert.assertEquals(initPos.getY() + 2 * MvcGameConfig.MOVE_STEP, cannonDownPos.getY());
    }

    /* Test if model aims correctly. */
    @Test
    public void cannonAimA() {
        Position initPos = new Position(100, 200);
        IGameObjectsFactory goFactory = mock(IGameObjectsFactory.class);
        CannonA cannon = new CannonA(new Position(initPos.getX(), initPos.getY()), goFactory);
        double initAngle = cannon.getAngle();
        cannon.aimUp();
        cannon.aimUp();
        double topAngle = cannon.getAngle();
        cannon.aimDown();
        cannon.aimDown();
        cannon.aimDown();
        cannon.aimDown();
        double bottomAngle = cannon.getAngle();
        double delta = 0.0000001;
        Assert.assertEquals(MvcGameConfig.INIT_ANGLE, initAngle, delta);
        Assert.assertEquals(MvcGameConfig.INIT_ANGLE + 2 * MvcGameConfig.ANGLE_STEP, topAngle, delta);
        Assert.assertEquals(MvcGameConfig.INIT_ANGLE - 2 * MvcGameConfig.ANGLE_STEP, bottomAngle, delta);
    }

    /* Test if cannon shoots correctly. */
    @Test
    public void cannonShootA() {
        Position initPos = new Position(100, 200);
        IGameObjectsFactory goFactory = mock(IGameObjectsFactory.class);
        AbsCannon cannon = new CannonA(new Position(initPos.getX(), initPos.getY()), goFactory);
        assertEquals(0, cannon.getShootingBatch().size());
        cannon.performShoot();
        Assert.assertEquals(cannon.getShootingBatch().size(), 1);
        cannon.performShoot();
        cannon.performShoot();
        Assert.assertEquals(cannon.getShootingBatch().size(), 1);
    }

}
