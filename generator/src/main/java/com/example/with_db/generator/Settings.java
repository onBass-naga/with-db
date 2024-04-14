package com.example.with_db.generator;

public record Settings(
        String driverClassName,
        String url,
        String schema,
        String username,
        String password,
        String outputDirectory,
        String basePackage,
        String dataSetPrefix) {
}
