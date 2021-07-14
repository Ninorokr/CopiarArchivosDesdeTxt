package com.alvarogiron;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<String> rutas = new ArrayList<>();
    static ArrayList<String> nomArchivo = new ArrayList<>();

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("D:/cargos.txt"));
            Scanner scanner2 = new Scanner(new File("D:/nrosCaso.txt"));
            while (scanner.hasNextLine()) {
                //System.out.println(scanner.nextLine());
                rutas.add(scanner.nextLine());
                nomArchivo.add(scanner2.nextLine());
            }
            scanner.close();
            for(int i = 0; i < rutas.size(); i++) {
                try {
                    copyFileUsingJava(new File(rutas.get(i)), new File("D:/Solicitados2/" + nomArchivo.get(i) + ".pdf"));
                    System.out.println(i+1 + ". Se copió " + nomArchivo.get(i) + ".pdf en D:/Solicitados2/");
                } catch (IOException ex) {
                    System.out.println(ex.toString());
                }
            }
            //System.out.println(rutas.get(3));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void copyFileUsingJava(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath());
    }
}
