package cz.cvut.fit.miadp.mvcgame.builder;


import cz.cvut.fit.miadp.mvcgame.model.gameobjects.AbsGameInfo;


public interface IGameInfoBuilder {

    IGameInfoBuilder posX(int posX);
    IGameInfoBuilder posY(int posY);

    IGameInfoBuilder withScore();
    IGameInfoBuilder withPower();
    IGameInfoBuilder withAngle();
    IGameInfoBuilder withMovingStrategy();
    IGameInfoBuilder withShootingMode();

    AbsGameInfo build();

}
