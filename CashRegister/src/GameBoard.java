import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.*;


public class GameBoard extends JFrame{

 private ShoppingArea dragPanel = new ShoppingArea( 100, 0);
   //private testKeys test2 = new testKeys(new ImageIcon("download.jpg"), 100, 100);
  //curently only know how to add one panel to a frame,
  //but you can switch off the panels

 
 public GameBoard(){
  
  this.add(dragPanel);
   //this.add(test2);
  this.setTitle("Cash Register");
  this.setSize(1000, 1000);
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.setVisible(true);
  
 }

}