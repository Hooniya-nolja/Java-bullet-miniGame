import java.awt.event.*;
import java.awt.*;

public class myCanvas extends Canvas implements Runnable{
  Thread th;
  Image buffer;
  Graphics bufferg;
  boolean waitFlag;

  DanmakuPrGame danmaku;
  public myCanvas(DanmakuPrGame danmaku){
    this.danmaku = danmaku;
    waitFlag = false;
    th = new Thread(this);

    addKeyListener(new MyKeyAdapter(danmaku));
  }
  public void start(){
    Dimension d = getSize();
    buffer = createImage(d.width, d.height);
    th.start();
  }
  public void run(){
    try{
      while(true){
        if(!waitFlag){
          repaint();
          danmaku.run();
        }
        th.sleep(50);
      }
    }catch(Exception e){}
  }

  public void update(Graphics g){
    paint(g);
  }
  public void paint(Graphics g){
    if(bufferg == null) bufferg = buffer.getGraphics();
    Dimension d = getSize();
    danmaku.draw(bufferg);
    g.drawImage(buffer, 0, 0, this);
  }
}

class MyKeyAdapter implements KeyListener{
  DanmakuPrGame danmaku;
  MyKeyAdapter(DanmakuPrGame danmaku){
    this.danmaku = danmaku;
  }
  public void keyPressed(KeyEvent e){
    danmaku.keyPressed(e);
  }
  public void keyReleased(KeyEvent e){
    danmaku.keyReleased(e);
  }
  public void keyTyped(KeyEvent e){
    danmaku.keyTyped(e);
  }
}
