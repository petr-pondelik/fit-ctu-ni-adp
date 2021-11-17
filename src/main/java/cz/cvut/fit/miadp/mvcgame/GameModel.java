package cz.cvut.fit.miadp.mvcgame;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;

public class GameModel {

    private Position logoPos;

    public GameModel() {
        this.logoPos = new Position((int) ((MvcGameConfig.MAX_X / 2) - 128), (int) ((MvcGameConfig.MAX_Y / 2) - 128));
    }

    public Position getLogoPos() {
        return this.logoPos;
    }

    public void moveLogoUp() {
        logoPos.setY(logoPos.getY() - 10);
    }

    public void moveLogoDown() {
        logoPos.setY(logoPos.getY() + 10);
    }

    public void moveLogoLeft() {
        logoPos.setX(logoPos.getX() - 10);
    }

    public void moveLogoRight() {
        logoPos.setX(logoPos.getX() + 10);
    }

    public void update() {
        // TODO
    }

}
