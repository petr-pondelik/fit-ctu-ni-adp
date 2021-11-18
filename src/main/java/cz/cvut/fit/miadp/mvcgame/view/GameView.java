package cz.cvut.fit.miadp.mvcgame.view;


import cz.cvut.fit.miadp.mvcgame.controller.GameController;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
// In future, use Bridge to remove this dependency
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GameView {

    private GameController controller;
    private GameModel model;

    public GameView(GameModel model) {
        this.model = model;
        this.controller = new GameController(model);
    }

    public GameController getController() {
        return this.controller;
    }

    public void render(GraphicsContext gr) {
        this.drawCannon(gr);
    }

    public void drawCannon(GraphicsContext gr) {
        gr.drawImage(new Image("images/cannon.png"), model.getCannonPosition().getX(), model.getCannonPosition().getY());
    }

}
