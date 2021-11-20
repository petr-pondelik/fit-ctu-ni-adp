package cz.cvut.fit.miadp.mvcgame.view;


import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.controller.GameController;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsGameObject;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;
import cz.cvut.fit.miadp.mvcgame.visitor.GameObjectsRender;

// In future, use Bridge to remove this dependency
import javafx.scene.canvas.GraphicsContext;


public class GameView implements IObserver {

    private GraphicsContext gr;

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

    public void setGraphicsContext(GraphicsContext gr) {
        this.gr = gr;
        this.render.setGraphicsContext(gr);
    }

    public void render() {
        if (this.gr == null) { return; }

        if (this.updateCnt > 0) {

            // Clear the canvas
            this.gr.clearRect(0, 0, MvcGameConfig.SCENE_WITH, MvcGameConfig.SCENE_HEIGHT);

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
