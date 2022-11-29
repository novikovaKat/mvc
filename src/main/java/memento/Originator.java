package memento;

import character.Stats;

public class Originator {
    private Stats stats;

    public Originator() {
        stats = new Stats();
    }
    public void generateNew(){
        stats.generate();
    }
    public Memento saveStateToMemento(){
        return new Memento(Stats.copyStats(stats));
    }

    public void getStateFromMemento(Object o){
        Memento memento = (Memento)o;
        stats = Stats.copyStats(memento.stats);
    }
    
    public void clear(){
        stats.getAttributes().clear();
    }

    public void print(){
        stats.print();
    }

    public Stats getStats() {
        return Stats.copyStats(stats);
    }

    public void setStats(Stats stats) {
        this.stats = Stats.copyStats(stats);
    }

    private class Memento{
        private Stats stats;

        public Memento(Stats stats) {
            this.stats = stats;
        }

    }
}
