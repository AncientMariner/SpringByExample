package org.xander.spring.springIdol.workingWithDatabase;

import org.springframework.jdbc.core.PreparedStatementCreator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertVehicleStatementCreator implements PreparedStatementCreator {
    private Vehicle vehicle;
    public InsertVehicleStatementCreator(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public PreparedStatement createPreparedStatement(Connection conn)
            throws SQLException {
        String sql = "INSERT INTO VEHICLE (VEHICLE_NO, COLOR, WHEEL, SEAT) "
                + "VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, vehicle.getVehicleNo());
        ps.setString(2, vehicle.getColor());
        ps.setInt(3, vehicle.getWheel());
        ps.setInt(4, vehicle.getSeat());
        return ps;
    }
}
