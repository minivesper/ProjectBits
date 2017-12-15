import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class dotGame {

    int size;
    int p1_type;
    int p2_type;
    DotsCanvas canvas;

    public dotGame(int p1_type_option, int p2_type_option, int size_option)
    {
      size = size_option;
      p1_type = p1_type_option;
      p1_type = p1_type_option;
      canvas = initCanvas(this);
    }

    public DotsCanvas initCanvas(dotGame d)
    {
      DotsCanvas myCanvas = new DotsCanvas(d);
      JFrame myFrame = new JFrame();
      myFrame.setTitle("Basic Draw");
      //Sets the window to close when upper right corner clicked.
      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      //Must use getContentPane() with JFrame.
      myFrame.add(myCanvas);
      myFrame.pack(); //resizes to preferred size for components.
      myFrame.setResizable(false  );
      myFrame.setVisible(true);
      return myCanvas;
    }
}
