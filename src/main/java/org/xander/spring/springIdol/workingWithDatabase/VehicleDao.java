package org.xander.spring.springIdol.workingWithDatabase;

import java.util.List;

public interface VehicleDao {
    void insert(Vehicle vehicle);
    void update(Vehicle vehicle);
    void delete(Vehicle vehicle);
    Vehicle findByVehicleNo(String vehicleNo);
    void insertBatch(final List<Vehicle> vehicles);
    List<Vehicle> findAll();
    String getColor(String vehicleNo);
    int countAll();
}
