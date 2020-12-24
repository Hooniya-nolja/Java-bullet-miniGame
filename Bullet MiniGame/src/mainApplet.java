import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class mainApplet extends Applet implements ActionListener{
  myCanvas canvas;
  DanmakuPrGame danmaku;
  Button b[];
  public void init(){
    setLayout(null);
    setBackground(Color.lightGray);

    danmaku = new DanmakuPrGame();
    canvas = new myCanvas(danmaku);
    canvas.setBounds(0, 0, danmaku.xSize, danmaku.ySize);
    add(canvas);
    danmaku.init(this, canvas);

    b = new Button[3];
    b[0] = new Button("start");
    b[1] = new Button("stop");
    b[2] = new Button("init");

    for(int i=0; i < 3; i++){
      b[i].addActionListener(this);
      b[i].setBounds(650+i*40, 120, 40, 20);
      b[i].addActionListener(this);
      add(b[i]);
    }
    canvas.start();
  }

  public void actionPerformed(ActionEvent e){
    if (e.getSource() == b[0]){
      canvas.waitFlag = false;
    }else if (e.getSource() == b[1]){
      canvas.waitFlag = true;
    }else if (e.getSource() == b[2]){
      danmaku.init(this, canvas);
    }
  }
}

