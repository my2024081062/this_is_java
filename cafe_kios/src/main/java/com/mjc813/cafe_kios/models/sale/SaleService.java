package com.mjc813.cafe_kios.models.sale;

import com.mjc813.cafe_kios.models.product.*;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleService {
    private final SaleRepository repository;

    public SaleDto insert(SaleDto newDto){
        SaleEntity newEntity = (SaleEntity) new SaleEntity().copyMembers(newDto,true);

        SaleEntity save =  this.repository.save(newEntity);
        return this.entityToDto(save);
    }

    private @NonNull SaleDto entityToDto(SaleEntity entity){
        //이렇게 save를 한 것을 복사하는 이유는 jpa로 한번 필터해서 자동으로 값이 넣어진 것을 복사해서 리턴값에 넣기 위해
        return (SaleDto) new SaleDto().copyMembers(entity,true);
    }
}
