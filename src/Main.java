import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String args[]) {
        Class class1 = Reflection.class;
        System.out.println(class1);

        Reflection produto = new Reflection();
        Class class2 = produto.getClass();
        System.out.println(class2);

        try {
            Constructor cons = class1.getConstructor();
            Reflection reflection1 = (Reflection) cons.newInstance();
            System.out.println(cons);
            System.out.println(reflection1);

            Field[] fields = reflection1.getClass().getDeclaredFields();
            for (Field field : fields) {
                Class<?> type = field.getType();
                String nome = field.getName();
                System.out.println(type);
                System.out.println(nome);
            }

            Method[] Method = reflection1.getClass().getDeclaredMethods();
            for (Method m : Method) {
                Class<?> type = m.getReturnType();
                String nome = m.getName();
                System.out.println(type);
                System.out.println(nome);

                if (m.getName().startsWith("get")) {
                    System.out.println(m.invoke(reflection1));
                } else {
                    for (Class classesTypes : m.getParameterTypes()) {
                        if (classesTypes.equals(String.class)) {
                            System.out.println(m.invoke(reflection1, "Daniel"));
                        } else if (classesTypes.equals(Long.class)) {
                            System.out.println(m.invoke(reflection1, 1l));
                        } else {
                            System.out.println(m.invoke(reflection1, 2d));
                        }
                    }

                }
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}


