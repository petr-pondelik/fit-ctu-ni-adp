package cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyB;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsEnemy;


public class EnemyB extends AbsEnemy {

    public EnemyB(Position initialPosition) {
        this.position = initialPosition;
        this.type = "2";
    }
    
}
