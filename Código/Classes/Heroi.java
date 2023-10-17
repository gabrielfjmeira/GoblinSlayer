package Classes;

import Classes.State.AliveState;
import Classes.State.DeadState;
import Classes.State.State;

import java.util.Random;

public class Heroi extends Personagem {
    // Definindo atributos
    private State state;
    private boolean vivo;
    private Random rd =new Random();
    private static Heroi instancia;

    //Implementação Singleton
    public static Heroi getInstancia(String nome, String classe){
        if(instancia == null){
            instancia = new Heroi(nome, classe);
        }
        return instancia;
    }

    // Método construtor
    private Heroi(String nome, String classe){
        //Implementação do builder
        super();
        super.setNome(nome);
        super.setOuro(20);
        super.setQtdPocao(1);
        super.setArma(new Arma("Mão", 0));
        super.setClasse(classe);
        changeState(new AliveState(this));
        switch (classe){
            case "Guerreiro":
                super.setVida(60);
                super.setAtaque(10);
                super.setDefesa(10);
                break;
            case "Arqueiro":
                super.setVida(50);
                super.setAtaque(15);
                super.setDefesa(8);
                break;
            case "Mago":
                super.setVida(45);
                super.setAtaque(35);
                super.setDefesa(6);
                break;
        }
    }

    //Construtor de carregar
    public Heroi(String nome, String classe, String ouro, String vida, String qtdPocao, Arma arma){
        //Implementação do builder
        super();
        super.setNome(nome);
        super.setOuro(Integer.parseInt(ouro));
        super.setQtdPocao(Integer.parseInt(qtdPocao));
        super.setArma(arma);
        super.setClasse(classe);
        super.setVida(Integer.parseInt(vida));
        if (Integer.parseInt(vida) <= 0){
            setVivo(false);
            changeState(new DeadState(this));
        }else{
            setVivo(true);
            changeState(new AliveState(this));
        }
        switch (classe){
            case "Guerreiro":
                super.setAtaque(10);
                super.setDefesa(10);
                break;
            case "Arqueiro":
                super.setAtaque(15);
                super.setDefesa(8);
                break;
            case "Mago":
                super.setAtaque(35);
                super.setDefesa(6);
                break;
        }
    }

    public static void setInstancia(Heroi heroi){
        instancia = heroi;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public void changeState(State state){
        this.state = state;
    }

    @Override
    public String atacar(Personagem personagem) {
        int dadoHeroi = rd.nextInt(20) + 1;
        int defesaInimigo = personagem.getDefesa();
        if (dadoHeroi > defesaInimigo) {
            personagem.setVida(personagem.getVida() - super.getAtaque() - super.getArma().getDano());
            return this.getNome() + " atacou o inimigo usando " + super.getArma().getNome() + " " + (this.getAtaque() + super.getArma().getDano()) + " de dano!";
        } else {
            return this.getNome() + " errou o ataque!";
        }

    }
}
