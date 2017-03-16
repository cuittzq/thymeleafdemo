package cn.tzq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by zhiqiang on 2017/3/16.
 */
@SpringBootApplication
public class Application  extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    // 重新绑定一个新端口
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        // container.setPort(8081);
    }
}
