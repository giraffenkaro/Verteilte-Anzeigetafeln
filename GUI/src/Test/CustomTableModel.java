package Test;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mpp00353
 */
public class CustomTableModel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        JTable table = new JTable();

        String[] header = {"Spalte 1","Spalte 2","Spalte 3"};
        String[][] data = {
                {"A1","B","C"},{"A2","B","C"},{"A3","B","C"},{"A4","B","C"},
                {"A5","B","C"},{"A6","B","C"},{"A7","B","C"},{"A8","B","C"},
                {"A9","B","C"},{"A10","B","C"},{"A11","B","C"},{"A12","B","C"},
                {"A13","B","C"},{"A14","B","C"},{"A15","B","C"},{"A16","B","C"},
                {"A17","B","C"},{"A18","B","C"},{"A19","B","C"},{"A20","B","C"},
                {"A21","B","C"},{"A22","B","C"},{"A23","B","C"},{"A24","B","C"}};

        table.setModel(new DefaultTableModel(data,header));

        table.setDefaultRenderer(Object.class,new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable jtable,
                                                           Object o, boolean bln, boolean bln1, int i, int i1) {

                JEditorPane editorPane = new JEditorPane();
                editorPane.setText(o.toString());

                editorPane.setSize(new Dimension(40,60));
                System.out.println("CellRenderer");

                if (jtable.getRowHeight(i) < editorPane.getPreferredSize().height) {
                    jtable.setRowHeight(i, editorPane.getPreferredSize().height);
                }

                return editorPane;
            }
        });


        initGUI(table);
    }

    private static void initGUI(JTable table) {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel(new BorderLayout());
        JPanel kopf = new JPanel();
        JPanel mitte = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Tabelle");

        System.out.println("table");

        kopf.add(label);
        mitte.add(table.getTableHeader(),BorderLayout.PAGE_START);
        mitte.add(table,BorderLayout.CENTER);

        panel.add(kopf,BorderLayout.PAGE_START);
        panel.add(mitte,BorderLayout.CENTER);
        frame.add(panel);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}