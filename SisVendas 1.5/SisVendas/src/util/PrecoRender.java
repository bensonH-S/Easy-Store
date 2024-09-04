
package util;

import java.awt.Component;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class PrecoRender extends DefaultTableCellRenderer{
    
    NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));
    
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
        
        super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
        
        if(o instanceof Float){
        
          this.setText(nf.format((float)o));
        }
        
        return this;
    }
    
    
    
}
