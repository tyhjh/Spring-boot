package com.yorhp.girl.service;

import com.yorhp.girl.Exception.GirlException;
import com.yorhp.girl.domain.Girl;
import com.yorhp.girl.enums.ResultEnum;
import com.yorhp.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {
    @Autowired
    GirlRepository girlRepository;

    //事务
    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setName("Xu");
        girlA.setCupSize("C");
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setName("Yu");
        girlB.setCupSize("36E");
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age <= 10) {
            throw new GirlException(ResultEnum.TOO_YOUNG);
        } else if (age > 10 && age <= 16) {
            throw new GirlException(ResultEnum.TOO_SIMPLE);
        }
    }

    /**
     * 通过id查询女孩
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
        return girlRepository.findOne(id);
    }

}
