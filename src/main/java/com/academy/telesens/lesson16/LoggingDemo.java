package com.academy.telesens.lesson16;

import com.academy.telesens.lesson05.oop.Person;
import com.academy.telesens.util.PropertyProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingDemo {
    private static Logger LOG = LoggerFactory.getLogger(LoggingDemo.class);

    public static void main(String[] args) {
        Person person = new Person();
        person.setFirstName("Vitaly");
        person.setAge(28);
        LOG.info("Info message {}", "data"); // Ключевая информация
        LOG.error("Error message"); // Ошибки
        LOG.debug("Debug message. Person: name {}, age {}",
                person.getFirstName(), person.getAge()); // Подробности

        PropertyProvider.get("db.url");
    }
}
