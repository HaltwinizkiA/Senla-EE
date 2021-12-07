package com.senla.haltvinizki.controller;


import com.senla.haltvinizki.dto.product.ProductInfoDto;
import com.senla.haltvinizki.security.entity.UserDetailsWithId;
import com.senla.haltvinizki.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ProductInfoDto createProduct(@RequestBody ProductInfoDto productInfoDto) {
        return productService.create(productInfoDto);
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ProductInfoDto getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @GetMapping(value = "/my-products/{num}")
    public Page<ProductInfoDto> getByUserId(@AuthenticationPrincipal UserDetailsWithId userInf,@PathVariable int num) {
        Pageable pageable=PageRequest.of(num,2);
        List<ProductInfoDto> productInfoDtoList = productService.getByUserId(userInf.getId());
        Page<ProductInfoDto> page=new PageImpl<ProductInfoDto>(productInfoDtoList, pageable, productInfoDtoList.size());
        return page;
    }

    @PutMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")//todo with obj
    public ProductInfoDto updateProduct(@RequestBody ProductInfoDto productInfoDto) {
        return productService.update(productInfoDto);
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")//todo with obj
    public ProductInfoDto deleteProduct(@PathVariable Long id) {
        return productService.delete(id);
    }
}
