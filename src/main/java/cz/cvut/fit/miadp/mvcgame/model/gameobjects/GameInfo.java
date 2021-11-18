package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.visitor.GameObjectsRender;

public class GameInfo extends AbsGameObject {
    
    private GameModel gameModel;

    public GameInfo(Position position, GameModel gameModel) {
        this.position = position;
        this.gameModel = gameModel;
    }

    public String getText() {       
        return "SCORE: " + this.gameModel.getScore();
    }

    @Override
    public void acceptVisitor(GameObjectsRender render) {
        // TODO Auto-generated method stub
        
    }

}
