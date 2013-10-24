package org.xander.spring.springIdol.workingWithDatabase;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import java.util.ArrayList;
import java.util.List;

public class JdbcVehicleDaoNamedParams extends SimpleJdbcDaoSupport implements VehicleDao {
    @Override
//    public void insert(Vehicle vehicle) {
//        String sql = "INSERT INTO VEHICLE (VEHICLE_NO, COLOR, WHEEL, SEAT) "
//                + "VALUES (:vehicleNo, :color, :wheel, :seat)";
//        Map<String, Object> parameters = new HashMap<>();
//        parameters.put("vehicleNo", vehicle.getVehicleNo());
//        parameters.put("color", vehicle.getColor());
//        parameters.put("wheel", vehicle.getWheel());
//        parameters.put("seat", vehicle.getSeat());
//        getSimpleJdbcTemplate().update(sql, parameters);
//    }

//    public void insert(Vehicle vehicle) {
//        String sql = "INSERT INTO VEHICLE (VEHICLE_NO, COLOR, WHEEL, SEAT) "
//                + "VALUES (:vehicleNo, :color, :wheel, :seat)";
//        Map<String, Object> parameters = new HashMap<String, Object>();
//        SqlParameterSource parameterSource =
//                new MapSqlParameterSource(parameters);
//        getSimpleJdbcTemplate().update(sql, parameterSource);
//    }


//    Here is where the SqlParameterSource intermediary starts to benefit us! SqlParameterSource is
//    BeanPropertySqlParameterSource, which wraps a normal Java object as a SQL parameter source. For
//    each of the named parameters, the property with the same name will be used as the parameter value.

    public void insert(Vehicle vehicle) {
        String sql = "INSERT INTO VEHICLE (VEHICLE_NO, COLOR, WHEEL, SEAT) "
                + "VALUES (:vehicleNo, :color, :wheel, :seat)";
        SqlParameterSource parameterSource =
                new BeanPropertySqlParameterSource(vehicle);
        getSimpleJdbcTemplate().update(sql, parameterSource);
    }

    @Override
    public void insertBatch(List<Vehicle> vehicles) {
        String sql = "INSERT INTO VEHICLE (VEHICLE_NO, COLOR, WHEEL, SEAT) "
                + "VALUES (:vehicleNo, :color, :wheel, :seat)";
        List<SqlParameterSource> parameters = new ArrayList<SqlParameterSource>();
        for (Vehicle vehicle : vehicles) {
            parameters.add(new BeanPropertySqlParameterSource(vehicle));
        }
        getSimpleJdbcTemplate().batchUpdate(sql,
                parameters.toArray(new SqlParameterSource[0]));
    }

    @Override
    public void update(Vehicle vehicle) {
    }

    @Override
    public void delete(Vehicle vehicle) {
    }

    @Override
    public Vehicle findByVehicleNo(String vehicleNo) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Vehicle> findAll() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getColor(String vehicleNo) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int countAll() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}