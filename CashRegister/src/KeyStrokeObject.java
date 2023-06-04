// import java.awt.*;
// import java.awt.event.*;

// import javax.imageio.ImageIO;
// import javax.swing.*;

// public class KeyStrokeObject implements KeyListener{

//  protected ImageIcon image;
//  protected final int WIDTH;
//  protected final int HEIGHT;
//  protected Point imageCorner;
//  protected Point prevPt;
//  protected int startX, startY;

//  public KeyStrokeObject(ImageIcon i, int sX, int sY){
  
//     image = i;
//     WIDTH = i.getIconWidth();
//     HEIGHT = i.getIconHeight();
//     startX = sX;
//     startY = sY;
//     this.addKeyListener(this);
//     setFocusable(true);
//     setFocusTraversalKeysEnabled(false);
//     imageCorner = new Point(sX,sY);
    
//    }
//    public void paintComponent(Graphics g) {
//     super.paintComponent(g);
//     image.paintIcon(this, g, (int)imageCorner.getX(), (int)imageCorner.getY());
//    }

//    public void left(){
//     imageCorner.translate(
     
//      (int)(-20),
//      0
//    );
//    repaint();
//    }
//    public void right(){
//     imageCorner.translate(
     
//      (int)(20),
//      0
//    );
//    repaint();
//    }

//    public void keyPressed(KeyEvent e){
//     int code = e.getKeyCode();
//     if(code == KeyEvent.VK_LEFT){
//         left();
//     }
//     if(code == KeyEvent.VK_RIGHT){
//         right();
//     }
//     }

//     public void keyTyped(KeyEvent e){
//     }
//     public void keyReleased(KeyEvent e){}
    

// }
