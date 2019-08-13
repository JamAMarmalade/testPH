package com.regression;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentRead {
    private Properties properties = new Properties();

    public void setEnvironment() {
        try (FileReader reader = new FileReader(".env")) {
            properties.load(reader);
        } catch (IOException ex) {
            System.out.println("==> Unable to load file: .env");
        }
        for (String name : properties.stringPropertyNames()) {
            System.setProperty(name, properties.getProperty(name));
        }
    }

    /**
     * Use the method get the credential from System properties
     * @param environmentId the credential Id in env
     * @return your credential
     */
    public String getProperty(String environmentId) {
        return System.getProperty(environmentId);
    }
}
