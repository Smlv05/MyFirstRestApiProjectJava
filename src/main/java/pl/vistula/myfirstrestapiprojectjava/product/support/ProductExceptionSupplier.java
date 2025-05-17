package pl.vistula.myfirstrestapiprojectjava.product.support;

import pl.vistula.myfirstrestapiprojectjava.product.support.exception.ProductNotFoundException;
import java.util.function.Supplier;

public class ProductExceptionSupplier {

    public static Supplier<ProductNotFoundException> productNotFound(Long id){
        return () -> new ProductNotFoundException(id);
    }
}
