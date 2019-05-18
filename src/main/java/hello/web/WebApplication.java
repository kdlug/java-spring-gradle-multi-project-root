package hello.web;

import hello.service.MyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Because WebApplication is inside a different package (hello.web) than MyService (hello.service),
// @SpringBootApplication won’t detect it initially.
// There are different ways to allow `MyService to be picked up:
// Import it directly with @Import(MyService.class).
// Fetch everything from it’s package using @SpringBootApplication(scanBasePackageClasses={…​}).
// ​specifying the parent package by name, hello @SpringBootApplication(scanBasePackages = "hello")
@SpringBootApplication(scanBasePackages = "hello")
@RestController
public class WebApplication {

    private final MyService myService;

    public WebApplication(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/")
    public String home() {
        return myService.message();
    }

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}