package com.example.with_db.generator.artifacts;

import com.example.with_db.generator.model.Column;
import com.example.with_db.generator.settings.Settings;
import com.example.with_db.generator.model.Table;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class Predicates extends AbstractFileWriter {

    private static final String TEMPLATE = "Predicates.ftlh";
    private static final String FILE_NAME_TEMPLATE = "%sPredicates.java";
    private static final List<String> PACKAGES = List.of("assertion", "predicates");

    public static void generate(final Settings settings, final Table table) {

        final Map<String, Object> parameter = Map.ofEntries(
                Map.entry("packageName", packageName(settings.basePackage(), PACKAGES)),
                Map.entry("table", table),
                Map.entry("importStatements", importStatements(table)),
                Map.entry("columns", table.columns())
        );

        final var path = outputPath(FILE_NAME_TEMPLATE.formatted(table.upperCamelCaseSingularName()), settings.outputDirectory(), PACKAGES);
        writeToFile(TEMPLATE, parameter, path);
    }

    static String nestedPredicates(final Table table) {
        final var columns = table.columns().stream().map(Column::lowerCamelCaseName).toList();
        final BiFunction<String, String, String> compose = (a, b) -> b.isEmpty() ? a : "%s.and(%s)".formatted(b, a);
        return foldRight(columns, "", compose);
    }

    public static <T, U> U foldRight(List<T> list, U identity, BiFunction<T, U, U> f) {
        return foldRightHelper(list, identity, f, 0);
    }

    private static <T, U> U foldRightHelper(List<T> list, U accumulator, BiFunction<T, U, U> f, int index) {
        if (index == list.size()) {
            return accumulator;
        } else {
            T element = list.get(index);
            U newAccumulator = f.apply(element, accumulator);
            return foldRightHelper(list, newAccumulator, f, index + 1);
        }
    }

}
