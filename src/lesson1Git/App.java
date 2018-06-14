package lesson1Git;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        //получение объекта Class<>

        //1 способ
        //создать объект
        ChessFigure chessFigure = new ChessFigure();
        Class classOfFigure = chessFigure.getClass();

        //2 способ
        //использ literal
        Class secondClassOfFigure = ChessFigure.class;

        //final Field[] fields = classOfFigure.getFields();//- только публичные
        final Field[] fields = classOfFigure.getDeclaredFields();//- все
        System.out.println("Fields of class ChessFigure");
        for (Field field: fields){
            System.out.println(field.getName());
        }

        Field nameField = classOfFigure.getDeclaredField("name");
        nameField.setAccessible(true);
        System.out.println("before = "+chessFigure );
        nameField.set(chessFigure, "Queen");
        System.out.println("after = "+chessFigure);

        Method privateMethod = classOfFigure.getDeclaredMethod("remove", String.class);
        privateMethod.setAccessible(true);
        privateMethod.invoke(chessFigure, "Hello");

        ChessFigure figure2 = (ChessFigure) classOfFigure.newInstance();
        final Constructor constructor = classOfFigure.getDeclaredConstructor();
        final Object  o = constructor.newInstance();
    }
}
