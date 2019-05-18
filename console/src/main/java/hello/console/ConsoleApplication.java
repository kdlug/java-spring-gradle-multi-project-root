package hello.console;

import hello.service.MyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// Because ConsoleApplication is inside a different package (hello.console) than MyService (hello.service),
// @SpringBootApplication won’t detect it initially.
// There are different ways to allow `MyService to be picked up:
// Import it directly with @Import(MyService.class).
// Fetch everything from it’s package using @SpringBootApplication(scanBasePackageClasses={…​}).
// ​specifying the parent package by name, hello @SpringBootApplication(scanBasePackages = "hello")
@SpringBootApplication(scanBasePackages = "hello")
public class ConsoleApplication implements CommandLineRunner {

    private final MyService myService;

    public ConsoleApplication(MyService myService) {
        this.myService = myService;
    }

    private static Logger LOG = LoggerFactory
            .getLogger(ConsoleApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ConsoleApplication.class);
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(ConsoleApplication.class, args);
        LOG.info("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) {
        LOG.info("EXECUTING : command line runner");

        for (int i = 0; i < args.length; ++i) {
            LOG.info("args[{}]: {}", i, args[i]);
        }

        LOG.info(myService.message());
    }
}