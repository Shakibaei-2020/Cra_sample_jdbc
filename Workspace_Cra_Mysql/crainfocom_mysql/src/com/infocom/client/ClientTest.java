package com.infocom.client;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.infocom.util.DBUtil;

public class ClientTest {
//test
	public static void main(String[] args) throws SQLException {
		
		 List<NoteDeFrais> ntFrais = new ArrayList<>();

		
		//Partie collaborateur
		Collaborateur collaborateur = new Collaborateur(13, "MICHELLE", "InfoCom", "Dev");
		
		//e.insertCollab(e);
		//e.selectAllCollab();
		//e.selectCollab(2);
		//e.deleteCollab(9);
		//e.updateCo.llab(e);
				 
		//PartieFrais
		//p.insertFrais(p);
		//p.selectFrais(1);
		//p.selectAllFrais();
		//p.deleteFrais(5);
		//p.updateFrais(p);
		
		//Utilisation des deux classe
		 collaborateur.setList(ntFrais);
		 
			collaborateur.ajouterNoteDeFrais(new NoteDeFrais(9, "consommation", 80,"13/02/2006"));
			collaborateur.ajouterNoteDeFrais(new NoteDeFrais(0, "trafic", 80,"13/02/2009"));
			collaborateur.ajouterNoteDeFrais(new NoteDeFrais(2, "consommation", 80,"13/02/2014"));
			collaborateur.ajouterNoteDeFrais(new NoteDeFrais(3, "trafic", 80,"13/02/2024"));
			 for (int i = 0; i < ntFrais.size(); i++) {
				 System.out.println(ntFrais.get(i).getDateFrais());
			}
	}

}
