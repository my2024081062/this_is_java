package com.mjc813.cafe_kios.models.sale;

import com.mjc813.cafe_kios.models.product.*;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleService {
    private final SaleRepository saleRepository;

    public SaleDto insert(SaleDto newDto){
        //이 1번 entity와
        SaleEntity newEntity = (SaleEntity) new SaleEntity().copyMembers(newDto,true);
        //이 2번 entity는 세부 멤버변수의 셋팅이 다르다.
        SaleEntity save =  this.saleRepository.save(newEntity);
        return this.entityToDto(save);
    }

    public SaleDto update(SaleDto updateDto){
        SaleEntity find = this.saleRepository.findById(updateDto.getId()).orElseThrow();

        SaleEntity updateEntity = (SaleEntity) new SaleEntity().copyMembers(find,true);
        updateEntity.copyMembers(updateDto,false);

        SaleEntity save = this.saleRepository.save(updateEntity);
        return this.entityToDto(save);
    }

    public SaleDto deleteById(Integer deleteId){
        SaleEntity findEntity = this.saleRepository.findById(deleteId).orElseThrow();
        this.saleRepository.deleteById(deleteId);
        return this.entityToDto(findEntity);
    }

    public SaleDto findById(Integer id){
        SaleEntity findEntity = this.saleRepository.findById(id).orElseThrow();
        return this.entityToDto(findEntity);
    }

    public Slice<SaleDto> findByProductEquals(Integer productId, Pageable pageable) {
        ProductEntity productEntity = ProductEntity.builder().id(productId).build();
        Slice<SaleEntity> findList = this.saleRepository.findByProductEquals(productEntity, pageable);
        List<SaleDto> list = findList.getContent().stream()
            .map( x -> (SaleDto)new SaleDto().copyMembers(x, true))
            .toList();
        Slice<SaleDto> result = new SliceImpl<>(list, findList.getPageable(), findList.hasNext());
        return result;
    }

    public Long sumPriceBySaleTimeAtBetween(LocalDate start, LocalDate end) {
        LocalDateTime startOfDay = start.atStartOfDay();
        LocalDateTime endOfDay = end.plusDays(1).atStartOfDay();
        Long result = this.saleRepository.sumPriceBySaleTimeAtBetween(startOfDay, endOfDay);
        return result;
    }

    private @NonNull SaleDto entityToDto(SaleEntity entity){
        //이렇게 save를 한 것을 복사하는 이유는 jpa로 한번 필터해서 자동으로 값이 넣어진 것을 복사해서 리턴값에 넣기 위해
        return (SaleDto) new SaleDto().copyMembers(entity,true);
    }
}
