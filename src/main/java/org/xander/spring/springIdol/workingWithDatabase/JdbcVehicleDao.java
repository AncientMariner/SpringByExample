package org.xander.spring.springIdol.workingWithDatabase;

import org.springframework.jdbc.core.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcVehicleDao implements VehicleDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//with JdbcDaoSupport extended
//    public void insertWithJdbcDaoSupportExtended(final Vehicle vehicle) {
//        String sql = "INSERT INTO VEHICLE (VEHICLE_NO, COLOR, WHEEL, SEAT) "
//                + "VALUES (?, ?, ?, ?)";
//        getJdbcTemplate().update(sql, new Object[] { vehicle.getVehicleNo(),
//                vehicle.getColor(), vehicle.getWheel(), vehicle.getSeat() });
//    }



    public void insert(Vehicle vehicle) {
        String sql = "INSERT INTO VEHICLE (VEHICLE_NO, COLOR, WHEEL, SEAT) "
                + "VALUES (?, ?, ?, ?)";
        Connection conn = null;
//  check for connection information      conn.getMetaData().getDatabaseProductName();
        try {
            conn = dataSource.getConnection();
            System.out.println(conn.getMetaData().getDatabaseProductName());
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, vehicle.getVehicleNo());
            ps.setString(2, vehicle.getColor());
            ps.setInt(3, vehicle.getWheel());
            ps.setInt(4, vehicle.getSeat());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(new InsertVehicleStatementCreator(vehicle));
    }

    public void insertWithJdbTemplate(final Vehicle vehicle) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection conn)
                    throws SQLException {
                String sql = "INSERT INTO VEHICLE "
                        + "(VEHICLE_NO, COLOR, WHEEL, SEAT) "
                        + "VALUES (?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, vehicle.getVehicleNo());
                ps.setString(2, vehicle.getColor());
                ps.setInt(3, vehicle.getWheel());
                ps.setInt(4, vehicle.getSeat());
                return ps;
            }
        });
    }

    public void insertWithStatementSetter(final Vehicle vehicle) {
        String sql = "INSERT INTO VEHICLE (VEHICLE_NO, COLOR, WHEEL, SEAT) "
                + "VALUES (?, ?, ?, ?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql, new PreparedStatementSetter() {
            public void setValues(PreparedStatement ps)
                    throws SQLException {
                ps.setString(1, vehicle.getVehicleNo());
                ps.setString(2, vehicle.getColor());
                ps.setInt(3, vehicle.getWheel());
                ps.setInt(4, vehicle.getSeat());
            }
        });
    }

    public void insertWithParameterAndParameterValues(final Vehicle vehicle) {
        String sql = "INSERT INTO VEHICLE (VEHICLE_NO, COLOR, WHEEL, SEAT) "
                + "VALUES (?, ?, ?, ?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql, new Object[] { vehicle.getVehicleNo(),
                                                vehicle.getColor(),
                                                vehicle.getWheel(),
                                                vehicle.getSeat() });
    }

    public void insertBatch(final List<Vehicle> vehicles) {
        String sql = "INSERT INTO VEHICLE (VEHICLE_NO, COLOR, WHEEL, SEAT) "
                + "VALUES (?, ?, ?, ?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            public int getBatchSize() {
                return vehicles.size();
            }
            public void setValues(PreparedStatement ps, int i)
                    throws SQLException {
                Vehicle vehicle = vehicles.get(i);
                ps.setString(1, vehicle.getVehicleNo());
                ps.setString(2, vehicle.getColor());
                ps.setInt(3, vehicle.getWheel());
                ps.setInt(4, vehicle.getSeat());
            }
        });
    }

    //insert batch using SimpleJdbcDaSupport
//    public void insertBatch(List<Vehicle> vehicles) {
//        String sql = "INSERT INTO VEHICLE (VEHICLE_NO, COLOR, WHEEL, SEAT) "
//                + "VALUES (?, ?, ?, ?)";
//        List<Object[]> parameters = new ArrayList<Object[]>();
//        for (Vehicle vehicle : vehicles) {
//            parameters.add(new Object[] { vehicle.getVehicleNo(),
//                    vehicle.getColor(), vehicle.getWheel(), vehicle.getSeat() });
//        }
//        getSimpleJdbcTemplate().batchUpdate(sql, parameters);
//    }


    public Vehicle findByVehicleNoPlainJdbc(String vehicleNo) {
        String sql = "SELECT * FROM VEHICLE WHERE VEHICLE_NO = ?";
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, vehicleNo);
            Vehicle vehicle = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                vehicle = new Vehicle(rs.getString("VEHICLE_NO"),
                        rs.getString("COLOR"), rs.getInt("WHEEL"),
                        rs.getInt("SEAT"));
            }
            rs.close();
            ps.close();
            return vehicle;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {


            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    public void update(Vehicle vehicle) {/* ... */}
    public void delete(Vehicle vehicle) {/* ... */}

//    Extracting Data with Row Callback Handler
//    public Vehicle findByVehicleNo(String vehicleNo) {
//        String sql = "SELECT * FROM VEHICLE WHERE VEHICLE_NO = ?";
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//        final Vehicle vehicle = new Vehicle();
//        jdbcTemplate.query(sql, new Object[] { vehicleNo },
//                new RowCallbackHandler() {
//                    public void processRow(ResultSet rs) throws SQLException {
//                        vehicle.setVehicleNo(rs.getString("VEHICLE_NO"));
//                        vehicle.setColor(rs.getString("COLOR"));
//                        vehicle.setWheel(rs.getInt("WHEEL"));
//                        vehicle.setSeat(rs.getInt("SEAT"));
//                    }
//                });
//        return vehicle;
//    }

    //using rowMapper
//    public Vehicle findByVehicleNo(String vehicleNo) {
//        String sql = "SELECT * FROM VEHICLE WHERE VEHICLE_NO = ?";
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//        Vehicle vehicle = (Vehicle) jdbcTemplate.queryForObject(sql,
//                new Object[] { vehicleNo }, new VehicleRowMapper());
//        return vehicle;
//    }

    //bean property row mapper
    public Vehicle findByVehicleNo(String vehicleNo) {
        String sql = "SELECT * FROM VEHICLE WHERE VEHICLE_NO = ?";
        BeanPropertyRowMapper<Vehicle> vehicleRowMapper =
                BeanPropertyRowMapper.newInstance(Vehicle.class);
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Vehicle vehicle = jdbcTemplate.queryForObject(
                sql, vehicleRowMapper, vehicleNo);
        return vehicle;
    }

//    extending SimpleJdbcDaoSupport
//    public Vehicle findByVehicleNo(String vehicleNo) {
//        String sql = "SELECT * FROM VEHICLE WHERE VEHICLE_NO = ?";
//// No need to cast into Vehicle anymore.
//        Vehicle vehicle = getSimpleJdbcTemplate().queryForObject(sql,
//                new VehicleRowMapper(), vehicleNo);
//        return vehicle;
//    }

//    public Vehicle findByVehicleNo(String vehicleNo) {
//        String sql = "SELECT * FROM VEHICLE WHERE VEHICLE_NO = ?";
//        Vehicle vehicle = getSimpleJdbcTemplate().queryForObject(sql,
//                ParameterizedBeanPropertyRowMapper.newInstance(Vehicle.class),
//                vehicleNo);
//        return vehicle;
//    }



    public List<Vehicle> findAll() {
        String sql = "SELECT * FROM VEHICLE";
        RowMapper<Vehicle> rm =
                BeanPropertyRowMapper.newInstance(Vehicle.class);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Vehicle> vehicles = jdbcTemplate.query(sql, rm);
        return vehicles;
    }

//    public List<Vehicle> findAll() {
//        String sql = "SELECT * FROM VEHICLE";
//        List<Vehicle> vehicles = getSimpleJdbcTemplate().query(sql,
//                ParameterizedBeanPropertyRowMapper.newInstance(Vehicle.class));
//        return vehicles;
//    }



    public String getColor(String vehicleNo) {
        String sql = "SELECT COLOR FROM VEHICLE WHERE VEHICLE_NO = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String color = (String) jdbcTemplate.queryForObject(sql,
                new Object[] { vehicleNo }, String.class);
        return color;
    }

//    public String getColor(String vehicleNo) {
//        String sql = "SELECT COLOR FROM VEHICLE WHERE VEHICLE_NO = ?";
//// No need to cast into String anymore.
//        String color = getSimpleJdbcTemplate().queryForObject(sql,
//                String.class, vehicleNo);
//        return color;
//    }
//


    public int countAll() {
        String sql = "SELECT COUNT(*) FROM VEHICLE";
        jdbcTemplate = new JdbcTemplate(dataSource);
        int count = jdbcTemplate.queryForInt(sql);
        return count;
    }



}
