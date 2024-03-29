package com.ofitoo.microservices.product.integration;

import com.ofitoo.microservices.product.model.CreateProductDtoModelTestUtil;
import com.ofitoo.microservices.product.model.ProductDtoModelTestUtil;
import com.ofitoo.microservices.product.model.dto.CreateProductDto;
import com.ofitoo.microservices.product.model.dto.ProductDto;
import com.ofitoo.microservices.product.utils.BaseIntegrationTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

public class ProductIntegrationTest extends BaseIntegrationTest {

    @Test
    public void shouldCreateProductInDatabaseAndReturnIt() {

        // given
        final CreateProductDto createProductDto = CreateProductDtoModelTestUtil.basic();
        final ProductDto expectedProductDto = ProductDtoModelTestUtil.basic();

        // when
        final ProductDto productDto = given()
                .header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .header(USER_ID, "123")
                .and()
                .body(createProductDto)
                .when()
                .post(BASE_PATH)
                .then()
                .statusCode(200)
                .extract().as(ProductDto.class);

        // then
        assertThat(productDto)
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(expectedProductDto);
    }
}
