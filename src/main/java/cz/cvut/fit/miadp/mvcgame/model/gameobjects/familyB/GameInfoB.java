package cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyB;

import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsGameInfo;


public class GameInfoB extends AbsGameInfo {
    
    private IGameModel gameModel;

    public GameInfoB(Position position, IGameModel gameModel) {
        this.position = position;
        this.gameModel = gameModel;
    }

    public String getText() {       
        return "SCORE: " + this.gameModel.getScore();
    }

}
