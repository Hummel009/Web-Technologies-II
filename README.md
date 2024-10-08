[![Code Smells][code_smells_badge]][code_smells_link]
[![Maintainability Rating][maintainability_rating_badge]][maintainability_rating_link]
[![Security Rating][security_rating_badge]][security_rating_link]
[![Bugs][bugs_badge]][bugs_link]
[![Vulnerabilities][vulnerabilities_badge]][vulnerabilities_link]
[![Duplicated Lines (%)][duplicated_lines_density_badge]][duplicated_lines_density_link]
[![Reliability Rating][reliability_rating_badge]][reliability_rating_link]
[![Quality Gate Status][quality_gate_status_badge]][quality_gate_status_link]
[![Technical Debt][technical_debt_badge]][technical_debt_link]
[![Lines of Code][lines_of_code_badge]][lines_of_code_link]

Мои лабораторные работы для BSUIR/БГУИР (белорусский государственный университет информатики и радиоэлектроники).

Предмет - WT/ВТ (веб-технологии).

## Условия

### Лабораторная работа 1

#### Задание 1

* Вычислить значение выражения по формуле (все переменные принимают действительные значения).
* Для модульного тестирования приложения разработайте JUnit-тесты.

#### Задание 2

* Для данной области составить программу, котораяпечатает true, если точка с координатами (х, у) принадлежит закрашенной
  области, и false — в противном случае.
* Для модульного тестирования приложения разработайте JUnit-тесты.

#### Задание 3

* Составить программу для вычисления значений функции `F(x) = tan(x)` на отрезке [а, b] с шагом h. Результат представить
  в виде таблицы, первый столбец которой – значения аргумента, второй - соответствующие значения функции.
* Для модульного тестирования приложения разработайте JUnit-тесты.

#### Задание 4

* Задан целочисленный массив размерности N. Определить, есть ли среди элементов массива простые числа. Если да, то
  вывести номера этих элементов.
* Для модульного тестирования приложения разработайте JUnit-тесты.

#### Задание 5

* Дана целочисленная таблица А[n]. Найти наименьшее число K элементов, которые можно выкинуть из данной
  последовательности, так чтобы осталась возрастающая подпоследовательность.
* Для модульного тестирования приложения разработайте JUnit-тесты.

#### Задание 6

* Даны действительные числа a1, a2, …, an. Получить следующую квадратную матрицу порядка n.
* Для модульного тестирования приложения разработайте JUnit-тесты.

#### Задание 7

* Дан массив n действительных чисел. Требуется упорядочить его по возрастанию. Делается это следующим образом:
  сравниваются два соседних элемента ai и ai+1 . Если ai <= ai+1, то продвигаются на один элемент вперед. Если ai >
  ai+1, то производится перестановка и сдвигаются на один элемент назад. Составить алгоритм этой сортировки.
* Для модульного тестирования приложения разработайте JUnit-тесты.

#### Задание 8

* Пусть даны две неубывающие последовательности действительных чисел a1 <= a2 <= … <=an и b1 <= b2 <= … <= bm. Требуется
  указать те места, на которые нужно вставлять элементы последовательности b1 <= b2 <= … <= bm в первую
  последовательность так, чтобы новая последовательность оставалась возрастающей.
* Для модульного тестирования приложения разработайте JUnit-тесты.

#### Задание 9

* Создать класс Мяч. Создать класс Корзина. Наполнить корзину мячиками. Определить вес мячиков в корзине и количество
  синих мячиков.
* Для модульного тестирования приложения создать JUnit-тесты.

#### Задание 10

Скомпилировать и запустить приложение, созданное при решении задачи 9 из командной строки.

#### Задание 11

Создать запускной jar-файл и запустить приложение, созданное при решении задачи 9.

#### Задание 12

Не пользуясь средствами автогенерации кода переопределить для класса Book методы equals(), hashCode() и toString().

#### Задание 13

Не пользуясь средствами автогенерации кода переопределить для класса ProgrammerBook методы equals(), hashCode() и
toString().

#### Задание 14

* Не пользуясь средствами автогенерации кода переопределить для класса Book из задачи 12 метод clone().
* Напишите тесты JUnit, проверяющие корректность клонирования.

#### Задание 15

* Реализовать интерфейс Comparable.
* Добавьте в класс Book из задачи 12 поле isbn. Реализуйте в классе Book интерфейс Comparable так, чтобы книги приобрели
  сортировку по умолчанию согласно номеру isbn.
* Напишите тесты JUnit, проверяющие корректность сортировки.

#### Задание 16

* Реализовать интерфейс Comparator.
* Реализуйте для класса Book из задачи 12 компараторы, позволяющие сортировать книги по названию; по названию, а потом
  по автору; по автору, а потом по названию; по автору, названию и цене.
* Напишите тесты JUnit, проверяющие корректность сортировок.

### Лабораторная работа 2

Тема работы: "Интернет-магазин". Образец функционала:

* Администратор осуществляет ведение каталога товаров.
* Клиент формирует и оплачивает заказ.
* Администратор управляет клиентами: предоставляет скидки, купоны, ставит баны.

Общий образец функционала:

* Вход и выход в/из системы.
* Регистрация пользователя или добавление артефакта предметной области системы.
* Просмотр информации (например: просмотр всех курсов, имеющихся кредитных карт, счетов и т.д.)
* Удаление информации (например: отмена заказа, медицинского назначения, отказ от курса обучения и т.д.)
* Добавление и модификация информации (например: создать и отредактировать курс, создать и отредактировать заказ и т.д.)

Технические требования:

* Приложение реализовать применяя технологии Servlet и JSP.
* Архитектура приложения должна соответствовать шаблонам Layered architecture и Model-View-Controller.
* Информация о предметной области должна хранится в БД:
    * Данные в базе хранятся на кириллице, рекомендуется применять кодировку UTF-8.
    * Технология доступа к БД – JDBC (только JDBC).
    * Для работы с БД в приложении должен быть реализован пул соединений.
    * При проектировании БД рекомендуется не использовать более 6-8 таблиц.
* Интерфейс приложения должен быть локализован; выбор из двух или более языков: (английский, белорусский, и т д.).
* Приложение должно корректно обрабатывать возникающие исключительные ситуации, в том числе вести их логи. В качестве
  логгера использовать Log4J или SLF4J.
* Классы и другие сущности приложения должны быть грамотно структурированы по пакетам и иметь отражающую их
  функциональность название.

Общие требования:

* При реализации бизнес-логики приложения следует при необходимости использовать шаблоны проектирования (например,
  шаблоны GoF: Factory Method, Command, Builder, Strategy, State, Observer, Singleton, Proxy etc), а также необходимо
  избегать процедурного стиля программирования.
* Для хранения пользовательской информации между запросами использовать сессию.
* Для перехвата и корректировки (при необходимости) объектов запроса (request) и ответа (response) применить фильтры.
* При реализации страниц JSP следует использовать теги библиотеки JSTL, использовать скриплеты запрещено. Просмотр
  “длинных списков” желательно
  организовывать в постраничном режиме.
* Валидацию входных данных производить на клиенте и на сервере.
* Документацию к проекту необходимо оформить согласно требованиям javadoc.
* Оформление кода должно соответствовать Java Code Convention.
* Рекомендуется использовать технологию Maven.
* Приложение должно содержать JUnit-тесты (метрики на усмотрение студента).

### Лабораторная работа 3

> [!IMPORTANT]  
> После открытия проекта в IntelliJ IDEA, чтобы не было 404, в Run Configurations нужно указать
> в качестве Working-directory "appLab3"

* Приложение реализовать применяя технологии Spring Core, Spring MVC, Hibernate.
* Конфигурация может задаваться в xml-файлах, через Java-конфигурацию. Использовать аннотации разрешено.
* Архитектура приложения должна соответствовать шаблонам Layered architecture и Model-View-Controller.
* Информация о предметной области должна хранится в БД:
    * Данные в базе хранятся на кириллице;
    * Технология доступа к БД – Hibernate;
    * Для работы с БД в приложении должен быть использован любой встроенный пул соединений;
* Опционально: интерфейс приложения должен быть локализован; выбор из двух или более языков: (английский, белорусский, и
  т д.).
* Опционально: для авторизации и аутентификации можно применить Spring Security.
* Классы и другие сущности приложения должны быть грамотно структурированы по пакетам и иметь отражающую их
  функциональность название.

<!----------------------------------------------------------------------------->

[code_smells_badge]: https://sonarcloud.io/api/project_badges/measure?project=Hummel009_Web-Technologies-II&metric=code_smells

[code_smells_link]: https://sonarcloud.io/summary/overall?id=Hummel009_Web-Technologies-II

[maintainability_rating_badge]: https://sonarcloud.io/api/project_badges/measure?project=Hummel009_Web-Technologies-II&metric=sqale_rating

[maintainability_rating_link]: https://sonarcloud.io/summary/overall?id=Hummel009_Web-Technologies-II

[security_rating_badge]: https://sonarcloud.io/api/project_badges/measure?project=Hummel009_Web-Technologies-II&metric=security_rating

[security_rating_link]: https://sonarcloud.io/summary/overall?id=Hummel009_Web-Technologies-II

[bugs_badge]: https://sonarcloud.io/api/project_badges/measure?project=Hummel009_Web-Technologies-II&metric=bugs

[bugs_link]: https://sonarcloud.io/summary/overall?id=Hummel009_Web-Technologies-II

[vulnerabilities_badge]: https://sonarcloud.io/api/project_badges/measure?project=Hummel009_Web-Technologies-II&metric=vulnerabilities

[vulnerabilities_link]: https://sonarcloud.io/summary/overall?id=Hummel009_Web-Technologies-II

[duplicated_lines_density_badge]: https://sonarcloud.io/api/project_badges/measure?project=Hummel009_Web-Technologies-II&metric=duplicated_lines_density

[duplicated_lines_density_link]: https://sonarcloud.io/summary/overall?id=Hummel009_Web-Technologies-II

[reliability_rating_badge]: https://sonarcloud.io/api/project_badges/measure?project=Hummel009_Web-Technologies-II&metric=reliability_rating

[reliability_rating_link]: https://sonarcloud.io/summary/overall?id=Hummel009_Web-Technologies-II

[quality_gate_status_badge]: https://sonarcloud.io/api/project_badges/measure?project=Hummel009_Web-Technologies-II&metric=alert_status

[quality_gate_status_link]: https://sonarcloud.io/summary/overall?id=Hummel009_Web-Technologies-II

[technical_debt_badge]: https://sonarcloud.io/api/project_badges/measure?project=Hummel009_Web-Technologies-II&metric=sqale_index

[technical_debt_link]: https://sonarcloud.io/summary/overall?id=Hummel009_Web-Technologies-II

[lines_of_code_badge]: https://sonarcloud.io/api/project_badges/measure?project=Hummel009_Web-Technologies-II&metric=ncloc

[lines_of_code_link]: https://sonarcloud.io/summary/overall?id=Hummel009_Web-Technologies-II
