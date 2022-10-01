package ru.job4j.early;

public class PasswordValidator {
    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password is null.");
        }
        if (password.length() < 8 || password.length() > 32) {
            return "Длинна пароля должна быть в диапазоне от 8 до 32 символов";
        }
        char[] passwordArray = password.toCharArray();
        boolean isUpCase = false;
        boolean isLowCase = false;
        boolean isDigit = false;
        boolean isSymbol = false;
        for (char temp : passwordArray) {
            if (Character.isUpperCase(temp)) {
                isUpCase = true;
            }
            if (Character.isLowerCase(temp)) {
                isLowCase = true;
            }
            if (Character.isDigit(temp)) {
                isDigit = true;
            }
            if (!Character.isUpperCase(temp) && !Character.isLowerCase(temp) && !Character.isDigit(temp)) {
                isSymbol = true;
            }
        }
        if (!isUpCase){
            return "Пароль должен содержать хотябы один символ в верхнем регистре";
        }
        if (!isLowCase) {
            return "Пароль должен содержать хотябы один символ в нижнем регистре";
        }
        if (!isDigit) {
            return "Парль должен содержать хотябы одну цифру";
        }
        if (!isSymbol) {
            return "Пароль должен содержать хотябы один символ";
        }
        String[] wrongContains = new String[] {"qwerty", "12345", "password", "admin", "user"};
        for (String temp : wrongContains) {
            if (password.toLowerCase().contains(temp)) {
                return "Пароль слишком простой";
            }
        }
        return "Валидный пароль";
    }
}
