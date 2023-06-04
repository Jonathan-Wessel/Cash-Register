import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ShoppingArea extends JPanel implements KeyListener{
 
 protected Images thisiImage;
 private Images cart = new Images(new ImageIcon("lib/Cart.png"),new Point(500,500));
 
 protected Point prevPt;
 protected int startX, startY;
 protected ArrayList<Images> listImages = new ArrayList<Images>();
 protected Cart myCart = new Cart();
 
 public ShoppingArea( int sX, int sY){
  for(int i = 0; i<5;i++){
    listImages.add(new Images(new ImageIcon("lib/banana.png"), new Point(sX*i,sY)));
  }
  for(int i = 0; i<5;i++){
    listImages.add(new Images(new ImageIcon("lib/banana.png"), new Point(sX*i,sY+300)));
  }
  startX = sX;
  startY = sY;
  
  ClickListener clickListener = new ClickListener();
  DragListener dragListener = new DragListener();
  this.addMouseListener(clickListener);
  this.addMouseMotionListener(dragListener);
  this.addKeyListener(this);
  setFocusable(true);
  setFocusTraversalKeysEnabled(false);
 }
 
 public void paintComponent(Graphics g) {
  super.paintComponent(g);
  ImageIcon background = new ImageIcon("lib/background.png");
  background.paintIcon(this, g, 0, 0);
  for(int i = 0; i<listImages.size();i++){
    Images s = listImages.get(i);
    s.getImageIcon().paintIcon(this, g, (int)s.getImageCorner().getX(), (int)s.getImageCorner().getY());
    
  }
  cart.getImageIcon().paintIcon(this, g, (int)cart.getImageCorner().getX(), (int)cart.getImageCorner().getY());

   
 }

 public int getmouseX(){
     return (int)prevPt.getX();
 }
 public int getmouseY(){
    return (int)prevPt.getY();
}
private Images hitTest(Point p){
  Images hitImage = null;
  for (int i = listImages.size()-1; i>=0; i--){
    Images s = listImages.get(i);
      if (p.getX()>s.getImageCorner().getX()&&(p.getX()<s.getImageCorner().getX()+s.getImageIcon().getIconWidth())&&(p.getY()>s.getImageCorner().getY()&&(p.getY()<s.getImageCorner().getY()+s.getImageIcon().getIconHeight()))){
          hitImage = s;
          listImages.remove(i);
          listImages.add(s);
          break;
      }
  }
  return hitImage;
}

private boolean hitCart(Point p){
  if (p.getX()>cart.getImageCorner().getX()&&(p.getX()<cart.getImageCorner().getX()+cart.getImageIcon().getIconWidth())&&(p.getY()>cart.getImageCorner().getY()&&(p.getY()<cart.getImageCorner().getY()+cart.getImageIcon().getIconHeight()))){
    return true;
  }
  return false;
}

public void left(){
  cart.getImageCorner().translate(
   
   (int)(-20),
   0
 );
 repaint();
 }
 public void right(){
  cart.getImageCorner().translate(
   
   (int)(20),
   0
 );
 repaint();
 }
 
 private class ClickListener extends MouseAdapter{
  
  public void mousePressed(MouseEvent e) {
   prevPt = e.getPoint();
   thisiImage = hitTest(e.getPoint());
  }
  public void mouseReleased(MouseEvent e) {
    if(hitCart(e.getPoint())&&thisiImage!=null){
      // for(int i = 0; i<listImages.size();i++){
      //   if(thisiImage.getImageCorner()==listImages.get(i).getImageCorner()){
      //     listImages.remove(i);
      //   }
      // }
      listImages.remove(thisiImage);
      myCart.addItem("banana");
      repaint();
    }
    thisiImage = null;
}
 }
 
 private class DragListener extends MouseMotionAdapter{
  
  public void mouseDragged(MouseEvent e) {
   Point currentPt = e.getPoint();
   if(thisiImage!= null){
   thisiImage.getImageCorner().translate(
     
     (int)(currentPt.getX() - prevPt.getX()),
     (int)(currentPt.getY() - prevPt.getY())
   );
   prevPt = currentPt;
   repaint(); 
   }  
  
}  
 }

@Override
public void keyTyped(KeyEvent e) {
  // TODO Auto-generated method stub
  
}

@Override
public void keyPressed(KeyEvent e) {
  int code = e.getKeyCode();
  if(code == KeyEvent.VK_LEFT){
      left();
  }
  if(code == KeyEvent.VK_RIGHT){
      right();
  }
}

@Override
public void keyReleased(KeyEvent e) {
  // TODO Auto-generated method stub
  
}
}