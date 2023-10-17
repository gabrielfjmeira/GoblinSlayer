package Classes;

import Classes.State.DeadState;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
public class Dungeon {
    public static Clip deathSound;
    public static Clip goblinDeath;
    private String nome;
    private Heroi heroi;
    private ArrayList<Personagem> inimigos;

    public Dungeon(String nome,ArrayList<Personagem> inimigos){
        this.nome = nome;
        this.heroi = MenuCriarHeroi.heroi;
        this.inimigos = inimigos;
    }

    public String getNome() {
        return nome;
    }
    private JFrame menu =new JFrame();
    private ImageIcon imageGuerreiro =new ImageIcon("src/Imagem/guerreiro.png");
    private ImageIcon imageMago =new ImageIcon("src/Imagem/mago.png");
    private ImageIcon imageArqueiro =new ImageIcon("src/Imagem/arqueiro.png");
    private ImageIcon imageGoblin =new ImageIcon("src/Imagem/goblin1.png");
    private File DeathSound =new File("src/Som/HeroDeathSound.WAV");
    private File GoblinDeathSound =new File("src/Som/GoblinDeath.WAV");
    public void inicializarDungeon(String status, String mensagemHeroi, String mensagemInimigo){
        menu.setTitle("Floresta Goblin");
        menu.setSize(1080,720);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setResizable(false);
        menu.setLocationRelativeTo(null);

        Font font = new Font("Arial", Font.BOLD, 20);
        Font title = new Font("Arial", Font.BOLD, 50);
        Color white = new Color(255, 255, 255);



        BackgroundImage background =new BackgroundImage("src/Imagem/FlorestaGoblin.jpg");
        ImageIcon backgroundButton = new ImageIcon("src/Imagem/Button.png");
        menu.add(background);
        background.setLayout(null);

        //Título
        JLabel titulo = new JLabel();
        titulo.setText(this.getNome());
        titulo.setBounds(300, 10, 550, 70);
        titulo.setFont(title);
        titulo.setForeground(white);
        background.add(titulo);

        //Nome do Herói
        JLabel nomeHeroi = new JLabel();
        nomeHeroi.setBounds(75, 70, 350, 70);
        nomeHeroi.setText(heroi.getNome());
        nomeHeroi.setFont(font);
        nomeHeroi.setForeground(white);
        background.add(nomeHeroi);

        //Vida do Herói
        JLabel vidaHeroi = new JLabel();
        vidaHeroi.setBounds(75, 100, 350, 70);
        if(heroi.getVida() > 0){
            vidaHeroi.setText("Vida: " + heroi.getVida());
        }else{
            vidaHeroi.setText("Vida: 0");
        }
        vidaHeroi.setFont(font);
        vidaHeroi.setForeground(white);
        background.add(vidaHeroi);

        //Poções do Herói
        JLabel pocaoVida = new JLabel();
        pocaoVida.setBounds(75, 130, 350, 70);
        pocaoVida.setText("Poções disponíveis: " + heroi.getQtdPocao());
        pocaoVida.setFont(font);
        pocaoVida.setForeground(white);
        background.add(pocaoVida);

        if(heroi.getClasse().equals("Guerreiro")) {
            JLabel guerreiro = new JLabel(imageGuerreiro);
            guerreiro.setBounds(50, 180, 350, 300);
            background.add(guerreiro);
        }
        if(heroi.getClasse().equals("Mago")) {
            JLabel mago = new JLabel(imageMago);
            mago.setBounds(50, 180, 350, 300);
            background.add(mago);
        }
        if(heroi.getClasse().equals("Arqueiro")) {
            JLabel arqueiro = new JLabel(imageArqueiro);
            arqueiro.setBounds(50, 180, 350, 300);
            background.add(arqueiro);
        }


        if(inimigos.size() < 1){

        }else {
            //Nome do Inimigo
            JLabel nomeInimigo = new JLabel();
            nomeInimigo.setBounds(900, 70, 350, 70);
            nomeInimigo.setText(inimigos.get(0).getNome());
            nomeInimigo.setFont(font);
            nomeInimigo.setForeground(white);
            background.add(nomeInimigo);

            //Vida do Inimigo
            JLabel vidaInimigo = new JLabel();
            vidaInimigo.setBounds(900, 100, 350, 70);
            if (inimigos.get(0).getVida() > 0) {
                vidaInimigo.setText("Vida: " + inimigos.get(0).getVida());
            } else {
                vidaInimigo.setText("Vida: 0");
            }
            vidaInimigo.setFont(font);
            vidaInimigo.setForeground(white);
            background.add(vidaInimigo);

            JLabel goblin = new JLabel(imageGoblin);
            goblin.setBounds(700, 180, 350, 300);
            background.add(goblin);


        }

        //Botão de Atacar
        JButton btnatacar = new JButton();
        btnatacar.setBounds(50, 600, 100, 50);
        btnatacar.setLayout(null);
        //estilizacao do botão
        btnatacar.setIcon(backgroundButton);
        JLabel nomebtnAtacar = new JLabel();
        nomebtnAtacar.setText("Atacar");
        nomebtnAtacar.setFont(font);
        btnatacar.add(nomebtnAtacar);
        nomebtnAtacar.setBounds(20,-6,250,70);

        if (inimigos.size() >= 1) {
            if (heroi.getVida() > 0) {
                background.add(btnatacar);
            }
        }

        //Botão de fugir
        JButton btnfugir = new JButton();
        btnfugir.setBounds(850, 600, 100, 50);
        btnfugir.setLayout(null);
        // estilizacao do botão
        btnfugir.setIcon(backgroundButton);
        JLabel nomebtnFugir = new JLabel();
        nomebtnFugir.setText("Fugir");
        nomebtnFugir.setFont(font);
        btnfugir.add(nomebtnFugir);
        nomebtnFugir.setBounds(20,-6,250,70);

        if (inimigos.size() >= 1) {
            if (heroi.getVida() > 0) {
                background.add(btnfugir);
            }
        }

        //Botão de Voltar
        JButton btnvoltar = new JButton();
        btnvoltar.setBounds(450, 600, 150, 50);
        btnvoltar.setLayout(null);
        // estilizacao do botão
        btnvoltar.setIcon(backgroundButton);
        JLabel nomebtnVoltar = new JLabel();
        if (heroi.getVida() > 0){
            nomebtnVoltar.setText("Voltar");
        }else{
            MenuDungeon.fightThemeStop();
            deathSound.setFramePosition(0);
            deathSound.start();
            nomebtnVoltar.setText("Game Over");
        }
        nomebtnVoltar.setFont(font);
        btnvoltar.add(nomebtnVoltar);
        nomebtnVoltar.setBounds(20,-6,250,70);


        if(heroi.getVida()<=0 || inimigos.size() < 1) {
            background.add(btnvoltar);
        }

        //Usar Poção
        JButton btnPocao = new JButton();
        btnPocao.setBounds(450, 620, 150, 50);
        btnPocao.setLayout(null);
        //estilizacao do botão
        btnPocao.setIcon(backgroundButton);
        JLabel nomebtnPocao = new JLabel();
        nomebtnPocao.setText("Usar Poção");
        nomebtnPocao.setFont(font);
        btnPocao.add(nomebtnPocao);
        nomebtnPocao.setBounds(20,-6,250,70);
        if(heroi.getQtdPocao() > 0 && inimigos.size() >= 1 && heroi.getVida()>0) {
            background.add(btnPocao);
        }

        //Mensagem de Status da Dungeon
        JLabel mensagemStatus = new JLabel();
        mensagemStatus.setBounds(320, 470, 550, 70);
        mensagemStatus.setText(status);
        mensagemStatus.setFont(font);
        mensagemStatus.setForeground(white);
        background.add(mensagemStatus);

        //Mensagem de Info Herói
        JLabel mensagemInfoHeroi = new JLabel();
        mensagemInfoHeroi.setBounds(50, 520, 550, 70);
        mensagemInfoHeroi.setText(mensagemHeroi);
        mensagemInfoHeroi.setFont(font);
        mensagemInfoHeroi.setForeground(white);
        background.add(mensagemInfoHeroi);

        //Mensagem de Info Inimigo
        JLabel mensagemInfoInimigo = new JLabel();
        mensagemInfoInimigo.setBounds(600, 520, 550, 70);
        mensagemInfoInimigo.setText(mensagemInimigo);
        mensagemInfoInimigo.setFont(font);
        mensagemInfoInimigo.setForeground(white);
        background.add(mensagemInfoInimigo);

        //Ações dos Botões
        btnatacar.addActionListener(this::ataque);
        btnfugir.addActionListener(this::fugir);
        btnPocao.addActionListener(this::usarPocao);
        btnvoltar.addActionListener(this::voltar);

        try {
            AudioInputStream deathSoundAudioInputStream = AudioSystem.getAudioInputStream(DeathSound);
            deathSound = AudioSystem.getClip();
            deathSound.open(deathSoundAudioInputStream);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
            ex.printStackTrace();
        }
        try {
            AudioInputStream GoblindeathSoundAudioInputStream = AudioSystem.getAudioInputStream(GoblinDeathSound);
            goblinDeath = AudioSystem.getClip();
            goblinDeath .open(GoblindeathSoundAudioInputStream);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
            ex.printStackTrace();
        }

        menu.setVisible(true);

    }

    private void voltar(ActionEvent e) {
        menu.setVisible(false);
        if(heroi.getVida() > 0){
            MenuDungeon.fightThemeStop();
            MenuDungeon menuDungeon = new MenuDungeon();
        }else{
            MenuDungeon.fightThemeStop();
            MenuJogo menuJogo  = new MenuJogo();
        }

    }

    private void fugir(ActionEvent e) {
        Random rd =new Random();
        if(rd.nextInt(10)+1>=8){
            JOptionPane.showMessageDialog(null, heroi.getNome() + " escapou!");
            menu.setVisible(false);
            MenuDungeon.fightThemeStop();
            MenuDungeon menuDungeon=new MenuDungeon();
        }else{
            //Mensagem do inimigo
            String msgInimigo = inimigos.get(0).atacar(heroi);

            //Mensagem do herói
            String msgHeroi = heroi.getNome() + " não conseguiu escapar!";
            if(heroi.getVida() <= 0){
                deathSound.setFramePosition(0);
                deathSound.start();
                msgHeroi = heroi.getNome() + " morreu!";
            }

            menu.setVisible(false);
            Dungeon dungeonNextStep = new Dungeon(nome, inimigos);
            dungeonNextStep.inicializarDungeon("", msgHeroi, msgInimigo);
        }
    }

    private void ataque(ActionEvent e)  {
        //Mensagem do Herói
        String msgHeroi =heroi.atacar(inimigos.get(0));

        //Mensagem do Inimigo
        String msgInimigo = inimigos.get(0).atacar(heroi);

        if(inimigos.get(0).getVida() <= 0){ //Herói derrotou o inimigo
            goblinDeath.setFramePosition(0);
            goblinDeath.start();

            //Recompensa adicionada no saldo do Herói
            heroi.setOuro(heroi.getOuro() + ((Inimigo) inimigos.get(0)).getRecompensa());

            //Passa para o próximo inimigo
            inimigos.remove(0);

            //Mensagem do Inimigo
            msgInimigo = heroi.getNome() + " derrotou o inimigo!";

        }else if(heroi.getVida() <= 0){ //Herói morreu
            heroi.changeState(new DeadState(heroi));
            deathSound.setFramePosition(0);
            deathSound.start();
            msgHeroi = heroi.getNome() + " morreu!";
        }

        //Continua Dungeon
        menu.setVisible(false);

        //Fim da Dungeon
        if (inimigos.size() < 1){
            Dungeon dungeonEnd = new Dungeon(nome, inimigos);
            dungeonEnd.inicializarDungeon("Dungeon finalizada!", msgHeroi, msgInimigo);
        }else{
            Dungeon dungeonNextStep = new Dungeon(nome, inimigos);
            dungeonNextStep.inicializarDungeon("", msgHeroi, msgInimigo);
        }
    }

    private void usarPocao(ActionEvent e){
        if(heroi.getQtdPocao() > 0){
            //Seta a vida do herói
            heroi.setQtdPocao(heroi.getQtdPocao() - 1);

            //Mensagem do Herói
            String msgHeroi = "Poção de vida usada com sucesso!";

            String classeHeroi = heroi.getClasse();
            switch (classeHeroi){
                case "Guerreiro":
                    heroi.setVida(60);
                    break;
                case "Arqueiro":
                    heroi.setVida(50);
                    break;
                case "Mago":
                    heroi.setVida(45);
                    break;
            }

            //Mensagem do Inimigo
            String msgInimigo = inimigos.get(0).atacar(heroi);

            menu.setVisible(false);
            Dungeon dungeonNextStep = new Dungeon(nome, inimigos);
            dungeonNextStep.inicializarDungeon("", msgHeroi, msgInimigo);
        }
    }
}
