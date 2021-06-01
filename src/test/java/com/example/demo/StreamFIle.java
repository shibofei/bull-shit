package com.example.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamFIle {
    public static void main(String[] args) throws IOException {
        Stream<String> lines = Files.lines(Paths.get("E:\\config.json"));
        lines.forEach(System.out::println);
    }
}
