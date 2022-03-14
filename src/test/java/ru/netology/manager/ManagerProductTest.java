package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repo.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ManagerProductTest {

    private static Product product1 = new Product(1, "Product1", 100);
    private static Product product2 = new Product(2, "Product2", 200);
    private static Product book = new Book(3, "Book1", 100, "Pushkin");
    private static Book book1 = new Book(4, "Book2", 400, "Tolstoy");
    private static Smartphone smartphone = new Smartphone(5, "Smartphone1", 100, "Motorola");
    private static Smartphone smartphone1 = new Smartphone(6, "Smartphone2", 4000, "Nokia");

    private ManagerProduct manager = new ManagerProduct(new ProductRepository());

    @BeforeEach
    void setApp() {

        manager.save(book);
        manager.save(book1);
        manager.save(smartphone);
        manager.save(smartphone1);

    }


    @Test
    public void shouldFindBook1Author() {
        Product[] expected = {book};
        Product[] actual = manager.searchBy("Pushkin");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBook2Author() {
        Product[] expected = {book1};
        Product[] actual = manager.searchBy("Tolstoy");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBook1Name() {
        Product[] expected = {book};
        Product[] actual = manager.searchBy("Book1");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBook2Name() {
        Product[] expected = {book1};
        Product[] actual = manager.searchBy("Book2");
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindSmartphone1Manufacturer() {
        Product[] expected = {smartphone};
        Product[] actual = manager.searchBy("Motorola");
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindSmartphone2Manufacturer() {
        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("Nokia");
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindSmartphone1Name() {
        Product[] expected = {smartphone};
        Product[] actual = manager.searchBy("Smartphone1");
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindSmartphone2Name() {
        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("Smartphone2");
        assertArrayEquals(expected, actual);

    }

}
