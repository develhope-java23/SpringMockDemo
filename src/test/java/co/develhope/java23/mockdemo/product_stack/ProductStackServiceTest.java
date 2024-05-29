package co.develhope.java23.mockdemo.product_stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ProductStackServiceTest {
    @Mock
    private ProductStackRepository repository;

    @InjectMocks
    private ProductStackService service;    

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testInsert_withValidData() {
        ProductStack stack = new ProductStack(0, "Pizza", 10);

        ProductStack insertedStack = new ProductStack(10, "Pizza", 10);
        when(repository.save(stack))
            .thenReturn(insertedStack);

        ProductStack result = service.insert(stack);

        assertEquals(insertedStack, result);
    }

    @Test
    public void testInsert_throwException_withZeroQuantity() {
        ProductStack stack = new ProductStack(0, "Pizza", 0);
        assertThrows(IllegalArgumentException.class, () -> service.insert(stack));
    }

    // TODO: Da rivedere
    @Test
    public void testInsert_doNotCallRepository_withZeroQuantity() {
        ProductStack stack = new ProductStack(0, "Pizza", 0);
        try {
            service.insert(stack);
        } catch(Exception e) { }

        verify(repository, never()).save(any());
    }
}
