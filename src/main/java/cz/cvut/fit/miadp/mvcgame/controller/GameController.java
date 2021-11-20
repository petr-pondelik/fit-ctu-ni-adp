package cz.cvut.fit.miadp.mvcgame.controller;

import java.util.List;

import cz.cvut.fit.miadp.mvcgame.command.GenericGameCommand;
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
                this.registerCommandByName("moveCannonUp");
                break;
            case "DOWN":
                this.registerCommandByName("moveCannonDown");
                break;
            case "SPACE":
                this.registerCommandByName("cannonShoot");
                break;
            case "A":
                this.registerCommandByName("aimCannonUp");
                break;
            case "Z":
                this.registerCommandByName("aimCannonDown");
                break;
            case "Q":
                this.registerCommandByName("cannonPowerDown");
                break;
            case "W":
                this.registerCommandByName("cannonPowerUp");
                break;
            case "SHIFT":
                this.registerCommandByName("toggleMovingStrategy");
                break;
            case "CONTROL":
                this.registerCommandByName("toggleShootingMode");
                break;
            case "B":
                this.model.undoLastCommand();
                break;
            default:
                System.out.println(code);
            }
        }
    }

    private void registerCommandByName(String cmdName) {
        try {
            GenericGameCommand cmd = new GenericGameCommand(this.model, this.model.getClass().getMethod(cmdName));
            this.model.registerCommand(cmd);
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
    }

}
