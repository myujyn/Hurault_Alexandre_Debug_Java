package com.hemebiotech.analytics;
import java.util.Map;
import java.util.List;

public class Main {
      public static void main (String[] args) {
        // // Initialisation des objets pour lire et écrire les données de symptômes.
        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataFromFile("result.out");

        // Analyticscounter est une autre classe qui est instanciée avec les objets reader et writer.
        // AnalyticsCounter est responsable de la logique de traitement principale
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

        //  Lecture, comptage et tri des symptômes à partir du fichier d'entrée.
        List<String> symptoms = reader.getSymptoms();
        Map<String, Integer> countedSymptoms = analyticsCounter.countSymptoms(symptoms);
        Map<String,Integer> sortedSymptoms = analyticsCounter.sortSymptoms(countedSymptoms);

        // Écriture des symptômes triés et comptés dans le fichier de sortie.
        analyticsCounter.writeSymptoms(sortedSymptoms);
    }
}
