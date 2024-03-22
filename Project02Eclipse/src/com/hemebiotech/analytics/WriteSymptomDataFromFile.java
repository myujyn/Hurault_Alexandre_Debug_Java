package com.hemebiotech.analytics;

import javax.sound.sampled.Line;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Map;
import java.io.IOException;
import java.util.List;

public class WriteSymptomDataFromFile implements ISymptomWriter {
// Variable destinée à stocker le chemin du fichier de sortie où les données seront écrites
    private String outputPath;

//Constructeur de la classe,  prend un paramètre outputPath de type String, qui est utilisé pour initialiser la variable membre outputPath.
//Ce paramètre permet à l'utilisateur de la classe de spécifier le chemin du fichier de sortie lors de la création d'une instance de WriteSymptomDataFromFile.
    public WriteSymptomDataFromFile(String outputPath) {

        this.outputPath = outputPath;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        // Déclare une variable "writer" de type BuffereWriter et l'initialise à nul.
        BufferedWriter writer = null;
        // Bloc try est utilisé pour envelopper le code qui pourrait générer une exception, comme des opérations d'entrée/sortie (I/O)
        try {
            // Initialise writer avec une instance BufferedWriter
            // Cette instance est créée en passant un nouvel objet FileWriter initialisé avec outputPath contenant le chemin de sortie
            // FileWriter permet d'écrire des caractères dans un fichier
            writer = new BufferedWriter(new FileWriter(outputPath));
            // Boucle for each qui itère sur l'ensemble des entrées de la map "symptoms"
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                // Ecris dans un fichier une ligne de texte pour chaque entrée de la map, soit chaque symptome
                // Cela se décompose comme suit : Symptomes (clé) ":" Nombre d'occurences du symptome (valeur)
                writer.write(entry.getKey() + ": " + entry.getValue());
                // Ajouter un saut de ligne après chaque nouvelle entrée
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            // Permet de gérer les exceptions en conservant une trace
            e.printStackTrace();
        }
    }
}