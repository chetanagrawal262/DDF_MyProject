package com.base;

import java.util.Map;

import com.util.ExcelUtils;
import com.util.ReadPropertyFile;

public class Environment {
	private static ThreadLocal<String> environment = new ThreadLocal<>();
	
	public synchronized static void setEnvironment(String environmentType) {
		ReadPropertyFile prop = new ReadPropertyFile();
		
		if(environmentType.contains("QA")) {
			Map<String, String> map = ExcelUtils.getRowFromRowNumber(prop.getExcelFileName(), Excel.Login, environmentType);
			environment = ThreadLocal.withInitial(() ->  map.get(Excel.URL));
		}
		else if(environmentType.contains("SUPPORT")) {
			Map<String, String> map = ExcelUtils.getRowFromRowNumber(prop.getExcelFileName(), Excel.Login, environmentType);
			environment = ThreadLocal.withInitial(() ->  map.get(Excel.URL));
		}
		else if(environmentType.contains("UAT")) {
			Map<String, String> map = ExcelUtils.getRowFromRowNumber(prop.getExcelFileName(), Excel.Login, environmentType);
			environment = ThreadLocal.withInitial(() ->  map.get(Excel.URL));
		}
		else if(environmentType.contains("DEMO")) {
			Map<String, String> map = ExcelUtils.getRowFromRowNumber(prop.getExcelFileName(), Excel.Login, environmentType);
			environment = ThreadLocal.withInitial(() ->  map.get(Excel.URL));
		}
	}
	
	
	public synchronized static String getEnvironment() {
		try {
			return environment.get();
		} catch (Exception e) {
			return environment.get();
		}
	}
}
