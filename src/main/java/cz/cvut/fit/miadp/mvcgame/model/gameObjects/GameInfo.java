package cz.cvut.fit.miadp.mvcgame.model.gameObjects;

import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;

public class GameInfo extends AbsGameObject {
    
    private GameModel gameModel;

    public GameInfo(Position position, GameModel gameModel) {
        super(position);
        this.gameModel = gameModel;
    }

    public String getText() {       
        return "SCORE: " + this.gameModel.getScore();
    }

}
