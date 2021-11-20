package cz.cvut.fit.miadp.mvcgame.model.gameobjects;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;


public abstract class AbsCollision extends AbsLifetimeLimitedGameObject {    

    protected AbsCollision(Position initialPosition) {
        super(initialPosition);
    }

    @Override
    public void acceptVisitor(IVisitor visitor) {
        visitor.visitCollision(this);
    }

    public boolean hasExpired() {
        return this.getAge() > MvcGameConfig.COLLISION_LIFETIME;
    }

}
