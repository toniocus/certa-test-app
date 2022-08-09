package org.acme.getting.started.strategy;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class StrategyFactory {

    @Inject
    Instance<MyStrategyBase> strategyProvider;

    @Inject
    BeanManager manager;


    public MyStrategyBase  createStrategy(final Long id, final StrategyContext context) {

        StrategyEnum selected = StrategyEnum.findById(id);

        if (selected == null) {
            throw new RuntimeException("No strategy available for id: " + id);
        }

        // TODO Ensure only one is return
        List<? extends MyStrategyBase> strategies = this
                .strategyProvider.select(selected.getStrategyClass())
                .stream()
                .collect(Collectors.toList());

        if (strategies.size() != 1) {
            throw new RuntimeException("Incorrect # of strategies found for id: " + id);
        }


        strategies.get(0).initialize(context);
        return strategies.get(0);
    }
}
