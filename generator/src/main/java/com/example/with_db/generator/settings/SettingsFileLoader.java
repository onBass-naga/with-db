package com.example.with_db.generator.settings;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class SettingsFileLoader {

    public static Settings load(String filePath) {
        File file = new File(filePath);
        try {
            Map<String, Object> map = new Yaml().load(new FileReader(file));
            return initSettings(map);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static Settings initSettings(Map<String, Object> map) {
        @SuppressWarnings("unchecked")
        final var datasource = (HashMap<String, String>) map.get("datasource");

        return new Settings(
                datasource.get("driverClassName"),
                datasource.get("url"),
                datasource.get("schema"),
                datasource.get("username"),
                datasource.get("password"),
                map.get("outputDirectory").toString(),
                map.get("basePackage").toString(),
                map.get("dataSetPrefix").toString()
        );
    }
}
