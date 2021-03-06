package com.infocom.client;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import com.infocom.util.DBUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Collaborateur   {	
	
	private int idColl;
	private String nomColl;
	private String societeColl;
	private String posteColl;
	
	private List<NoteDeFrais> ntFrais;

	
	private  final String INSERT_COLLAB_SQL = "INSERT INTO collaborateur" + "  (nom_coll, societe_coll, poste_coll) VALUES " + " (?, ?, ?);";
	private  final String SELECT_COLLAB_BY_ID = "SELECT id_coll,nom_coll,societe_coll,poste_coll FROM collaborateur WHERE id_coll =?";	
	private  final String SELECT_ALL_COLLAB = "SELECT * FROM collaborateur";
	private  final String DELETE_COLLAB_SQL = "DELETE FROM collaborateur WHERE id_coll = ?;";
	private  final String UPDATE_COLLAB_SQL = "UPDATE collaborateur SET nom_coll = ?,societe_coll= ?, poste_coll =? WHERE id_coll = ?;";
	
	
	public Collaborateur( int idColl, String nomColl, String societeColl, String posteColl) {
        	this.idColl = idColl;
			this.nomColl = nomColl;
	        this.societeColl = societeColl;
	        this.posteColl = posteColl;
	 }
	
	 public List<NoteDeFrais> getList() {
		 return ntFrais;
		 
	 }
	 
	 public void setList(List<NoteDeFrais>ntFrais) {
		  this.ntFrais = ntFrais;
	 }
	 
	 public int getIdCollab() {
			return idColl;
	 }
	 
	 public int setIdCollab(int idColl) {
			return this.idColl = idColl;
	 }
	 
	 public String getnomCollab() {
		 return nomColl;
	 }
	 
	 public String setnomCollab(String nomColl) {
		 return this.nomColl = nomColl;
	 }
	
	 public String getsocieteCollab() {
		 return societeColl;
	 }
	 
	 public String setsocieteCollab(String societeColl) {
		 return this.societeColl = societeColl;
	 }
	 
	 public String getpostCollab() {
		 return posteColl;
	 }
	 
	 public String setpostCollab(String posteColl) {
		 return this.posteColl = posteColl;
	 }
	 
	  public void insertCollab(Collaborateur Collaborateur) throws SQLException {
	        System.out.println(INSERT_COLLAB_SQL);
	        try (Connection connection = DBUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COLLAB_SQL)) {
	            preparedStatement.setString(1, Collaborateur.getnomCollab());
	            preparedStatement.setString(2, Collaborateur.getsocieteCollab());
	            preparedStatement.setString(3, Collaborateur.getpostCollab());
	            System.out.println(preparedStatement);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	  

	  public Collaborateur selectCollab(int idColl) {
		  Collaborateur Collaborateur = null;
	        try (Connection connection = DBUtil.getConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COLLAB_BY_ID)) {
	            preparedStatement.setInt(1, idColl);
	            ResultSet rs = (ResultSet) preparedStatement.executeQuery();

	            while (rs.next()) {
	                String nomColl = rs.getString("nom_coll");
	                String societeColl = rs.getString("societe_coll");
	                String posteColl = rs.getString("poste_coll");
	                
	                Collaborateur = new Collaborateur(idColl, societeColl, societeColl, posteColl);
	                System.out.println(idColl+" "+ nomColl +" "+ societeColl+" "+ posteColl);
	            }
	               
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	        return Collaborateur;
	    }
	  
	 
	  public List < Collaborateur > selectAllCollab() {

	        List < Collaborateur > Collaborateur = new ArrayList <Collaborateur> ();
	        try (Connection connection = DBUtil.getConnection();

	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COLLAB);) {
	            ResultSet rs = (ResultSet) preparedStatement.executeQuery();
	            while (rs.next()) {
	                int idColl = rs.getInt("id_coll");
	                String nomColl = rs.getString("nom_coll");
	                String societeColl = rs.getString("societe_coll");
	                String posteColl = rs.getString("poste_coll");
	                Collaborateur.add(new Collaborateur(idColl, nomColl, societeColl, posteColl));
	                
	                System.out.println(idColl+" "+ nomColl +" "+ societeColl +" "+ posteColl);
	            }
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	        return Collaborateur;
	    }
	  
	    public boolean deleteCollab(int idCollab) throws SQLException {
	        boolean rowDeleted;
	        try (Connection connection = DBUtil.getConnection();
	        		PreparedStatement statement = connection.prepareStatement(DELETE_COLLAB_SQL);) {
	            statement.setInt(1, idCollab);
	            rowDeleted = statement.executeUpdate() > 0;
	        }
	        return rowDeleted;
	    }

	    public boolean updateCollab(Collaborateur Collaborateur) throws SQLException {
	        boolean rowUpdated;
	        try (Connection connection = DBUtil.getConnection();
	        	PreparedStatement statement = connection.prepareStatement(UPDATE_COLLAB_SQL);) {
	            statement.setString(1, Collaborateur.getnomCollab());
	            statement.setString(2, Collaborateur.getpostCollab());
	            statement.setString(3, Collaborateur.getsocieteCollab());
	            statement.setInt(4, Collaborateur.getIdCollab());

	            rowUpdated = statement.executeUpdate() > 0;
	        }
	        return rowUpdated;
	    }
	    
	    public void ajouterNoteDeFrais(NoteDeFrais notedefrais) {
			 this.ntFrais.add(notedefrais);		 
		 }
}

