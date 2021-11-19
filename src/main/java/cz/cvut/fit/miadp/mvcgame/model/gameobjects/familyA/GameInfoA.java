package cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA;

import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsGameInfo;


public class GameInfoA extends AbsGameInfo {
    
    private GameModel gameModel;

    public GameInfoA(Position position, GameModel gameModel) {
        this.position = position;
        this.gameModel = gameModel;
    }

    public String getText() {       
        return "SCORE: " + this.gameModel.getScore();
    }

}
