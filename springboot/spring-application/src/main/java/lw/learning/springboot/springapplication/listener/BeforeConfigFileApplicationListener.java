package lw.learning.springboot.springapplication.listener;

import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * Before {@link ConfigFileApplicationListener}
 *
 * @Author lw
 * @Date 2019-02-16 19:14:56
 **/
public class BeforeConfigFileApplicationListener implements SmartApplicationListener, Ordered {

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return ApplicationEnvironmentPreparedEvent.class.isAssignableFrom(eventType)
                || ApplicationPreparedEvent.class.isAssignableFrom(eventType);
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationEnvironmentPreparedEvent) {
            ApplicationEnvironmentPreparedEvent preparedEvent = (ApplicationEnvironmentPreparedEvent) event;
            ConfigurableEnvironment environment = preparedEvent.getEnvironment();
            String java = environment.getProperty("java");
            System.out.println("\n=========================================================\n");
            System.out.println("java = " + java);
            System.out.println("\n=========================================================\n");
        }
        if (event instanceof ApplicationPreparedEvent) {
        }
    }

    @Override
    public int getOrder() {
        return ConfigFileApplicationListener.DEFAULT_ORDER + 1;
    }
}
