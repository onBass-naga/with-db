package com.example.with_db.generator.artifacts;

import com.example.with_db.generator.Table;
import freemarker.template.Template;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

abstract class AbstractFileWriter {
    static void writeToFile(final String templateName, final Map<String, Object> parameter, final Path filePath) {

        try (final var fileWriter = new FileWriter(filePath.toFile());
             final var stringWriter = new StringWriter()) {

            Template template = FreeMarkers.getTemplate(templateName);
            template.process(parameter, stringWriter);

            fileWriter.write(stringWriter.toString());

        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    static Path outputPath(final String fileName, final String baseDirectory, final List<String> packages) {
        final var directory = Path.of(baseDirectory, String.join("/", packages));
        if (!Files.exists(directory)) {
            try {
                Files.createDirectories(directory);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        final var filePath = Path.of(directory.toString(), fileName);
        if (!Files.exists(filePath)) {
            try {
                Files.createFile(filePath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(filePath);

        return filePath;
    }

    static String packageName(final String base, final List<String> packages) {
        return "%s.%s".formatted(base, String.join(".", packages));
    }

    static List<String> importStatements(final Table table) {
        return table.usingDataTypes()
                .stream().map("import %s;"::formatted).toList();
    }
}
