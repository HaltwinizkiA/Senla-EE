package com.senla.haltvinizki.controller;


import com.senla.haltvinizki.dto.product.ProductInfoDto;
import com.senla.haltvinizki.security.entity.UserDetailsWithId;
import com.senla.haltvinizki.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.support.PagedListHolder;
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
    public List<ProductInfoDto> getByUserId(@AuthenticationPrincipal UserDetailsWithId userInf, @PathVariable int num) {
        PagedListHolder pagedListHolder = new PagedListHolder(productService.getByUserId(userInf.getId()));
        pagedListHolder.setPageSize(2);
        pagedListHolder.setPage(num);
        return pagedListHolder.getPageList();
    }

    @PutMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ProductInfoDto updateProduct(@RequestBody ProductInfoDto productInfoDto) {
        return productService.update(productInfoDto);
    }

    @PutMapping
    public ProductInfoDto updateYourProduct(@AuthenticationPrincipal UserDetailsWithId userInf
            , @RequestBody ProductInfoDto productInfoDto) {
        return productService.updateYour(productInfoDto, userInf.getId());
    }


    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ProductInfoDto deleteProduct(@PathVariable Long id) {
        return productService.delete(id);
    }

    @DeleteMapping(value = "/{id}")
    public ProductInfoDto deleteYourProduct(@AuthenticationPrincipal UserDetailsWithId userInf,
                                            @PathVariable Long id) {
        return productService.deleteYour(userInf.getId(), id);
    }
}
