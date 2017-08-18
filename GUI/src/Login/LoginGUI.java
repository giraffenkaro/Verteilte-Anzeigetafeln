package Login;

import Edit.EditGUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created with IntelliJ IDEA
 * User:   Yannick Neumann
 * Date:   11.08.2017
 * Time:   10:55
 */
public class LoginGUI extends JFrame
{
    private JPanel mainPanel;
    private JTextField txtUserID;
    private JPasswordField txtUserPW;
    private JButton loginButton;
    private JButton cancelButton;
    private JFrame frame = new JFrame("Login");
    private GridBagConstraints gbc;

    public LoginGUI()
    {
        createPanel();
        addUserID();
        addUserPW();
        addJLable();
        addLoginBtn();
        addCancelBtn();
        addLisener();
    }

    public void addUserID()
    {
        txtUserID = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(txtUserID, gbc);
    }

    public void createPanel()
    {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
    }

    public void addUserPW ()
    {
        txtUserPW = new JPasswordField();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(txtUserPW, gbc);
    }

    public  void addJLable ()
    {
        final JLabel label1 = new JLabel();
        label1.setText("UserID");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 0, 10);
        mainPanel.add(label1, gbc);

        final JLabel label2 = new JLabel();
        label2.setText("Password");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 0, 10);
        mainPanel.add(label2, gbc);
    }

    public void addLoginBtn ()
    {
        loginButton = new JButton();
        loginButton.setBackground(new Color(-9911320));
        loginButton.setText("Login");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 0, 10);
        mainPanel.add(loginButton, gbc);

    }

    public void addCancelBtn ()
    {
        cancelButton = new JButton();
        cancelButton.setBackground(new Color(-9911320));
        cancelButton.setText("Cancel");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 2;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(cancelButton, gbc);
    }

    //TODO in klasse auslagern
    public void addLisener ()
    {
        loginButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                EditGUI test = new EditGUI();
                test.start();
                setFrameClear();
                System.out.println("test");
            }
        });
        cancelButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int question = JOptionPane.showConfirmDialog(null, "Programm beenden?", "Cancel", JOptionPane.YES_NO_OPTION);

                if(question == JOptionPane.YES_OPTION)
                {
                    System.exit(0);
                }
            }
        });

//        loginButton.setActionCommand("login");
//        cancelButton.setActionCommand("cancel");
//
//        loginButton.addActionListener(new LoginListener());
//        cancelButton.addActionListener(new LoginListener());
    }

    public void setFrameClear()
    {
        frame.dispose();
    }

    public void setVisibleFrame()
    {
        frame.setVisible(false);
    }

    public void setFrame()
    {
        frame.setContentPane(mainPanel);
        frame.setVisible(true);
        frame.setSize(250, 150);
        frame.setResizable(false);
        frame.setLocation(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setIcon()
    {
        try
        {
            File f = new File("emblem-readonly.png");
            String test = f.getAbsolutePath();
            BufferedImage b = ImageIO.read(f);
            frame.setIconImage(b);
        } catch (Exception e)
        {

        }
    }

}
