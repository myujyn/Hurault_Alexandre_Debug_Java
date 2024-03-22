package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.TreeMap;
/**
 * Classe principale pour analyser les données de symptômes.
 * Cette classe utilise des objets conformes aux interfaces ISymptomReader et ISymptomWriter
 * pour lire des données de symptômes à partir d'une source donnée, compter les occurrences de chaque symptôme,
 * trier les symptômes et écrire les résultats dans une destination spécifiée.
 */
public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;

	/**
	 * Construit une instance d'AnalyticsCounter avec les composants spécifiés pour la lecture et l'écriture des données de symptômes.
	 *
	 * @param reader un objet qui implémente ISymptomReader pour lire les symptômes.
	 * @param writer un objet qui implémente ISymptomWriter pour écrire les résultats des symptômes comptés et triés.
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}
	/**
	 * Récupère la liste des symptômes en utilisant la méthode définie dans l'interface ISymptomReader.
	 *
	 * @return une liste des symptômes lus.
	 */
	public List<String> getSymptoms() {

		return getSymptoms();
	}

	// Mise en place de la méthode pour compter les symptômes
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
	/**
	 * Trie la map des symptômes par leurs noms (clés) et retourne une nouvelle map triée.
	 *
	 * @param symptoms une map non triée de symptômes et leurs occurrences.
	 * @return une map triée de symptômes et leurs occurrences.
	 */
	public Map<String, Integer>	sortSymptoms(Map<String, Integer> symptoms) {

		return new TreeMap<>(symptoms);
	}
	/**
	 * Écrit les symptômes comptés et triés dans une destination spécifiée en utilisant l'objet writer.
	 *
	 * @param symptoms une map triée de symptômes et leurs occurrences.
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {

		writer.writeSymptoms(symptoms);
	}
}
