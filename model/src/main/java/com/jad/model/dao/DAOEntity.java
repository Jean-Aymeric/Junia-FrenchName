package com.jad.model.dao;

import com.jad.model.entity.IEntities;
import com.jad.model.entity.IEntity;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DAOEntity<E extends IEntity, Es extends IEntities<E>> {
    private final Connection connection;
    private final String findByIdProcedureName;
    private final String findAllProcedureName;
    private final String deleteByIdProcedureName;
    private final String saveProcedureName;

    protected DAOEntity(final String findByIdProcedureName,
                        final String findAllProcedureName,
                        final String deleteByIdProcedureName,
                        final String saveProcedureName) {
        this.connection = DBConnection.INSTANCE.getConnection();
        this.findByIdProcedureName = findByIdProcedureName;
        this.findAllProcedureName = findAllProcedureName;
        this.deleteByIdProcedureName = deleteByIdProcedureName;
        this.saveProcedureName = saveProcedureName;
    }

    public void delete(final E entity) throws SQLException {
        final CallableStatement call = this.connection.prepareCall(this.deleteByIdProcedureName);
        call.setInt(1, entity.getId());
        call.execute();
    }

    public abstract boolean save(final E entity) throws SQLException;

    public final E findById(final int id) throws SQLException {
        final CallableStatement call = this.connection.prepareCall(this.findByIdProcedureName);
        call.setInt(1, id);
        call.execute();
        return this.resultSetToEntity(call.getResultSet());
    }

    protected abstract E resultSetToEntity(final ResultSet resultSet);

    public final Es getAll(final Es entities) throws SQLException {
        final CallableStatement call = this.connection.prepareCall(this.findAllProcedureName);
        call.execute();
        final ResultSet resultSet = call.getResultSet();
        while (resultSet.next()) {
            entities.addEntity(this.resultSetToEntity(resultSet));
        }
        return entities;
    }
}
