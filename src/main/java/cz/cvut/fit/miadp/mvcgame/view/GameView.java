package cz.cvut.fit.miadp.mvcgame.view;


import cz.cvut.fit.miadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.miadp.mvcgame.controller.GameController;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsGameObject;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;
import cz.cvut.fit.miadp.mvcgame.visitor.GameObjectsRender;


public class GameView implements IObserver {

    private IGameGraphics gr;

    private GameObjectsRender render;

    private GameController controller;
    private IGameModel model;

    private int updateCnt;


    public GameView(IGameModel model) {
        this.gr = null;
        this.render = new GameObjectsRender();
        this.model = model;
        this.controller = new GameController(model);
        this.model.registerObserver(this);
        this.updateCnt = 1;
    }


    public GameController getController() {
        return this.controller;
    }

    public void setGraphicsContext(IGameGraphics gr) {
        this.gr = gr;
        this.render.setGraphicsContext(gr);
    }

    public void render() {
        if (this.gr == null) { return; }

        if (this.updateCnt > 0) {

            // Clear the canvas
            this.gr.clear();

            for (AbsGameObject go : this.model.getGameObjects()) {
                go.acceptVisitor(this.render);
            }

            this.updateCnt = 0;
        }
    }

    @Override
    public void update() {
        this.updateCnt++;
    }

}
