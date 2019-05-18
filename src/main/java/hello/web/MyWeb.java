package hello.web;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@EnableConfigurationProperties(WebProperties.class)
public class MyWeb {
    private final WebProperties webProperties;

    public MyWeb(WebProperties webProperties) {
        this.webProperties = webProperties;
    }

    public String title() {
        return this.webProperties.getTitle();
    }
}
