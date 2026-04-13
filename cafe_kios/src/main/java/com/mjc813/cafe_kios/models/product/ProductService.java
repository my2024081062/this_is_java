package com.mjc813.cafe_kios.models.product;

import com.mjc813.cafe_kios.models.category.CategoryDto;
import com.mjc813.cafe_kios.models.category.CategoryEntity;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return this.entityToDto(save);
    }

    public ProductDto update(ProductDto updateDto) {//영속성 문제 가능?
        //업데이트를 하긴 하지만 null 값이 들어올 수 있으니
        ProductEntity find = this.repository.findById(updateDto.getId()).orElseThrow();
        //일단 찾은 걸로 복사 시킨 뒤
        ProductEntity updateEntity = (ProductEntity) new ProductEntity().copyMembers(find,true);
        //들어온 Dto로 null값을 제외하고 복사한다.
        updateEntity.copyMembers(updateDto,false);

        ProductEntity save = this.repository.save(updateEntity);
        return this.entityToDto(save);
    }

    public ProductDto deleteById(Integer id) {
        ProductDto find = this.findById(id);
        this.repository.deleteById(find.getId());
        return find;
    }

    public ProductDto findById(Integer id) {
        ProductEntity find = this.repository.findById(id).orElseThrow();
        return this.entityToDto(find);
    }

    public Slice<ProductDto> findByNameContains(String name, Pageable pageable) {
        Slice<ProductEntity> slice = this.repository.findByNameContains(name, pageable);
        List<ProductEntity> entityList = slice.getContent();
        List<ProductDto> resultList = entityList.stream()
            .map(productEntity -> (ProductDto)ProductDto.builder()
                .build()
                .copyMembers(productEntity, true))
            .toList();
        return new SliceImpl<>(resultList, pageable, slice.hasNext());
    }

    public List<ProductDto> findByPriceGreaterThan(Integer price) {
        List<ProductEntity> list = this.repository.findByPriceGreaterThan(price);
        List<ProductDto> resultList = list.stream()
            .map(productEntity -> (ProductDto)ProductDto.builder()
                .build()
                .copyMembers(productEntity, true))
            .toList();
        return resultList;
    }

    Page<ProductDto> findByCategoryEntity(CategoryDto category, Pageable pageable) {
        CategoryEntity categoryEntity = (CategoryEntity) new CategoryEntity().copyMembers(category, true);
        Page<ProductEntity> find = this.repository.findByCategoryEquals(categoryEntity, pageable);
        List<ProductDto> list = find.getContent().stream()
            .map( item -> {
                ProductDto convert = (ProductDto) new ProductDto().copyMembers(item, true);
                return convert;
            }).toList();
        Page<ProductDto> result = new PageImpl<>(list, find.getPageable(), find.getTotalElements());
        return result;
    }

    private @NonNull ProductDto entityToDto(ProductEntity entity){
        //이렇게 save를 한 것을 복사하는 이유는 jpa로 한번 필터해서 자동으로 값이 넣어진 것을 복사해서 리턴값에 넣기 위해
        return (ProductDto) new ProductDto().copyMembers(entity,true);
    }
}
