package org.xander.spring.springIdol.workingWithDatabase;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

public class JdbcSpitterDao extends SimpleJdbcDaoSupport implements SpitterDAO{

    private static final String SQL_INSERT_SPITTER =
            "insert into spitter (username, password, fullname) " +
                    "values (:username, :password, :fullname)";


    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


//    public void addSpitter(Spitter spitter) {
//        getSimpleJdbcTemplate().update(SQL_INSERT_SPITTER,
//                spitter.getUsername(),
//                spitter.getPassword(),
//                spitter.getFullName(),
//                spitter.getEmail(),
//                spitter.isUpdateByEmail());
//        spitter.setId(queryForIdentity());
//    }

}
