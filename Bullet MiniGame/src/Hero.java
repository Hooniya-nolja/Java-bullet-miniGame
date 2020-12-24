import java.awt.*;

public class Hero extends Item{
  public int health;
//  boolean shiftFlag;
  Image image;

  Hero(int xSize, int ySize){
    super(1);
    health = 3;
    X[0] = (xSize / 2) - 17;
    Y[0] = ySize / 2;
  }

  void move(int xSize, int ySize, int speed){}

  void draw(Graphics g, myCanvas canvas){
    Dimension d = canvas.getSize();
    g.drawImage(image, X[0], Y[0], canvas);
    g.setColor(Color.white);
    g.drawString("life = " + health, d.width - 80, 20);
  }
}

