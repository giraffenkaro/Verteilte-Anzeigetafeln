package Edit;

//import Scoreboard.ScoreboardGUI;

import Scoreboard.ScoreboardGUI;

import javax.swing.*;
import javax.swing.text.JTextComponent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA
 * User:   Yannick Neumann
 * Date:   13.08.2017
 * Time:   19:46
 */
public class EditListener implements ActionListener
{
    private JButton saveButton;
    private JButton cancelButton;
    private EditGUI editGUI;
    private JList<String> list1;
    private JTextArea textArea1;
    private int index;
    private DefaultListModel<String> defaultListModel1;
    private Boolean editTest = false;
    private String cancel;

   //TODO Klasse schreiben aus denen ich meine Daten für die JList und das Scoreboard beziehe

    public EditListener(JList<String> list1, JTextArea textArea1, DefaultListModel<String> defaultListModel1, JButton cancelButton, JButton saveButton)
    {
        this.list1 = list1;
        this.textArea1 = textArea1;
        this.defaultListModel1 = defaultListModel1;
        this.cancelButton = cancelButton;
        this.saveButton = saveButton;
    }

    public void actionPerformed(ActionEvent e)
    {
        JButton eSource = (JButton) e.getSource();

        switch (eSource.getActionCommand())
        {
            case "open":
                ScoreboardGUI scoreboardGUI = new ScoreboardGUI();
                scoreboardGUI.start();
                break;
            case "edit":
                editFunction();
                break;
            case "post":
                postToScoreboard();
                break;
            case "close":
                System.exit(0);
                break;
            case "save":
                saveTolist();
                break;
            case "cancel":
                returnToList();
                setTextAreaClear();
                setButtonVisibles();
                break;
            case "delete":
                deleteSelectIndex();
                break;
        }
    }

    public void editFunction()
    {
        String listValue;
        index = selectedIndex();

        if (index <= 0)
        {
            JOptionPane.showMessageDialog(null, "Kein Eintrag markiert.");
        }
        else
        {
            listValue = (String)list1.getSelectedValue();
            defaultListModel1.remove(index);
            textArea1.setText(listValue);
            cancel = textArea1.getText();
            editTest = true;
            cancelButton.setVisible(true);
            saveButton.setVisible(true);
        }
    }

    public void postToScoreboard()
    {
        String txtValue = textArea1.getText().trim();
        if (txtValue.equals("") )
        {
            JOptionPane.showMessageDialog(null,"Kein inhalt zum posten");
        }
        else
        {
            defaultListModel1.addElement(textArea1.getText());
            textArea1.setText("");
        }
    }

    private void saveTolist()
    {
        if(editTest == false)
        {
            defaultListModel1.addElement(textArea1.getText());
            textArea1.setText("");
        }
        else
        {
            defaultListModel1.add(index, textArea1.getText());
            textArea1.setText("");
            editTest = false;
        }
    }

    public void returnToList()
    {
        if(!cancel.equals(textArea1.getText()))
        {
            defaultListModel1.add(index, cancel);
        }
        else
        {
            defaultListModel1.add(index, textArea1.getText());
        }
    }

    public void deleteSelectIndex()
    {
        int deletIndex = selectedIndex();
        if (deletIndex >= 0)
        {
            int delete = JOptionPane.showConfirmDialog(null,"Möchten sie wirklich diesen eintrag löschen?","Löschen",JOptionPane.YES_NO_OPTION);
            if (delete == JOptionPane.YES_OPTION)
            {
                defaultListModel1.remove(deletIndex);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Kein eintrag ausgewählt zum löschen!");
        }
    }

    public void setTextAreaClear()
    {
        textArea1.setText("");
        editTest = false;
    }

    public int selectedIndex()
    {
        index = list1.getSelectedIndex();
        return index;
    }

    public void setButtonVisibles ()
    {
        cancelButton.setVisible(false);
        saveButton.setVisible(false);
    }

}
