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
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("Stri!1");
                });
        assertThat(exception.getMessage()).isEqualTo("Длинна пароля должна быть в диапазоне от 8 до 32 символов");
    }

    @Test
    void whenPasswordIsNotUpCase() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("string!1");
                });
        assertThat(exception.getMessage()).isEqualTo("Пароль содержит хотя бы один символ в верхнем регистре");
    }

    @Test
    void whenPasswordIsNotLowCase() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("STRING!1");
                });
        assertThat(exception.getMessage()).isEqualTo("Пароль содержит хотя бы один символ в нижнем регистре");
    }

    @Test
    void whenPasswordIsNotDigit() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("Strings!");
                });
        assertThat(exception.getMessage()).isEqualTo("Пароль содержит хотя бы одну цифру");
    }

    @Test
    void whenPasswordIsNotSymbol() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("String12");
                });
        assertThat(exception.getMessage()).isEqualTo("Пароль содержит хотя бы один спец. символ");
    }

    @Test
    void whenPasswordIsSimple() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("12345Aa1!");
                });
        assertThat(exception.getMessage()).isEqualTo("Пароль слишком простой");
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