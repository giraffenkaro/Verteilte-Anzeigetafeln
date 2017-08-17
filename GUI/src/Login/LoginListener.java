package Login;

import Edit.EditGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA
 * User:   Yannick Neumann
 * Date:   11.08.2017
 * Time:   14:42
 */
public class LoginListener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        JButton eSource = (JButton) e.getSource();

        if (eSource.getActionCommand().equals("login"))
        {
            EditGUI test = new EditGUI();
            test.start();
        }
        if (eSource.getActionCommand().equals("cancel"))
        {
            int question = JOptionPane.showConfirmDialog(null, "Programm beenden?", "Cancel", JOptionPane.YES_NO_OPTION);

            if(question == JOptionPane.YES_OPTION)
            {
                System.exit(0);
            }
        }
        if (eSource.getActionCommand().equals("login"))
        {


        }
    }
}
