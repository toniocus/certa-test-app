package org.acme.getting.started.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class MyStrategyBase implements MyStrategy {


    private static final Logger log = LoggerFactory.getLogger(MyStrategyBase.class);

    private static long idCounter = 1;

    private StrategyContext context;
    private long id;

    MyStrategyBase() {
        log.info("Constructing strategy: {}",  getClass().getSimpleName());
        this.id = idCounter++;
    }

    void initialize(final StrategyContext context) {

        /*
        if (this.context != null) {
            throw new RuntimeException("You cannot initialize Strategy more than once");
        }
        */

        this.context = context;
    }

    public StrategyContext getContext() {
        return this.context;
    }

    public long getId() {
        return this.id;
    }

    public String getIdString() {
        return String.format("StrategyId: %s(%d), ContextId: %d"
                , getClass().getSimpleName()
                , getId()
                , getContext().getId()
                );
    }

}
