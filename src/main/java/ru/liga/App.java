package ru.liga;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        Stream<Path> stream = Files.walk(Paths.get("C:/json"));
        ObjectMapper mapper = new ObjectMapper();
        stream.filter(Files::isRegularFile).forEach(e -> {
            try {
                Home home = mapper.readValue(e.toFile(), Home.class);
                home.setPeople(home.getPeople() + 1);
                mapper.writeValue(e.toFile(), home);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }

}
