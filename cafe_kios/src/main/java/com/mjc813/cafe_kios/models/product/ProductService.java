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
        ProductEntity newEntity = (ProductEntity) new ProductEntity().copyMembers(newDto,true);
        newEntity.setId(null);

        ProductEntity save = this.repository.save(newEntity);

        ProductDto result = (ProductDto) new ProductDto().copyMembers(save,true);
        return result;
    }

    public ProductDto update(ProductDto updateDto) {//영속성 문제 가능?
        //업데이트를 하긴 하지만 null 값이 들어올 수 있으니
        ProductEntity find = this.repository.findById(updateDto.getId()).orElseThrow();
        //일단 찾은 걸로 복사 시킨 뒤
        ProductEntity updateEntity = (ProductEntity) new ProductEntity().copyMembers(find,true);
        //들어온 Dto로 null값을 제외하고 복사한다.
        updateEntity.copyMembers(updateDto,false);

        ProductEntity save = this.repository.save(updateEntity);

        ProductDto result = (ProductDto) new ProductDto().copyMembers(save,true);
        return result;
    }
}
