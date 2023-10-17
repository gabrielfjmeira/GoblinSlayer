package Classes;

import Classes.BackgroundImage;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class MenuDungeon {
    //Componentes para criar Dungeon
    Random rd = new Random();
    ArrayList<Dungeon> dungeons=new ArrayList<>();

    //Som
    public static Clip fightTheme;
    private static Clip dungeonTheme;
    private File DungeonTheme = new File("src/Som/DungeonTheme.WAV");
    private File FightTheme = new File("src/Som/FigthTheme.WAV");

    //Fonte das Letras
    private Font font = new Font("Arial",Font.BOLD,20);
    private Font title = new Font("Arial",Font.BOLD,30);
    private Color black = new Color(0,0,0);

    //Componentes da Tela
    private JFrame menu =new JFrame();
    private BackgroundImage background = new BackgroundImage("src/Imagem/BackgroundMenuDungeon.jpg");
    private ImageIcon backgroundButton = new ImageIcon("src/Imagem/Button.png");
    private String fala;
    public MenuDungeon(){
        menu.setTitle("Menu - Dungeons");
        menu.setSize(1080,720);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setResizable(false);
        menu.setLocationRelativeTo(null);
        menu.add(background);
        background.setLayout(null);

        //Título
        JLabel titulo = new JLabel("Inicie uma Jornada Aventureiro");
        titulo.setBounds(300, 100, 500, 70);
        titulo.setFont(title);
        titulo.setForeground(black);
        background.add(titulo);

        //Botão para voltar para o menu
        JButton voltar = new JButton();
        voltar.setBounds(50, 25, 100, 50);
        voltar.setLayout(null);
        //estilizacao do botao
        voltar.setIcon(backgroundButton);
        JLabel nomeBotao1 = new JLabel();
        nomeBotao1.setText("Voltar");
        nomeBotao1.setFont(font);
        voltar.add(nomeBotao1);
        nomeBotao1.setBounds(20,-10,250,70);
        background.add(voltar);

        ArrayList<Personagem> inimigosDungeon1= new ArrayList<>();
        for (int i=0;i<=rd.nextInt(10);i++){
            inimigosDungeon1.add(new Inimigo("Goblins"));
        }
        dungeons.add(new Dungeon("Floresta dos Goblins",inimigosDungeon1));
        fala = inimigosDungeon1.get(0).falaPersonagem();

        //Botão Dungeon 1
        JButton btnDungeon1 = new JButton();
        btnDungeon1.setBounds(405,200,250,60);
        btnDungeon1.setLayout(null);
        //estilizacao do botao
        btnDungeon1.setIcon(backgroundButton);
        JLabel nomeBotao2 = new JLabel();
        nomeBotao2.setText("Floresta dos Goblins");
        nomeBotao2.setFont(font);
        btnDungeon1.add(nomeBotao2);
        nomeBotao2.setBounds(27,-6,250,70);
        background.add(btnDungeon1);



        //Ações dos botões
        voltar.addActionListener(this::voltar);
        btnDungeon1.addActionListener(this::iniciaDungeon1);

        try {
            AudioInputStream backgroundAudioInputStream = AudioSystem.getAudioInputStream(DungeonTheme);
            dungeonTheme = AudioSystem.getClip();
            dungeonTheme.open(backgroundAudioInputStream);
            dungeonTheme.loop(Clip.LOOP_CONTINUOUSLY);
            dungeonTheme.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
            ex.printStackTrace();
        }

        try {
            AudioInputStream  fightThemeAudioInputStream = AudioSystem.getAudioInputStream(FightTheme);
            fightTheme = AudioSystem.getClip();
            fightTheme.open(fightThemeAudioInputStream);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
            ex.printStackTrace();
        }


        menu.setVisible(true);
    }

    private void iniciaDungeon1(ActionEvent a) {
        if (MenuCriarHeroi.heroi.isVivo() == true){
            menu.setVisible(false);
            dungeons.get(0).inicializarDungeon("A batalha na " + dungeons.get(0).getNome() + " começa!", MenuCriarHeroi.heroi.falaPersonagem(),fala );
            dungeonTheme.stop();
            fightTheme.start();
        }else{
            JOptionPane.showMessageDialog(null, "Personagem está morto!");
        }
    }

    private void voltar(ActionEvent a) {
        dungeonTheme.stop();
        menu.setVisible(false);
        MenuJogo menuJogo = new MenuJogo();
        MenuPrincipal.iniciar();
    }

    public static void fightThemeStop(){
        fightTheme.stop();
    }
}
