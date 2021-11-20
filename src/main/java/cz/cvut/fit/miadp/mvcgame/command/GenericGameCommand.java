package cz.cvut.fit.miadp.mvcgame.command;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import cz.cvut.fit.miadp.mvcgame.model.IGameModel;


public class GenericGameCommand extends AbsGenericGameCommand {

    private Method cmdMethod;

    public GenericGameCommand(IGameModel subject, Method cmdMethod) {
        this.subject = subject;
        this.cmdMethod = cmdMethod;
    }

    @Override
    protected void execute() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.cmdMethod.invoke(this.subject);
    }
    
}
