package hello.console;

import hello.service.MyService;
import hello.web.MyWeb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;


// Because ConsoleApplication is inside a different package (hello.console) than MyService (hello.service),
// @SpringBootApplication won’t detect it initially.
// There are different ways to allow `MyService to be picked up:
// Import it directly with @Import(MyService.class).
// Fetch everything from it’s package using @SpringBootApplication(scanBasePackageClasses={…​}).
// ​specifying the parent package by name, hello @SpringBootApplication(scanBasePackages = "hello")
@SpringBootApplication(scanBasePackages = "hello")
public class ConsoleApplication implements CommandLineRunner {

    private final MyService myService;
    private final MyWeb myWeb;

    public ConsoleApplication(MyService myService, MyWeb myWeb) {
        this.myService = myService;
        this.myWeb = myWeb;
    }

    private static Logger LOG = LoggerFactory
            .getLogger(ConsoleApplication.class);

    public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        // Because consoleApplication depends on WebApplication which runs web server
        // We have to additionally disable web server
        new SpringApplicationBuilder(ConsoleApplication.class).web(WebApplicationType.NONE).run(args);
        LOG.info("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) {
        LOG.info("EXECUTING : command line runner");

        for (int i = 0; i < args.length; ++i) {
            LOG.info("args[{}]: {}", i, args[i]);
        }

        LOG.info(myService.message());
        LOG.info(myWeb.title());
    }
}