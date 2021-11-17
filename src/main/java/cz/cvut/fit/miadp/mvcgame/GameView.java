package cz.cvut.fit.miadp.mvcgame;

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
        gr.drawImage(new Image("icons/fit-icon-256x256.png"), model.getLogoPos().getX(), model.getLogoPos().getY());
    }

}
