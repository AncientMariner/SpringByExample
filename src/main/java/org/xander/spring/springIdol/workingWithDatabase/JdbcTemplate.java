package org.xander.spring.springIdol.workingWithDatabase;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class JdbcTemplate {
    public void update(String sqlInsertSpitter, String username, String password, String fullName) {

    }

    public Spitter queryForObject(String sqlSelectSpitter, ParameterizedRowMapper<Spitter> parameterizedRowMapper, long id) {
        return null;
    }
}
