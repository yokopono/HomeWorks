import java.io.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Language {
    static String path;

    public static void main(String[] args) throws IOException {
        read();
    }

    public static void read() throws IOException {
        System.out.println("Введи название языка");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            path = reader.readLine();
            Properties property = new Properties();
            FileReader fileReader = new FileReader(path + ".properties");
            property.load(fileReader);
            HashMap<String, String> hMap = new HashMap<>();

            for (final String name : property.stringPropertyNames()){
                hMap.put(name, property.getProperty(name));
            }
            int count = 0;
            int count2 = 0;

            for (Map.Entry<String,String> pair: hMap.entrySet()) {
                System.out.println(pair.getKey());
                String s = reader.readLine().toLowerCase();
                if (s.equals(pair.getValue())) {
                    System.out.println("Верно");
                    count++;
                } else if (s.toLowerCase().equals("exit")) {
                    break;
                } else {
                    System.out.println("Не верно");
                    count2++;
                }
            }
            System.out.println("Количество верных ответов: " + count + ", Неверных: " + count2);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден, введи ещё раз");
            read();
        }
    }
}
