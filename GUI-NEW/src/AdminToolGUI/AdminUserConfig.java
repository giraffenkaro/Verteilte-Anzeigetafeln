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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminUserConfig extends JFrame
{
    private JPanel contentPane;
    private JTextField txtUserName;
    private JPasswordField passwordField;
    private JFrame adminUserFrame = new JFrame("User Config");
    private JPanel panelButtons;
    private JPanel panelMain;
    private JComboBox comboBox;
    private JButton btnSave;
    private JList<String> listGroup;
    private JButton btnCancel;
    private GridBagConstraints gbc;
    private DefaultListModel<String> defaultListModel1;

    public void closeEdit ()
    {
        adminUserFrame.dispose();
    }

    public void start ()
    {
        setFrame();
    }
    
    public void setFrame ()
    {
        adminUserFrame.setContentPane(contentPane);
        adminUserFrame.setVisible(true);
        adminUserFrame.setSize(310,450);
        adminUserFrame.setResizable(false);
        adminUserFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public AdminUserConfig()
    {
        setPanels();
        setLabels();
        setButtons();
        setTextInput();
        setCombobox();
        setList();
        addListener();
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
    
    public void setLabels ()
    {
        JLabel lblName = new JLabel("Name:");
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panelMain.add(lblName, gbc);

        JLabel lblPW = new JLabel("PW:");
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 10, 10, 10);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panelMain.add(lblPW, gbc);

        JLabel lblGroups = new JLabel("Groups:");
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 10, 10, 0);
        gbc.gridx = 1;
        gbc.gridy = 4;
        panelMain.add(lblGroups, gbc);

        JLabel lblPermissions = new JLabel("Permissions:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 6;
        panelMain.add(lblPermissions, gbc);
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
        
        listGroup = new JList<String>();
        defaultListModel1 = new DefaultListModel<>();
        defaultListModel1.addElement("test");
        defaultListModel1.addElement("test11111111111111111111111111111111111111111111");
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
        listGroup.setModel(defaultListModel1);
        listGroup.setSelectionMode(0);
        scrollPane.setViewportView(listGroup);
    }
    
    public void setTextInput ()
    {
        txtUserName = new JTextField();
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelMain.add(txtUserName, gbc);
        txtUserName.setColumns(10);

        passwordField = new JPasswordField();
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 3;
        panelMain.add(passwordField, gbc);
    }
    
    public void setPanels ()
    {
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));

        panelMain = new JPanel();
        contentPane.add(panelMain, BorderLayout.CENTER);
        GridBagLayout gblPanelMain = new GridBagLayout();
        gblPanelMain.columnWidths = new int[]{0, 0, 0};
        gblPanelMain.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gblPanelMain.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gblPanelMain.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panelMain.setLayout(gblPanelMain);

        panelButtons = new JPanel();
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 8;
        panelMain.add(panelButtons, gbc);
        GridBagLayout gblPanelButtons = new GridBagLayout();
        gblPanelButtons.columnWidths = new int[]{0, 0, 0};
        gblPanelButtons.rowHeights = new int[]{0, 0};
        gblPanelButtons.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        gblPanelButtons.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        panelButtons.setLayout(gblPanelButtons);
    }
    
    public void setCombobox ()
    {
        comboBox = new JComboBox();
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 7;
        panelMain.add(comboBox, gbc);
    }
}

