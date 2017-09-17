package AdminToolGUI;
/**
 * Created with IntelliJ IDEA
 * User:   Yannick Neumann
 * Date:   13.09.2017
 * Time:   17:35
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

public class AdminTool extends JFrame
{
    private JPanel contentPane;
    private JTable table;
    private JPanel buttonPanelSCC;
    private JPanel tappedPanelSB;
    private JPanel buttonPanelNCD1;
    private JPanel tappedPanelUG;
    private JPanel buttonPanelEDPO;
    private JPanel buttonPanelNCD2;
    private GridBagConstraints gbc;
    private JFrame adminFrame = new JFrame("Admin Tool");
    private JButton btnClose;
    private JButton btnNewButton_U;
    private JButton btnChangeButton_U;
    private JButton btnDeleteButton_U;
    private JButton btnNewButton_G;
    private JButton btnChangeButoon_G;
    private JButton btnDeleteButton_G;
    private JButton btnCloseButtonUG;
    private JButton btnEditButton;
    private JButton btnDeleteButtonScoreboard;
    private JButton btnPostButton;
    private JButton btnOpenButton;
    private JButton btnSaveButton;
    private JButton btnCancelButtonScoreboard;
    private AdminToolListener crtl;
    private JTextArea textArea;
    private JList<String> listGroup;
    private JList<String> listUser;
    private DefaultListModel<String> defaultListModel1;

    public static void main(String[] args) {

        AdminTool adminTool = new AdminTool();
        adminTool.start();
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    AdminTool frame = new AdminTool();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
    }

    public void setFrame ()
    {
        adminFrame.setContentPane(contentPane);
        adminFrame.setVisible(true);
        adminFrame.setSize(800,800);
        adminFrame.setResizable(false);
        adminFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void start ()
    {
        setFrame();
    }

    public AdminTool()
    {
        setPanels();
        setButtonsAdmin();
        setComboBox();
        setLabelsAdmin();
        setTextArea();
        setTableView();
        setList();
        addListener();
    }

    public void addListener()
    {
        btnCloseButtonUG.setActionCommand("closeUG");
        btnCancelButtonScoreboard.setActionCommand("cancelS");
        btnChangeButoon_G.setActionCommand("changeG");
        btnChangeButton_U.setActionCommand("changeU");
        btnClose.setActionCommand("close");
        btnDeleteButton_G.setActionCommand("deleteG");
        btnDeleteButton_U.setActionCommand("deleteU");
        btnDeleteButtonScoreboard.setActionCommand("deleteS");
        btnEditButton.setActionCommand("edit");
        btnNewButton_G.setActionCommand("newG");
        btnNewButton_U.setActionCommand("newU");
        btnOpenButton.setActionCommand("open");
        btnPostButton.setActionCommand("post");
        btnSaveButton.setActionCommand("save");
        crtl = new AdminToolListener(textArea, listGroup, listUser);
        btnCloseButtonUG.addActionListener(crtl);
        btnCancelButtonScoreboard.addActionListener(crtl);
        btnChangeButoon_G.addActionListener(crtl);
        btnChangeButton_U.addActionListener(crtl);
        btnClose.addActionListener(crtl);
        btnDeleteButton_G.addActionListener(crtl);
        btnDeleteButton_U.addActionListener(crtl);
        btnDeleteButtonScoreboard.addActionListener(crtl);
        btnEditButton.addActionListener(crtl);
        btnNewButton_G.addActionListener(crtl);
        btnNewButton_U.addActionListener(crtl);
        btnOpenButton.addActionListener(crtl);
        btnPostButton.addActionListener(crtl);
        btnSaveButton.addActionListener(crtl);
    }

    public void setList()
    {
        JScrollPane scrollPane = new JScrollPane();
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 10, 0, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 1;
        tappedPanelUG.add(scrollPane, gbc);

        listUser = new JList<String>();
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
        listUser.setModel(defaultListModel1);
        listUser.setSelectionMode(0);
        scrollPane.setViewportView(listUser);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        gbc.insets = new Insets(0, 0, 0, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 3;
        gbc.gridy = 1;
        tappedPanelUG.add(scrollPane_1, gbc);

        listGroup = new JList();
        defaultListModel1 = new DefaultListModel<>();
        defaultListModel1.addElement("test");
        defaultListModel1.addElement("test1");
        defaultListModel1.addElement("test2");
        defaultListModel1.addElement("test21111111111111111111111111111111111111111111111111111");
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
        listGroup.setModel(defaultListModel1);
        listGroup.setSelectionMode(0);
        scrollPane_1.setViewportView(listGroup);
    }

    public void setComboBox()
    {
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"Scorevoard1", "Scorevoard2", "Scorevoard3", "Scorevoard4", "Scorevoard5"}));
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 10);
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridwidth = 2;
        gbc.gridx = 4;
        gbc.gridy = 0;
        buttonPanelEDPO.add(comboBox, gbc);
    }

    public void setPanels()
    {
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        contentPane.add(tabbedPane, BorderLayout.CENTER);
        
        tappedPanelUG = new JPanel();
        tabbedPane.addTab("Administration", null, tappedPanelUG, null);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
        gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
        gbl_panel.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
        tappedPanelUG.setLayout(gbl_panel);
        
        buttonPanelNCD1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 1;
        tappedPanelUG.add(buttonPanelNCD1, gbc);
        GridBagLayout gbl_panel_2 = new GridBagLayout();
        gbl_panel_2.columnWidths = new int[]{0, 0};
        gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0};
        gbl_panel_2.columnWeights = new double[]{0.0, Double.MIN_VALUE};
        gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        buttonPanelNCD1.setLayout(gbl_panel_2);

        buttonPanelNCD2 = new JPanel();
        gbc.insets = new Insets(0, 0, 0, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 4;
        gbc.gridy = 1;
        tappedPanelUG.add(buttonPanelNCD2, gbc);
        GridBagLayout gbl_panel_3 = new GridBagLayout();
        gbl_panel_3.columnWidths = new int[]{0, 0};
        gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0};
        gbl_panel_3.columnWeights = new double[]{0.0, Double.MIN_VALUE};
        gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        buttonPanelNCD2.setLayout(gbl_panel_3);

        tappedPanelSB = new JPanel();
        tabbedPane.addTab("Scoreboards", null, tappedPanelSB, null);
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[]{0, 0};
        gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
        gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
        tappedPanelSB.setLayout(gbl_panel_1);

        buttonPanelEDPO = new JPanel();
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(0, 0, 5, 0);
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        tappedPanelSB.add(buttonPanelEDPO, gbc);
        GridBagLayout gbl_panel_4 = new GridBagLayout();
        gbl_panel_4.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
        gbl_panel_4.rowHeights = new int[]{23, 0};
        gbl_panel_4.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panel_4.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        buttonPanelEDPO.setLayout(gbl_panel_4);

        buttonPanelSCC = new JPanel();
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 4;
        tappedPanelSB.add(buttonPanelSCC, gbc);
        GridBagLayout gbl_buttonPanelSCC = new GridBagLayout();
        gbl_buttonPanelSCC.columnWidths = new int[]{0, 0, 0, 0};
        gbl_buttonPanelSCC.rowHeights = new int[]{0, 0};
        gbl_buttonPanelSCC.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_buttonPanelSCC.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        buttonPanelSCC.setLayout(gbl_buttonPanelSCC);
    }

    public void setButtonsAdmin()
    {
        btnNewButton_U = new JButton("New");
        btnNewButton_U.setMinimumSize(new Dimension(80, 23));
        btnNewButton_U.setMaximumSize(new Dimension(80, 23));
        btnNewButton_U.setPreferredSize(new Dimension(80, 23));
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanelNCD1.add(btnNewButton_U, gbc);

        btnChangeButton_U = new JButton("Change");
        btnChangeButton_U.setPreferredSize(new Dimension(80, 23));
        btnChangeButton_U.setMinimumSize(new Dimension(80, 23));
        btnChangeButton_U.setMaximumSize(new Dimension(80, 23));
        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.gridx = 0;
        gbc.gridy = 1;
        buttonPanelNCD1.add(btnChangeButton_U, gbc);

        btnDeleteButton_U = new JButton("Delete");
        btnDeleteButton_U.setPreferredSize(new Dimension(80, 23));
        btnDeleteButton_U.setMinimumSize(new Dimension(80, 23));
        btnChangeButton_U.setMaximumSize(new Dimension(80, 23));
        gbc.gridx = 0;
        gbc.gridy = 2;
        buttonPanelNCD1.add(btnDeleteButton_U, gbc);

        btnNewButton_G = new JButton("New");
        btnNewButton_G.setMinimumSize(new Dimension(80, 23));
        btnNewButton_G.setMaximumSize(new Dimension(80, 23));
        btnNewButton_G.setPreferredSize(new Dimension(80, 23));
        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanelNCD2.add(btnNewButton_G, gbc);

        btnChangeButoon_G = new JButton("Change");
        btnChangeButoon_G.setPreferredSize(new Dimension(80, 23));
        btnChangeButoon_G.setMinimumSize(new Dimension(80, 23));
        btnChangeButoon_G.setMaximumSize(new Dimension(80, 23));
        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.gridx = 0;
        gbc.gridy = 1;
        buttonPanelNCD2.add(btnChangeButoon_G, gbc);

        btnDeleteButton_G = new JButton("Delete");
        btnDeleteButton_G.setMinimumSize(new Dimension(80, 23));
        btnDeleteButton_G.setMaximumSize(new Dimension(80, 23));
        btnDeleteButton_G.setPreferredSize(new Dimension(80, 23));
        gbc.gridx = 0;
        gbc.gridy = 2;
        buttonPanelNCD2.add(btnDeleteButton_G, gbc);

        btnCloseButtonUG = new JButton("Close");
        btnCloseButtonUG.setPreferredSize(new Dimension(80, 23));
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.gridx = 4;
        gbc.gridy = 2;
        tappedPanelUG.add(btnCloseButtonUG, gbc);

        btnEditButton = new JButton("Edit");
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 0, 10, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanelEDPO.add(btnEditButton, gbc);
        btnEditButton.setMaximumSize(new Dimension(80, 23));
        btnEditButton.setMinimumSize(new Dimension(80, 23));
        btnEditButton.setPreferredSize(new Dimension(80, 23));

        btnDeleteButtonScoreboard = new JButton("Delete");
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 1;
        gbc.gridy = 0;
        buttonPanelEDPO.add(btnDeleteButtonScoreboard, gbc);
        btnDeleteButtonScoreboard.setMaximumSize(new Dimension(80, 23));
        btnDeleteButtonScoreboard.setMinimumSize(new Dimension(80, 23));
        btnDeleteButtonScoreboard.setPreferredSize(new Dimension(80, 23));

        btnPostButton = new JButton("Post");
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.gridx = 2;
        gbc.gridy = 0;
        buttonPanelEDPO.add(btnPostButton, gbc);
        btnPostButton.setMaximumSize(new Dimension(80, 23));
        btnPostButton.setMinimumSize(new Dimension(80, 23));
        btnPostButton.setPreferredSize(new Dimension(80, 23));

        btnOpenButton = new JButton("Open");
        btnOpenButton.setPreferredSize(new Dimension(80, 23));
        btnOpenButton.setMinimumSize(new Dimension(80, 23));
        btnOpenButton.setMaximumSize(new Dimension(80, 23));
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.NORTHEAST;
        gbc.gridx = 3;
        gbc.gridy = 0;
        buttonPanelEDPO.add(btnOpenButton, gbc);

        btnSaveButton = new JButton("Save");
        btnSaveButton.setMinimumSize(new Dimension(80, 23));
        btnSaveButton.setMaximumSize(new Dimension(80, 23));
        btnSaveButton.setPreferredSize(new Dimension(80, 23));
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 0, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanelSCC.add(btnSaveButton, gbc);

        btnCancelButtonScoreboard = new JButton("Cancel");
        btnCancelButtonScoreboard.setMaximumSize(new Dimension(80, 23));
        btnCancelButtonScoreboard.setMinimumSize(new Dimension(80, 23));
        btnCancelButtonScoreboard.setPreferredSize(new Dimension(80, 23));
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 0, 10, 10);
        gbc.gridx = 1;
        gbc.gridy = 0;
        buttonPanelSCC.add(btnCancelButtonScoreboard, gbc);

        btnClose = new JButton("Close");
        gbc.insets = new Insets(10, 0, 10, 10);
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 2;
        gbc.gridy = 0;
        buttonPanelSCC.add(btnClose, gbc);
        btnClose.setMaximumSize(new Dimension(80, 23));
        btnClose.setMinimumSize(new Dimension(80, 23));
        btnClose.setPreferredSize(new Dimension(80, 23));
    }

    public void setTableView()
    {
        JScrollPane scrollPane_2 = new JScrollPane();
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(0, 10, 5, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        tappedPanelSB.add(scrollPane_2, gbc);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                },
                new String[] {
                        "User name", "Message"
                }
        ) {
            Class[] columnTypes = new Class[] {
                    String.class, String.class
            };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        table.getColumnModel().getColumn(0).setPreferredWidth(78);
        table.getColumnModel().getColumn(1).setPreferredWidth(600);
        scrollPane_2.setViewportView(table);
    }

    public void setLabelsAdmin()
    {
        JLabel userlist = new JLabel("Userlist");
        userlist.setFont(new Font("Cambria", Font.PLAIN, 18));
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        tappedPanelUG.add(userlist, gbc);

        JLabel grouplist = new JLabel("Grouplist");
        grouplist.setFont(new Font("Cambria", Font.PLAIN, 18));
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.gridx = 3;
        gbc.gridy = 0;
        tappedPanelUG.add(grouplist, gbc);

        JLabel lblScoreboardAdministration = new JLabel("Scoreboard Administration");
        lblScoreboardAdministration.setFont(new Font("Cambria", Font.PLAIN, 18));
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        tappedPanelSB.add(lblScoreboardAdministration, gbc);
    }

    public void setTextArea()
    {
        JScrollPane scrollPane_3 = new JScrollPane();
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 10, 5, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 3;
        tappedPanelSB.add(scrollPane_3, gbc);

        textArea = new JTextArea();
        scrollPane_3.setViewportView(textArea);
    }
}
