package cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA;

import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsGameInfo;


public class GameInfoA extends AbsGameInfo {
    
    private IGameModel gameModel;

    public GameInfoA(
        Position position, IGameModel gameModel,
        boolean showScore, boolean showPower, boolean showAngle, boolean showMovingStrategy, boolean showShootingMode
    ) {
        this.position = position;
        this.gameModel = gameModel;
        this.showScore = showScore;
        this.showPower = showPower;
        this.showAngle = showAngle;
        this.showMovingStrategy = showMovingStrategy;
        this.showShootingMode = showShootingMode;
    }

    public String getText() {
        String res = "";
        boolean first = true;
        if (this.showScore) {
            res += "SCORE: " + this.gameModel.getScore();
            first = false;
        }
        if (this.showPower) {
            if (!first) {
                res += " | ";
            }
            res += "POWER: " + this.gameModel.getCannon().getPower();
            first = false;
        }
        if (this.showAngle) {
            if (!first) {
                res += " | ";
            }
            res += "ANGLE: " + (this.gameModel.getCannon().getAngle() / Math.PI) * 180 + "°";
            first = false;
        }
        if (this.showMovingStrategy) {
            if (!first) {
                res += " | ";
            }
            res += "MOVING STRATEGY: " + this.gameModel.getMovingStrategy().getName();
            first = false;
        }
        if (this.showShootingMode) {
            if (!first) {
                res += " | ";
            }
            res += "SHOOTING MODE: " + this.gameModel.getCannon().getShootingMode().getName();
            first = false;
        }
        return res;
    }

}
