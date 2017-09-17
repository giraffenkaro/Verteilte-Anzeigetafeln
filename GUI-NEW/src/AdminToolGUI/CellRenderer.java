package AdminToolGUI;

        import javax.swing.*;
        import javax.swing.table.DefaultTableCellRenderer;
        import javax.swing.table.DefaultTableModel;
        import javax.swing.table.TableCellRenderer;
        import java.awt.*;

/**
 * Created with IntelliJ IDEA
 * User:   Yannick Neumann
 * Date:   13.09.2017
 * Time:   21:01
 */
public class CellRenderer {

    /**
     * @param args the command line arguments
     */
    public static void main( String[] args ) {

        JTable table = new JTable();

        String[] header = { "Spalte 1", "Spalte 2", "Spalte 3" };
        String[][] data = {
                { "A1", "B", "C" }, { "A2", "B", "C" }, { "A3", "B", "C" }, { "A4",
                "B", "C" },
                { "A5", "B", "C" }, { "A6", "B", "C" }, { "A7", "B", "C" }, { "A8",
                "B", "C" },
                { "A9", "B", "C" }, { "A10", "B", "C" }, { "A11", "B", "C" }, {
                "A12", "B", "C" },
                { "A13", "B", "C" }, { "A14", "B", "C" }, { "A15", "B", "C" }, {
                "A16", "B", "C" },
                { "A17", "B", "C" }, { "A18", "B", "C" }, { "A19", "B", "C" }, {
                "A20", "B", "C" },
                { "A21", "B", "C" }, { "A22", "B", "C" }, { "A23", "B", "C" }, {
                "A24", "B", "C" } };

        table.setModel( new DefaultTableModel( data, header ) );

        table.setDefaultRenderer( Object.class, new CustomTableCellRenderer() );


        initGUI( table );
    }

    private static class CustomTableCellRenderer extends DefaultTableCellRenderer
    {

        private static final Dimension PREF_SIZE = new Dimension( 60, 40 );

        private static final JTextArea textArea = new JTextArea( 2, 2 );


        private CustomTableCellRenderer() {
            textArea.setPreferredSize( PREF_SIZE );
            textArea.setWrapStyleWord( true );
            textArea.setLineWrap( true );

        }

        @Override
        public Component getTableCellRendererComponent( JTable table,
                                                        Object value,
                                                        boolean isSelected, boolean hasFocus, int row, int column ) {

            super.getTableCellRendererComponent( table, value,
                    isSelected, hasFocus, row, column );

            textArea.setText( value.toString() );

            if( table.getRowHeight( row ) < PREF_SIZE.height ) {
                table.setRowHeight( row, PREF_SIZE.height );
                //table.setRowHeight( table.getRowHeight() + 100 );
            }

            return textArea;
        }

    }

    private static void initGUI( JTable table ) {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel( new BorderLayout() );
        JPanel kopf = new JPanel();
        JPanel mitte = new JPanel( new BorderLayout() );
        JLabel label = new JLabel( "Tabelle" );

        kopf.add( label );
        mitte.add( table.getTableHeader(), BorderLayout.PAGE_START );
        // Hier ummantele ich die Tabelle mit nem Scrollpane
        mitte.add( new JScrollPane( table ), BorderLayout.CENTER );

        panel.add( kopf, BorderLayout.PAGE_START );
        panel.add( mitte, BorderLayout.CENTER );
        frame.add( panel );

        frame.pack();
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setVisible( true );
    }


}

