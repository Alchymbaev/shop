Написать программу получения товарного чека.  В классе Main
1.  Доброе пожаловать
2.  Выберите категорию продуктов
Метод вывода всех категорий продуктов( Молочные, Алкоголь и тд)
3.  С помощью сканера написать выбранную  категорию продукта
4.  Выберите продукты по категории
Метод вывода всех продуктов по выбранной ранее категории
5.  С помощью сканера написать выбранный продукт
Метод получения продукта по его названию
6.  Написать количество выбранного продукта
7.  Написать скидка если она есть, если нет написать 0. Скидка считается процентами
8.  Продолжаем? N нет, Y да.
9.  Y действия продолжаются с пункта 2
10.  N Написать логин кассира совершившего операцию
Метод получения кассира по его имени
11.  Заполнить Класс Order с полями Cashier, Details [].
Caschier класс с полями String name, login.
Details класс с полями Product product, double amount, int discount.
Product abstract class  с полями name, Measure, ProductCategory, double cost.
Measure enum (тип объема кг, литр, поштучно).
ProductCategory enum (категории продуктов выше описана)
12.  У вас должен быть цикл с пункта 2 до пункта 8
13.  Каждый выбранный продукт из метода 5 должен добавляться в массив Details далее этот Details будет в классе Order
14.  Методы вызываются с помощью интерфейса Operation, реализация которой происходит в классе OperationImpl.
15.  По несколько объектов продуктов, наследованных от класса Product должны быть объявлены в классе OperationImpl, также в этом классе объявите двух минимум кассиров по шаблону класса Cashier.


Залить проект в гит под мастер веткой
