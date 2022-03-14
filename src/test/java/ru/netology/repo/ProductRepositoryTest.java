package ru.netology.repo;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository repository = new ProductRepository();

    private Book coreJava1 = new Book();
    private Smartphone coreJava2 = new Smartphone();

    @Test

    public void shouldSaveItemBook(){
        repository.save(coreJava1);

        Product[] expected = new Product[]{coreJava1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected,actual);
    }

    @Test

    public void shouldSaveItemSmartphone(){
        repository.save(coreJava2);

        Product[] expected = new Product[]{coreJava2};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected,actual);
    }


}