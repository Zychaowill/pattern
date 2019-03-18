package com.pattern.tutor.microservice.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.pattern.tutor.microservice.hystrix.service.ProductService;

/**
 * @author buildupchao
 *         Date: 2019/3/19 00:16
 * @since JDK 1.8
 */
public class GetProductServiceCommand extends HystrixCommand<String> {

    private ProductService productService;
    private Long id;

    public GetProductServiceCommand(Setter setter, ProductService productService, Long id) {
        super(setter);
        this.productService = productService;
        this.id = id;
    }

    @Override
    protected String run() throws Exception {
        return productService.getProduct(id);
    }

    @Override
    protected String getCacheKey() {
        return "product-" + id;
    }
}
