package com.example.with_db.generator;

import com.example.with_db.generator.settings.SettingsFileLoader;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Path to setting.yaml is required.");
        }

        final var filePath = args[0];
        final var settings = SettingsFileLoader.load(filePath);
        new Generator().execute(settings);
    }
}
