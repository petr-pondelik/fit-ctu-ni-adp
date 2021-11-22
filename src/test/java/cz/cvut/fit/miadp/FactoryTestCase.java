package cz.cvut.fit.miadp;

import static org.mockito.Mockito.*;

import org.junit.Test;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.GameObjectsFactoryA;
import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectsFactory;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.strategy.SimpleMovingStrategy;
import junit.framework.Assert;


public class FactoryTestCase {

    /* Test missile creation and if it's initial position equals to the position of the cannon. */
    @Test
    public void createMissile() {
        IGameModel model = mock(GameModel.class);
        when(model.getCannonPosition()).thenReturn(new Position(500, 600));
        when(model.getMovingStrategy()).thenReturn(new SimpleMovingStrategy());
        IGameObjectsFactory goFact = new GameObjectsFactoryA(model);
        AbsMissile missile = goFact.createMissile(0, 10);
        Assert.assertEquals(missile.getPosition().getX(), 500);
        Assert.assertEquals(missile.getPosition().getY(), 600);
    }

    /* Test cannon creation. */
    @Test
    public void createCannon() {
        IGameModel model = mock(GameModel.class);
        IGameObjectsFactory goFact = new GameObjectsFactoryA(model);
        AbsCannon cannon = goFact.createCannon();
        Assert.assertEquals(MvcGameConfig.INIT_ANGLE, cannon.getAngle());
        Assert.assertEquals(MvcGameConfig.INIT_POWER, cannon.getPower());
        Assert.assertEquals(MvcGameConfig.CANNON_POS_X, cannon.getPosition().getX());
        Assert.assertEquals(MvcGameConfig.CANNON_POS_Y, cannon.getPosition().getY());
        Assert.assertEquals(0, cannon.getShootingBatch().size());
    }

}
