package com.inditex.ecommerce.infrastructure.commons;

import com.inditex.ecommerce.application.response.ProductResponse;
import com.inditex.ecommerce.domain.Product;
import com.inditex.ecommerce.infrastructure.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
/**
 *
 * @author jcagigas
 */
@Mapper
public interface ProductMapper {

    ProductResponse toDomain(Product product);

    @Mapping(source = "entity.brandEntity.id", target = "brandId")
    Product toModel(ProductEntity entity);

    default LocalDateTime mapTimestamp(Timestamp timestamp) {
        return timestamp.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

}
