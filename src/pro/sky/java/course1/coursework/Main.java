package pro.sky.java.course1.coursework;

public class Main {
    private static final EmployeeBook employeeBook = new EmployeeBook();

    public static void main(String[] args) {
        employeeBook.addEmployee("Захаров Марк Никитич", 1, 50_000);
        employeeBook.addEmployee("Нефедова София Германовна", 2, 60_000);
        employeeBook.addEmployee("Дементьев Алексей Захарович", 3, 30_000);
        employeeBook.addEmployee("Левин Александр Кириллович", 4, 20_000);
        employeeBook.addEmployee("Михайлова Майя Александровна", 5, 70_000);
        employeeBook.addEmployee("Попова Майя Дмитриевна", 5, 80_000);
        employeeBook.addEmployee("Мещерякова Злата Артёмовна", 4, 15_000);
        employeeBook.addEmployee("Федоров Дмитрий Константинович", 3, 40_000);
        employeeBook.addEmployee("Гаврилов Георгий Даниилович", 2, 35_000);
        employeeBook.addEmployee("Яковлева Мадина Марсельевна", 1, 90_000);
        task1();
    }

    private static void task1() {
        employeeBook.printEmployee();
    }

    private static void task2() {
        double amount = employeeBook.calculateAmountEmployee(employeeBook.getEmployees());
        System.out.println("Сумма затрат на зарплаты в месяц " + amount);
    }

    private static void task3() {
        employeeBook.printEmployeeMinSalary(employeeBook.getEmployees());
    }

    private static void task4() {
        employeeBook.printEmployeeMaxSalary(employeeBook.getEmployees());
    }

    private static void task5() {
        int volume = employeeBook.getEmployees().length;
        double average = employeeBook.calculateAverageSalary(employeeBook.getEmployees(), volume);
        System.out.println("Среднее значение зарплат " + average);
    }

    private static void task6() {
        employeeBook.printEmployeeFio();
    }

    private static void task7() {
        double percent = 15;
        employeeBook.indexingSalary(percent);
    }

    private static void task8() {
        int department = 5;
        double percent = 20;
        Employee[] employeesDepartment = employeeBook.searchByDepartment(department);
        int volume = employeesDepartment.length;
        System.out.println("Сотрудники " + department + "-го отдела с минимальной и максимальной зарплатой:");
        employeeBook.printEmployeeMinSalary(employeesDepartment);
        employeeBook.printEmployeeMaxSalary(employeesDepartment);
        System.out.println();
        double amount = employeeBook.calculateAmountEmployee(employeesDepartment);
        System.out.println("Сумма затрат на зарплаты в мецяс в " + department + "-м отделе " + amount);
        System.out.println();
        double average = employeeBook.calculateAverageSalary(employeesDepartment, volume);
        System.out.println("Среднее значение зарпалат в " + department + "-м отделе " + average);
        employeeBook.indexingSalaryDepartment(employeesDepartment, percent);
        System.out.println();
        System.out.println("Сотрудники " + department + "-го отдела:");
        employeeBook.printIdEmployeeFioSalary(employeesDepartment);
    }

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

    private static void task10() {
        employeeBook.removeEmployee(1);
    }

    private static void task11() {
        employeeBook.setSalary("Мещерякова Злата Артёмовна", 100_000);
        employeeBook.setDepartment("Нефедова София Германовна", 5);
    }

    private static void task12() {
        employeeBook.printDepartmentEmployee();
    }
}