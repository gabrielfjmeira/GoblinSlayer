package Classes;

import javax.swing.*;
import java.awt.*;

public class BackgroundImage extends JPanel {
    private Image imagem;

    public BackgroundImage(String path){
        imagem = new ImageIcon(path).getImage();
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imagem,0,0,getWidth(),getHeight(),this);
    }

}
