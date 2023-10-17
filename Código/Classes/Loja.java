package Classes;

import Classes.BackgroundImage;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
public class Loja {

    public static Clip moneysound;
    private Heroi heroi;
    //Fonte das Letras
    private Font font = new Font("Arial",Font.BOLD,20);
    private Font title = new Font("Arial",Font.BOLD,40);
    private Color white = new Color(255,255,255);
    //Componentes Tela
    private JFrame menu = new JFrame();
    private BackgroundImage background =new BackgroundImage("src/Imagem/imagemLoja.jpg");
    private ImageIcon imagePocao =new ImageIcon("src/Imagem/pocaoVida.png");
    private ImageIcon imageArmaG =new ImageIcon("src/Imagem/espada1.png");
    private ImageIcon imageArmaM =new ImageIcon("src/Imagem/cajado1.png");
    private ImageIcon imageArmaA =new ImageIcon("src/Imagem/arco2.png");
    private ImageIcon imageCoin =new ImageIcon("src/Imagem/Coin.png");
    private ImageIcon backgroundButton = new ImageIcon("src/Imagem/Button.png");
    private File MoneySound =new File("src/Som/MoneySound.WAV");

    public Loja(){
        this.heroi = MenuCriarHeroi.heroi;
        menu.setTitle("Menu - Loja");
        menu.setSize(1080,720);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setResizable(false);
        menu.setLocationRelativeTo(null);

        menu.add(background);
        background.setLayout(null);

        //Voltar
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


        //Pocao
        JLabel pocaoLoja = new JLabel(imagePocao);
        pocaoLoja.setBounds(150,200,250,250);
        background.add(pocaoLoja);
        //Botão para comprar poção
        JButton comprarPocao = new JButton();
        comprarPocao.setBounds(200, 400, 150, 50);
        comprarPocao.setLayout(null);
        //estilizacao do botao
        comprarPocao.setIcon(backgroundButton);
        JLabel nomePocao = new JLabel();
        nomePocao.setText("Comprar 10G");
        nomePocao.setFont(font);
        comprarPocao.add(nomePocao);
        nomePocao.setBounds(20,-10,250,70);
        background.add(comprarPocao);

        //Arma
        if(heroi.getClasse().equals("Guerreiro")){
            JLabel armaLoja= new JLabel(imageArmaG);
            armaLoja.setBounds(550,180,250,250);
            background.add(armaLoja);
            //Botão para arma
            JButton comprarArma = new JButton();
            comprarArma.setBounds(600, 400, 150, 50);
            comprarArma.setLayout(null);
            //estilizacao do botao
            comprarArma.setIcon(backgroundButton);
            JLabel nomeArma = new JLabel();
            nomeArma.setText("Comprar 100G");
            nomeArma.setFont(font);
            comprarArma.add(nomeArma);
            nomeArma.setBounds(10,-10,250,70);
            background.add(comprarArma);
            comprarArma.addActionListener(this::comprarArma);

            try {
                AudioInputStream moneysoundAudioInputStream = AudioSystem.getAudioInputStream(MoneySound);
                moneysound = AudioSystem.getClip();
                moneysound.open(moneysoundAudioInputStream);
            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
                ex.printStackTrace();
            }

        }
        else if(heroi.getClasse().equals("Mago")){
            JLabel armaLoja= new JLabel(imageArmaM);
            armaLoja.setBounds(550,180,250,250);
            background.add(armaLoja);
            //Botão para arma
            JButton comprarArma = new JButton();
            comprarArma.setBounds(600, 400, 150, 50);
            comprarArma.setLayout(null);
            //estilizacao do botao
            comprarArma.setIcon(backgroundButton);
            JLabel nomeArma = new JLabel();
            nomeArma.setText("Comprar 100G");
            nomeArma.setFont(font);
            comprarArma.add(nomeArma);
            nomeArma.setBounds(10,-10,250,70);
            background.add(comprarArma);
            comprarArma.addActionListener(this::comprarArma);
        }
        else if(heroi.getClasse().equals("Arqueiro")){
            JLabel armaLoja= new JLabel(imageArmaA);
            armaLoja.setBounds(550,180,250,250);
            background.add(armaLoja);
            //Botão para arma
            JButton comprarArma = new JButton();
            comprarArma.setBounds(600, 400, 150, 50);
            comprarArma.setLayout(null);
            //estilizacao do botao
            comprarArma.setIcon(backgroundButton);
            JLabel nomeArma = new JLabel();
            nomeArma.setText("Comprar 100G");
            nomeArma.setFont(font);
            comprarArma.add(nomeArma);
            nomeArma.setBounds(10,-10,250,70);
            background.add(comprarArma);
            comprarArma.addActionListener(this::comprarArma);
        }

        //Mostrar Dinheiro
        JLabel coin= new JLabel(imageCoin);
        coin.setBounds(50,100,70,70);
        background.add(coin);
        JLabel dinheiro = new JLabel(Integer.toString(heroi.getOuro()));
        dinheiro.setBounds(120, 100, 350, 70);
        dinheiro.setFont(title);
        dinheiro.setForeground(white);
        background.add(dinheiro);


        //Ações Botões
        comprarPocao.addActionListener(this::comprarPocao);

        voltar.addActionListener(this::voltar);

        menu.setVisible(true);
    }

    private void comprarArma(ActionEvent a) {
        if(heroi.getOuro()-100>=0){
            if(heroi.getClasse().equals("Guerreiro")){
                moneysound.setFramePosition(0);
                moneysound.start();
                heroi.setArma(new Arma("Excalibur",5));

            }
            else if(heroi.getClasse().equals("Mago")){
                moneysound.setFramePosition(0);
                moneysound.start();
                heroi.setArma(new Arma("Spectrum",5));
            }
            else if(heroi.getClasse().equals("Arqueiro")){
                moneysound.setFramePosition(0);
                moneysound.start();
                heroi.setArma(new Arma("Turbilium",5));
            }


            heroi.setOuro(heroi.getOuro()-100);
            menu.setVisible(false);
            new Loja();
        }
        else{
            JOptionPane.showMessageDialog(null, "Sem ouro!");

        }

    }

    private void voltar(ActionEvent a) {
        menu.setVisible(false);
        MenuJogo menuJogo = new MenuJogo();
        MenuPrincipal.nextPage();
        MenuPrincipal.iniciar();
    }

    private void comprarPocao(ActionEvent a) {
        if(heroi.getOuro()-10>=0){
            heroi.setQtdPocao(heroi.getQtdPocao()+1);
            heroi.setOuro(heroi.getOuro()-10);
            menu.setVisible(false);
            moneysound.setFramePosition(0);
            moneysound.start();
            new Loja();
        }
        else{
            JOptionPane.showMessageDialog(null, "Sem ouro!");
        }
    }
}
