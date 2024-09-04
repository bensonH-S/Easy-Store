
package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ControleDataVenc {
    
    ConectaBanco conn = new ConectaBanco();
    
    public void SalvarData(modelo.ModeloDataVenc mod){
        conn.conexao();
        try {
            PreparedStatement pst = conn.conn.prepareStatement("insert into chaveacesso(chave,datavenc) values(?,?)");
            pst.setString(1, mod.getChave());
            pst.setString(2, mod.getData());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Cadastrada com Sucesso.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na inserção da data!");
            System.out.println(ex);
        }
        
    }

}
