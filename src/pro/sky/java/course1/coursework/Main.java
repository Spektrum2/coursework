package pro.sky.java.course1.coursework;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Захаров Марк Никитич", 1, 50_000);
        employees[1] = new Employee("Нефедова София Германовна", 2, 60_000);
        employees[2] = new Employee("Дементьев Алексей Захарович", 3, 30_000);
        employees[3] = new Employee("Левин Александр Кириллович", 4, 20_000);
        employees[4] = new Employee("Михайлова Майя Александровна", 5, 70_000);
        employees[5] = new Employee("Попова Майя Дмитриевна", 5, 80_000);
        employees[6] = new Employee("Мещерякова Злата Артёмовна", 4, 15_000);
        employees[7] = new Employee("Федоров Дмитрий Константинович", 3, 40_000);
        employees[8] = new Employee("Гаврилов Георгий Даниилович", 2, 35_000);
        employees[9] = new Employee("Яковлева Мадина Марсельевна", 1, 90_000);
        task5(employees);
    }

    private static void task1(Employee[] employees) {
        EmployeeService.printEmployee(employees);
    }

    private static void task2(Employee[] employees) {
        int amount = EmployeeService.calculateAmountEmployee(employees);
        System.out.println(amount);
    }

    private static void task3(Employee[] employees) {
        EmployeeService.printEmployeeMinSalary(employees);
    }

    private static void task4(Employee[] employees) {
        EmployeeService.printEmployeeMaxSalary(employees);
    }

    private static void task5(Employee[] employees) {
        int amount = EmployeeService.calculateAmountEmployee(employees);
        int average = EmployeeService.calculateAverageSalary(amount);
        System.out.println(average);
    }

    private static void task6(Employee[] employees) {
        EmployeeService.printEmployeeFio(employees);
    }
}