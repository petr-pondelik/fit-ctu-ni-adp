package cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyB;

import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsGameInfo;


public class GameInfoB extends AbsGameInfo {
    
    private IGameModel gameModel;

    public GameInfoB(
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
            res += "Score: " + this.gameModel.getScore();
            first = false;
        }
        if (this.showPower) {
            if (!first) {
                res += " | ";
            }
            res += "Power: " + this.gameModel.getCannon().getPower();
            first = false;
        }
        if (this.showAngle) {
            if (!first) {
                res += " | ";
            }
            res += "Angle: " + (this.gameModel.getCannon().getAngle() / Math.PI) + " PI";
            first = false;
        }
        if (this.showMovingStrategy) {
            if (!first) {
                res += " | ";
            }
            res += "Moving strategy: " + this.gameModel.getMovingStrategy().getName();
            first = false;
        }
        if (this.showShootingMode) {
            if (!first) {
                res += " | ";
            }
            res += "Shooting mode: " + this.gameModel.getCannon().getShootingMode().getName();
            first = false;
        }
        return res;
    }

}
