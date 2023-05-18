package pro.sky.java.course1.coursework;

public class Main {
    private static final EmployeeBook employeeBook = new EmployeeBook();

    public static void main(String[] args) {
        employeeBook.addEmployee("Захаров Марк Никитич", 1, 15_000);
        employeeBook.addEmployee("Нефедова София Германовна", 2, 50_000);
        employeeBook.addEmployee("Дементьев Алексей Захарович", 3, 30_000);
        employeeBook.addEmployee("Левин Александр Кириллович", 4, 20_000);
        employeeBook.addEmployee("Михайлова Майя Александровна", 5, 70_000);
        employeeBook.addEmployee("Попова Майя Дмитриевна", 5, 80_000);
        employeeBook.addEmployee("Мещерякова Злата Артёмовна", 4, 60_000);
        employeeBook.addEmployee("Федоров Дмитрий Константинович", 3, 40_000);
        employeeBook.addEmployee("Гаврилов Георгий Даниилович", 2, 35_000);
        employeeBook.addEmployee("Яковлева Мадина Марсельевна", 1, 90_000);
    }
//                                                Базовая сложность
//    a. Получить список всех сотрудников со всеми имеющимися по ним данными (вывести в консоль значения всех полей (toString)).
    private static void task1() {
        employeeBook.printEmployee();
    }

//    b. Посчитать сумму затрат на зарплаты в месяц.
    private static void task2() {
        double amount = employeeBook.calculateAmountEmployee();
        System.out.println("Сумма затрат на зарплаты в месяц " + amount);
    }

//    c. Найти сотрудника с минимальной зарплатой.
    private static void task3() {
        employeeBook.printEmployeeMinSalary();
    }

//    d. Найти сотрудника с максимальной зарплатой.
    private static void task4() {
        employeeBook.printEmployeeMaxSalary();
    }

//    e. Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b).
    private static void task5() {
        double average = employeeBook.calculateAverageSalary();
        System.out.println("Среднее значение зарплат " + average);
    }

//    f. Получить Ф. И. О. всех сотрудников (вывести в консоль).
    private static void task6() {
        employeeBook.printEmployeeFio();
    }

//                                         Повышенная сложность
//    1. Проиндексировать зарплату (вызвать изменение зарплат у всех сотрудников на величину аргумента в %).
    private static void task7() {
        double percent = 15;
        employeeBook.indexingSalary(percent);
    }

//    2. Получить в качестве параметра номер отдела (1–5) и найти (всего 6 методов):
//        a. Сотрудника с минимальной зарплатой.
//        b. Сотрудника с максимальной зарплатой.
//        c. Сумму затрат на зарплату по отделу.
//        d. Среднюю зарплату по отделу (учесть, что количество людей в отделе отличается от employees.length).
//        e. Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра.
//        f. Напечатать всех сотрудников отдела (все данные, кроме отдела).
    private static void task8() {
        int department = 5;
        double percent = 20;
        Employee[] employeesDepartment = employeeBook.searchByDepartment(department);
        System.out.println("Сотрудники " + department + "-го отдела с минимальной и максимальной зарплатой:");
        employeeBook.printEmployeeMinSalaryDepartment(employeesDepartment);
        employeeBook.printEmployeeMaxSalaryDepartment(employeesDepartment);
        System.out.println();
        double amount = employeeBook.calculateAmountEmployeeDepartment(employeesDepartment);
        System.out.println("Сумма затрат на зарплаты в мецяс в " + department + "-м отделе " + amount);
        System.out.println();
        double average = employeeBook.calculateAverageSalaryDepartment(employeesDepartment);
        System.out.println("Среднее значение зарпалат в " + department + "-м отделе " + average);
        employeeBook.indexingSalaryDepartment(department, percent);
        System.out.println();
        System.out.println("Сотрудники " + department + "-го отдела:");
        employeeBook.printDepartment(department);
    }

//    3. Получить в качестве параметра число и найти:
//        a. Всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль).
//        b. Всех сотрудников с зарплатой больше (или равно) числа (вывести id, Ф. И. О. и зарплатой в консоль).
    private static void task9() {
        int number = 45_000;
        Employee[] lessSalary = employeeBook.compareLessSalary(number);
        Employee[] moreSalary = employeeBook.compareMoreSalary(number);
        System.out.println("Сотрудники с зарплатой меньше " + number + ":");
        employeeBook.printIdEmployeeFioSalary(lessSalary);
        System.out.println();
        System.out.println("Сотрудники с зарплатой больше (или равно) " + number + ":");
        employeeBook.printIdEmployeeFioSalary(moreSalary);
    }

//                                               Очень сложно
//    4. Добавить несколько новых методов:
//        a. Добавить нового сотрудника (создаем объект, заполняем поля, кладем в массив).
//           Нужно найти свободную ячейку в массиве и добавить нового сотрудника в нее.
//           Искать нужно всегда с начала, так как возможно добавление в ячейку удаленных ранее сотрудников.
//        b. Удалить сотрудника (находим сотрудника по Ф. И. О. и/или id, обнуляем его ячейку в массиве).
    private static void task10() {
        employeeBook.removeEmployee(1);
    }

//    5. Изменить сотрудника (получить сотрудника по Ф. И. О., модернизировать его запись):
//        a.Изменить зарплату.
//        b. Изменить отдел.
    private static void task11() {
        employeeBook.setSalary("Мещерякова Злата Артёмовна", 100_000);
        employeeBook.setDepartment("Нефедова София Германовна", 5);
    }

    //    6. Получить Ф. И. О. всех сотрудников по отделам (напечатать список отделов и их сотрудников).
    private static void task12() {
        employeeBook.printDepartmentEmployee();
    }
}