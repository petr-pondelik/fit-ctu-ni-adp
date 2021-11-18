package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import cz.cvut.fit.miadp.mvcgame.model.Position;


public abstract class AbsLifetimeLimitedGameObject extends AbsGameObject {
    
    protected LocalDateTime bornAt;

    AbsLifetimeLimitedGameObject(Position initialPosition) {
        this.position = initialPosition;
        this.bornAt = LocalDateTime.now();
    }

    public long getAge() {
        return ChronoUnit.MILLIS.between(this.bornAt, LocalDateTime.now());
    }

}
