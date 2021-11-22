package cz.cvut.fit.miadp;

import org.junit.Test;

import cz.cvut.fit.miadp.mvcgame.command.GenericGameCommand;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import junit.framework.Assert;


public class MementoTestCase {
    
    /* Test command undoing using memento. */
    @Test
    public void undoCommandTest() throws NoSuchMethodException, SecurityException {
        IGameModel model = new GameModel();
        Position positionBeforeUndo = model.getCannonPosition();
        
        model.registerCommand(new GenericGameCommand(model, model.getClass().getMethod("moveCannonUp")));
        model.update();

        Position positionAfterExecution = model.getCannonPosition();
        
        model.undoLastCommand();
        
        Position positionAfterUndo = model.getCannonPosition();
        
        Assert.assertEquals(positionBeforeUndo.getX(), positionAfterExecution.getX());
        Assert.assertEquals(positionAfterExecution.getX(), positionAfterUndo.getX());
        Assert.assertEquals(positionBeforeUndo.getX(), positionAfterUndo.getX());

        Assert.assertEquals(positionBeforeUndo.getY(), positionAfterExecution.getY() + MvcGameConfig.MOVE_STEP);
        Assert.assertEquals(positionBeforeUndo.getY(), positionAfterUndo.getY());

    }

}
