package java_core.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class ExtractRegex {
    public static void main(String[] args) throws IOException {
        try (Stream<String> lines = Files.lines(Path.of("C:\\Users\\Havey Hoang\\Desktop\\[confirm_line].txt"))) {
            lines.map(ExtractRegex::parse).filter(Objects::nonNull).sorted().forEach(System.out::println);
        }

        System.out.println("\n\n");

        try (Stream<String> lines = Files.lines(Path.of("C:\\Users\\Havey Hoang\\Desktop\\[add_co_pick].txt"))) {
            lines.map(ExtractRegex::parse).filter(Objects::nonNull).sorted().forEach(System.out::println);
        }
    }

    final static String REGEX = "\\w*apiIn\\.(?<fieldname>\\w+) = [^/]*// (?<description>.*)";
    final static Pattern PATTERN = Pattern.compile(REGEX);
    private static Field parse(String line) {
        Matcher matcher = PATTERN.matcher(line);
        if (matcher.find()) {
            String name = matcher.group("fieldname");
            String description = matcher.group("description");
            return new Field(name, description);
        }
        return null;
    }

    static class Field implements Comparable<Field> {
        private String name;
        private String description;

        public Field(String name, String description) {
            this.name = name;
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return String.format("%s", name).strip();
        }

        @Override
        public int compareTo(Field o) {
            return o.getName().compareTo(name);
        }
    }
}
