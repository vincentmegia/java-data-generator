package com.stupendousware.datagenerator.readers;

import java.time.LocalDate;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.stupendousware.datagenerator.models.User;

public class UserItemReader implements ItemReader<User> {

    @Override
    public User read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        // TODO Auto-generated method stub
        return User.create("john", "doe", "john.doe-java-1", "salty-joe-java-1", "john.doe-java@mail.com",
                LocalDate.now());
    }

}
