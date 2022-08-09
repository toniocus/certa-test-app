package org.acme.getting.started.strategy;

import javax.enterprise.context.Dependent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Dependent
//@Unremovable
public class MyStrategyOne extends MyStrategyBase {

    private static final Logger log = LoggerFactory.getLogger(MyStrategyOne.class);


    @Override
    public void generateRequest() {
        log.info("generateRequest() in  {}", getIdString());
    }

    @Override
    public void processAnswer() {
        log.info("processAnswer() in  {}", getIdString());
    }



}
