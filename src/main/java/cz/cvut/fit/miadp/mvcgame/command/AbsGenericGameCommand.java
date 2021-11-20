package cz.cvut.fit.miadp.mvcgame.command;

import java.lang.reflect.InvocationTargetException;

import cz.cvut.fit.miadp.mvcgame.model.IGameModel;


public abstract class AbsGenericGameCommand {

    IGameModel subject;
    Object memento;

    protected abstract void execute() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
    
    public void doExecute() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.memento = this.subject.createMemento();
        this.execute();
    }

    public void unexecute () {
        this.subject.setMemento(this.memento);
    }

}
