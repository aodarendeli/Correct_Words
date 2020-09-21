/*
 Zemberek kütüphanesini kullanarak kelimelerdeki yazım yanlışlarını düzelten program.
 */
package com.darendeliozgur.deneme;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import zemberek.morphology.TurkishMorphology;
import zemberek.morphology.analysis.SingleAnalysis;
import zemberek.morphology.analysis.WordAnalysis;
import zemberek.normalization.TurkishSentenceNormalizer;

/**
 *
 * @author Özgür
 */
public class NewMain {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
         BufferedReader inputStream = null;
       /* String[] examples = {
        "Yrn okua gidicem kro kıro krosin olm sen kıroo",
        "Tmm, yarin havuza giricem ve aksama kadar yaticam :)",
        "ah aynen ya annemde fark ettı siz evinizden cıkmayın diyo",
        "gercek mı bu? Yuh! Artık unutulması bile beklenmiyo",
        "Hayır hayat telaşm olmasa alacam buraları gökdelen dikicem.",
        "yok hocam kesınlıkle oyle birşey yok",
        "herseyi soyle hayatında olmaması gerek bence boyle ınsanların falan baskı yapıyosa",
        "büttttttüüüünnnn  tama ynna"
    };*/
   Path zemberekDataRoot = Paths.get("D:/Ozgur/Documents/NetBeansProjects/deneme");
  Path lookupRoot = zemberekDataRoot.resolve("normalization");
  Path lmFile = zemberekDataRoot.resolve("lm/lm.2gram.slm");
  TurkishMorphology morphology = TurkishMorphology.createWithDefaults();
  TurkishSentenceNormalizer normalizer = new TurkishSentenceNormalizer(morphology, lookupRoot, lmFile);
  inputStream = new BufferedReader(new FileReader("D:/Ozgur/Desktop/a.txt"));
  String filename="D:/Ozgur/Desktop/pozitif.txt";
  PrintWriter outputStream=new PrintWriter(filename);
            String data;
              while ((data = inputStream.readLine()) != null) {
				outputStream.println(normalizer.normalize(data));  
                                outputStream.println();
           }
              outputStream.close();
 /* for (String example : examples) {
      System.out.println(example);
      System.out.println(normalizer.normalize(example));
      System.out.println();
    }*/
} 
} 

    
    

