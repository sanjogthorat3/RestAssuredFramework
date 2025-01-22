package utils;

import com.github.javafaker.Faker;

public class TestDataUtils {
    public static String generateName(){
        Faker faker = new Faker();
        return "Playlist" + faker.regexify("[a-zA-Z1-9 $!]{10}");
    }

    public static String generateDescription(){
        Faker faker = new Faker();
        return "Description" + faker.regexify("[a-zA-Z1-9 $!]{50}");
    }
}
