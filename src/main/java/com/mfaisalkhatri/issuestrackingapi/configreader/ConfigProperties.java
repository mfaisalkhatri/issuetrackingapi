package com.mfaisalkhatri.issuestrackingapi.configreader;

import java.io.IOException;
import com.configreader.configreader.main.PropertiesReader;

public class ConfigProperties {

	PropertiesReader prop = new PropertiesReader();

	public String getAccessToken() throws IOException {
		return prop.getKey("accesstoken");
	}

	public String getAuthType() throws IOException {
		return prop.getKey("authenticationtype");
	}

	public String getHeaderk1() throws IOException {
		return prop.getKey("headerkey1");
	}

	public String getHeaderv1() throws IOException {
		return prop.getKey("headervalue1");
	}

	public String getRqstType() throws IOException {
		return prop.getKey("request");
	}

	public String getRqstUrl() throws IOException {
		return prop.getKey("getapi");
	}

	public String getPostBodyParamKey1() throws IOException {
		return prop.getKey("postbodyparamkey1");

	}

	public String getPostBodyParamValue1() throws IOException {
		return prop.getKey("postbodyparamvalue1");

	}

}
