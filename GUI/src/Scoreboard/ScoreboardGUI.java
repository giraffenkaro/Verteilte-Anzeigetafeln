package Scoreboard;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created with IntelliJ IDEA
 * User:   Yannick Neumann
 * Date:   13.08.2017
 * Time:   14:28
 */
public class ScoreboardGUI extends JFrame
{
    private JPanel scoreboardPanel;
    private JTable table1;
    private JFrame frame = new JFrame("Scoreboard");

    public ScoreboardGUI ()
    {
        scoreboardPanel = new JPanel();
        scoreboardPanel.setLayout(new GridBagLayout());
        int i = 0;
        String[] tttest = new String[100000];
        while (i<10)
        {
            JLabel _lbl = new JLabel("Testtttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt" + i);
            GridBagConstraints gbc;
            gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = i;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(10, 0, 10, 0);
            scoreboardPanel.add(_lbl, gbc);

            String test2 = _lbl.getText();
            tttest[i] = test2;
//            scoreboardPanel.revalidate();
//            scoreboardPanel.repaint();
//            frame.pack();

            i++;
        }

        int e = 0;
        String[] ttttest = new String[100000];
        while (e<10)
        {
            JLabel _lbl = new JLabel("user" + e);
            GridBagConstraints gbc;
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = e;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(10, 0, 10, 10);
            scoreboardPanel.add(_lbl, gbc);

            String test2 = _lbl.getText();
            ttttest[e] = test2;
//            scoreboardPanel.revalidate();
//            scoreboardPanel.repaint();
//            frame.pack();

            e++;
        }
        //scoreboad();
    }

    public void scoreboard()
    {
        int i = 0;
        String[] tttest = new String[100000];
        while (i<10)
        {
            JLabel _lbl = new JLabel("Test" + i);
            GridBagConstraints gbc;
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = i;
            gbc.fill = GridBagConstraints.BOTH;
            scoreboardPanel.add(_lbl, gbc);
            i++;

            String test2 = _lbl.getText();
            tttest[i] = test2;
            scoreboardPanel.revalidate();
            scoreboardPanel.repaint();
            frame.pack();

            i++;
        }
    }

    public void start ()
    {
        //TODO siehe Swing2 Test wie ich dynamisch JLabels adde
        scoreboad();

    }

    public void scoreboad()
    {
        frame.setContentPane(scoreboardPanel);
        //frame.setResizable(false);
        frame.setVisible(true);
        frame.setSize(800, 900);
        frame.setLocation(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void setIcon()
    {
        try
        {
            File f = new File("view-process-system.png");
            String test = f.getAbsolutePath();
            BufferedImage b = ImageIO.read(f);
            frame.setIconImage(b);
        } catch (Exception e)
        {

        }
    }

}
