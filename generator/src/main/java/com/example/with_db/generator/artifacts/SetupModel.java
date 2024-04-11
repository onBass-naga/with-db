package com.example.with_db.generator.artifacts;

import com.example.with_db.generator.ColumnMeta;
import com.example.with_db.generator.Settings;
import com.example.with_db.generator.TableName;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.*;
import java.util.stream.Collectors;

public class SetupModel {

    public static String generate(final Settings settings, final TableName tableName, final List<ColumnMeta> columnMetas) {

        try {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);
            cfg.setDirectoryForTemplateLoading(new File("generator/src/main/resources/templates"));
            // Recommended settings for new projects:
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            cfg.setLogTemplateExceptions(false);
            cfg.setWrapUncheckedExceptions(true);
            cfg.setFallbackOnNullLoopVariable(false);
            cfg.setSQLDateAndTimeTimeZone(TimeZone.getDefault());


            Map<String, Object> root = new HashMap<>();
            root.put("tableName", tableName);
            root.put("packageName", "%s.setup.model".formatted(settings.basePackage()));

            final var importStatements = columnMetas.stream()
                    .map(ColumnMeta::fullyQualifiedClassNameOpt)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .map("import %s;"::formatted)
                    .collect(Collectors.toUnmodifiableSet());

            root.put("importStatements", new TreeSet<>(importStatements));
            root.put("columns", columnMetas);
            root.put("requiredColumns", columnMetas.stream().filter(ColumnMeta::isRequired).toList());


            /* Get the template (uses cache internally) */
            Template temp = cfg.getTemplate("SetupModel.ftlh");

            /* Merge data-model with template */
            Writer out = new OutputStreamWriter(System.out);
            temp.process(root, out);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
