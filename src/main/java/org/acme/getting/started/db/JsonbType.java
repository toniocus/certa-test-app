package org.acme.getting.started.db;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Objects;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

public class JsonbType implements UserType {

    @Override
    public int[] sqlTypes() {
        return new int[]{Types.JAVA_OBJECT};
    }

    @Override
    public Class<JsonNode> returnedClass() {
        return JsonNode.class;
    }

    @Override
    public Object nullSafeGet(final ResultSet rs
            , final String[] names
            , final SharedSessionContractImplementor session
            , final Object owner)
            throws HibernateException, SQLException {

        try (InputStream cellContent = rs.getBinaryStream(names[0]) ){

            if (cellContent == null) {
                return null;
            }

            final ObjectMapper mapper = new ObjectMapper();
            return mapper.readTree(cellContent);
        } catch (final Exception ex) {
            throw new RuntimeException("Failed to convert Sql column " + names[0] + " to JsonNode " + ex.getMessage(), ex);
        }
    }

    @Override
    public void nullSafeSet(final PreparedStatement ps
            , final Object value
            , final int idx
            , final SharedSessionContractImplementor session) throws HibernateException, SQLException {

        if (value == null) {
            ps.setNull(idx, Types.OTHER);
            return;
        }
        try {
            ps.setObject(idx, value.toString(), Types.OTHER);
        } catch (final Exception ex) {
            throw new RuntimeException("Failed to convert JsonNode to SqlObject: " + ex.getMessage(), ex);
        }
    }

    @Override
    public boolean equals(final Object x, final Object y) throws HibernateException {
        return Objects.equals(x, y);
    }

    @Override
    public int hashCode(final Object x) throws HibernateException {
        return x == null ? 0 : x.hashCode();
    }

    @Override
    public Object deepCopy(final Object value) throws HibernateException {
        return value == null ? null : ((JsonNode) value).deepCopy();
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(final Object value) throws HibernateException {
        return value == null ? null : value.toString();
    }

    @Override
    public Object assemble(final Serializable cached, final Object owner) throws HibernateException {
        return cached == null ? null : new ObjectMapper().valueToTree(cached);
    }

    @Override
    public Object replace(final Object original, final Object target, final Object owner) throws HibernateException {
        return original;
    }
}