package cz.cvut.fit.miadp.mvcgame.memento;

import java.util.ArrayList;
import java.util.List;

import cz.cvut.fit.miadp.mvcgame.model.IGameModel;


public class CareTaker {
    
    private IGameModel model;
    private List<Object> mementos = new ArrayList<>();

    private static class SingletonHolder {
        private static final CareTaker INSTANCE = new CareTaker();
    }

    public static CareTaker getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void setModel(IGameModel model) {
        this.model = model;
    }

    public Object createMemento() {
        if (this.model instanceof IGameModel) {
            Object m = this.model.createMemento();
            this.mementos.add(m);
            return m;
        }
        return null;
    }

    public void setMemento() {
        if (this.model instanceof IGameModel) {
            if (this.mementos.size() > 0) {
                this.model.setMemento(this.mementos.get(this.mementos.size() - 1));
            }
        }
    }

}
