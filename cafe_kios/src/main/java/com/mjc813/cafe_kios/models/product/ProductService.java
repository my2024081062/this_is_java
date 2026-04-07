package com.mjc813.cafe_kios.models.product;

import com.mjc813.cafe_kios.models.category.CategoryEntity;
import com.mjc813.cafe_kios.models.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;
    public ProductDto insert(ProductDto newDto){
        //JoinColumn은 Entity 타입이기 때문에 categoryRepository 불러서 getId까지 사용함
        CategoryEntity category = categoryRepository.findById(newDto.getCategory().getId())
            .orElseThrow(() -> new RuntimeException("해당 카테고리가 없습니다. ID:"));

        ProductEntity newEntity = new ProductEntity();
        newEntity.copyMembers(newDto);
        newEntity.setCategory(category);
        newEntity.setId(null);
        this.repository.save(newEntity);

        ProductDto result = new ProductDto();
        result.copyMembers(newEntity);
        return result;
    }
}
