package memento;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    private Object memento;

    public CareTaker() {
        memento = new Object();
    }
    public void save(Object memento){
        this.memento = memento;
    }
    public Object get(){
        return memento;
    }
}
