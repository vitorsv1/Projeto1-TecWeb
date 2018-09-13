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
			"jdbc:mysql://localhost/teepo", "root", "Certezajorge123");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// PARTE DE CATEGORIAS PRONTA E FUNCIONANDO
	
	public List<Categorias> getCategorias(){          			//Pega todas as Categorias do database
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
	
	public void adicionaCategoria(Categorias categ) {           //Metodo que adiciona uma nova categoria no database
			
			String sql = "INSERT INTO categorias" +
						 "(titulo) values(?)";
			PreparedStatement stmt;
			try {
				stmt = connection.prepareStatement(sql);
				stmt.setString(1, categ.getTitulo());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	
	public void alteraCategoria(Categorias categ) {				//Metodo que altera o nome da categoria
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
	
	public void removeCategoria(Integer Id) {				//remove categoria com id x     
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
	
	public List<Categorias> procuraCategoria(String busca){          			    //Metodo que faz a busca em categorias que tenham titulo parecido com o que foi dado como
		PreparedStatement stmt; 						  		  					//parametro para a busca  (falta teste)
	
		List<Categorias> buscaCategorias = new ArrayList<Categorias>();
		try {
			stmt = connection.
					prepareStatement("SELECT titulo FROM categorias WHERE titulo LIKE '%?%'");
			stmt.setString(1, busca);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Categorias categ = new Categorias();
				categ.setIdCategoria(rs.getInt("idCategoria"));
				categ.setTitulo(rs.getString("titulo"));
				
				buscaCategorias.add(categ);
				}
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return buscaCategorias;
		
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	public List<Notas> getNotas(){          //Pega todas as Notas do database 			(funciona)
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
	
	public List<Notas> notasCategoria(Categorias categ){   //Pega as notas da categoria especifica    (funciona)
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
	
	public void adicionaNota(Notas nota, Integer id_categ) {           //adiciona Notas (para editar temos que adicionar a nota no id antigo)
	     											 				   //se não funcionar, ver o edita do handout (funciona)
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
	
	public void alteraNota(Notas nota) {								//Assim que receber uma nota, o método vai dar update no database com 
		String sql = "UPDATE notas SET " +								//o novo conteudo no id de nota que ele já estava (falta teste)		
					 "conteudo=?  WHERE idNota=? AND idCategoria=?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, nota.getConteudo());
			stmt.setInt(2, nota.getIdNota());
			stmt.setInt(3, nota.getIdCategoria());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			}
		}
	
	public void removeTodasNotas(Integer id_categ) {				  //Como não era possível excluir uma categoria se ela tivesse alguma nota dentro,
		PreparedStatement stmt;										  //fizemos esse método para excluir todas as notas de uma categoria antes de excluir ela (funciona)
		try {
			stmt = connection
			 .prepareStatement("DELETE FROM notas WHERE idCategoria=?");
			stmt.setLong(1, id_categ);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			}
	}

	public void removeNota(Integer idNota) {				//Método para remover nota especifica, recebe o id dela no banco de dados (falta teste)
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
	
	public List<Notas> procuraNota(String busca){          			    //Metodo que faz a busca em categorias que tenham titulo parecido com o que foi dado como
		PreparedStatement stmt; 						  		  					//parametro para a busca  (falta teste)
	
		List<Notas> buscaNotas = new ArrayList<Notas>();
		try {
			stmt = connection.
					prepareStatement("SELECT conteudo FROM notas WHERE conteudo LIKE '%?%'");
			stmt.setString(1, busca);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Notas nota = new Notas();
				nota.setConteudo(rs.getString("conteudo"));
				
				buscaNotas.add(nota);
				}
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return buscaNotas;
		
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void busca(String busca) {                    //metodo que usa os metodos de busca em notas e em categorias para procurar nos dois (falta teste)
		procuraNota(busca);
		procuraCategoria(busca);
	}
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}