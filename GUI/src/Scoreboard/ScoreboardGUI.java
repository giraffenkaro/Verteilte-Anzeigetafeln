package Scoreboard;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
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
    private List<JLabel> labelTest = new ArrayList<JLabel>();
    private List<JLabel> labelAdmin = new ArrayList<JLabel>();
    private List<JTextArea> textAreas = new ArrayList<JTextArea>();
    private GridBagConstraints gbc;
    private JPanel mainScoreboardPanel;

    public ScoreboardGUI ()
    {
        setPanels();
        setLabelUser(100);
        setLabelAdmin(100);
        setTextArea(100);
//        scoreboardPanel.revalidate();
//        scoreboardPanel.repaint();
        //frame.pack();
        //deleteLabel(10);
    }

    public void setPanels()
    {
        scoreboardPanel = new JPanel();
        scoreboardPanel.setLayout(new BorderLayout());
        JLabel lblAnzeigetafel = new JLabel("AnzeigeTafel");
        lblAnzeigetafel.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblAnzeigetafel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreboardPanel.add(lblAnzeigetafel, BorderLayout.NORTH);

        JScrollPane mainScrollPane = new JScrollPane();
        mainScoreboardPanel = new JPanel();
        scoreboardPanel.add(mainScrollPane, BorderLayout.CENTER);
        mainScrollPane.setViewportView(mainScoreboardPanel);

        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
        gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
        mainScoreboardPanel.setLayout(gbl_panel);
    }

    public void setLabelUser( int anzahl ){
        int i = 1;
        // Hinzufügen falls notwendig
        while( anzahl > labelTest.size() ){
            JLabel userName = new JLabel();
            userName.setText( "User " + (labelTest.size()+1) );
            gbc = new GridBagConstraints();
            gbc.insets = new Insets(0, 10, 5, 10);
            gbc.gridx = 1;
            gbc.gridy = i;
            labelTest.add(userName);
            mainScoreboardPanel.add(userName, gbc);
            i++;
            i++;
        }
    }

    public void setLabelAdmin(int anzahl)
    {
        int i = 2;
        // Hinzufügen falls notwendig
        while( anzahl > labelAdmin.size() ){
            JLabel adminChange = new JLabel();
            adminChange.setText( "Admin " + (labelAdmin.size()+1) );
            gbc = new GridBagConstraints();
            gbc.insets = new Insets(0, 10, 5, 10);
            gbc.gridx = 1;
            gbc.gridy = i;
            labelAdmin.add(adminChange);
            mainScoreboardPanel.add(adminChange, gbc);
            i++;
            i++;
        }
    }

    public void setTextArea( int anzahl ){
        int i = 1;
        // Hinzufügen falls notwendig
        while( anzahl > textAreas.size() ){
            JTextArea Test = new JTextArea();
            //Test.setEditable(false);
            gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 0, 10, 20);
            gbc.fill = GridBagConstraints.BOTH;
            gbc.gridx = 2;
            gbc.gridy = i;
            textAreas.add(Test);
            mainScoreboardPanel.add(Test, gbc);
            i++;
            i++;
        }
    }

    public void deleteLabel (int anzahl)
    {
        // Entfernen falls notwendig
        while( anzahl < labelTest.size() ){
            int index = labelTest.size()-1;
            JLabel button = labelTest.get( index );
            labelTest.remove( index );
            remove( button );
        }
    }

    public void start ()
    {
        //TODO siehe Swing2 Test wie ich dynamisch JLabels adde
        scoreboad();
        setIcon();

    }

    public void scoreboad()
    {
        frame.setContentPane(scoreboardPanel);
        //frame.setResizable(false);
        frame.setVisible(true);
        frame.setSize(800, 900);
        frame.setLocation(800, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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
