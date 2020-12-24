import java.awt.*;

public class Ball extends Item{
  Image image;
  public int Speed[];
  public int Open[];
  public int Slope[];
  int randomSeed;
  int randomTime;

  Ball(){
    super(100);

    Speed = new int[num];
    Open = new int[num];
    Slope = new int[num];

    randomSeed = 50;
    randomTime = (int) (((Math.random() * randomSeed) + 1) + 50);
  }

  public void newball(int xSize, int timeInc) {
    int r = 0;
    for (int a = 0; a < num; a++) {
      if (r == 0 & Open[a] == 0) {
        Open[a] = 1;
        r = 1;
        Speed[a] = (int) ((Math.random() * 5) + 1);
        Slope[a] = (int) (((Math.random() * 3) + 1) - 1);
        int t = (int) ((Math.random() * 2) + 1);
        if (t == 1) Slope[a] = -(Slope[a]);

        X[a] = (int) ((Math.random() * (xSize - 32)) + 1);
        if (a % 2 == 0) Y[a] = 0;
	else Y[a] = 480;
        randomTime = (int) (((Math.random() * randomSeed) + 1) + 50);
      }
    }
  }

  public void move (int xSize, int ySize, int speed){
    for (int i = 0; i < num; i++) {
      if (X[i] + Slope[i] < 0) Slope[i] *= -1;
      if (X[i] + Slope[i] > xSize - 32) Slope[i] *= -1;
      X[i] += Slope[i];
      int a = (int) ((Math.random() * 150) + 1);
      if (a == 3) Slope[i] *=-1;
      if (a == 5 & Math.abs(Slope[i]) < 8) Slope[i] *= -2;
      if (a == 6 & Math.abs(Slope[i]) > 0) Slope[i] /= -2;
      if (Open[i] > 0) {
        if (Y[i] > ySize || Y[i] < 0) Open[i] = 0;
        else if (i % 2 == 0) Y[i] += Speed[i] + (speed - 6);
        else Y[i] -= Speed[i] + (speed - 6);
      }
    }
  }

  public void draw(Graphics g, myCanvas canvas){
    for (int i = 0; i < num; i++) {
      g.drawImage(image, X[i], Y[i], canvas);
    }
  }

}


