package co.develhope.java23.mockdemo.product_stack;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductStackService {
    @Autowired
    private ProductStackRepository repository;
    
    public ProductStack insert(ProductStack productStack) {
        return repository.save(productStack);
    }

    public Optional<ProductStack> retrieve(long id) {
        return repository.findById(id);
    }

    public List<ProductStack> retrieveAll() {
        return repository.findAll();
    }
}
