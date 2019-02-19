package com.lsc.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("taskComponent")
public class TaskComponent {
    private static final Log LOGGER = LogFactory.getLog( TaskComponent.class);

    @Scheduled(fixedDelay = 10000)
    public void doTask(){
        LOGGER.info ( "Hello from here" );
    }
}
