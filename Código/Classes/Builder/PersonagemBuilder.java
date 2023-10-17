package Classes.Builder;

import Classes.Arma;

//Builder da classe Personagem
public interface PersonagemBuilder {

    //Método que define a vida do personagem
    public void setVida(Integer vida);

    //Método que define o ataque do personagem
    public void setAtaque(Integer ataque);

    //Método que define a defesa do personagem
    public void setDefesa(Integer defesa);

    //Método que define o nome do personagem
    public void setNome(String nome);

    //Método que define a classe do personagem
    public void setClasse(String classe);

    //Método que define o ouro do personagem
    public void setOuro(Integer ouro);

    //Método que define a quantidade de poção do personagem
    public void setQtdPocao(Integer qtdPocao);

    //Método que define a arma do personagem
    public void setArma(Arma arma);

    //Método que define a recompensa do personagem
    public void setRecompensa(Integer recompensa);
}