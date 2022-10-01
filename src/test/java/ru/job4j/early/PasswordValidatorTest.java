package ru.job4j.early;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void whenPasswordIsValidate() {
        String password = "String1?";
        String expected = "Валидный пароль";
        assertThat(PasswordValidator.validate(password)).isEqualTo(expected);
    }

    @Test
    void whenPasswordIsShort() {
        String password = "String";
        String expected = "Длинна пароля должна быть в диапазоне от 8 до 32 символов";
        assertThat(PasswordValidator.validate(password)).isEqualTo(expected);
    }

    @Test
    void whenPasswordIsNotUpCase() {
        String password = "string1?";
        String expected = "Пароль должен содержать хотябы один символ в верхнем регистре";
        assertThat(PasswordValidator.validate(password)).isEqualTo(expected);
    }

    @Test
    void whenPasswordIsNotLowCase() {
        String password = "STRING1?";
        String expected = "Пароль должен содержать хотябы один символ в нижнем регистре";
        assertThat(PasswordValidator.validate(password)).isEqualTo(expected);
    }

    @Test
    void whenPasswordIsNotDigit() {
        String password = "Strings?";
        String expected = "Парль должен содержать хотябы одну цифру";
        assertThat(PasswordValidator.validate(password)).isEqualTo(expected);
    }

    @Test
    void whenPasswordIsNotSymbol() {
        String password = "Strings11";
        String expected = "Пароль должен содержать хотябы один символ";
        assertThat(PasswordValidator.validate(password)).isEqualTo(expected);
    }

    @Test
    void whenPasswordIsSimple() {
        String password = "12345fG!1";
        String expected = "Пароль слишком простой";
        assertThat(PasswordValidator.validate(password)).isEqualTo(expected);
    }

    @Test
    void whenPasswordIsNull() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(null);
                });
        assertThat(exception.getMessage()).isEqualTo("Password is null.");
    }
}