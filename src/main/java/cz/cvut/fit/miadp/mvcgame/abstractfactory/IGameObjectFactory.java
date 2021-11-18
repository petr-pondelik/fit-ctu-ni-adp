package cz.cvut.fit.miadp.mvcgame.abstractfactory;

import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;

public interface IGameObjectFactory {
    
    AbsCannon createCannon();
    AbsMissile createMissile();

    // TODO: enemies, gameInfo, collisions

}
