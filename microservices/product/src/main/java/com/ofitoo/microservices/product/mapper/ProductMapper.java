package com.ofitoo.microservices.product.mapper;

import com.ofitoo.microservices.product.model.dto.CreateProductDto;
import com.ofitoo.microservices.product.model.dto.ProductDto;
import com.ofitoo.microservices.product.model.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductEntity toEntity(final CreateProductDto createProductDto, final Long userId) {
        return ProductEntity.builder()
                .name(createProductDto.name())
                .ownerId(userId)
                .kcal(createProductDto.kcal())
                .visibility(createProductDto.visibility())
                .barcode(createProductDto.barcode())
                .protein(createProductDto.protein())
                .carbohydrate(createProductDto.carbohydrate())
                .fat(createProductDto.fat())
                .sugar(createProductDto.sugar())
                .fiber(createProductDto.fiber())
                .salt(createProductDto.salt())
                .description(createProductDto.description())
                .manufacturer(createProductDto.manufacturer())
                .build();
    }

    public ProductDto toDto(final ProductEntity productEntity) {
        return new ProductDto(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getOwnerId(),
                productEntity.getKcal(),
                productEntity.getVisibility(),
                productEntity.getBarcode(),
                productEntity.getProtein(),
                productEntity.getCarbohydrate(),
                productEntity.getFat(),
                productEntity.getSugar(),
                productEntity.getFiber(),
                productEntity.getSalt(),
                productEntity.getDescription(),
                productEntity.getManufacturer()
        );
    }
}
