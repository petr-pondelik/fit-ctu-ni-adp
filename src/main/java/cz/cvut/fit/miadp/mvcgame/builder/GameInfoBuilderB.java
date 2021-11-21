package cz.cvut.fit.miadp.mvcgame.builder;


import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsGameInfo;
import cz.cvut.fit.miadp.mvcgame.model.gameobjects.familyB.GameInfoB;


public class GameInfoBuilderB implements IGameInfoBuilder {

    private IGameModel model;

    private int posX;
    private int posY;

    private boolean showScore;
    private boolean showPower;
    private boolean showAngle;
    private boolean showMovingStrategy;
    private boolean showShootingMode;

    public GameInfoBuilderB(IGameModel model) {
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
        return new GameInfoB(pos, this.model, this.showScore, this.showPower, this.showAngle, this.showMovingStrategy, this.showShootingMode);
    }

}
