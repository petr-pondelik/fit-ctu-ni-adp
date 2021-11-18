package cz.cvut.fit.miadp.mvcgame.model.gameObjects;

import java.util.Date;

import cz.cvut.fit.miadp.mvcgame.model.Position;

public abstract class AbsLifetimeLimitedGameObject extends AbsGameObject {
    
    protected Date bornAt;

    AbsLifetimeLimitedGameObject(Position initialPosition) {
        super(initialPosition);
        this.bornAt = new Date();
    }

    public long getAge() {
        return this.bornAt.getTime();
    }

}
