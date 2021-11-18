package cz.cvut.fit.miadp.mvcgame.view;


import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.controller.GameController;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.Enemy;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;
// In future, use Bridge to remove this dependency
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class GameView implements IObserver {

    private GraphicsContext gr;

    private GameController controller;
    private GameModel model;

    private int updateCnt;

    public GameView(GameModel model) {
        this.gr = null;
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
    }

    public void render() {
        if (this.gr == null) { return; }

        if (this.updateCnt > 0) {

            // Clear the canvas
            this.gr.clearRect(0, 0, MvcGameConfig.SCENE_WITH, MvcGameConfig.SCENE_HEIGHT);

            this.drawCannon();
            this.drawGameInfo();
            this.drawEnemies();

            this.updateCnt = 0;
        }
    }

    public void drawGameInfo() {
        this.gr.fillText(model.getGameInfo().getText(), model.getGameInfo().getPosition().getX(), model.getGameInfo().getPosition().getY());

    }

    public void drawCannon() {
        this.gr.drawImage(new Image("images/cannon.png"), model.getCannon().getPosition().getX(), model.getCannon().getPosition().getY());
    }

    public void drawEnemies() {
        for (Enemy e : model.getEnemies()) {
            this.gr.drawImage(new Image("images/enemy1.png"), e.getPosition().getX(), e.getPosition().getY());
        }
    }

    @Override
    public void update() {
        this.updateCnt++;
    }

}
