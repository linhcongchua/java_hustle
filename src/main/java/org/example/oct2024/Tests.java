package org.example.oct2024;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Tests {
    public static void main(String[] args) {
        List<Adu> adus = List.of(new Adu(null, 1), new Adu("halo", 2));
        Map<String, List<Adu>> collect = adus.stream().collect(Collectors.groupingBy(Adu::getName));
        System.out.println(collect);
    }

    public static class Adu {
        String name;
        int age;

        public Adu(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

}
