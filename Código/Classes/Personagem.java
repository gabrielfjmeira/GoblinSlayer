package Classes;

import Classes.Builder.PersonagemBuilder;

public abstract class Personagem implements PersonagemBuilder {
    private Integer vida;
    private Integer ataque;
    private Integer defesa;
    private String nome;
    private String classe;
    private Integer ouro;
    private Integer qtdPocao;
    private Arma arma;
    private Integer recompensa;

    public Personagem() {
        this.vida = null;
        this.ataque = null;
        this.defesa = null;
        this.nome = null;
        this.classe = null;
        this.ouro = null;
        this.qtdPocao = null;
        this.arma = null;
        this.recompensa = null;
    }

    public Integer getVida() {
        return vida;
    }

    @Override
    public void setVida(Integer vida) {
        this.vida = vida;
    }

    public Integer getAtaque() {
        return ataque;
    }

    @Override
    public void setAtaque(Integer ataque) {
        this.ataque = ataque;
    }

    public Integer getDefesa() {
        return defesa;
    }

    @Override
    public void setDefesa(Integer defesa) {
        this.defesa = defesa;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClasse() {
        return classe;
    }

    @Override
    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Integer getOuro() {
        return ouro;
    }

    @Override
    public void setOuro(Integer ouro) {
        this.ouro = ouro;
    }

    public Integer getQtdPocao() {
        return qtdPocao;
    }

    @Override
    public void setQtdPocao(Integer qtdPocao) {
        this.qtdPocao = qtdPocao;
    }

    public Arma getArma() {
        return arma;
    }

    @Override
    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public Integer getRecompensa() {
        return recompensa;
    }

    @Override
    public void setRecompensa(Integer recompensa) {
        this.recompensa = recompensa;
    }

    public  String falaPersonagem(){
        return "Fala do Personagem:";
    }

    public abstract String atacar(Personagem personagem);

}