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

    private final Product firstProduct = new Product(1, "firstProduct",100);
    private final Product secondProduct = new Product(2, "secondProduct",200);
    private final Book firstBook = new Book(3, "firstBook",300, "Pushkin");
    private final Book secondBook = new Book(4, "secondBook",400,"Tolstoy");
    private final Smartphone firstSmartphone = new Smartphone(5, "firstSmartphone",3000, "Motorola");
    private final Smartphone secondSmartphone = new Smartphone (6, "secondSmartphone",4000,"Nokia");

    private ManagerProduct manager = new ManagerProduct(new ProductRepository());

    @BeforeEach

    void setApp(){
        manager.save(firstProduct);
        manager.save(secondProduct);
        manager.save(firstBook);
        manager.save(secondBook);
        manager.save(firstSmartphone);
        manager.save(secondSmartphone);

    }

    @Test

    void shouldReturnByText(){
        Product[] expected = {firstProduct,firstBook,firstSmartphone};
        Product[] actual = manager.searchBy("Pushkin");
        assertArrayEquals(expected, actual);
        System.out.println(actual);
    }


}