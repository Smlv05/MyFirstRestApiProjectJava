package pl.vistula.myfirstrestapiprojectjava.product.service;

import org.springframework.stereotype.Service;
import pl.vistula.myfirstrestapiprojectjava.product.api.request.ProductRequest;
import pl.vistula.myfirstrestapiprojectjava.product.api.request.UpdateProductRequest;
import pl.vistula.myfirstrestapiprojectjava.product.api.response.ProductResponse;
import pl.vistula.myfirstrestapiprojectjava.product.domain.Product;
import pl.vistula.myfirstrestapiprojectjava.product.repository.ProductRepository;
import pl.vistula.myfirstrestapiprojectjava.product.support.ProductExceptionSupplier;
import pl.vistula.myfirstrestapiprojectjava.product.support.ProductMapper;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductResponse create(ProductRequest productRequest) {
        Product product = productMapper.toProduct(productRequest);
        Product savedProduct = productRepository.save(product);
        return productMapper.toProductResponse(savedProduct);
    }

    public ProductResponse find(Long id) {
        Product product = productRepository.findById(id).orElseThrow(ProductExceptionSupplier.productNotFound(id));
        return productMapper.toProductResponse(product);
    }

    public ProductResponse update(Long id, UpdateProductRequest updateProductRequest) {
        Product product = productRepository.findById(id)
                .orElseThrow(ProductExceptionSupplier.productNotFound(id));
        productRepository.save(productMapper.toProduct(product, updateProductRequest));
        return productMapper.toProductResponse(product);
    }
}

