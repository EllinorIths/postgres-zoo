package se.iths.cecilia.postrgreszoo.validator;

import org.springframework.stereotype.Component;
import se.iths.cecilia.postrgreszoo.exception.pumaExceptions.PumaInvalidAgeException;
import se.iths.cecilia.postrgreszoo.exception.pumaExceptions.PumaInvalidWeightException;
import se.iths.cecilia.postrgreszoo.exception.pumaExceptions.PumaNameIsEmptyException;
import se.iths.cecilia.postrgreszoo.exception.pumaExceptions.PumaNameIsNullException;
import se.iths.cecilia.postrgreszoo.model.Puma;

@Component
public class PumaValidator {

    public void validate(Puma puma) {

        if (puma.getName() == null) {
            throw new PumaNameIsNullException("Puma name cannot be null");
        }

        if (puma.getName().isEmpty()) {
            throw new PumaNameIsEmptyException("Puma name cannot be empty");
        }

        if (puma.getAge() < 0) {
            throw new PumaInvalidAgeException("Puma age cannot be negative");
        }

        if (puma.getWeight() <= 0) {
            throw new PumaInvalidWeightException("Puma weight must be greater than 0");
        }
    }
}
