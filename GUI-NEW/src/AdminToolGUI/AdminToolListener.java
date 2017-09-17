package AdminToolGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA
 * User:   Yannick Neumann
 * Date:   13.09.2017
 * Time:   17:35
 */
public class AdminToolListener implements ActionListener
{
    private JTextArea textArea;
    private JList listGroup;
    private JList listUser;

    public AdminToolListener(JTextArea textArea, JList listGroup, JList listUser)
    {
        this.textArea = textArea;
        this.listGroup = listGroup;
        this.listUser = listUser;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        JButton eSource = (JButton) e.getSource();

        switch (eSource.getActionCommand())
        {
            case "closeUG":
                System.exit(0);
                break;
            case "cancelS":

                break;
            case "changeG":

                break;
            case "changeU":

                break;
            case "close":
                System.exit(1);
                break;
            case "deleteG":
                deleteSelectIndex(2);
                break;
            case "deleteU":
                deleteSelectIndex(1);
                break;
            case "deleteS":

                break;
            case "edit":

                break;
            case "newG":
                EventQueue.invokeLater(new Runnable()
                {
                    public void run()
                    {
                        try
                        {
                            AdminGroupConfig adminGroupConfig = new AdminGroupConfig();
                            adminGroupConfig.start();
                        } catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                });
                System.out.println("TEST");
                break;
            case "newU":
                EventQueue.invokeLater(new Runnable()
                {
                    public void run()
                    {
                        try
                        {
                            AdminUserConfig adminUserConfig = new AdminUserConfig();
                            adminUserConfig.start();
                        } catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                });
                break;
            case "open":

                break;
            case "post":

                break;
            case "save":

                break;
        }
    }

    public void deleteSelectIndex(int i)
    {
        int selectList = i;
        int deletIndex = selectedIndex(selectList);
        if (deletIndex >= 0)
        {
            int delete = JOptionPane.showConfirmDialog(null,"Möchten sie wirklich diesen eintrag löschen?","Löschen",JOptionPane.YES_NO_OPTION);
            if (delete == JOptionPane.YES_OPTION && i == 1)
            {
                listUser.remove(deletIndex);
            }
            else if(delete == JOptionPane.YES_OPTION && i == 2)
            {
                listGroup.remove(deletIndex);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Kein eintrag ausgewählt zum löschen!");
        }
    }

    public int selectedIndex(int i)
    {
        int index = -1;
        if(i == 1)
        {
            index = listUser.getSelectedIndex();
        }
        else if(i == 2)
        {
            index = listGroup.getSelectedIndex();
        }
        return index;
    }

}
