
/**
 * SimpleCanvas.java
 *
 * Part of the basic graphics Template.
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class DotsCanvas extends JPanel
{
  	 Color myColor = Color.red;
  	 Graphics2D g2d;
     dotGame dotgame;
    public DotsCanvas(dotGame s)
	 {
  	dotgame = s;
		//The following is another way to guarantee correct size.
		setPreferredSize(new Dimension(1000,1000));
		setBackground(Color.lightGray);
    }

    public void paintComponent(Graphics g)
    {
		super.paintComponent(g);  //without this no background color set.
		g2d = (Graphics2D)g; //cast so we can use JAVA2D.

	 }






}
