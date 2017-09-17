package AdminToolGUI;

/**
 * Created with IntelliJ IDEA
 * User:   Yannick Neumann
 * Date:   13.09.2017
 * Time:   17:36
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminGroupConfig extends JFrame {

    private JPanel contentPane;
    private JTextField txtGroupName;
    private JTextField txtGroupModerator;
    private JFrame adminGroupFrame = new JFrame("Group Config");
    private JPanel panelMain;
    private JPanel panelButtons;
    private GridBagConstraints gbc;
    private JButton btnSave;
    private JButton btnCancel;
    private JList<String> list;
    private DefaultListModel<String> defaultListModel1;

    public AdminGroupConfig()
    {
        setPanels();
        setLabels();
        setButtons();
        setInput();
        setList();
        addListener();
    }

    public void closeEdit ()
    {
        adminGroupFrame.dispose();
    }

    public void setFrame ()
    {
        adminGroupFrame.setContentPane(contentPane);
        adminGroupFrame.setVisible(true);
        adminGroupFrame.setSize(310,450);
        adminGroupFrame.setResizable(false);
        adminGroupFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public void start ()
    {
        setFrame();
    }

    public void addListener ()
    {
        btnCancel.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                closeEdit();
            }
        });

        btnSave.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
    }

    public void setList ()
    {
        JScrollPane scrollPane = new JScrollPane();
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 5;
        panelMain.add(scrollPane, gbc);

        list = new JList<String>();
        defaultListModel1 = new DefaultListModel<>();
        defaultListModel1.addElement("test");
        defaultListModel1.addElement("test1");
        defaultListModel1.addElement("test21111111111111111111111111111111111111111111");
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
        list.setModel(defaultListModel1);
        list.setSelectionMode(0);
        scrollPane.setViewportView(list);
    }

    public void setPanels ()
    {
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));

        panelMain = new JPanel();
        contentPane.add(panelMain, BorderLayout.CENTER);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{0, 0, 0};
        gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panelMain.setLayout(gbl_panel);

        panelButtons = new JPanel();
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 6;
        panelMain.add(panelButtons, gbc);
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[]{0, 0, 0};
        gbl_panel_1.rowHeights = new int[]{0, 0};
        gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        panelButtons.setLayout(gbl_panel_1);
    }

    public void setButtons ()
    {
        btnSave = new JButton("Save");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelButtons.add(btnSave, gbc);

        btnCancel = new JButton("Cancel");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 10, 10);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panelButtons.add(btnCancel, gbc);
    }

    public void setInput ()
    {
        txtGroupName = new JTextField();
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelMain.add(txtGroupName, gbc);
        txtGroupName.setColumns(10);

        txtGroupModerator = new JTextField();
        txtGroupModerator.setColumns(10);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 3;
        panelMain.add(txtGroupModerator, gbc);
    }

    public void setLabels ()
    {
        JLabel lblName = new JLabel("Name:");
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panelMain.add(lblName, gbc);

        JLabel lblModerator = new JLabel("Moderator:");
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 10, 10, 10);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panelMain.add(lblModerator, gbc);

        JLabel lblMembers = new JLabel("Members:");
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 10, 10, 0);
        gbc.gridx = 1;
        gbc.gridy = 4;
        panelMain.add(lblMembers, gbc);
    }
}

