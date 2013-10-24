package org.xander.spring.springIdol.workingWithDatabase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("org/xander/spring/springIdol/workingWithDatabase/appcontext.xml");
        VehicleDao vehicleDao = (JdbcVehicleDao) context.getBean("vehicleDao");
//        vehicleDao.insert(new Vehicle("11345", "red", 4, 3));
//
//        Vehicle vehicle = new Vehicle("TEM0001", "Red", 4, 4);
//        vehicleDao.insert(vehicle);
//        vehicle = vehicleDao.findByVehicleNo("TEM0001");
//        System.out.println("Vehicle No: " + vehicle.getVehicleNo());
//        System.out.println("Color: " + vehicle.getColor());
//        System.out.println("Wheel: " + vehicle.getWheel());
//        System.out.println("Seat: " + vehicle.getSeat());
//
//        Vehicle vehicle1 = new Vehicle("TEM0002", "Blue", 4, 4);
//        Vehicle vehicle2 = new Vehicle("TEM0003", "Black", 4, 6);
//        vehicleDao.insertBatch(
//        Arrays.asList(new Vehicle[]{vehicle1, vehicle2}));

        List<Vehicle> vehicles = vehicleDao.findAll();
        for (Vehicle vehicle : vehicles) {
            System.out.println("Vehicle No: " + vehicle.getVehicleNo());
            System.out.println("Color: " + vehicle.getColor());
            System.out.println("Wheel: " + vehicle.getWheel());
            System.out.println("Seat: " + vehicle.getSeat());
        }
        int count = vehicleDao.countAll();
        System.out.println("Vehicle Count: " + count);
        String color = vehicleDao.getColor("TEM0001");
        System.out.println("Color for [TEM0001]: " + color);

        Vehicle vehicle = new Vehicle("EX0001", "Green", 4, 4);
        try {
            vehicleDao.insert(vehicle);
        } catch (Exception e) {
            SQLException sqle = (SQLException) e.getCause();
            System.out.println("\n\n\n\nError code: " + sqle.getErrorCode());
            System.out.println("SQL state: " + sqle.getSQLState());
        }

//        look for error code in sql-error-codes.xml
//        <property name="duplicateKeyCodes">
//        <value>1062</value>
//        </property>
    }
}
