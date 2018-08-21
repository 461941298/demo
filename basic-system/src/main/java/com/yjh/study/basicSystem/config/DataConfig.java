package com.yjh.study.basicSystem.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DataConfig {

    @Value("${system.name}")
    private String systemName;

    @Value("${system.uuid}")
    private String systemUUID;

    @Value("${system.description}")
    private String systemDescription;


    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getSystemUUID() {
        return systemUUID;
    }

    public void setSystemUUID(String systemUUID) {
        this.systemUUID = systemUUID;
    }

    public String getSystemDescription() {
        return systemDescription;
    }

    public void setSystemDescription(String systemDescription) {
        this.systemDescription = systemDescription;
    }
}
