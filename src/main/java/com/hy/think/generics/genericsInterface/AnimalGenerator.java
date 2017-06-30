package com.hy.think.generics.genericsInterface;

import java.util.Iterator;
import java.util.Random;

/**
 * desc: 动物生成器
 * @author hy
 * @version 1.0
 * @Created on 2017/6/29 8:46
 */
public class AnimalGenerator implements Generator<Animal>,Iterable<Animal> {
    private Class[] types = {Bird.class,Cat.class,Dog.class,Pig.class};
    private int size = 1;
    private static Random random = new Random();

    public AnimalGenerator(){}

    public AnimalGenerator(int size) {
        this.size = size;
    }

    /**
     * description: 创建T
     * @return
     * @author hy
     * @version 1.0
     * @created 2017/6/29 8:39
     */
    @Override
    public Animal create() {
        System.out.println(this);
        try {
            return (Animal) types[random.nextInt(types.length)].newInstance();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    class GeneratorIterator implements Iterator<Animal> {
        int count = size;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return count > 0;
        }

        /**
         * Returns the next element in the iteration.
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Animal next() {
            System.out.println(AnimalGenerator.this);
            count --;
            return AnimalGenerator.this.create();//AnimalGenerator.this表示外部类AnimalGenerator对象的引用，调用外部类的create()方法
        }
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * @return an Iterator.
     */
    @Override
    public Iterator<Animal> iterator() {
        return new GeneratorIterator();
    }


    public static void main(String[] args){
        AnimalGenerator generator = new AnimalGenerator(5);
        Iterator<Animal> iterator = generator.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
