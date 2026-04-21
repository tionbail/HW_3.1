package utils;

import static java.lang.String.format;

public class RandomUtils {

    public static int getRandomInt(int min, int max) {
        int range = (max - min) + 1;
        int random = (int) ((range * Math.random()) + min);
        return random;
    }

    public static String getRandomPhone() {
        String phoneTemplate = "%s%s%s%s%s";

        return format(phoneTemplate, getRandomInt(1, 9), getRandomInt(111, 999), getRandomInt(111, 999)
                , getRandomInt(11, 99), getRandomInt(1, 9));
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female"};
        return getRandomItemStringArray(genders);
    }

    public static String getRandomSubject() {
        String[] subjects = {"Math", "History", "English", "Geometry", "Biology"};
        return getRandomItemStringArray(subjects);
    }

    public static String getRandomHobbies() {
        String[] hobbies = {"Reading", "Sports", "Music"};
        return getRandomItemStringArray(hobbies);
    }

    public static String getRandomImage() {
        String[] image = {"screen.jpg","screen1.jpg","screen2.jpg"};
        return getRandomItemStringArray(image);
    }

    public static String getRandomState() {
        String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return getRandomItemStringArray(state);
    }

    public static String getRandomMonth() {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        return getRandomItemStringArray(months);
    }

    public static String getRandomCity(String states) {
        switch (states) {
            case "NCR":
                return getRandomItemStringArray(new String[]{"Delhi", "Gurgaon", "Noida"});
            case "Uttar Pradesh":
                return getRandomItemStringArray(new String[]{"Agra", "Lucknow", "Merrut"});
            case "Haryana":
                return getRandomItemStringArray(new String[]{"Karnal", "Panipat"});
            case "Rajasthan":
                return getRandomItemStringArray(new String[]{"Jaipur", "Jaiselmer"});
            default:
                return states;
        }
    }

    public static String getRandomItemStringArray(String[] stringArray) {
        int arrayLength = stringArray.length;
        int randomIndex = getRandomInt(0, arrayLength - 1);
        return stringArray[randomIndex];
    }

}
