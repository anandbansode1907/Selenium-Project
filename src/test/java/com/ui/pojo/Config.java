package com.ui.pojo;

import java.util.Map;

public class Config {

	Map<String, Environment> environments;

	public Map<String, Environment> getEnvironment() {
		return environments;
	}

	public void setEnvironment(Map<String, Environment> environment) {
		this.environments = environment;
	}

}