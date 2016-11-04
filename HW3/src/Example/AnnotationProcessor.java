package Example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by Yoko on 30.10.2016.
 */
public class AnnotationProcessor {
    public static void main(String[] args) throws IOException {
      /*  BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        String stringKeyboard = reader.readLine();*/
    inspectService(SimpleService.class);
    inspectService(LazyService.class);


    }

    static void inspectService(Class<?> service) {
        Method[] methods = service.getDeclaredMethods();
            for (int i = 0; i < methods.length; i++) {
                Init annInit = service.getAnnotation(Init.class);
                System.out.println(methods);
            } System.out.println("Не нашел");
    }
}
