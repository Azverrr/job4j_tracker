package ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public  class FactTest {

    @Test
    public void whenExeption() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
            Fact.calc(-1);
    });
        assertThat(exception.getMessage()).isEqualTo("N could not be less then 0");
    }
}