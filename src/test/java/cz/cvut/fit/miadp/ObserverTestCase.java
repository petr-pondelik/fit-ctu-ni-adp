package cz.cvut.fit.miadp;

import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.view.GameView;

import org.junit.Test;

import static org.mockito.Mockito.*;


public class ObserverTestCase {

    @Test
    public void registerObserver() {
        IGameModel model = new GameModel();
        GameView view1 = mock(GameView.class);
        GameView view2 = mock(GameView.class);
        model.registerObserver(view1);
        model.registerObserver(view2);
        model.notifyObservers();
        verify(view1, times(1)).update();
        verify(view2, times(1)).update();
    }

    @Test
    public void unregisterObserver() {
        IGameModel model = new GameModel();
        GameView view1 = mock(GameView.class);
        GameView view2 = mock(GameView.class);
        model.registerObserver(view1);
        model.registerObserver(view2);
        model.unregisterObserver(view1);
        model.notifyObservers();
        verify(view2, times(1)).update();
        verify(view1, never()).update();
    }

}
