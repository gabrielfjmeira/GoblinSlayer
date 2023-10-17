package Classes.State;

import Classes.Heroi;

//Classe de mudança de estado do personagem (vivo)
public class AliveState extends State {

    public AliveState(Heroi heroi){
        super(heroi);

        heroi.setVivo(true);
    }

    @Override
    public String alive(){
        if (heroi.isVivo() == false){
            heroi.setVivo(true);
            heroi.changeState(new AliveState(heroi));
            return "Herói reviveu";
        }else {
            return "Herói vivo!";
        }
    }

    @Override
    public String dead() {
        return "Herói vivo!";
    }
}
