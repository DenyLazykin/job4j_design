package ru.job4j.generics.exercises;

import java.util.Iterator;
import java.util.Random;

class StoryCharacters {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}

class GoodGuys extends StoryCharacters {
}

class LukeSkywalker extends GoodGuys {
}

class Yoda extends GoodGuys {
}

class BadGuys extends StoryCharacters {
}

class DarthVader extends BadGuys {
}

class JabbaTheHut extends BadGuys {
}

public class StoryCharactersGenerator implements Generator<StoryCharacters>, Iterable<StoryCharacters> {
    private Class[] types = {DarthVader.class, JabbaTheHut.class,
            LukeSkywalker.class, Yoda.class};
    private static Random random = new Random();

    public StoryCharactersGenerator() {
    }

    private int size = 0;

    public StoryCharactersGenerator(int sz) {
        size = sz;
    }

    public StoryCharacters next() {
        try {
            return (StoryCharacters) types[random.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    class StoryCharactersIterator implements Iterator<StoryCharacters> {
        int count = size;

        public boolean hasNext() {
            return count > 0;
        }

        public StoryCharacters next() {
            count--;
            return StoryCharactersGenerator.this.next();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public Iterator<StoryCharacters> iterator() {
        return new StoryCharactersIterator();
    }

    public static void main(String[] args) {
        StoryCharactersGenerator gen = new StoryCharactersGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }
        for (StoryCharacters s : new StoryCharactersGenerator(5)) {
            System.out.println(s);
        }
    }
}


