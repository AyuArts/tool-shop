package org.testWork.utils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import java.io.File;
import java.io.IOException;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class RandomUser {

    private static final String FILE_PATH = "user.json";
    private static final Faker faker = new Faker();
    private static final Random random = new Random();
    private static final List<String> allowedCountries = List.of(
            "United States of America (the)"
    );

    private static RandomUser instance;

    // ⬇️ Додано анотацію для десеріалізації
    @JsonProperty("userData")
    private final Map<String, String> userData;

    // Конструктор для Jackson (не створює нових даних)
    @JsonCreator
    public RandomUser(@JsonProperty("userData") Map<String, String> userData) {
        this.userData = userData != null ? userData : new HashMap<>();
    }

    // Приватний конструктор для генерації нових даних
    private RandomUser() {
        this.userData = new HashMap<>();
        generateUser();
        save();
    }

    public static RandomUser getInstance() {
        if (instance == null) {
            File file = new File(FILE_PATH);
            ObjectMapper mapper = new ObjectMapper();

            if (file.exists()) {
                try {
                    instance = mapper.readValue(file, RandomUser.class);
                } catch (IOException e) {
                    System.err.println("Failed to load user.json, creating new user");
                    instance = new RandomUser();
                }
            } else {
                instance = new RandomUser();
            }
        }
        return instance;
    }

    private static String generateStrongPassword() {
        String upper = faker.letterify("?").toUpperCase();
        String lower = faker.letterify("?").toLowerCase();
        String digit = faker.numerify("#");
        String special = faker.regexify("[!@#$%^&*]");
        String rest = faker.lorem().characters(4, 8, true);
        String combined = upper + lower + digit + special + rest;

        List<Character> chars = new ArrayList<>();
        for (char c : combined.toCharArray()) {
            chars.add(c);
        }

        Collections.shuffle(chars);

        return chars.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private void generateUser() {
        userData.put("firstName", faker.name().firstName());
        userData.put("lastName", faker.name().lastName());
        userData.put("email", faker.internet().emailAddress());
        userData.put("phone", "123456789" + random.nextInt(1000000));
        userData.put("password", generateStrongPassword());
        userData.put("street", faker.address().streetAddress());
        userData.put("postalCode", faker.address().zipCode());
        userData.put("city", faker.address().city());
        userData.put("state", faker.address().state());
        userData.put("country", allowedCountries.get(random.nextInt(allowedCountries.size())));
        userData.put("dateOfBirth", faker.date().birthday(18, 60)
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate()
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
    }

    public void save() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), this);
        } catch (IOException e) {
            System.err.println("Failed to save user.json: " + e.getMessage());
        }
    }

    public String get(String key) {
        return userData.get(key);
    }

    public void set(String key, String value) {
        userData.put(key, value);
        save();
    }

    public Map<String, String> toMap() {
        return new HashMap<>(userData);
    }

    public Map<String, String> getUserData() {
        return userData;
    }
}
