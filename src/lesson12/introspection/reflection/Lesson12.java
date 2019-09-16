package lesson12.introspection.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Lesson12 {
    public static void main(String[] args) throws Exception {
// 1) Инстанциировать параметризированный коструктор через рефлексию
        Class<?> cityClass = Class.forName("lesson12.introspection.reflection.City");

        Class[] secondConstructorParams = {String.class, int.class, double.class, String.class, long.class};
        Constructor<?> cityConstructor = cityClass.getDeclaredConstructor(secondConstructorParams);

        cityConstructor.setAccessible(true);

        Object[] secondConstructorArgs = {"testName", 1111, 11.11d, "testTimeZone", 1110L};
        Object objCity = cityConstructor.newInstance(secondConstructorArgs);

// 2) Вызвать перегруженные методы.
        Method getPopulationPerSquareOne = cityClass.getDeclaredMethod("populationPerSquare");
        System.out.println(getPopulationPerSquareOne.invoke(objCity));

        Class[] methodParams = {int.class, double.class};
        Method getPopulationPerSquareTwo = cityClass.getDeclaredMethod("populationPerSquare", methodParams);

        Object[] methodArgs = {100, 5.0d};
        System.out.println(getPopulationPerSquareTwo.invoke(objCity,methodArgs));

// 3) Проинициализировать поля через сетторы из файла на диске
        CityReader cityReader = new CityReader(fileAddress());
        cityReader.loader();

        Class[] nameParam = {String.class};
        Method setName = cityClass.getMethod("setName", nameParam);
        setName.invoke(objCity,cityReader.getRealName());

        Class[] sinceParam = {int.class};
        Method setSince = cityClass.getMethod("setSince", sinceParam);
        setSince.invoke(objCity,cityReader.getRealSince());

        Class[] areaParam = {double.class};
        Method setArea = cityClass.getDeclaredMethod("setArea", areaParam);
        setArea.invoke(objCity,cityReader.getRealArea());

        Class[] timeZoneParam = {String.class};
        Method setTimeZone = cityClass.getDeclaredMethod("setTimeZone", timeZoneParam);
        setTimeZone.invoke(objCity,cityReader.getRealTimeZone());

        Class[] populationParam = {long.class};
        Method setPopulation = cityClass.getDeclaredMethod("setPopulation", populationParam);
        setPopulation.invoke(objCity,cityReader.getRealPopulation());

// 4) Показать результат инициализации
        System.out.println(objCity);
    }

    private static String fileAddress() {
        return "C:\\Users\\Admin\\IdeaProjects" +
                "\\AlexeyCourse\\src\\lesson12" +
                "\\introspection\\reflection\\lesson12.txt";
    }
}