package com.mjc813.cafe_kios.models.category;

import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public CategoryDto insert(CategoryDto newDto){
        CategoryEntity newEntity = new CategoryEntity();
        return saveCategoryDto(newDto, newEntity);
    }

    public CategoryDto update(CategoryDto updateDto){
        CategoryEntity updateEntity = this.repository.findById(updateDto.getId()).orElseThrow();
        return saveCategoryDto(updateDto,updateEntity);
    }

    public CategoryDto deleteById(Integer deleteId){
        CategoryEntity deleteEntity = this.repository.findById(deleteId).orElseThrow();
        this.repository.delete(deleteEntity);
        return entityToDto(deleteEntity);
    }

    public CategoryDto findById(Integer id) {
        CategoryEntity findEntity = this.repository.findById(id).orElseThrow();
        return entityToDto(findEntity);
    }

    private @NonNull CategoryDto saveCategoryDto(CategoryDto dto, CategoryEntity entity) {
        entity.copyMembers(dto,true);
        entity.setId(dto.getId());
        CategoryEntity result = this.repository.save(entity);

        return entityToDto(result);
    }

    private @NonNull CategoryDto entityToDto(CategoryEntity save){
        //이렇게 save를 한 것을 복사하는 이유는 jpa로 한번 필터해서 자동으로 값이 넣어진 것을 복사해서 리턴값에 넣기 위해
        CategoryDto result = new CategoryDto();
        result.copyMembers(save,true);
        return result;
    }

    public Slice<CategoryDto> findByNameContains(String name, Pageable pageable) {
        Slice<CategoryEntity> slice = this.repository.findByNameContains(name, pageable);
        List<CategoryEntity> entityList = slice.getContent();
        List<CategoryDto> resultList = entityList.stream()
            .map(categoryEntity -> {
                CategoryDto item = (CategoryDto)CategoryDto.builder().build()
                    .copyMembers(categoryEntity, true);
//					item.copyMembers(categoryEntity, true);
//					item.setId(categoryEntity.getId());
//					item.setName(categoryEntity.getName());
                return item;
            }).toList();
        Slice<CategoryDto> result = new SliceImpl<>(resultList, pageable, slice.hasNext());
        return result;
    }
}
