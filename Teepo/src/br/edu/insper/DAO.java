package br.edu.insper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	private Connection connection = null;
	public DAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(
			"jdbc:mysql://localhost/teepo", "root", "senha");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Notas> getNotas(){          //getLista das Notas
		List<Notas> Notas = new ArrayList<Notas>();
		
		PreparedStatement stmt;
		try {
			stmt = connection.
					prepareStatement("SELECT * FROM notas");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Notas nota = new Notas();
				nota.setIdNota(rs.getInt("idNota"));
				nota.setIdCategoria(rs.getInt("idCategoria"));
				nota.setConteudo(rs.getString("conteudo"));
				nota.setCor(rs.getString("cor"));
				
				Notas.add(nota);
				}
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Notas;
		
	}

	public List<Categorias> getCategorias(){          //getLista das Categorias
		List<Categorias> Categorias = new ArrayList<Categorias>();
		
		PreparedStatement stmt;
		try {
			stmt = connection.
					prepareStatement("SELECT * FROM categorias");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Categorias categ = new Categorias();
				categ.setIdCategoria(rs.getInt("idCategoria"));
				categ.setTitulo(rs.getString("titulo"));
				
				Categorias.add(categ);
				}
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Categorias;
		
	}
	
	public void adiciona(Notas nota) {           //adiciona/edita Notas (para editar temos que adicionar a nota no id antigo)
												 //se não funcionar, ver o edita do handout
		String sql = "INSERT INTO notas" +
					 "(idNota,idCategoria,conteudo) values(?,?,?)";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			//stmt.setString(1,nota.getNome());
			//stmt.setDate(2, new Date(
			//			 nota.getNascimento().getTimeInMillis()));
			//stmt.setDouble(3,nota.getAltura());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			}
		}
		
	public void remove(Integer id) {				//remove nota do id x
		PreparedStatement stmt;
		try {
			stmt = connection
			 .prepareStatement("DELETE FROM notas WHERE id=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			}
		}
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}