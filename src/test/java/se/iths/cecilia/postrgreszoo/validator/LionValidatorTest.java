package se.iths.cecilia.postrgreszoo.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.iths.cecilia.postrgreszoo.exception.lionExceptions.*;
import se.iths.cecilia.postrgreszoo.model.Lion;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LionValidatorTest {

    LionValidator lionValidator;
    Lion lion;

    @BeforeEach
    public void setUp() {
        lion = new Lion();
        lionValidator = new LionValidator();
    }

    @Test
    public void verifyNameIsNull() {
        lion.setName(null);
        assertThrows(LionNameIsNullException.class, () ->
                lionValidator.validate(lion));
    }

    @Test
    public void verifyNameIsEmpty() {
        lion.setName("");
        assertThrows(LionNameIsEmptyException.class, () ->
                lionValidator.validate(lion));
    }

    @Test
    public void verifyName() {
        lion.setName("Karin");
        lionValidator.validate(lion);
    }

    @Test
    public void verifyAgeIsBelowRange() {
        lion.setName("Karin");
        lion.setAge(-1);
        assertThrows(LionAgeOutOfRangeException.class, () ->
                lionValidator.validate(lion));
    }

    @Test
    public void verifyAgeIsOverRange() {
        lion.setName("Peter");
        lion.setAge(111);
        assertThrows(LionAgeOutOfRangeException.class, () ->
                lionValidator.validate(lion));
    }

    @Test
    public void verifyAge() {
        lion.setName("Kiara");
        lion.setAge(12);
        lionValidator.validate(lion);
    }

    @Test
    public void verifyWeightIsBelowRange() {
        lion.setName("Olle");
        lion.setAge(12);
        lion.setWeight(-25);
        assertThrows(LionWeightOutOfRangeException.class, () ->
                lionValidator.validate(lion));
    }

    @Test
    public void verifyWeightIsOverRange() {
        lion.setName("Linda");
        lion.setAge(64);
        lion.setWeight(351);
        assertThrows(LionWeightOutOfRangeException.class, () ->
                lionValidator.validate(lion));
    }

    @Test
    public void verifyWeight() {
        lion.setName("Petra");
        lion.setAge(65);
        lion.setWeight(211);
        lionValidator.validate(lion);
    }

    @Test
    public void verifyKillsNegativeNumber() {
        lion.setName("Bill");
        lion.setAge(42);
        lion.setWeight(172);
        lion.setKills(-4);
        assertThrows(LionKillsNegativeException.class, () ->
                lionValidator.validate(lion));
    }

    @Test
    public void verifyKills() {
        lion.setName("Anders");
        lion.setAge(37);
        lion.setWeight(142);
        lion.setKills(9);
        lionValidator.validate(lion);
    }
}
