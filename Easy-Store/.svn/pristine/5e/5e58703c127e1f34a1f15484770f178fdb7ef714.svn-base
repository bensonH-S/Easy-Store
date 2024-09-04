package novo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelecionarCodigosBarrasDao {

	private Connection conn;
	
	public SelecionarCodigosBarrasDao(){
		this.conn = new ConnectionFactory().getConnection();
	}
	
//	public static void main(String[] args) {
//		SelecionarCodigosBarrasDao scDao = new SelecionarCodigosBarrasDao();
//		for (String string : scDao.selectCredits()) {
//			System.out.println(string);
//		}
//	}
	
	public List<String> selectCredits(){

		List<String> lista = new ArrayList<String>();

		String query = "select codigobarras from produto;";

		PreparedStatement ps = null;

		try {

			ps = conn.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				lista.add(rs.getString("codigobarras"));

			}

			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;		
	}
}
