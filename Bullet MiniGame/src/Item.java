import java.awt.*;

abstract class Item{
  int X[];
  int Y[];
  int num;
  Item(int num){
    this.num = num;
    X = new int[num];
    Y = new int[num];
  }
  abstract void move(int xSize, int ySize, int speed);
  abstract void draw(Graphics g, myCanvas canvas);
}
