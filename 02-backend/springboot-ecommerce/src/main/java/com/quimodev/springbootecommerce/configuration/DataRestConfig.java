package com.quimodev.springbootecommerce.configuration;

import com.quimodev.springbootecommerce.entity.Product;
import com.quimodev.springbootecommerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] unsupportedMethods = {HttpMethod.DELETE,HttpMethod.PUT,HttpMethod.POST};
        //disable HTTP methods for Product class
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((metadata,httpMethods) ->httpMethods.disable(unsupportedMethods))
                .withCollectionExposure((metadata,httpMethods)->httpMethods.disable(unsupportedMethods));
        //disable HTTP methods for ProductCategory class
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metadata,httpMethods) ->httpMethods.disable(unsupportedMethods))
                .withCollectionExposure((metadata,httpMethods)->httpMethods.disable(unsupportedMethods));
    }
}
