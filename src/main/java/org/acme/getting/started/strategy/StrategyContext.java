package org.acme.getting.started.strategy;

public class StrategyContext {

    private static long idCounter = 1;
    private long id;

    public StrategyContext() {
        this.id = idCounter++;
    }

    public long getId() {
        return this.id;
    }


}
