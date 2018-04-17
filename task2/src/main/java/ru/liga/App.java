package ru.liga;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.liga.xml.Person;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public class App {
    private static final String xmlPath = "C:\\Users\\learning\\IdeaProjects\\day14\\task2\\src\\xml\\persons";
    private static final String jsonPath = "C:\\Users\\learning\\IdeaProjects\\day14\\task2\\src\\json";

    public static void main(String[] args) throws IOException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Stream<Path> stream = Files.walk(Paths.get(xmlPath));
        ObjectMapper mapper = new ObjectMapper();
        stream.filter(Files::isRegularFile).forEach(path -> {
            try {
                Person person = (Person) unmarshaller.unmarshal(path.toFile());
                if (person.getCompany().equals("ABC")){
                    mapper.writeValue(new File(jsonPath + "\\"
                            + person.getId()), person);
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        });

    }
}
