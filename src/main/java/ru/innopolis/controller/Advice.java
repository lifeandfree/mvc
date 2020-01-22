package ru.innopolis.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

/**
 * Advice.
 *
 * @author lifeandfree
 */
@ControllerAdvice
public class Advice {

    private static final Logger logger = LogManager.getLogger(RegController.class.getName());

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String handle(Exception ex) {
        logger.error(ex.getMessage());
        return ex.getMessage();
    }

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public String handleRE(RuntimeException ex) {
        logger.error(ex.getMessage());
        return ex.getMessage();
    }

    @ExceptionHandler(value = SQLException.class)
    @ResponseBody
    public String handleSQL(SQLException ex) {
        logger.error(ex.getMessage());
        return ex.getMessage();
    }
}
