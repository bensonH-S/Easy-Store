    package controle;

    import com.mysql.jdbc.PreparedStatement;
    import java.sql.SQLException;
    import java.text.SimpleDateFormat;
    import java.util.Date;
    import java.util.logging.Level;
    import java.util.logging.Logger;
    import javax.swing.JOptionPane;

    /**
    *
    * @author Benson Henrique. add 04/01/2018
    */
    public class ControleValidacao {

    ConectaBanco conn = new ConectaBanco();
    int valida;

    public void valida(String senha) {

        conn.conexao();
        conn.executaSQL("SELECT * FROM chaveacesso");
        try {
            conn.rs.last();
            valida = Integer.parseInt(conn.rs.getString("datavenc"));
            int operacao = (valida + 9000 - 233);
            int senhaValidacao = Integer.parseInt(senha);
            if (operacao == senhaValidacao) {
                int dia, mes, ano;

                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                Date hoje = new Date();
                String data = df.format(hoje);
                char[] senhachar = data.toCharArray();

                String AcertaMes, AcertaDia, ProxSenha;
                dia = Integer.parseInt("" + senhachar[0] + senhachar[1]);
                mes = Integer.parseInt("" + senhachar[3] + senhachar[4]);
                ano = Integer.parseInt("" + senhachar[6] + senhachar[7] + senhachar[8] + senhachar[9]);

                if (mes < 12) {
                    mes++;
                    if (mes < 10) {
                        AcertaMes = "0" + mes;
                    } else {
                        AcertaMes = "" + mes;
                    }
                } else {
                    mes = 1;
                    ano++;
                    AcertaMes = "0" + mes;
                }
                if (dia < 10) {
                    AcertaDia = "0" + dia;

                } else {
                    AcertaDia = "" + dia;
                }

                ProxSenha = AcertaDia + AcertaMes + ano;
                PreparedStatement pst = (PreparedStatement) conn.conn.prepareStatement("insert into chaveacesso (chave,datavenc) values(?,?)");
                pst.setString(1, "00000");
                pst.setString(2, ProxSenha);
                pst.execute();


                JOptionPane.showMessageDialog(null, "Código de validação feito com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Código de validação Incorreto.");
            }
            //JOptionPane.showMessageDialog(null,valida);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao validar!\nErro:" + ex);
        }
        conn.desconecta();

    }

    }
