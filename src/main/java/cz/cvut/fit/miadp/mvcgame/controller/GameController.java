package cz.cvut.fit.miadp.mvcgame.controller;

import java.util.List;

import cz.cvut.fit.miadp.mvcgame.model.GameModel;

public class GameController {

    private GameModel model;

    public GameController(GameModel model) {
        this.model = model;
    }

    public void processPressedKeys(List<String> pressedKeysCodes) {
        for (String code : pressedKeysCodes) {
            switch (code) {
            case "UP":
                this.model.moveCannonUp();
                break;
            case "DOWN":
                this.model.moveCannonDown();
                break;
            case "SPACE":
                this.model.cannonShoot();
                break;
            case "A":
                this.model.aimCannonUp();
                break;
            case "Z":
                this.model.aimCannonDown();
                break;
            case "Q":
                this.model.cannonPowerDown();
                break;
            case "W":
                this.model.cannonPowerUp();
                break;
            case "S":
                this.model.toggleMovingStrategy();
                break;
            case "ALT":
                this.model.toggleShootingMode();
                break;
            default:
                System.out.println(code);
            }
        }
    }

}
