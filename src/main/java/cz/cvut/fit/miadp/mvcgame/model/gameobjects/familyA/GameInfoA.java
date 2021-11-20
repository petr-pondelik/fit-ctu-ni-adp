package cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA;

import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsGameInfo;


public class GameInfoA extends AbsGameInfo {
    
    private IGameModel gameModel;

    public GameInfoA(Position position, IGameModel gameModel) {
        this.position = position;
        this.gameModel = gameModel;
    }

    public String getText() {
        return  "SCORE: " + this.gameModel.getScore()
                + " | " + "POWER: " + this.gameModel.getCannon().getPower()
                + " | " + "ANGLE: " + (this.gameModel.getCannon().getAngle() / Math.PI) * 180 + "°"
                + " | " + "MOVING STRATEGY: " + this.gameModel.getMovingStrategy().getName()
                + " | " + "SHOOTING MODE: " + this.gameModel.getCannon().getShootingMode().getName();
    }

}
