package cz.cvut.fit.miadp;

import static org.junit.Assert.assertThat;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;

import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.strategy.RealisticMovingStrategy;
import cz.cvut.fit.miadp.mvcgame.strategy.SimpleMovingStrategy;

public class MovingStrategyTestCase {
    
    /* Test if model toggles it's moving strategy. */
    @Test
    public void toggleMovingStrategy() {
        IGameModel model = new GameModel();
        assertThat(model.getMovingStrategy(), instanceOf(SimpleMovingStrategy.class));
        model.toggleMovingStrategy();
        assertThat(model.getMovingStrategy(), instanceOf(RealisticMovingStrategy.class));
    }

}
