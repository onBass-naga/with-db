package com.example.with_db.generator.artifacts;

import com.example.with_db.generator.Column;
import com.example.with_db.generator.Settings;
import com.example.with_db.generator.Table;
import freemarker.template.Template;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.*;
import java.util.stream.Collectors;

public class SetupModel {

    public static String generate(final Settings settings, final Table table) {

        try {
            Map<String, Object> root = new HashMap<>();
            root.put("table", table);
            root.put("packageName", "%s.setup.model".formatted(settings.basePackage()));

            final var importStatements = table.usingDataTypes()
                    .stream().map("import %s;"::formatted).toList();

            root.put("importStatements", importStatements);
            root.put("columns", table.columns());
            root.put("requiredColumns", table.requiredColumns());

            Template temp = FreeMarkers.getTemplate("SetupModel.ftlh");
            Writer out = new OutputStreamWriter(System.out);
            temp.process(root, out);

        } catch (final Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
