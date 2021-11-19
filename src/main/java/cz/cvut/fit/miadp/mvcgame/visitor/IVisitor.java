package cz.cvut.fit.miadp.mvcgame.visitor;

import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCollision;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsGameInfo;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;

public interface IVisitor {
    
    void visitGameInfo(AbsGameInfo gameInfo);
    void visitCannon(AbsCannon cannon);
    void visitEnemy(AbsEnemy enemy);
    void visitMissile(AbsMissile missile);
    void visitCollision(AbsCollision collision);

}
