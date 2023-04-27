package repository;

import java.util.List;

public interface CRUD<T> {
    List<T> getAllProducts();


    T getProductById(int id);


    void addProduct(T variable);


    void updateProduct(T variable);


    void deleteProduct(int id);
}
