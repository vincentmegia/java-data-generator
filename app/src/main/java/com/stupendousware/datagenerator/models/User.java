package com.stupendousware.datagenerator.models;

import java.time.LocalDate;

public record User(
        long id,
        String lastname,
        String firstname,
        String username,
        String password,
        String salt,
        LocalDate createdDate,
        LocalDate updatedDate,
        String email,
        LocalDate birthDate) {

    public static User create(String firstname,
            String lastname,
            String username,
            String password,
            String email,
            LocalDate birthDate) {
        var id = LocalDate.now().toEpochDay();
        var salt = String.format("%s-%s-%s-%s", firstname, id, lastname, id);
        var createdDate = LocalDate.now();
        return new User(id, lastname, firstname,
                username, password, salt,
                createdDate, null, email, birthDate);
    }

    public static User create(User user, String firstname, String lastname, String username, String email) {
        var id = LocalDate.now().toEpochDay();
        var salt = String.format("%s-%s-%s-%s", firstname, id, lastname, id);
        var createdDate = LocalDate.now();
        return new User(id, lastname, firstname,
                username, user.password(), salt,
                createdDate, user.updatedDate(), user.email(), user.birthDate());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User user = (User) obj;
        if (this.id != user.id())
            return false;

        return true;
    }
}
