package com.mjc813.cafe_kios.models.product;

import com.mjc813.cafe_kios.models.category.CategoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
//import com.mjc813.cafe_kios.models.category.CategoryRepository;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;
//    private final CategoryRepository categoryRepository;
    public ProductDto insert(ProductDto newDto){
        //JoinColumn은 Entity 타입이기 때문에 categoryRepository 불러서 getId까지 사용함
//        CategoryEntity category = categoryRepository.findById(newDto.getCategory().getId())
//            .orElseThrow(() -> new RuntimeException("해당 카테고리가 없습니다. ID:"));
        ProductEntity newEntity = new ProductEntity();
        CategoryEntity category = CategoryEntity.builder().id(newDto.getCategory().getId()).build();
        newEntity.copyMembers(newDto);
        newEntity.setCategory(category);
        newEntity.setId(null);
        this.repository.save(newEntity);

        ProductDto result = new ProductDto();
        result.copyMembers(newEntity);
        return result;
    }

    public ProductDto update(ProductDto updateDto) {
        ProductEntity emptyEntity = new ProductEntity();
        ProductEntity findEntity = this.repository.findById(updateDto.getId()).orElseThrow(); //업데이트 dto에서 getId로 entity얻고
        findEntity.copyMembers(updateDto); //dta로 entity를 업데이트
        this.repository.save(findEntity); //그것을 저장
        ProductDto result = new ProductDto(); //
        result.copyMembers(findEntity);
        return result;
    }
}
