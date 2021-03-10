import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class cFrmUtama extends JFrame {
    BufferedImage gambar;
    int top, bot, left, right, margin = 50;
    int sale[]={8, 10, 7, 6, 4}, max, distanceX, distanceY, i;
    int height[]= new int[sale.length];

    int findMaxSales(){
        int result, i;
        result = sale[0];
        for (i=0; i< sale.length; i++){
            if (result < sale[i]){
                result = sale[i];
            }
        }
        return result;
    }
    private void StraightLine (int x1, int x2, int y1, int y2, int warna){
        int dx, dy, xLength, yLength, Count, i;
        double x, y, rx, ry;

        x=x1; y=y1;
        dx = x2-x1;
        dy = y2-y1;
        xLength = Math.abs(dx);
        yLength = Math.abs(dy);

        if(xLength>yLength){
            rx = 1;
            ry = Math.abs(yLength * 1.0/xLength);
            Count = xLength;
        }
        else{
            rx=Math.abs(xLength * 1.0/yLength);
            ry = 1;
            Count = yLength;
        }
        if (dx<0){
            rx = -rx;
        }
        if (dy<0){
            ry = -ry;
        }

        for(i = 0; i < Count; i++){
            gambar.setRGB((int)x, (int)y, warna);
            x += rx;
            y += ry;
        }
    }

    public cFrmUtama(){
        int location;
        initComponents();
        gambar = new BufferedImage(1920, 1080, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < 1920; i++) {
            for (int j = 0; j < 1080; j++) {
                gambar.setRGB(i, j, Color.WHITE.getRGB());
            }
        }
        top = 50; left = 50;
        right = gambar.getWidth() - margin;
        bot = gambar.getHeight() - margin;
        StraightLine(left, left, top, bot, 0x00ffff);
        StraightLine(left, right, bot, bot, 0x00ffff);

        max = findMaxSales();
        distanceX = (int) ((right - left)/sale.length);
        distanceY = (int) ((bot - top)*1.0/max);

        //garis kecil di skala sumbu X
        for (i = 0; i < sale.length; i++){
            location = left + (i+1) * distanceX;
            StraightLine(location, location, bot, bot+5, 0x00ffff);
        }

        //garis kecil di skala sumbu Y
        for (i = 0; i < max; i++){
            location = bot - (i+1) * distanceY;
            StraightLine(left - 5, left, location, location, 0x00ffff);
        }

        //garis chart dibentuk
        for (i = 0; i <sale.length; i++){
            location = left + (i+1) * distanceX;
            height[i] = bot - sale[i] * distanceY;
            StraightLine(location, location,  height[i], bot, 0x00ffff);
        }

        //garis penghubung antar chart
        for (i = 1; i < sale.length; i++){
            location = left + i * distanceX;
            StraightLine(location, location+distanceX, height[i-1], height[i], 0x00ffff);
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
        g.drawImage(gambar, 0 ,30, this);
        this.setTitle("Line Chart");
    }
}
