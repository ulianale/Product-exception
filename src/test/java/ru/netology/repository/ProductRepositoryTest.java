package ru.netology.repository;

import ru.netology.domain.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();

    Product book1 = new Book(1, "Sun", 10, "Bob Li");
    Product book2 = new Book(2, "Galaxy", 10, "Alex Smith");
    Product book3 = new Book(3, "Family", 10, "Anna Koch ");
    Product smartphone1 = new Smartphone(11, "Iphone11", 1000, "USA");

    @Test
    public void test1() {

        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.removeById(2);

        Product[] expected = {book1, book3, smartphone1};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test2() {

        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(12);
        });
    }

}
