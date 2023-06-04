import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class Images{
    private Point imageCorner;
    private ImageIcon image;
    public Images(ImageIcon i, Point s){
        image = i;
        imageCorner = s;
    }
    public Point getImageCorner(){
        return imageCorner;
    }
    public ImageIcon getImageIcon(){
        return image;
    }
}
