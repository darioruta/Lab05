package it.polito.tdp.anagrammiDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammiDAO {

	
	public boolean isCorrect (String anagramma) {
		
		String sql ="SELECT nome FROM parola WHERE nome = ? ";
		
		//boolean result = false;
		try {
			
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagramma);
			ResultSet res = st.executeQuery();
					
			if (res.next()) {
				return true;
			}
			
		res.close();
		st.close();
		conn.close();
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		
		}

		return false;
		
	}

		
		
}
