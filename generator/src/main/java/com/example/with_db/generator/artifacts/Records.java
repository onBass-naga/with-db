package com.example.with_db.generator.artifacts;

import com.example.with_db.generator.Settings;
import com.example.with_db.generator.Table;

import java.util.List;
import java.util.Map;

public class Records extends AbstractFileWriter {

    private static final String TEMPLATE = "Records.ftlh";
    private static final String FILE_NAME_TEMPLATE = "%sRecords.java";
    private static final List<String> PACKAGES = List.of("assertion", "records");

    public static void generate(final Settings settings, final Table table) {

        final Map<String, Object> parameter = Map.ofEntries(
                Map.entry("packageName", packageName(settings.basePackage(), PACKAGES)),
                Map.entry("table", table)
        );

        final var path = outputPath(FILE_NAME_TEMPLATE.formatted(table.upperCamelCaseSingularName()), settings.outputDirectory(), PACKAGES);
        writeToFile(TEMPLATE, parameter, path);
    }
}
