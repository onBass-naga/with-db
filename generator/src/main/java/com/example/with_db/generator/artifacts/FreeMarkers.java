package com.example.with_db.generator.artifacts;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;
import java.util.TimeZone;

public class FreeMarkers {
    private static final Configuration config;
    static {
        config = new Configuration(Configuration.VERSION_2_3_32);
        try {
            config.setDirectoryForTemplateLoading(new File("generator/src/main/resources/templates"));
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
        config.setDefaultEncoding("UTF-8");
        config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        config.setLogTemplateExceptions(false);
        config.setWrapUncheckedExceptions(true);
        config.setFallbackOnNullLoopVariable(false);
        config.setSQLDateAndTimeTimeZone(TimeZone.getDefault());
    }

    public static Template getTemplate(final String templateName) {
        try {
            return config.getTemplate(templateName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
