package se.iths.cecilia.postrgreszoo.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.iths.cecilia.postrgreszoo.exception.pumaExceptions.PumaInvalidAgeException;
import se.iths.cecilia.postrgreszoo.exception.pumaExceptions.PumaInvalidWeightException;
import se.iths.cecilia.postrgreszoo.exception.pumaExceptions.PumaNameIsEmptyException;
import se.iths.cecilia.postrgreszoo.exception.pumaExceptions.PumaNameIsNullException;
import se.iths.cecilia.postrgreszoo.model.Puma;

class PumaValidatorTest {

    Puma puma;
    PumaValidator pumaValidator;

    @BeforeEach
    void setUp() {

        puma = new Puma();
        pumaValidator = new PumaValidator();

    }

    @Test
    @DisplayName("Exception thrown when name is null")
    void verifyNameIsNullThrowsException() {

        puma.setName(null);

        Assertions.assertThrows(
                PumaNameIsNullException.class,
                () -> pumaValidator.validate(puma)
        );
    }

    @Test
    @DisplayName("Exception thrown when name is empty")
    void verifyNameIsEmptyThrowsException() {

        puma.setName("");

        Assertions.assertThrows(
                PumaNameIsEmptyException.class,
                () -> pumaValidator.validate(puma)
        );
    }

    @Test
    @DisplayName("Exception thrown when age is negative")
    void verifyAgeIsNegativeThrowsException() {

        puma.setName("Puma");
        puma.setAge(-1);
        puma.setWeight(50);

        Assertions.assertThrows(
                PumaInvalidAgeException.class,
                () -> pumaValidator.validate(puma)
        );
    }

    @Test
    @DisplayName("Exception thrown when weight is zero")
    void verifyWeightIsZeroThrowsException() {

        puma.setName("Puma");
        puma.setAge(5);
        puma.setWeight(0);

        Assertions.assertThrows(
                PumaInvalidWeightException.class,
                () -> pumaValidator.validate(puma)
        );
    }

    @Test
    @DisplayName("Exception thrown when weight is negative")
    void verifyWeightIsNegativeThrowsException() {

        puma.setName("Puma");
        puma.setAge(5);
        puma.setWeight(-10);

        Assertions.assertThrows(
                PumaInvalidWeightException.class,
                () -> pumaValidator.validate(puma)
        );
    }

    @Test
    @DisplayName("No exception thrown when Puma is valid")
    void verifyValidPumaDoesNotThrowException() {

        puma.setName("Valid Puma");
        puma.setAge(5);
        puma.setWeight(60);

        Assertions.assertDoesNotThrow(
                () -> pumaValidator.validate(puma)
        );
    }
}