
package classes;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
public class ColorealResaltar extends DefaultTableCellRenderer {
//este me hace que los articulos que esten a punto de reordenar me les ponga un color
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {    
        String cantsr =  String.valueOf(table.getValueAt(row, 2));
        String redsr =  String.valueOf(table.getValueAt(row, 5));
        float cantint=Float.valueOf(cantsr);
        float redtint=Float.valueOf(redsr);
                
        if (cantint<=redtint & cantint>0) {
           setBackground(Color.yellow);
         }
        else if (cantint<=0) {
            setBackground(Color.red);
        }
         else{
             setBackground(Color.white);
         }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
    }

}
