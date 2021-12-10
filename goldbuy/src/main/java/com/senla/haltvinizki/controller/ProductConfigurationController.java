package com.senla.haltvinizki.controller;

import com.senla.haltvinizki.dto.product_configuration.ProductConfigurationInfoDto;
import com.senla.haltvinizki.dto.product_configuration.ProductConfigurationWithProductDto;
import com.senla.haltvinizki.security.entity.UserDetailsWithId;
import com.senla.haltvinizki.service.ProductConfigurationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequiredArgsConstructor
@RequestMapping("/product-configurations")
public class ProductConfigurationController {

    private final ProductConfigurationService productConfigurationService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ProductConfigurationInfoDto createProductConfiguration(@RequestBody ProductConfigurationInfoDto productConfigurationInfoDto) {
        return productConfigurationService.create(productConfigurationInfoDto);

    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ProductConfigurationWithProductDto getById(@PathVariable Long id) {
        return productConfigurationService.getProductConfigWithProduct(id);
    }

    @PutMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")//todo with obj
    public ProductConfigurationInfoDto updateProductConfiguration(@RequestBody ProductConfigurationInfoDto productConfigurationInfoDto) {
        return productConfigurationService.update(productConfigurationInfoDto);
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")//todo with obj
    public ProductConfigurationInfoDto deleteProductConfiguration(@PathVariable Long id) {
        return productConfigurationService.delete(id);
    }


    @GetMapping(value = "/product/{id}")
    public ProductConfigurationWithProductDto getByMyProduct(@AuthenticationPrincipal UserDetailsWithId userDetailsWithId,@RequestBody long productId){
        return productConfigurationService.getProductConfigWithProductChekUserId(userDetailsWithId.getId(),productId);
    }//todo in dao


//
//    @PutMapping
//    public ProductConfigurationInfoDto updateProductConfiguration(@AuthenticationPrincipal UserDetailsWithId userDetailsWithId,@RequestBody ProductConfigurationInfoDto productConfigurationInfoDto) {
//        return productConfigurationService.update(productConfigurationInfoDto);
//    }




//    public ProductConfigurationInfoDto getByProductId(){
//        return productConfigurationService.getByProductId();
//    }//todo with checking own product



//    @GetMapping(value = "product/{id}")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    public ProductConfigurationWithProductDto getProductConfigurationWithProduct(@PathVariable Long id) {
//        return productConfigurationService.getProductConfigWithProduct(id);
//    }
}
