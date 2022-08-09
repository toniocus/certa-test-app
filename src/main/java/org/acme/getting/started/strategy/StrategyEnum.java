package org.acme.getting.started.strategy;

public enum StrategyEnum {

    ONE(1L, MyStrategyOne.class),
    TWO(2L, MyStrategyTwo.class),
    THREE(3L, MyStrategyThree.class),

    OTRO(-999L, MyStrategyOne.class);

    Long id;
    Class<? extends MyStrategyBase> strategyClass;

    StrategyEnum(final Long id
            , final Class<? extends MyStrategyBase> clazz
            ) {
        this.id = id;
        this.strategyClass = clazz;
    }


    public static StrategyEnum findById(final Long id) {
        for (StrategyEnum e : StrategyEnum.values()) {
            if (e.id.equals(id)) {
                return e;
            }
        }

        return null;
    }

    public Class<? extends MyStrategyBase> getStrategyClass() {
        return this.strategyClass;
    }
}
