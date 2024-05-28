package co.develhope.java23.mockdemo.product_stack;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/productStacks")
public class ProductStackController {
    @Autowired
    private ProductStackService service;

    @PostMapping
    public ResponseEntity<ProductStack> insert(@RequestBody ProductStack stack) {
        ProductStack result = service.insert(stack);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductStack> retrieve(@PathVariable long id) {
        Optional<ProductStack> result = service.retrieve(id);

        if(result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(result.get());
    }

    @GetMapping
    @ResponseBody
    public List<ProductStack> retrieveAll() {
        return service.retrieveAll();
    }

}
