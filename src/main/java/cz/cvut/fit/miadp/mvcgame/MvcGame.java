package cz.cvut.fit.miadp.mvcgame;

import java.util.List;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.controller.GameController;
import cz.cvut.fit.miadp.mvcgame.memento.CareTaker;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.proxy.GameModelProxy;
import cz.cvut.fit.miadp.mvcgame.view.GameView;

// in future, use Bridge to remove this dependency
import javafx.scene.canvas.GraphicsContext;

public class MvcGame {

    private IGameModel model;
    private GameView view;
    private GameController controller;

    public void init() {
        model = new GameModelProxy(new GameModel());
        view = new GameView(model);
        controller = view.getController();

        CareTaker.getInstance().setModel(model);
    }

    public void processPressedKeys(List<String> pressedKeysCodes) {
        this.controller.processPressedKeys(pressedKeysCodes);
    }

    public void update() {
        // nothing yet
        this.model.timeTick();
    }

    public void render(GraphicsContext gc) {
        this.view.setGraphicsContext(gc);
        this.view.render();
    }

    public String getWindowTitle() {
        return "The MI-ADP MvcGame";
    }

    public int getWindowWidth() {
        return MvcGameConfig.SCENE_WITH;
    }

    public int getWindowHeight() {
        return MvcGameConfig.SCENE_HEIGHT;
    }

}