package Classes;

import Classes.BackgroundImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MenuJogo {


    //Fonte das Letras
    private Font font = new Font("Arial",Font.BOLD,20);
    private Font title = new Font("Arial",Font.BOLD,30);
    private Color black = new Color(0,0,0);
    //Componentes para Tela
    private JFrame menu = new JFrame();
    private BackgroundImage background = new BackgroundImage("src/Imagem/MenuImage.jpg");
    private BackgroundImage painel = new BackgroundImage("src/Imagem/Painel.jpg");
    private ImageIcon backgroundButton = new ImageIcon("src/Imagem/Button.png");
    public MenuJogo(){
        menu.setTitle("Menu - Jogo");
        menu.setSize(1080,720);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setResizable(false);
        menu.setLocationRelativeTo(null);

        menu.add(background);
        background.setLayout(null);
        background.add(painel);

        // Titulo
        JLabel titulo = new JLabel("Bem-vindo Aventureiro!");
        titulo.setBounds(50, 20, 400, 70);
        titulo.setFont(title);
        titulo.setForeground(black);

        //Botão para Jogar
        JButton jogar = new JButton();
        jogar.setBounds(80, 100, 250, 70);
        jogar.setLayout(null);
        jogar.setIcon(backgroundButton);
        JLabel nomeBotao1 = new JLabel();

        nomeBotao1.setText("Jogar");
        nomeBotao1.setFont(font);
        nomeBotao1.setForeground(black);
        jogar.add(nomeBotao1);
        jogar.add(nomeBotao1, BorderLayout.CENTER);
        nomeBotao1.setBounds(95,-3,250,70);

        //Botão para Loja
        JButton loja = new JButton();
        loja.setBounds(80, 200, 250, 70);
        loja.setLayout(null);
        loja.setIcon(backgroundButton);
        JLabel nomeBotao2 = new JLabel();
        nomeBotao2.setText("Loja");
        nomeBotao2.setFont(font);
        nomeBotao2.setForeground(black);
        loja.add(nomeBotao2);
        nomeBotao2.setBounds(100,-3,250,70);

        //Botão para salvar o jogo
        JButton salvar = new JButton();
        salvar.setBounds(80, 300, 250, 70);
        salvar.setLayout(null);
        salvar.setIcon(backgroundButton);
        JLabel nomeBotao4 = new JLabel();
        nomeBotao4.setText("Salvar");
        nomeBotao4.setFont(font);
        nomeBotao4.setForeground(black);
        salvar.add(nomeBotao4);
        nomeBotao4.setBounds(90,-3,250,70);

        //Botão para fechar o jogo
        JButton sair = new JButton();
        sair.setBounds(80, 400, 250, 70);
        sair.setLayout(null);
        sair.setIcon(backgroundButton);
        JLabel nomeBotao3 = new JLabel();
        nomeBotao3.setText("Sair");
        nomeBotao3.setFont(font);
        nomeBotao3.setForeground(black);
        sair.add(nomeBotao3);
        nomeBotao3.setBounds(103,-3,250,70);


        // Organizando elementos da tela
        painel.setLayout(null);
        painel.setBounds(375,100, 400,500);
        painel.add(titulo);
        painel.add(jogar);
        painel.add(jogar);
        painel.add(loja);
        painel.add(salvar);
        painel.add(sair);

        //Adiciona eventos nos botões
        jogar.addActionListener(this::jogar);
        loja.addActionListener(this::loja);
        salvar.addActionListener(this::salvar);
        sair.addActionListener(this::sair);

        menu.setVisible(true);
    }

    private void sair(ActionEvent actionEvent) {
        System.exit(0);
    }

    private void salvar(ActionEvent actionEvent) {
        try {
            FileWriter fw = new FileWriter("savePersonagem.txt");
            PrintWriter pw = new PrintWriter(fw);
            pw.println(MenuCriarHeroi.heroi.getNome());
            pw.println(MenuCriarHeroi.heroi.getClasse());
            pw.println(MenuCriarHeroi.heroi.getOuro());
            pw.println(MenuCriarHeroi.heroi.getVida());
            pw.println(MenuCriarHeroi.heroi.getQtdPocao());
            pw.println(MenuCriarHeroi.heroi.getArma().getNome());
            pw.println(MenuCriarHeroi.heroi.getArma().getDano());
            pw.flush();
            pw.close();
            fw.close();
            JOptionPane.showMessageDialog(null, "Progresso salvo no diretório do jogo como: savePersonagem.txt");

        } catch (IOException event) {
            throw new RuntimeException(event);
        }
    }


    private void loja(ActionEvent actionEvent) {
        if(MenuCriarHeroi.heroi.isVivo() == true){
            menu.setVisible(false);
            MenuPrincipal.nextPage();
            Loja loja =new Loja();
        }else{
            JOptionPane.showMessageDialog(null, "Personagem morto!");
        }
    }

    private void jogar(ActionEvent actionEvent) {
        if(MenuCriarHeroi.heroi.isVivo() == true) {
            menu.setVisible(false);
            MenuDungeon menuDungeon = new MenuDungeon();
            MenuPrincipal.nextPage();
            MenuPrincipal.parar();
        }else{
            JOptionPane.showMessageDialog(null, "Personagem morto!");
        }
    }
}
