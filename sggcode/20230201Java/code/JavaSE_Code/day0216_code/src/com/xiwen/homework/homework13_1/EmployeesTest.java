package com.xiwen.homework.homework13_1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/16-19:31
 * @Version: 1.0
 */
public class EmployeesTest {
    public static void main(String[] args) {

//        {"13", "2", "令狐冲", "32", "18000", "15000", "2000"},

        String[][] data = Data.EMPLOYEES;

        Employee[] employees = new Employee[data.length];


        for (int i = 0; i < employees.length; i++) {
            switch (Integer.parseInt(data[i][0])) {
                case Data.EMPLOYEE:
                    employees[i] = new Employee(Integer.parseInt(data[i][1]), data[i][2], Integer.parseInt(data[i][3]), Double.parseDouble(data[i][4]));
                    break;
                case Data.PROGRAMMER:
                    employees[i] = new Programmer(Integer.parseInt(data[i][1]), data[i][2], Integer.parseInt(data[i][3]), Double.parseDouble(data[i][4]));
                    break;
                case Data.DESIGNER:
                    employees[i] = new Designer(Integer.parseInt(data[i][1]), data[i][2], Integer.parseInt(data[i][3]), Double.parseDouble(data[i][4]), Double.parseDouble(data[i][5]));
                    break;
                case Data.ARCHITECT:
                    employees[i] = new Architect(Integer.parseInt(data[i][1]), data[i][2], Integer.parseInt(data[i][3]), Double.parseDouble(data[i][4]), Double.parseDouble(data[i][5]), Double.parseDouble(data[i][6]));
                    break;
                default:
                    employees[i] = null;
            }
            System.out.println(employees[i]);

        }


    }
}
