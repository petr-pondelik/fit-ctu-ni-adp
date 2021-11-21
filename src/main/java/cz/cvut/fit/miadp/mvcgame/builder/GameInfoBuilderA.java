package cz.cvut.fit.miadp.mvcgame.builder;


import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsGameInfo;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyA.GameInfoA;


public class GameInfoBuilderA implements IGameInfoBuilder {

    private IGameModel model;

    private int posX = 0;
    private int posY = 0;

    private boolean showScore = false;
    private boolean showPower = false;
    private boolean showAngle = false;
    private boolean showMovingStrategy = false;
    private boolean showShootingMode = false;

    public GameInfoBuilderA(IGameModel model) {
        this.model = model;
    }

    @Override
    public IGameInfoBuilder posX(int posX) {
        this.posX = posX;
        return this;
    }

    @Override
    public IGameInfoBuilder posY(int posY) {
        this.posY = posY;
        return this;
    }

    @Override
    public IGameInfoBuilder withScore() {
        this.showScore = true;
        return this;
    }

    @Override
    public IGameInfoBuilder withPower() {
        this.showPower = true;
        return this;
    }

    @Override
    public IGameInfoBuilder withAngle() {
        this.showAngle = true;
        return this;
    }

    @Override
    public IGameInfoBuilder withMovingStrategy() {
        this.showMovingStrategy = true;
        return this;
    }

    @Override
    public IGameInfoBuilder withShootingMode() {
        this.showShootingMode = true;
        return this;
    }

    @Override
    public AbsGameInfo build() {
        Position pos = new Position(this.posX, this.posY);
        return new GameInfoA(pos, this.model, this.showScore, this.showPower, this.showAngle, this.showMovingStrategy, this.showShootingMode);
    }

}
