package com.infocom.client;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.infocom.util.DBUtil;

public class NoteDeFrais {
	
	private int idFrais;
	private String raisonFrais;
	// Attetion un prix pour être un double
	private int prixFrais;
	// Pourquoi la date en String ?
	private String dateFrais;
	
	// Pourquoi la concaténation de INSERT_FRAIS_SQL
	private  final String INSERT_FRAIS_SQL = "INSERT INTO notedefrais" + "  (raison_frais, prix_frais, date_frais) VALUES " + " (?, ?, ?);";
	private  final String SELECT_FRAIS_BY_ID = "SELECT id_frais,raison_frais,prix_frais,date_frais FROM notedefrais WHERE id_frais =?";	
	private  final String SELECT_ALL_FRAIS = "SELECT * FROM notedefrais";
	private  final String DELETE_FRAIS_SQL = "DELETE FROM notedefrais WHERE id_frais = ?;";
	private  final String UPDATE_FRAIS_SQL = "UPDATE notedefrais SET raison_frais = ?,prix_frais= ?, date_frais =? WHERE id_frais = ?;";
	
	// TODO : Constructeur par défaut
	
	public NoteDeFrais(int idFrais, String raisonFrais, int prixFrais, String dateFrais) {
		super();
		this.idFrais = idFrais;
		this.raisonFrais = raisonFrais;
		this.prixFrais = prixFrais;
		this.dateFrais = dateFrais;
	}
	 
	 
	 public int getIdFrais() {
			return idFrais;
		}
	 
	 public int setIdFrais(int idFrais) {
			return this.idFrais = idFrais;
		}
	 
	 public String getRaisonFrais() {
		 return raisonFrais;
	 }
	 public String setRaisonFrais(String raisonFrais) {
		 return this.raisonFrais = raisonFrais;
	 }
	
	 public int getPrixFrais() {
		 return prixFrais;
	 }
	 public int setPrixFrais(int prixFrais) {
		 return this.prixFrais = prixFrais;
	 }
	 
	 public String getDateFrais() {
		 return dateFrais;
	 }
	 public String setDateFrais(String dateFrais) {
		 return this.dateFrais = dateFrais;
	 }
	 
	 // Le nom de ta variable doit commmencer par un miniscule pour distonguer cela de l'objet
	  public void insertFrais(NoteDeFrais NoteDeFrais) throws SQLException { // Allège ton code par un retour à la ligne losqu'il le faut
	        try (Connection connection = DBUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FRAIS_SQL)) {
	            preparedStatement.setString(1, NoteDeFrais.getRaisonFrais());
	            preparedStatement.setInt(2, NoteDeFrais.getPrixFrais());
	            preparedStatement.setString(3, NoteDeFrais.getDateFrais());
	            preparedStatement.executeUpdate();
	            // Il faut fermer la connextion : connection.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	  

	  public NoteDeFrais selectFrais(int idFrais) {
		  // Convention de nommage des variables
		  NoteDeFrais NoteDeFrais = null;
	        try (Connection connection = DBUtil.getConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FRAIS_BY_ID)) {
	            preparedStatement.setInt(1, idFrais);
	            ResultSet rs = (ResultSet) preparedStatement.executeQuery();

	            while (rs.next()) {
	            	
	                String raisonFrais = rs.getString("raison_frais");
	                int prixFrais = rs.getInt("prix_frais");
	                String dateFrais = rs.getString("date_frais");
	                // Pourquoi ne pas utiliser directement les Setters : NoteDeFrais.setRaisonFrais(rs.getString("raison_frais"));
	                NoteDeFrais = new NoteDeFrais(idFrais, raisonFrais, prixFrais, dateFrais);
	                // N'oublie pas d'enlever le System.out.println une fois qu tu t'en sert plus
	                System.out.println(idFrais+" "+ raisonFrais +" "+ prixFrais+" "+ dateFrais);
	            }
	         // Il faut fermer la connextion : connection.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	        return NoteDeFrais;
	    }
	  
	
	  public List < NoteDeFrais > selectAllFrais() {
		  // Convention de nommage des variables
	        List < NoteDeFrais > NoteDeFrais = new ArrayList <NoteDeFrais> ();
	        try (Connection connection = DBUtil.getConnection();

	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FRAIS);) {
	        	// N'oublie pas d'enlever le System.out.println une fois qu tu t'en sert plus
	            System.out.println(preparedStatement);
	            // Pourquoi t'as casté preparedStatement.executeQuery()?
	            ResultSet rs = (ResultSet) preparedStatement.executeQuery();
	            while (rs.next()) {
	            	// Pourquoi ne pas utiliser directement les Setters : noteDeFrais.setRaisonFrais(rs.getString("raison_frais"));
	                int idFrais = rs.getInt("id_frais");
	                String raisonFrais = rs.getString("raison_frais");
	                int prixFrais = rs.getInt("prix_frais");
	                String dateFrais = rs.getString("date_frais");
	                NoteDeFrais.add(new NoteDeFrais(idFrais, raisonFrais, prixFrais, dateFrais));
	                // N'oublie pas d'enlever le System.out.println une fois qu tu t'en sert plus
	                System.out.println(idFrais+" "+ raisonFrais +" "+ prixFrais +" "+ dateFrais);
	            }
	            // Il faut fermer la connextion : connection.close();
	        } catch (SQLException e) {
	        	// e.printStackTrace();
	            System.out.println(e);
	        }
	        return NoteDeFrais;
	    }
	 
	    public boolean deleteFrais(int idFrais) throws SQLException {
	    	// Same as the above
	        boolean rowDeleted;
	        try (Connection connection = DBUtil.getConnection();
	        		PreparedStatement statement = connection.prepareStatement(DELETE_FRAIS_SQL);) {
	            statement.setInt(1, idFrais);
	            rowDeleted = statement.executeUpdate() > 0;
	        }
	        return rowDeleted;
	    }
	    
	 
	    public boolean updateFrais(NoteDeFrais NoteDeFrais) throws SQLException {
	        boolean rowUpdated;
	     // Same as the above
	        try (Connection connection = DBUtil.getConnection();
	        	PreparedStatement statement = connection.prepareStatement(UPDATE_FRAIS_SQL);) {
	            statement.setString(1, NoteDeFrais.getRaisonFrais());
	            statement.setInt(2, NoteDeFrais.getPrixFrais());
	            statement.setString(3, NoteDeFrais.getDateFrais());
	            statement.setInt(4, NoteDeFrais.getIdFrais());

	            rowUpdated = statement.executeUpdate() > 0;
	        }
	        return rowUpdated;
	    }


		@Override
		public String toString() {
			return "NoteDeFrais [idFrais=" + idFrais + ", raisonFrais=" + raisonFrais + ", prixFrais=" + prixFrais
					+ ", dateFrais=" + dateFrais + ", INSERT_FRAIS_SQL=" + INSERT_FRAIS_SQL + ", SELECT_FRAIS_BY_ID="
					+ SELECT_FRAIS_BY_ID + ", SELECT_ALL_FRAIS=" + SELECT_ALL_FRAIS + ", DELETE_FRAIS_SQL="
					+ DELETE_FRAIS_SQL + ", UPDATE_FRAIS_SQL=" + UPDATE_FRAIS_SQL + "]";
		}

}
