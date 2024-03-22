package com.hemebiotech.analytics;

import java.util.Map;
public interface ISymptomWriter {
    // Méthode conçue pour écrire les données des symptomes dans un fichier spécifié
    // L'unique paramètre : une Map<String, Integer> nommée symptoms.
    // Chaque clé est un String représentant un symptôme et chaque valeur est un Integer représentant le nombre d'occurrences de ce symptôme
    public void writeSymptoms(Map<String, Integer> symptoms);
}
