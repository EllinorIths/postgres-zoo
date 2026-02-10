package se.iths.cecilia.postrgreszoo.service;

import org.springframework.stereotype.Service;
import se.iths.cecilia.postrgreszoo.exception.MonkeyNotFoundException;
import se.iths.cecilia.postrgreszoo.model.Monkey;
import se.iths.cecilia.postrgreszoo.repository.MonkeyRepository;
import se.iths.cecilia.postrgreszoo.validator.MonkeyValidator;

import java.util.List;

@Service
public class MonkeyService {

    private MonkeyRepository monkeyRepository;

    private MonkeyValidator monkeyValidator;

    public MonkeyService(MonkeyRepository monkeyRepository, MonkeyValidator monkeyValidator) {
        this.monkeyRepository = monkeyRepository;
        this.monkeyValidator = monkeyValidator;
    }

    public List<Monkey> getMonkeys() {
        return monkeyRepository.findAll();
    }

    public Monkey getMonkey(long id) {
        return monkeyRepository.findById(id)
                .orElseThrow(() -> new MonkeyNotFoundException("Monkey with id " + id + " not found"));
    }

    public Monkey createMonkey(Monkey monkey) {
        verifyMonkey(monkey);
        Monkey newMonkey = new Monkey();

        newMonkey.setName(monkey.getName());
        newMonkey.setCurrentHabitat(monkey.getCurrentHabitat());
        newMonkey.setOriginCountry(monkey.getOriginCountry());
        newMonkey.setType(monkey.getType());

        return monkeyRepository.save(monkey);
    }

    public Monkey updateMonkey(long id, Monkey monkey) {
        Monkey currentMonkey = monkeyRepository.findById(id).orElseThrow(() -> new MonkeyNotFoundException("Monkey with id " + id + " not found"));
        verifyMonkey(monkey);
        monkey.setId(id);
        currentMonkey.setName(monkey.getName());
        currentMonkey.setCurrentHabitat(monkey.getCurrentHabitat());
        currentMonkey.setOriginCountry(monkey.getOriginCountry());
        currentMonkey.setType(monkey.getType());
        return monkeyRepository.save(currentMonkey);
    }

    public void deleteMonkey(long id) {
        monkeyRepository.findById(id).orElseThrow(() -> new MonkeyNotFoundException("Monkey with id " + id + " not found"));
        monkeyRepository.deleteById(id);
    }


    private void verifyMonkey(Monkey monkey) {

        monkeyValidator.verifyThatNameIsNotEmpty(monkey);
        monkeyValidator.verifyThatNameIsNotNull(monkey);
        monkeyValidator.verifyThatMonkeyHasHabitat(monkey);
        monkeyValidator.verifyThatMonkeyHasType(monkey);
        monkeyValidator.verifyThatMonkeyHasOriginCountry(monkey);
    }
}
