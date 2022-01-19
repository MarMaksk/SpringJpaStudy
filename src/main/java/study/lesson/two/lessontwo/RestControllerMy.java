package study.lesson.two.lessontwo;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/restApi")
public class RestControllerMy {

    @GetMapping("/getRandomNum")
    public int getRandomNum() {
        return (int) (Math.random() * 10000000);
    }

    @GetMapping("/getRandomNumDiap")
    public int getRandomNum(@RequestParam int min, @RequestParam("max") int max) {
        return (int) (Math.random() * (max - min) + min);
    }

    @GetMapping("/randomQuote")
    public String randomQuote() {
        Map<Integer, String> quote = Map.of(1, "Все на свете имеет две стороны (Ленин)",
                2, "Воспитатель сам должен быть воспитан (Маркс)",
                3, "Нет большего мученья, чем о поре счастливой вспоминать (Данте)",
                4, "Тот, кто искал служенья, Должен идти один (Д\"Арк)");
        return quote.get((int) (Math.random() * quote.size()));
    }

    @GetMapping("/randomQuoteType")
    public String randomQuote(@RequestParam("type") String type) {
        Map<String, Map<Integer, String>> quote = new HashMap<>();
        quote.put("technology", Map.of(1, "Хотите – верьте, хотите – нет, но цель всего – удовольствие (Л. Торвальдс)"));
        quote.put("filosophy", Map.of(1, "Нет большего мученья, чем о поре счастливой вспоминать (Данте)"));
        quote.put("other", Map.of(1, "Все на свете имеет две стороны (Ленин)",
                2, "Воспитатель сам должен быть воспитан (Маркс)",
                3, "Тот, кто искал служенья, Должен идти один (Д\"Арк)"));
        Map<Integer, String> category = quote.get(type);
        return category.get((int) (Math.random() * (category.size())) + 1);
    }
}
