package org.acme.getting.started.db;

import java.util.List;

import org.hibernate.QueryException;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.engine.spi.Mapping;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;

public class ILikeSqlFunction implements SQLFunction {

    @Override
    public boolean hasArguments() {
        return true;
    }

    @Override
    public boolean hasParenthesesIfNoArguments() {
        return true;
    }

    @Override
    public Type getReturnType(final Type firstArgumentType, final Mapping mapping)
            throws QueryException {
        return StandardBasicTypes.BOOLEAN;
    }

    @Override
    public String render(final Type firstArgumentType, final List arguments,
            final SessionFactoryImplementor factory) throws QueryException {

        return String.format(" (%s ILIKE %s) ", arguments.get(0).toString(), arguments.get(1).toString());
    }
}