package ru.job4j.generics.store;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class UserStoreTest {
    @Test
    void whenAddAndFindThenUsernameIsPetr() {
        UserStore store = new UserStore();
        store.add(new User("1", "Petr"));
        User result = store.findBy("1");
        assertThat(result.getUserName()).isEqualTo("Petr");
    }
}