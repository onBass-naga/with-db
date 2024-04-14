package com.example.with_db.generator.artifacts;

import com.example.with_db.generator.settings.Settings;
import com.example.with_db.generator.model.Table;

import java.util.List;
import java.util.Map;

public class SetupModel extends AbstractFileWriter {

    private static final String TEMPLATE = "SetupModel.ftlh";
    private static final String FILE_NAME_TEMPLATE = "%s.java";
    private static final List<String> PACKAGES = List.of("setup", "model");

    public static void generate(final Settings settings, final Table table) {

        final Map<String, Object> parameter = Map.ofEntries(
                Map.entry("packageName", packageName(settings.basePackage(), PACKAGES)),
                Map.entry("table", table),
                Map.entry("importStatements", importStatements(table)),
                Map.entry("columns", table.columns()),
                Map.entry("requiredColumns", table.requiredColumns())
        );

        final var path = outputPath(FILE_NAME_TEMPLATE.formatted(table.upperCamelCaseSingularName()), settings.outputDirectory(), PACKAGES);
        writeToFile(TEMPLATE, parameter, path);
    }
}
