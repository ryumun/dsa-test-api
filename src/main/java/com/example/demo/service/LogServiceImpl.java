package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service(value="LogService")
public class LogServiceImpl implements LogService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment env;
	
	@Override
	public String writeLog(String logType) {
		String module_name = env.getProperty("module_name");
		System.out.println(logType);
		switch (logType) {
		case "info":
			logger.info(module_name + " Info");
			break;
		case "warn":
			logger.warn(module_name + " Warn");
			break;
		case "error":
			logger.error(module_name + " Error");
			break;
		default:
			logger.info(module_name + " Info");
			logger.warn(module_name + " Warn");
			logger.error(module_name + " Error");
			break;
		}
		return logType;
	}
	
}
