package com.example.with_db.generator.artifacts;

import com.example.with_db.generator.settings.Settings;
import com.example.with_db.generator.model.Table;

import java.util.List;
import java.util.Map;

public class TablesEnum extends AbstractFileWriter {

    private static final String TEMPLATE = "TablesEnum.ftlh";
    private static final String FILE_NAME = "Tables.java";
    private static final List<String> PACKAGES = List.of("tables");

    public static void generate(final Settings settings, final List<Table> tables) {

        final Map<String, Object> parameter = Map.ofEntries(
                Map.entry("packageName", packageName(settings.basePackage(), PACKAGES)),
                Map.entry("tables", tables)
        );

        final var path = outputPath(FILE_NAME, settings.outputDirectory(), PACKAGES);
        writeToFile(TEMPLATE, parameter, path);
    }
}
