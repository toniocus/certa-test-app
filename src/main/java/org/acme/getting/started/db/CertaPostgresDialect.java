package org.acme.getting.started.db;

import java.sql.Types;
import java.util.Map;

import org.hibernate.dialect.PostgreSQL10Dialect;
import org.hibernate.dialect.function.SQLFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CertaPostgresDialect extends PostgreSQL10Dialect {

    private static final Logger log = LoggerFactory.getLogger(CertaPostgresDialect.class);

    public CertaPostgresDialect() {

        log.info("******************** YES THIS IS MY DIALECT");

        this.registerColumnType(Types.JAVA_OBJECT, "jsonb");

        registerFunction( "pg_ilike", new ILikeSqlFunction());

        Map<String, SQLFunction> functions = super.getFunctions();
        functions.keySet().forEach(System.out::println);
    }

}