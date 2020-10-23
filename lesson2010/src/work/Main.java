package work;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws IllegalArgumentException {
        try (BufferedReader fin = new BufferedReader(new FileReader(args[0], StandardCharsets.UTF_8))) {
            String line;
            int count = 0;
            while ((line = fin.readLine()) != null) {
                var arr = line.split("[^а-яА-Яa-zA-Z]+");
                count += arr.length;
            }
            System.out.println(count);
        } catch (IOException e){
            System.out.println("Ошибка открытия файла");
        }

    }
}

