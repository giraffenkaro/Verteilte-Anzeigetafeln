package EditGUI;

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

/**
 * Created with IntelliJ IDEA
 * User:   Yannick Neumann
 * Date:   13.09.2017
 * Time:   17:34
 */
public class Edit
{
    private JFrame frame = new JFrame("Edit");
    private JPanel contentPane;
    private JPanel panel;
    private JTable table;
    private JButton btnDelete;
    private JButton btnEdit;
    private JButton btnClose;
    private JButton btnPost;
    private JButton btnOpen;
    private JComboBox comboBox;
    private JPanel panelButtons;
    private JTextArea txtArea;
    private GridBagConstraints gbc;

    public static void main(String[] args)
    {
        Edit edit = new Edit();
        edit.start();
    }

    public void Edit ()
    {
        setPanels();
        setButtons();
        setLabels();
        setInput();
        setCombobox();
    }

    public void start ()
    {
        setFrame();
    }

    public void setFrame ()
    {
        frame.setContentPane(contentPane);
        frame.setVisible(true);
        frame.setSize(600,400);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void setButtons ()
    {
        btnPost = new JButton("Post");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 0, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelButtons.add(btnPost, gbc);

        btnDelete = new JButton("Delete");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 0, 5);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panelButtons.add(btnDelete, gbc);

        btnEdit = new JButton("Edit");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 0, 5);
        gbc.gridx = 2;
        gbc.gridy = 0;
        panelButtons.add(btnEdit, gbc);

        btnOpen = new JButton("Open");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 0, 5);
        gbc.gridx = 3;
        gbc.gridy = 0;
        panelButtons.add(btnOpen, gbc);

        btnClose = new JButton("Close");
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(btnClose, gbc);
    }

    public void setPanels ()
    {
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));

        panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{0, 0};
        gbl_panel.rowHeights = new int[]{0, 167, 0, 0, 0, 0};
        gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
        panel.setLayout(gbl_panel);

        panelButtons = new JPanel();
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(0, 0, 5, 0);
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(panelButtons, gbc);
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
        gbl_panel_1.rowHeights = new int[]{0, 0};
        gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        panelButtons.setLayout(gbl_panel_1);
    }

    public void setLabels ()
    {
        JLabel lblMessagesFromScoreboard = new JLabel("Messages from Scoreboard");
        lblMessagesFromScoreboard.setFont(new Font("Tahoma", Font.PLAIN, 18));
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 5, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lblMessagesFromScoreboard, gbc);
    }

    public void setInput ()
    {
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setMaximumSize(new Dimension(325, 325));
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 5, 0);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(scrollPane, gbc);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {null},
                        {null},
                        {null},
                        {null},
                        {null},
                        {null},
                        {null},
                        {null},
                        {null},
                        {null},
                },
                new String[] {
                        "Messages"
                }
        ));
        scrollPane.setViewportView(table);

        JScrollPane scrollPane_1 = new JScrollPane();
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 5, 0);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(scrollPane_1, gbc);

        txtArea = new JTextArea();
        scrollPane_1.setViewportView(txtArea);
    }

    public void setCombobox()
    {
        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tester", "Tester2 ", "Tester3333"}));
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        panelButtons.add(comboBox, gbc);
    }

    public void setListener ()
    {

    }
}
