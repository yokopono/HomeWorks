import java.util.ArrayList;
import java.util.List;

public class Sklad {
    public static void main(String[] args) {
        Tovar water = new Tovar("Water", 100, 300, "Прозрачная");
        Tovar bread = new Tovar("Bread", 20, 200, "Серый");
        Tovar salt = new Tovar("Salt", 300, 70,"Белый");
        Tovar oil = new Tovar("Oil", 60, 100, "Желтый");
        Tovar oil2 = new Tovar("Oil2", 69, 199, "Желтый");
        Tovar oil3 = new Tovar("Oil2", 69, 199, "Желтый");

        List<Tovar> listOfTovars = new ArrayList<>();
        listOfTovars.add(water);
        listOfTovars.add(bread);
        listOfTovars.add(salt);
        listOfTovars.add(oil);
        listOfTovars.add(oil2);
        listOfTovars.add(oil3);
        getListOfTovars(listOfTovars);
        getCountTovar(listOfTovars);
        getSrednyiVes(listOfTovars);
        getColorTovar(listOfTovars);
    }

    public static void getListOfTovars(List<Tovar> list) {
        for (Tovar tovar : list) {
            System.out.println(tovar.name);
        }
    }

    public static void getCountTovar(List<Tovar> list) {
        int count = 0;
        for (Tovar tovar : list) {
            count++;
        }
        System.out.println(count);
    }

    public static void getSrednyiVes(List<Tovar> list) {
        int count = 0;
        int allWeights = 0;
        for (Tovar tovar : list) {
            count++;
            allWeights += tovar.weight;
        }

    }

    public static void getColorTovar(List<Tovar> list) {
        int count = 1;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); ) {
                if (list.get(i).color.equals(list.get(j).color) && i != j) {
                    count++;
                    list.remove(j);
                } else {
                    j++;
                }
            }
            System.out.println(list.get(i).color + " v kolichestve " + count + " shtuk.");
            count = 1;
        }
    }
}


/*
5) Написать структуру классов для магазина электроники. Предполагается иметь товары разных
        типов с общими свойствами (цена, вес, цвет..). Написать отдельный класс "Склад", который хранит у себя массив товаров.
         У него должны быть методы для получения списка товаров, количества товаров, среднего
        веса всех товаров и получения статистики по цветам товаров (например "красный - 1шт, синий - 2шт")*/
