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

    private static void printEmployee(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static int calculateAmountEmployee(Employee[] employees) {
        int amount = 0;
        for (Employee employee : employees) {
            amount += employee.getSalary();
        }
        return amount;
    }

    private static void printEmployeeMinSalary(Employee[] employees) {
        int minSalary = 1_000_001;
        Employee minEmployee = null;
        for (Employee employee : employees) {
            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                minEmployee = employee;
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой " + minEmployee);
    }

    private static void printEmployeeMaxSalary(Employee[] employees) {
        int maxSalary = -1;
        Employee maxEmployee = null;
        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                maxEmployee = employee;
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой " + maxEmployee);
    }

    private static double calculateAverageSalary(Employee[] employees, double amount) {
        return amount / employees.length;
    }

    public static void printEmployeeFio(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee.getFio());
        }
    }


    private static void task1(Employee[] employees) {
        printEmployee(employees);
    }

    private static void task2(Employee[] employees) {
        int amount = calculateAmountEmployee(employees);
        System.out.println("Сумма затрат на зарплаты в месяц " + amount);
    }

    private static void task3(Employee[] employees) {
        printEmployeeMinSalary(employees);
    }

    private static void task4(Employee[] employees) {
        printEmployeeMaxSalary(employees);
    }

    private static void task5(Employee[] employees) {
        int amount = calculateAmountEmployee(employees);
        double average = calculateAverageSalary(employees, amount);
        System.out.println("Среднее значение зарплат " + average);
    }

    private static void task6(Employee[] employees) {
        printEmployeeFio(employees);
    }
}