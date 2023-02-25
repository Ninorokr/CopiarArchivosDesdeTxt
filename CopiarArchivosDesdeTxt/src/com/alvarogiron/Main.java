package com.alvarogiron;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<String> contrastes = new ArrayList<>();
    static ArrayList<String> suministros = new ArrayList<>();

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("D:\\contrastes.txt"));
            Scanner scanner2 = new Scanner(new File("D:\\suministros.txt"));
            while (scanner.hasNextLine()) {
                //System.out.println(scanner.nextLine());
                contrastes.add(scanner.nextLine());
                suministros.add(scanner2.nextLine());
            }
            scanner.close();
            scanner2.close();

            for(int i = 0; i < contrastes.size(); i++) {
                String contraste = contrastes.get(i);
                String OS = contraste.substring(0,7);
                String ruta = "\\\\192.168.1.2\\img\\2023\\ENE\\ENDESA\\33333333333\\" + OS + "\\" + contraste + ".gif";
                try {
                    copyFileUsingJava(new File(ruta), new File("D:\\Muestra\\SUM " + suministros.get(i) + ".gif"));
                    System.out.println(i+1 + ". Se copió " + contraste + ".gif en D:\\Muestra\\");
                } catch (IOException ex) {
//                    System.out.println(ex);
                    System.out.println("No se ubicó " + contraste);
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
