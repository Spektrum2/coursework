package pro.sky.java.course1.coursework;

public class EmployeeBook {
    private final Employee[] employees;
    private int size;

    public EmployeeBook() {
        this.employees = new Employee[10];
    }

    /**
     * Метод для добавления сотрудника в книгу
     *
     * @param fio        Ф. И. О. сотрудника
     * @param department отдел
     * @param salary     зарплата
     */
    public void addEmployee(String fio, int department, double salary) {
        if (size >= employees.length) {
            throw new IllegalArgumentException("Список сотрудников заполнен. Добавление нового сотрудника ограничено.");
        }
        Employee newEmployee = new Employee(fio, department, salary);
        employees[size++] = newEmployee;

    }

    /**
     * Метод для удаления сотрудника из книги
     *
     * @param id id сотрудника
     */
    public void removeEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                System.out.println("Сотрудник " + employees[i].getFio() + " удален(а)");
                System.arraycopy(employees, i + 1, employees, i, size - i - 1);
                employees[size - 1] = null;
                size--;
                return;
            }
        }
    }

    /**
     * Метод для изменения зарплаты
     *
     * @param fio    Ф. И. О. сотрудника
     * @param salary зарплата
     */
    public void setSalary(String fio, double salary) {
        for (Employee employee : employees) {
            if (employee.getFio().equals(fio)) {
                employee.setSalary(salary);
            }
        }
    }

    /**
     * Метод для изменения отдела
     *
     * @param fio        Ф. И. О. сотрудника
     * @param department зарплата
     */
    public void setDepartment(String fio, int department) {
        for (Employee employee : employees) {
            if (employee.getFio().equals(fio)) {
                employee.setDepartment(department);
            }
        }
    }

    /**
     * Метод для получения Ф. И. О. всех сотрудников по отделам
     */
    public void printDepartmentEmployee() {
        for (Employee sot : employees) {
            System.out.println("Сотрудники отдела " + sot.getDepartment() + ":");
            for (Employee employee : employees) {
                if (employee.getDepartment() == sot.getDepartment()) {
                    System.out.println(employee.getFio());
                }
            }
            System.out.println();
        }
    }

    /**
     * Метод для получения списка всех сотрудников со всеми имеющимися по ним данными
     */
    public void printEmployee() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    /**
     * Метод для подсчета суммы затрат на зарплаты в месяц
     *
     * @return Возвращает сумму затрат на зарплаты в месяц
     */
    public double calculateAmountEmployee() {
        double amount = 0;
        for (Employee employee : employees) {
            amount += employee.getSalary();
        }
        return amount;
    }

    /**
     * Метод для подсчета суммы затрат на зарплаты в месяц по отделу
     *
     * @param employees сотрудники из конкретного отдела
     * @return Возвращает сумму затрат на зарплаты в месяц по отделу
     */
    public double calculateAmountEmployeeDepartment(Employee[] employees) {
        double amount = 0;
        for (Employee employee : employees) {
            amount += employee.getSalary();
        }
        return amount;
    }

    /**
     * Метод для поиска сотрудника с минимальной зарплатой
     */
    public void printEmployeeMinSalary() {
        Employee minEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() < minEmployee.getSalary()) {
                minEmployee = employee;
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой " + minEmployee);
    }

    /**
     * Метод для поиска сотрудника с минимальной зарплатой по отделу
     *
     * @param employees сотрудники из конкретного отдела
     */
    public void printEmployeeMinSalaryDepartment(Employee[] employees) {
        Employee minEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() < minEmployee.getSalary()) {
                minEmployee = employee;
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой " + minEmployee);
    }

    /**
     * Метод для поиска сотрудника с максимальной зарплатой
     */
    public void printEmployeeMaxSalary() {
        Employee maxEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() > maxEmployee.getSalary()) {
                maxEmployee = employee;
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой " + maxEmployee);
    }

    /**
     * Метод для поиска сотрудника с максимальной зарплатой по отделу
     *
     * @param employees сотрудники из конкретного отдела
     */
    public void printEmployeeMaxSalaryDepartment(Employee[] employees) {
        Employee maxEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() > maxEmployee.getSalary()) {
                maxEmployee = employee;
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой " + maxEmployee);
    }

    /**
     * Метод для подсчета среднего значения зарплат
     *
     * @return Возвращает среднее значение зарплат
     */
    public double calculateAverageSalary() {
        double amount = calculateAmountEmployee();
        return amount / employees.length;
    }

    /**
     * Метод для поиска средней зарплаты по отделу
     *
     * @param employees сотрудники из конкретного отдела
     * @return Возвращает среднее значение зарплат по отделу
     */
    public double calculateAverageSalaryDepartment(Employee[] employees) {
        double amount = calculateAmountEmployeeDepartment(employees);
        return amount / employees.length;
    }


    /**
     * Метод для получения Ф. И. О. всех сотрудников
     */
    public void printEmployeeFio() {
        for (Employee employee : employees) {
            System.out.println(employee.getFio());
        }
    }

    /**
     * Метод для вывода всех сотрудников отдела (все данные, кроме отдела)
     *
     * @param employees отрудники из конкретного отдела
     */
    public void printIdEmployeeFioSalary(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println("id = " + employee.getId() + ", Ф.И.О. = " + employee.getFio() + ", Зарпалата = " + employee.getSalary());
        }
    }

    /**
     * Метод для индексации зарплаты
     *
     * @param percent Процент для индексации зарплаты
     */
    public void indexingSalary(double percent) {
        for (Employee employee : employees) {
            double indexing = employee.getSalary() + employee.getSalary() * (percent / 100);
            employee.setSalary(indexing);
        }
    }

    /**
     * Метод для поиска сотрудников по отделу
     *
     * @param numberDepartment номер отдела
     * @return возвращает сотрудников из конкретного отдела
     */
    public Employee[] searchByDepartment(int numberDepartment) {
        if (numberDepartment < 0 || numberDepartment > 5) {
            throw new IllegalArgumentException("Неправильно указан номер отдела. Укажите номер отдела от 1 до 5!");
        }
        int size = 0;
        int size2 = 0;
        for (Employee value : employees) {
            if (value.getDepartment() == numberDepartment) {
                size++;
            }
        }
        Employee[] employeesDepartment = new Employee[size];
        for (Employee employee : employees) {
            if (employee.getDepartment() == numberDepartment) {
                employeesDepartment[size2++] = employee;
            }
        }
        return employeesDepartment;
    }

    /**
     * Метод для получения сотрудников с зарплатой меньше числа
     *
     * @param number число для сравнения
     * @return Возвращает сотрудников с зарплатой меньше числа
     */
    public Employee[] compareLessSalary(int number) {
        int size = 0;
        int size2 = 0;
        for (Employee employee : employees) {
            if (employee.getSalary() < number) {
                size++;
            }
        }
        Employee[] lessSalary = new Employee[size];
        for (Employee employee : employees) {
            if (employee.getSalary() < number) {
                lessSalary[size2++] = employee;
            }
        }
        return lessSalary;
    }

    /**
     * Метод для получения сотрудников с зарплатой больше (или равно) числа
     *
     * @param number число для сравнения
     * @return Возвращает сотрудников с зарплатой больше (или равно) числа
     */
    public Employee[] compareMoreSalary(int number) {
        int size = 0;
        int size2 = 0;
        for (Employee employee : employees) {
            if (employee.getSalary() >= number) {
                size++;
            }
        }
        Employee[] moreSalary = new Employee[size];
        for (Employee employee : employees) {
            if (employee.getSalary() >= number) {
                moreSalary[size2++] = employee;
            }
        }
        return moreSalary;
    }

    /**
     * Метод для индексации зарплаты по отделам
     *
     * @param department отдел
     * @param percent Процент для индексации зарплаты
     */
    public void indexingSalaryDepartment(int department, double percent) {
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                double indexing = employee.getSalary() + employee.getSalary() * (percent / 100);
                employee.setSalary(indexing);
            }
        }
    }

    /**
     * Метод для получения сотрудников по отделам
     *
     * @param department отдел
     */
    public void printDepartment(int department) {
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                System.out.println("id = " + employee.getId() + ", Ф.И.О. = " + employee.getFio() + ", Зарпалата = " + employee.getSalary());
            }
        }
    }
}
