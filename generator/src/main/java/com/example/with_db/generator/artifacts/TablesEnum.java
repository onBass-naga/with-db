package com.example.with_db.generator.artifacts;

import com.example.with_db.generator.Column;
import com.example.with_db.generator.Settings;
import com.example.with_db.generator.Table;
import freemarker.template.Template;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.*;

public class TablesEnum {
    public static String generate(final Settings settings, final List<Table> tables) {

        try {
            Map<String, Object> root = new HashMap<>();
            root.put("tables", tables);
            root.put("packageName", "%s.tables".formatted(settings.basePackage()));

            Template temp = FreeMarkers.getTemplate("TablesEnum.ftlh");
            Writer out = new OutputStreamWriter(System.out);
            temp.process(root, out);

        } catch (final Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
