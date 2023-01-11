package ru.job4j.assertj;

public class SimpleModel {
    private String name = "";

    /**
     * Генерирует испключение если поле name не заполнено.
     *
     * @return Имя.
     */
    public String getName() {
        if (name.length() == 0) {
            throw new IllegalArgumentException();
        }
        return name;
    }

    /**
     * Генерирует испключение если длина переменной word не совпадает со значением переменной number.
     * @param word Слово.
     * @param number Число.
     */
    public void setName(String word, int number) {
        if (word.length() != number) {
            throw new IllegalArgumentException(
                    String.format("this word: %s has length not equal to : %s", word, number)
            );
        }
        this.name = word;
    }
}
