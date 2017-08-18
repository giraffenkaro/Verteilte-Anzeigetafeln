package Edit;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created with IntelliJ IDEA
 * User:   Yannick Neumann
 * Date:   13.08.2017
 * Time:   14:27
 */
public class EditGUI extends JFrame
{
    private JPanel editPanel;
    private JButton postButton;
    private JButton editButton;
    private JButton openButton;
    private JComboBox<String> comboBox1;
    private JList<String> list1;
    private JTextArea textArea1;
    private EditListener crtl;
    private JFrame editFrame = new JFrame("Edit Scoreboard");
    private JButton saveButton;
    private JButton closeButton;
    private JButton cancelButton;
    private JButton deleteButton;
    private GridBagConstraints gbc;
    private DefaultListModel<String> defaultListModel1;

    public EditGUI()
    {
        createPanel();
        addJLable();
        addScrollPaneList();
        addScrollPaneTextArea();
        addButtons();
        addCombobox();
        addListener();
    }

    public void createPanel ()
    {
        editPanel = new JPanel();
        editPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc;
    }

    public void addJLable ()
    {
        final JLabel scoreBoardNews = new JLabel();
        scoreBoardNews.setText("Nachrichten auf Anzeigetafel");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 0, 5, 0);
        editPanel.add(scoreBoardNews, gbc);

        final JLabel editPostLabel = new JLabel();
        editPostLabel.setText("Nachricht Post/Edit");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 0, 5, 0);
        editPanel.add(editPostLabel, gbc);
    }

    public void addScrollPaneList ()
    {
        JScrollPane scrollPane1 = new JScrollPane();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 5;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        editPanel.add(scrollPane1, gbc);

        //TODO in JTabble in einer spalte ändern um es zu editieren
        list1 = new JList<String>();
        defaultListModel1 = new DefaultListModel<>();
        defaultListModel1.addElement("test");
        defaultListModel1.addElement("test1");
        defaultListModel1.addElement("test2");
        defaultListModel1.addElement("test3");
        defaultListModel1.addElement("test4");
        defaultListModel1.addElement("test5");
        defaultListModel1.addElement("test6");
        defaultListModel1.addElement("test7");
        defaultListModel1.addElement("test8");
        defaultListModel1.addElement("test9");
        defaultListModel1.addElement("test10");
        defaultListModel1.addElement("test11");
        defaultListModel1.addElement("test12");
        defaultListModel1.addElement("test13");
        list1.setModel(defaultListModel1);
        list1.setSelectionMode(0);
        scrollPane1.setViewportView(list1);
    }

    public void addScrollPaneTextArea ()
    {
        JScrollPane scrollPane2 = new JScrollPane();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 5;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        editPanel.add(scrollPane2, gbc);

        textArea1 = new JTextArea();
        textArea1.setColumns(0);
        textArea1.setRows(3);
        textArea1.setWrapStyleWord(false);
        scrollPane2.setViewportView(textArea1);
    }


    public void addButtons ()
    {
        postButton = new JButton();
        postButton.setBackground(new Color(-9911320));
        postButton.setText("Post");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 10);
        editPanel.add(postButton, gbc);

        deleteButton = new JButton();
        deleteButton.setBackground(new Color(-9911320));
        deleteButton.setText("Delete");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 10);
        editPanel.add(deleteButton, gbc);

        editButton = new JButton();
        editButton.setBackground(new Color(-9911320));
        editButton.setText("Edit");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 10);
        editPanel.add(editButton, gbc);

        openButton = new JButton();
        openButton.setBackground(new Color(-9911320));
        openButton.setText("Open");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 10);
        editPanel.add(openButton, gbc);

        saveButton = new JButton();
        saveButton.setBackground(new Color(-9911320));
        saveButton.setText("Save");
        saveButton.setVisible(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 10);
        editPanel.add(saveButton, gbc);

        cancelButton = new JButton();
        cancelButton.setBackground(new Color(-9911320));
        cancelButton.setText("Cancel");
        cancelButton.setVisible(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 10);
        editPanel.add(cancelButton, gbc);

        closeButton = new JButton();
        closeButton.setBackground(new Color(-9911320));
        closeButton.setText("Close");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0);
        editPanel.add(closeButton, gbc);
    }

    public void addCombobox()
    {
        comboBox1 = new JComboBox<String>();
        comboBox1.setBackground(new Color(0x68C3E8));
        DefaultComboBoxModel<String> defaultComboBoxModel1 = new DefaultComboBoxModel<String>();
        defaultComboBoxModel1.addElement("ScoreBoard1");
        defaultComboBoxModel1.addElement("ScoreBoard2");
        defaultComboBoxModel1.addElement("ScoreBoard3");
        comboBox1.setModel(defaultComboBoxModel1);
        comboBox1.setOpaque(true);
        comboBox1.setToolTipText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0);
        editPanel.add(comboBox1, gbc);
    }

    public void addListener ()
    {
        openButton.setActionCommand("open");
        editButton.setActionCommand("edit");
        postButton.setActionCommand("post");
        comboBox1.setActionCommand("scoreboards");
        closeButton.setActionCommand("close");
        saveButton.setActionCommand("save");
        cancelButton.setActionCommand("cancel");
        deleteButton.setActionCommand("delete");
        crtl = new EditListener(list1, textArea1,defaultListModel1,cancelButton,saveButton);
        openButton.addActionListener(crtl);
        editButton.addActionListener(crtl);
        postButton.addActionListener(crtl);
        closeButton.addActionListener(crtl);
        saveButton.addActionListener(crtl);
        cancelButton.addActionListener(crtl);
        deleteButton.addActionListener(crtl);
        //TODO wahrscheinlich auslagern in andere klasse
        //comboBox1.addActionListener(crtl);
    }

    public void start ()
    {
        editFrame();
        setIcon();
    }

    public void editFrame()
    {
        editFrame.setContentPane(editPanel);
        //soll es vergrößerbar sein ?
        //frame.setResizable(false);
        editFrame.setVisible(true);
        editFrame.setSize(440, 380);
        editFrame.setLocation(800, 400);
        editFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        editFrame.setMinimumSize(editFrame.getSize());
        //dynamisches layout
       // Toolkit.getDefaultToolkit().setDynamicLayout(true);
    }

    public void setIcon()
    {
        try
        {
            File f = new File("view-process-own.png");
            String test = f.getAbsolutePath();
            BufferedImage b = ImageIO.read(f);
            editFrame.setIconImage(b);
        } catch (Exception e)
        {

        }
    }

    public void visible()
    {
        cancelButton.setVisible(true);
        saveButton.setVisible(true);
    }

}
