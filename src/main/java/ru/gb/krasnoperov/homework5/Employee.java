package ru.gb.krasnoperov.homework5;

public class Employee {

    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public static void main(String[] args) {

        Employee employee_1 = new Employee("Иванов Иван Иванович", "Инженер", "ivanow@ivan.ru", "89038888888", 300000, 30);

        printInfoEmployee(employee_1);

        Employee[] employeeArray = new Employee[5];

        employeeArray[0] = employee_1;
        employeeArray[1] = new Employee("Смрнов Семен Семенович", "Технолог", "smirnov@sm.ru", "89038888888", 400000, 50);
        employeeArray[2] = new Employee("Сидоров Семен Семенович", "Бухгалтер", "sidorov@sm.ru", "89038888888", 600000, 42);
        employeeArray[3] = new Employee("Наполеонов Семен Семенович", "Водитель", "nap@sm.ru", "89038888888", 200000, 36);
        employeeArray[4] = new Employee("Петров Семен Семенович", "Рабочий", "peter@sm.ru", "89038888888", 300000, 20);


        for (int i = 0; i < employeeArray.length; i++) {

            if (employeeArray[i].getAge()>=40){
                printInfoEmployee(employeeArray[i]);
            }

            System.out.println();

        }

    }

    public Employee() {

    }

    public Employee(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void printInfoEmployee(Employee employee) {
        System.out.println("Информация о сотруднике:");
        System.out.println("ФИО: " + employee.getName());
        System.out.println("Должность: " + employee.getPosition());
        System.out.println("EMAIL: " + employee.getEmail());
        System.out.println("Телефон: " + employee.getPhone());
        System.out.println("Зарплата: " + employee.getSalary());
        System.out.println("Возраст: " + employee.getAge());
    }


}
