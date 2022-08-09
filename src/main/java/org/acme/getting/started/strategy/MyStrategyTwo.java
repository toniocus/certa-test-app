package org.acme.getting.started.strategy;

import javax.enterprise.context.Dependent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.arc.Unremovable;

@Dependent
@Unremovable
public class MyStrategyTwo extends MyStrategyBase {

    private static final Logger log = LoggerFactory.getLogger(MyStrategyTwo.class);


    @Override
    public void generateRequest() {
        log.info("generateRequest() in  {}", getIdString());
    }

    @Override
    public void processAnswer() {
        log.info("processAnswer() in  {}", getIdString());
    }



}
