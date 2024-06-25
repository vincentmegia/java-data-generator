package com.stupendousware.datagenerator.processors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.stupendousware.datagenerator.models.User;

@Component
public class UserItemProcessor implements ItemProcessor<User, User> {
    private static final Logger log = LoggerFactory.getLogger(UserItemProcessor.class);

    /**
     * Spring batch pattern have transformation layer where business rules
     * User model will encapsulate logic specic only to User.
     */
    @Override
    public User process(User item) throws Exception {
        String firstname = item.firstname().toUpperCase();
        String lastname = item.lastname().toUpperCase();
        String username = item.username().toUpperCase();
        String email = item.email().toUpperCase();
        User user = User.create(item, firstname, lastname, username, email);
        log.info("user id: %s, firstname, lastname, email has been transformed", user.id());
        return user;
    }

}
