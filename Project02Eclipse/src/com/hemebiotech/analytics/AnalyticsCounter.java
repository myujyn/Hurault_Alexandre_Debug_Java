package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.TreeMap;

public class AnalyticsCounter {
	// Déclaration de variables d'instance pour les interfaces de lecture et d'écriture de symptômes.
	private ISymptomReader reader;
	private ISymptomWriter writer;

	// Constructeur qui initialise la classe avec des objets implémentant ISymptomReader et ISymptomWriter.
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}
	// Utilisation de la méthode getSymptoms de l'interface ISymptomReader pour lire le fichier
	public List<String> getSymptoms() {

		return getSymptoms();
	}

	// Méthode pour compter les occurences de chaque symptomes
	public Map<String, Integer>	countSymptoms(List<String> symptoms) {
		// Crée une nouvelle instance de HashMap, assignée à la variable symptomCounts pour stocker le compte de symptomes
		Map<String, Integer> symptomCounts = new HashMap<>();
		// Boucle for each qui itère sur chaque élément de la liste symptoms
		for (String symptom : symptoms) {
			// Cette ligne permet la mise à jour de la Hashmap avec le symptome actuel
			// Méthode getordefault permet de compter le nombre de fois où le symptome est observé
			// Cette valeur est mise à jour au symptome associé dans la map en utilisant la méthode put
			symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0)+1);
		}
		// Retourne la map avec le comptage mis à jour
		return symptomCounts;
	}
	// Méthode pour trier automatiquement les symptomes par leurs noms (clé), en utilisant Treemap
	public Map<String, Integer>	sortSymptoms(Map<String, Integer> symptoms) {

		return new TreeMap<>(symptoms);
	}
	// Utilisation de la méthode writeSymptom de l'interface ISymptomWriter pour l'écriture des données
	public void writeSymptoms(Map<String, Integer> symptoms) {

		writer.writeSymptoms(symptoms);
	}
}
