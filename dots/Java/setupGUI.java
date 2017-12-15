import javax.swing.*;
import java.awt.event.*;
import java.util.*;

//class GUIbox creates the GUI and its pieces. It also contains the methods that each button calls.
public class setupGUI extends JDialog implements ActionListener {

        //initialize the panel and its pieces, and construct an arraylist for the buttons.

        JPanel panel;
        JLabel p1_lab;
        JLabel p2_lab;
        JLabel size_lab;
        JComboBox p1;
        JComboBox p2;
        JComboBox size;
        JButton play;


        public setupGUI()
        {
                //stops being able to resize the window.
                setModal(true);
                setResizable(false);
                setSize(300,200);
                setDefaultCloseOperation(HIDE_ON_CLOSE);

                panel = new JPanel();

                //Construct and set fields of objects on the jpanel.
                p1_lab = new JLabel("P1 Player Type");
                p1_lab.setBounds(25,15,100,20);

                p2_lab = new JLabel("P2 Player Type");
                p2_lab.setBounds(150,15,100,20);

                size_lab = new JLabel("Select Size");
                size_lab.setBounds(25,75,100,20);

                play = new JButton("PLAY!");
                play.setBounds(25, 125, 240, 40);
                play.addActionListener(this);

                String[] player_options = {"Human", "Computer"};
                String[] size_options = {"4x4", "5x5"};

                p1 = new JComboBox(player_options);
                p1.setBounds(25,40,100,20);
                p1.addActionListener(this);
                p2 = new JComboBox(player_options);
                p2.setBounds(150,40,100,20);
                p2.addActionListener(this);
                size = new JComboBox(size_options);
                size.setBounds(25,100,100,20);
                size.addActionListener(this);
                //add all objects to the panel, and the panel to the frame
                panel.setLayout(null);
                panel.add(p1_lab);
                panel.add(p2_lab);
                panel.add(size_lab);
                panel.add(p1);
                panel.add(p2);
                panel.add(size);
                panel.add(play);

                add(panel);
                setVisible(true);

        }

        public void actionPerformed(ActionEvent evt)
        {
          if(evt.getSource() == play)
          {
          }
        }

        public gameData returnData()
        {
            gameData gd = new gameData((String)p1.getSelectedItem(), (String)p2.getSelectedItem(), (String)size.getSelectedItem());
            return gd;
        }
    }
