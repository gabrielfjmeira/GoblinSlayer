package Classes.State;

import Classes.Heroi;

//Classe de mudança de estado do personagem (morto)
public class DeadState extends State {

    public DeadState(Heroi heroi){
        super(heroi);
        heroi.setVivo(false);
    }

    @Override
    public String alive(){
        return "Herói morto!";
    }

    @Override
    public String dead() {
        if (heroi.isVivo() == true){
            heroi.setVivo(false);
            heroi.changeState(new DeadState(heroi));
            return "Herói morreu!";
        }else {
            return "Herói já está morto!";
        }
    }

}
