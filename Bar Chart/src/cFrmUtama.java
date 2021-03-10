import java.awt.*;
import java.awt.image.BufferedImage; //Agar bisa memakai BufferedImage line 9
import java.io.File; //Pemanggilan File line 8
import java.io.IOException; //Untuk Try Catch Exceptions
import javax.imageio.ImageIO;
import javax.swing.*;
import java.lang.Math; //Untuk abs line 49

public class cFrmUtama extends javax.swing.JFrame {
    File f;
    BufferedImage Gambar;
    private JPanel panel1;

    public void HorizontalLine(int x1, int x2, int y, int Warna){
        for(int x=x1; x<x2; x++){
            Gambar.setRGB(x, y, Warna);
        }
    }
    public void VerticalLine(int x, int y1, int y2, int Warna){
        for(int y=y1; y<y2; y++){
            Gambar.setRGB(x, y, Warna);
        }
    }
    public void FilledRectangle (int x1, int x2, int y1, int y2, int Warna){
        for(int y=y1; y<y2; y++){
            for(int x=x1; x<x2; x++){
                Gambar.setRGB(x, y, Warna);
            }
        }
    }

    public cFrmUtama() {
        int x, y, Warna = 0x00FF00;

        initComponents();
        Gambar = new BufferedImage(1920, 1080, BufferedImage.TYPE_INT_RGB);
//        for (int i = 0; i < 1920; i++) {
//            for (int j = 0; j < 1080; j++) {
//                Gambar.setRGB(i, j, Color.WHITE.getRGB());
//            }
//        }
        HorizontalLine(200, 700, 500, 0x00ffff);
        VerticalLine(200, 100, 500, 0x00ffff);
        for(int i = 150; i < 500; i+=75) {
            HorizontalLine(175, 200, i, 0x00ffff);
        }
        for(int i = 250; i < 700; i+=75) {
            VerticalLine(i, 500, 525, 0x00ffff);
        }
        int YStartPos = 500, XStartPos = 200, D = 50, y1, y2, x1, x2, W = 20;
        int[] Sale = {80, 100, 70, 60, 40};
        y2 = YStartPos;
        x1 = XStartPos + D;
        for(int i = 0; i<Sale.length; i++){
            y1 = Sale[i];
            x2 = x1 + W;
            FilledRectangle(x1, x2, y1, y2, 0x00b334 );
            x1 +=D;
        }
    }
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 986, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 614, Short.MAX_VALUE)
        );

        pack();
    }

    public void paint(Graphics g){
        g.drawImage(Gambar, 0 ,30, this);
        this.setTitle("Bar Chart    ");
    }
}

