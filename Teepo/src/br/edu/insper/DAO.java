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
			"jdbc:mysql://localhost/teepo", "root", "Mendez575");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Categorias> getCategorias(){          //Pega todas as Categorias do database
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
	
	public void adicionaCategoria(Categorias categ) {           //adiciona/edita Categorias
			
			String sql = "INSERT INTO categorias" +
						 "(titulo) values(?)";
			PreparedStatement stmt;
			//System.out.println(categ.getTitulo());
			try {
				stmt = connection.prepareStatement(sql);
				stmt.setString(1, categ.getTitulo());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	
	public void alteraCategoria(Categorias categ) {
		String sql = "UPDATE categorias SET " +
					 "titulo=?  WHERE idCategoria=?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, categ.getTitulo());
			stmt.setInt(2, categ.getIdCategoria());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			}
		}
	
	public void removeCategoria(Integer Id) {				//remove categoria do id x
		PreparedStatement stmt;
		try {
			stmt = connection
			 .prepareStatement("DELETE FROM categorias WHERE idCategoria=?");
			stmt.setInt(1, Id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			}
		}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	public List<Notas> getNotas(){          //Pega todas as Notas do database
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
				
				Notas.add(nota);
				}
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Notas;
		
	}
	
	public List<Notas> notasCategoria(Categorias categ){   //Pega as notas da categoria especifica
		List<Notas> Notas = new ArrayList<Notas>();
		Integer id_categ = categ.getIdCategoria();
		PreparedStatement stmt;
		try {
			stmt = connection.
					prepareStatement("SELECT * FROM notas WHERE idCategoria="+ id_categ);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Notas nota = new Notas();
				nota.setIdNota(rs.getInt("idNota"));
				nota.setIdCategoria(rs.getInt("idCategoria"));
				nota.setConteudo(rs.getString("conteudo"));	
				Notas.add(nota);
				}
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			}
		return Notas;
		}	
	
	public void adicionaNota(Notas nota, Integer id_categ) {           //adiciona/edita Notas (para editar temos que adicionar a nota no id antigo)
	     											 //se não funcionar, ver o edita do handout
		String sql = "INSERT INTO notas" +
					 "(conteudo,idCategoria) values(?,?)";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1,nota.getConteudo());
			stmt.setInt(2, id_categ);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			}
	}	

	public void removeNota(Integer idNota) {				//remove nota do id x
		PreparedStatement stmt;
		try {
			stmt = connection
			 .prepareStatement("DELETE FROM notas WHERE idNota=?");
			stmt.setLong(1, idNota);
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