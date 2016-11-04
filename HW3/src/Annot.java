import Example.Init;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Annot{
    public volatile int scet = 100;

    public static void main(String[] args) throws IOException {
        System.out.println("В программе есть аннотации: Добавить, Удалить.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String keyboardsSymbols = reader.readLine();
        inspectService(Annot.class);

    }
    static void inspectService(Class<?> service) {
        Method[] methods = Annot.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MyAnnotation.class))
             try {
                 Class c = Annot.class;
                 method.invoke(c);
             } catch (InvocationTargetException e) {
                 e.printStackTrace();
             } catch (IllegalAccessException e) {
                 e.printStackTrace();
             }
        }
    }

    @MyAnnotation(name = "Добавить")
    private void methodAddSto() {
        scet+=100;
    }
    @MyAnnotation(name = "Добавить")
    private void methodAddDvesti() {
        scet+=200;
    }
    @MyAnnotation(name = "Добавить")
    private void methodAddTristo() {
        scet+=300;
    }
    @MyAnnotation(name = "Удалить")
    private void methodDeleteTristo() {
        scet-=300;
    }
    @MyAnnotation(name = "Удалить")
    private  void methodDeletePetdisyat() {
        scet-=50;
    }


    /*@Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface Delete {
        String name();
    }*/
}
