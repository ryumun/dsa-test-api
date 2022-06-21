package com.example.demo.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.LogService;

@RestController
public class LogController {
	@Resource(name="LogService")
	LogService service;
	
	@RequestMapping(value = "/write_log/{log_type}", method = RequestMethod.GET) 
    public ResponseEntity<String> write_log(@PathVariable("log_type") String log_type) { 
		service.writeLog(log_type);
        ResponseEntity<String> resEntity = null; 
        try { 
            String result = service.writeLog(log_type);
            resEntity = new ResponseEntity<>(result, HttpStatus.OK); 
        } catch (Exception e) { 
            e.printStackTrace(); 
            resEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
        } 
        return resEntity; 
    }
	@RequestMapping(value = "/test")
	public String test() {
		Logger logger = LoggerFactory.getLogger(this.getClass());
		logger.info("Hello world.");
		return "test";
	}

}
