package se.iths.cecilia.postrgreszoo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import se.iths.cecilia.postrgreszoo.repository.MonkeyRepository;
import se.iths.cecilia.postrgreszoo.service.MonkeyService;

@Controller
@RequestMapping("/monkeys")
public class MonkeyController {

    private final MonkeyService monkeyService;
    private final MonkeyRepository monkeyRepository;

    public MonkeyController(MonkeyService monkeyService, MonkeyRepository monkeyRepository) {
        this.monkeyService = monkeyService;
        this.monkeyRepository = monkeyRepository;
    }

    @GetMapping
    public String getAllMonkeys(Model model) {
        model.addAttribute("monkeys", monkeyService.getAllMonkeys());
        return "monkeys";

    }
}
