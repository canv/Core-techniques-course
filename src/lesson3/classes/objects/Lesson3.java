package lesson3.classes.objects;


public class Lesson3 {
    public static void main(String[] args) {
        Human warrior = new Human()
                .withNickname("TAN41K")
                .withHealth(15)
                .withManna(0);

        Human warriorCopy = new Human()
                .withNickname("TAN41K")
                .withHealth(15)
                .withManna(0);

        Human mag1 = new Human()
                .withNickname("YOKO")
                .withHealth(6)
                .withManna(22);



// 1) Отобразить информацию о классе через консольный вывод
        System.out.println(warrior);
        System.out.println(mag1);
        /*
            Отображение возможно благодаря переопределению метода toString
        */

// 2) Почему (warrior == warriorCopy) false? Хотя на вид они одинаковые.
        System.out.println(warrior == warriorCopy);
        System.out.println(warrior.equals(warriorCopy));
        /*
            Потому что оператор '==' сравнивает только ссылки на объекты
          Для корректного сравнения разроботчик сам должен решить какие
          данные в объекте должны сравниватся между собой, а какие нет.
            В нашем случае для нас достаточно сравнение полей 'nickname',
          'health' и 'manna' для общего вывода об эквивалентности объектов
          и поэтому мы можем переопределить метод equals() и воспользоватся
          им при сравнении.
        */

// 3) Сделать структуру односвязного списка LinkedList
//      сделать метод add() и get(по индексу)

        MyLinkedList<Human> army = new MyLinkedList<>();

        army.addElement(warrior);
        army.addElement(warriorCopy);
        army.addElement(mag1);

        System.out.println(army.getElement(2));
        System.out.println(army.getElement(1));
        System.out.println(army.getElement(0));
    }
}