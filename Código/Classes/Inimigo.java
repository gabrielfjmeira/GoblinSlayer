package Classes;

import java.util.Random;
public class Inimigo extends Personagem{
    Random rd = new Random();

    //Método construtor
    public Inimigo(String nome) {
        //Implementação do builder
        super();
        super.setRecompensa(rd.nextInt(20) +15);
        super.setNome(nome);
        super.setVida(16);
        super.setAtaque(8);
        super.setDefesa(7);
    }

    @Override
    public String atacar(Personagem personagem){
        int dadoInimigo = rd.nextInt(20)+1;
        int defesaHeroi=personagem.getDefesa();
        if(dadoInimigo>defesaHeroi){
            personagem.setVida(personagem.getVida()-super.getAtaque());
            return "O inimigo atacou o herói, causando " + super.getAtaque() + " de dano";
        }else{
            return "O inimigo errou o ataque";
        }
    }

}
