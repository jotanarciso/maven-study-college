package com.jotanarciso;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
Exemplo simples de uso da API Apache Commons CVS
Extrair o arquivo commons-csv-1.7.jar para o diretorio do projeto
Para compilar no Windows: javac -cp .;.\commons-csv-1.7.jar App.java
Para compilar no Linux: javac -cp commons-csv-1.7.jar App.java
Para executar no windows: java -cp .;.\commons-csv-1.7.jar App
Para executar no Linux: java -cp .:commons-csv-1.7.jar App
Para executar: java -cp .;.\commons-csv-1.7.jar App.java
*/
public class App {
    private static final String SAMPLE_CSV_FILE_PATH = "src/main/java/com/jotanarciso/veiculos.dat";

    public static void main(String[] args) throws IOException {
        try (
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        ) {
            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                String placa = csvRecord.get(0);
                String marca = csvRecord.get(1);
                String cor = csvRecord.get(2);
                String categoria = csvRecord.get(3);

                System.out.println("Record No - " + csvRecord.getRecordNumber());
                System.out.println("---------------");
                System.out.println("Placa : " + placa);
                System.out.println("Marca : " + marca);
                System.out.println("Cor : " + cor);
                System.out.println("Categoria : " + categoria);
                System.out.println("---------------\n\n");
            }
        }
    }
}
