package cz.cvut.fit.miadp.mvcgame.abstractfactory;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsCollision;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsGameInfo;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsMissile;

public interface IGameObjectFactory {
    
    AbsGameInfo createGameInfo();
    AbsCannon createCannon();
    AbsEnemy createEnemy(Position initialPosition);
    AbsMissile createMissile(Position initialPosition, double initAngle, double initVelocity);
    AbsCollision createCollision(Position initialPosition);

}
