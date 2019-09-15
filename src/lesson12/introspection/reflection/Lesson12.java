package lesson12.introspection.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Lesson12 {
    public static void main(String[] args) throws Exception {
// 1) Инстанциировать параметризированный коструктор через рефлексию
        Class<?> cityClass = Class.forName("lesson12.introspection.reflection.City");

        Class[] constructorParams = {String.class, int.class, double.class, String.class, long.class};
        Constructor<?> cityConstructor = cityClass.getDeclaredConstructor(constructorParams);

        cityConstructor.setAccessible(true);
        Object[] constructorArgs = {"testName", 1212, 12.12d, "testTimeZone", 1234L};
        Object testCity = cityConstructor.newInstance(constructorArgs);

        Field cityName = cityClass.getDeclaredField("name");

// 2) Вызвать перегруженные методы.
        Method getPopulationPerSquareOne = cityClass.getDeclaredMethod("populationPerSquare");
        System.out.println(getPopulationPerSquareOne.invoke(testCity));

        Class[] methodParams = {int.class, double.class};
        Method getPopulationPerSquareTwo = cityClass.getDeclaredMethod("populationPerSquare", methodParams);

        Object[] methodArgs = {100, 5.0d};
        System.out.println(getPopulationPerSquareTwo.invoke(testCity,methodArgs));

// 3) Проинициализировать поля через сетторы из файла на диске

//        cityName.setAccessible(true);
//
//
//        System.out.println(cityName.get(testCity));
//
//
//        City.CityBuilder cb = new City.CityBuilder();
//        City cc = cb
//                .withName("cbName")
//                .withSince(4321)
//                .withArea(77.77d)
//                .withTimeZone("+32323")
//                .withPopulation(12L).build();
//
//        System.out.println(cc.getTimeZone());

// 4) Вызвать эти проинициализированные поля через гетторы
    }
}