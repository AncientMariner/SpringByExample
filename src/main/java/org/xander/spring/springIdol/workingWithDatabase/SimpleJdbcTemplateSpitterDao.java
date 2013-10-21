package org.xander.spring.springIdol.workingWithDatabase;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SimpleJdbcTemplateSpitterDao implements SpitterDAO {
    private static final String SQL_INSERT_SPITTER =
            "insert into spitter (username, password, fullname) " +
                    "values (:username, :password, :fullname)";


    private static final String SQL_SELECT_SPITTER =
            "select id, username, fullname from spitter where id = ?";

    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    public void addSpitter(Spitter spitter) {
//        jdbcTemplate.update(SQL_INSERT_SPITTER,
//                spitter.getUsername(),
//                spitter.getPassword(),
//                spitter.getFullName());
//        spitter.setId(queryForIdentity());
//    }

    public Spitter getSpitterById(long id) {
        return jdbcTemplate.queryForObject(
                SQL_SELECT_SPITTER,
        new ParameterizedRowMapper<Spitter>() {
            public Spitter mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
                Spitter spitter = new Spitter();
                spitter.setId(rs.getLong(1));
                spitter.setUsername(rs.getString(2));
                spitter.setPassword(rs.getString(3));
                spitter.setFullName(rs.getString(4));
                return spitter;
            }
        },
                id
        );
    }

//    public void addSpitter(Spitter spitter) {
//        Map<String, Object> params = new HashMap<String, Object>();
//        params.put("username", spitter.getUsername());
//        params.put("password", spitter.getPassword());
//        params.put("fullname", spitter.getFullName());
//        jdbcTemplate.update(SQL_INSERT_SPITTER, params);
//        spitter.setId(queryForIdentity());
//    }


}
