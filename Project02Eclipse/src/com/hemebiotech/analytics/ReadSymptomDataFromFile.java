package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath; // Chemin du fichier contenant les symptômes

	/**
	 * Constructeur qui initialise l'instance avec le chemin vers le fichier contenant les symptômes.
	 *
	 * @param filepath Chemin complet ou partiel vers le fichier contenant les symptômes, un par ligne.
	 */
	public ReadSymptomDataFromFile (String filepath) {

		this.filepath = filepath;
	}
	/**
	 * Lit les symptômes à partir du fichier spécifié et les retourne sous forme de liste.
	 *
	 * @return Une liste contenant les symptômes lus depuis le fichier, chaque élément de la liste correspondant à un symptôme.
	 */
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				// Utilisation de BufferedReader pour lire le fichier ligne par ligne.
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				// Boucle tant qu'il reste des lignes à lire dans le fichier.
				while (line != null) {
					result.add(line);// Ajoute chaque ligne (symptôme) à la liste des résultats.
					line = reader.readLine();// Lit la ligne suivante.
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
