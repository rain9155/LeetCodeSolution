import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        Class<?> stringClass1 = Class.forName("java.lang.String");
        Class<String> stringClass2 = String.class;
        Class<?> stringClass3 = new String().getClass();

    }





}
