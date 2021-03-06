package edu.uade.appl_interact.data_access.dao.impl;

import edu.uade.appl_interact.model.entities.User;

import java.sql.ResultSet;

public class UserDao extends Base<User> {
    private static UserDao instance;

    private UserDao() {
    }

    public static UserDao getInstance() {
        if (instance == null) {
            instance = new UserDao();
        }
        return instance;
    }

    @Override
    public String getTableName() {
        return "user";
    }

    @Override
    public String getCreateQuery(User entity) {

        return new StringBuilder("INSERT INTO user (name, email, birth_date ,password) VALUES ( ")
                .append(String.format("'%s', ", entity.getName()))
                .append(String.format("'%s', ", entity.getEmail()))
                .append(String.format("'%s', ", formatter.format(entity.getBirthDate())))
                .append(String.format("'%s')", entity.getPassword()))
                .toString();
    }

    @Override
    public String getUpdateQuery(User entity) {
        return new StringBuilder("UPDATE user SET ")
                .append(String.format("name = '%s', ", entity.getName()))
                .append(String.format("email = '%s', ", entity.getEmail()))
                .append(String.format("birth_date = '%s' ", formatter.format(entity.getBirthDate())))
                .append(String.format("WHERE id = %d", entity.getId()))
                .toString();
    }

    public String getUpdatePassQuery(User entity) {
        return new StringBuilder("UPDATE user SET ")
                .append(String.format("password = '%s', ", entity.getPassword()))
                .append(String.format("WHERE id = %d", entity.getId()))
                .toString();
    }

    @Override
    public User toObject(ResultSet resultSet) throws Exception {
        User result = new User();
        result.setId(resultSet.getInt("id"));
        result.setName(resultSet.getString("name"));
        result.setEmail(resultSet.getString("email"));
        result.setPassword(resultSet.getString("password"));
        return result;
    }

    public String getUserFromEmail(String field, String value) {
        return new StringBuilder("SELECT * FROM ")
                .append(getTableName())
                .append(String.format(" WHERE %s = '%s' ", field, value))
                .toString();
    }


}
