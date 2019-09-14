package lesson6.structures.hashmap;

public class Lesson6 {
    public static void main(String[] args) {

// 1) Сделать свой HashMap

        HashArray<String, String> test = new HashArray<>();

        test.put("hashKeyOne", "HashMapOne");
        test.put("التجزئةمفتاحاثنين", "HashMapTwo");
        test.put("מפתחשני", "HashMapThree");
        test.put("מפתחשני", "HashMapThree(Overwritten)");
        System.out.println(test.get("hashKeyOne"));
        System.out.println(test.get("التجزئةمفتاحاثنين"));
        System.out.println(test.get("מפתחשני"));
        /*
            Данная HashTable реализована на основе массива LinkedList'ов
          На вход подаётся пара ключ-значение где уникальный hashCode()
          ключа является индексом массива
        */

        test.put("AaAaAa", "hashKeyCollision(2/2)");
        test.put("AaAaBB", "hashKeyCollision(1/2)");
        System.out.println(test.get("AaAaBB"));
        System.out.println(test.get("AaAaAa"));
        /*
            Так же рассмотрены и обработаны коллизии.
          При совпадении hashCode() в список добавляется еще одна нода
          и в дальнейшем значение ищется по эквивалентности значения ключейключей
        */

        System.out.println(" ");

// 2) сделать Бинарное дерево поиска, так же с HashKey

        MyTreeMap<String, String> treeTest = new MyTreeMap<>();

        treeTest.put("treeKeyOne", "TreeMapOne");
        treeTest.put("treeKeyTwo", "TreeMapTwo");
        treeTest.put("treeKeyThree", "TreeMapThree");
        treeTest.put("treeKeyThree", "TreeMapThree(Overwritten)");
        System.out.println(treeTest.get("treeKeyOne"));
        System.out.println(treeTest.get("treeKeyTwo"));
        System.out.println(treeTest.get("treeKeyThree"));

        treeTest.put("AaAaBB", "treeMapCollision(1/2)");
        treeTest.put("AaAaAa", "treeMapCollision(2/2)");
        System.out.println(treeTest.get("AaAaBB"));
        System.out.println(treeTest.get("AaAaAa"));

// 3) special test 01.09.2019 19:01

        final HashArray<String, String> stringStringHashArray = new HashArray<>();
        stringStringHashArray.put("AaAa","One");
        stringStringHashArray.put("BBBB","Two");
        stringStringHashArray.put("AaBB","Three");
        stringStringHashArray.put("BBAa","Four");
        stringStringHashArray.put("AaAa","Five");

        System.out.println(stringStringHashArray.get("AaAa")); // Here should be Five!
        System.out.println(stringStringHashArray.get("BBBB"));
        System.out.println(stringStringHashArray.get("AaBB"));
        System.out.println(stringStringHashArray.get("BBAa"));
    }
}