package cz.cvut.fit.miadp.mvcgame.visitor;

import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;

public interface IVisitor {
    
    void visitCannon(AbsCannon cannon);
    void visitMissile(AbsMissile missile);

    // TODO: enemies, gameInfo, collisions

}
