package org.acme.getting.started.db;

import java.util.Objects;

import org.hibernate.boot.model.relational.Namespace;
import org.hibernate.boot.model.relational.Sequence;
import org.hibernate.mapping.Table;
import org.hibernate.tool.schema.spi.SchemaFilter;

class MySchemaFilter implements SchemaFilter {

    public static final MySchemaFilter INSTANCE = new MySchemaFilter();

    @Override
    public boolean includeNamespace(final Namespace namespace) {
        return true;
    }

    @Override
    public boolean includeTable(final Table table) {
        System.out.println("******* USING SCHEMA FILTER ****");
        return table.getSchema() == null
                || !Objects.equals(table.getSchema(), "salesforce");
    }


    @Override
    public boolean includeSequence(final Sequence sequence) {
        return true;
    }
}