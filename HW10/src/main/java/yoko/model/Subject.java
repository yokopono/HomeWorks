package yoko.model;

/**
 * Created by Yoko on 20.11.2016.
 */
public enum Subject {

    ECONOMY("Экономика"),
    MATH("Математика"),
    INFORMATIC("Информатика"),
    Philosophy("Философия"),
    SCIENCE("Наука"),
    POLITICS("Политика");
    String description;

    Subject(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
