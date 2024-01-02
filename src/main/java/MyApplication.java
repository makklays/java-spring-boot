import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class MyApplication {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}

// @RestController - стереотипная аннотация. Данная аннотация служит подсказкой для людей, читающих код, и для Spring,
// что класс играет определенную роль. В данном случае наш класс является @Controller для веб, поэтому Spring учитывает
// его при обработке входящих веб-запросов.

// @RequestMapping - аннотация передает информацию о "маршрутизации". Она сообщает Spring, что любой HTTP-запрос
// с путем / следует отображать на метод home

// Аннотации @RestController и @RequestMapping являются аннотациями Spring MVC (они не характерны для Spring Boot).

// @EnableAutoConfiguration. Эта аннотация сообщает Spring Boot, что необходимо "угадать", как нужно сконфигурировать
// Spring, основываясь на добавленных вами jar-зависимостях. Поскольку spring-boot-starter-web добавил Tomcat и
// Spring MVC, средство автоконфигурирования предполагает, что вы разрабатываете веб-приложение, и настраивает Spring
// соответствующим образом.