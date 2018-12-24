package com.example.demo.exception.handler;


import com.example.demo.exception.CityExistException;
import com.example.demo.exception.CityNotFoundException;
import com.example.demo.exception.GeneralException;
import com.example.demo.exception.OutputErrorInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalHandlerException {

    private static final String ERROR = "error";
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private static Object genOutputException(GeneralException exception) {
        OutputErrorInfo outputException = new OutputErrorInfo(
                exception.getMessage(),
                exception.getCode(),
                exception.getType()
        );
        Map<String, OutputErrorInfo> map = new HashMap<>(2);
        map.put(ERROR, outputException);
        return map;
    }

    @ExceptionHandler(CityExistException.class)
    public ResponseEntity handleAccountExistException(final CityExistException e) {
        logger.info(e.getMessage(), e);
        e.setMessage("城市已存在");
        e.setCode("0001");
        e.setType(CityExistException.class.getName());
        Object resp = genOutputException(e);
        return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CityNotFoundException.class)
    public ResponseEntity handleAccountNotFoundException(final CityNotFoundException e) {
        logger.info(e.getMessage(), e);

        e.setMessage("搜索的城市不存在" + e.getMessage());
        e.setCode("0002");
        e.setType(CityNotFoundException.class.getName());
        Object resp = genOutputException(e);
        return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
    }
}
