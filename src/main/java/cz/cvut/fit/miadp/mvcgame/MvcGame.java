package cz.cvut.fit.miadp.mvcgame;

import java.util.List;

import cz.cvut.fit.miadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.controller.GameController;
import cz.cvut.fit.miadp.mvcgame.memento.CareTaker;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.proxy.GameModelProxy;
import cz.cvut.fit.miadp.mvcgame.view.GameView;


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

    public void render(IGameGraphics gr) {
        this.view.setGraphicsContext(gr);
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