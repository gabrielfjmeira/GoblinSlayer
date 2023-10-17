package Classes.State;

import Classes.Heroi;

//Classe de estado do personagem
public abstract class State {
    Heroi heroi;
    public State(Heroi heroi){
        this.heroi = heroi;
    }

    public abstract String alive();
    public abstract String dead();
}
