package org.acme.getting.started.db;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.sql.DataSource;

@ApplicationScoped
public class DataBasic {

    @Inject
    DataSource dataSource;

}
