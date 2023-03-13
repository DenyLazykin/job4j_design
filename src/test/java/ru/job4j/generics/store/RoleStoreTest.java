package ru.job4j.generics.store;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RoleStoreTest {
    @Test
    void whenAddAndFindThenUsernameIsPetr() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Den"));
        Role rsl = roleStore.findBy("1");
        assertThat(rsl.getRoleName()).isEqualTo("Den");
    }

    @Test
    void whenAddAndFindThenUserIsNull() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Den"));
        Role rsl = roleStore.findBy("10");
        assertThat(rsl).isNull();
    }

    @Test
    void whenAddDuplicateAndFindUsernameIsPetr() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Den"));
        roleStore.add(new Role("1", "Ed"));
        Role rsl = roleStore.findBy("1");
        assertThat(rsl.getRoleName()).isEqualTo("Den");
    }

    @Test
    void whenReplaceThenUsernameIsMaxim() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Den"));
        roleStore.replace("1", new Role("1", "Ed"));
        Role rsl = roleStore.findBy("1");
        assertThat(rsl.getRoleName()).isEqualTo("Ed");
    }

    @Test
    void whenNoReplaceUserThenNoChangeUsername() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Den"));
        roleStore.replace("10", new Role("10", "Ed"));
        Role rsl = roleStore.findBy("1");
        assertThat(rsl.getRoleName()).isEqualTo("Den");
    }

    @Test
    void whenDeleteUserThenUserIsNull() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Den"));
        roleStore.delete("1");
        Role rsl = roleStore.findBy("1");
        assertThat(rsl).isNull();
    }

    @Test
    void whenNoDeleteUserThenUsernameIsPetr() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Den"));
        roleStore.delete("10");
        Role rsl = roleStore.findBy("1");
        assertThat(rsl.getRoleName()).isEqualTo("Den");
    }

    @Test
    void whenReplaceOkThenTrue() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Den"));
        boolean rsl = roleStore.replace("1", new Role("1", "Ed"));
        assertThat(rsl).isTrue();
    }

    @Test
    void whenReplaceNotOkThenFalse() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Den"));
        boolean rsl = roleStore.replace("10", new Role("10", "Ed"));
        assertThat(rsl).isFalse();
    }

    @Test
    void whenDeleteOkThenTrue() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Den"));
        boolean rsl = roleStore.delete("1");
        assertThat(rsl).isTrue();
    }

    @Test
    void whenDeleteNotOkThenFalse() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Den"));
        boolean rsl = roleStore.delete("10");
        assertThat(rsl).isFalse();
    }
}