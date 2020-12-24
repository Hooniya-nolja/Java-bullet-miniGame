import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;

public class DanmakuPrGame{
  int timeInc = 0;

  Hero hero;
  Ball ball;
  XBall xball;

  public int xSize = 640, ySize = 480;
  public int speed = 12;

  Applet myApplet;
  myCanvas canvas;

  public void init (Applet myApplet, myCanvas canvas) {
    this.myApplet = myApplet;
    this.canvas = canvas;

    timeInc = 0;
    hero = new Hero(xSize, ySize);
    ball = new Ball();
    xball = new XBall();

    hero.image = myApplet.getImage(myApplet.getCodeBase(), "./image/hero.jpg");
    ball.image = myApplet.getImage(myApplet.getCodeBase(), "./image/ball.jpg");
    xball.image = myApplet.getImage(myApplet.getCodeBase(), "./image/ball.jpg");
  }

  public void run() {
    if (hero.health == 0) {
      init(myApplet, canvas);
    }
    timeInc++;
    if (timeInc == 3) {
      ball.newball(xSize, timeInc);
      xball.newball(xSize, timeInc);
      timeInc = 0;
    }
    ball.move(xSize, ySize, speed);
    xball.move(xSize, ySize, speed);
    collisions();
  }

  public void collisions(){
        for (int a = 0; a < ball.num; a++){
          if (ball.Open[a] == 1){
            if (ball.Y[a] > hero.Y[0] & ball.Y[a] < hero.Y[0] + 32){
              if (ball.X[a] > hero.X[0] & ball.X[a] < hero.X[0] + 32){
                ball.Open[a] = 0;
                hero.health -= 1;
              }
            }
          }
          if (xball.Open[a] == 1){
            if (xball.Y[a] > hero.Y[0] & xball.Y[a] < hero.Y[0] + 32){
              if (xball.X[a] > hero.X[0] & xball.X[a] < hero.X[0] + 32){
                xball.Open[a] = 0;
                hero.health -= 1;
              }
            }
          }
        }
  }

  public void draw(Graphics g){
    Dimension d = canvas.getSize();
    g.setColor(Color.black);
    g.fillRect(0, 0, d.width, d.height);
    ball.draw(g, canvas);
    hero.draw(g, canvas);
    xball.draw(g, canvas);
  }

  public void keyPressed (KeyEvent e) {
    int keycode = e.getKeyCode();
    switch(keycode){
      case KeyEvent.VK_UP	:hero.Y[0] -= 3; break;
      case KeyEvent.VK_DOWN	:hero.Y[0] += 3; break;
      case KeyEvent.VK_LEFT	:hero.X[0] -= 3; break;
      case KeyEvent.VK_RIGHT	:hero.X[0] += 3; break;
    }
  }
  public void keyReleased (KeyEvent e) {}
  public void keyTyped (KeyEvent e) {}

}


