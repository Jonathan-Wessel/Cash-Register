import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Cart extends JFrame{
    private ArrayList<String> cart = new ArrayList<String>();
    private int total;
    private int count = 0;
    private ArrayList<JLabel> labels = new ArrayList<JLabel>();
    public Cart(){
        total = 0;
        for(int i = 0; i<9;i++){
            JLabel t = new JLabel();
            t.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
            t.setFont(new java.awt.Font("Arial", 50, 50));
            labels.add(t);
            this.add(t);
        }
        this.setTitle("Cart");
        this.setSize(300, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        this.setVisible(true);
    }

    public void addItem(String item){
        cart.add(item);
        if(item.equals("banana")){
            total+=10;
        }
        
        for(int i = 0; i<labels.size();i++){
            labels.get(i).setText(item);
        }
        
    }
}
