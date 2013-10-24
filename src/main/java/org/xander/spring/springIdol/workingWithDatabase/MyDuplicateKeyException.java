package org.xander.spring.springIdol.workingWithDatabase;

import org.springframework.dao.DataIntegrityViolationException;

public class MyDuplicateKeyException extends DataIntegrityViolationException {
    public MyDuplicateKeyException(String msg) {
        super(msg);
    }
    public MyDuplicateKeyException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
