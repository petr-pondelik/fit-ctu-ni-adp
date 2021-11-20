package cz.cvut.fit.miadp.mvcgame.controller;

import java.util.List;

import cz.cvut.fit.miadp.mvcgame.memento.CareTaker;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;


public class GameController {

    private IGameModel model;

    public GameController(IGameModel model) {
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
            case "SHIFT":
                this.model.toggleMovingStrategy();
                break;
            case "CONTROL":
                this.model.toggleShootingMode();
                break;
            case "S":
                CareTaker.getInstance().createMemento();
                break;
            case "R":
                CareTaker.getInstance().setMemento();
                break;
            default:
                System.out.println(code);
            }
        }
    }

}
