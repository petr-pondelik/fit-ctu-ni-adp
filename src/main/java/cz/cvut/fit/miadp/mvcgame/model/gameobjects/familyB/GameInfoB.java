package cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyB;

import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsGameInfo;


public class GameInfoB extends AbsGameInfo {
    
    private GameModel gameModel;

    public GameInfoB(Position position, GameModel gameModel) {
        this.position = position;
        this.gameModel = gameModel;
    }

    public String getText() {       
        return "SCORE: " + this.gameModel.getScore();
    }

}
