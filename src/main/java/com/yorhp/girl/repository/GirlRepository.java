package com.yorhp.girl.repository;

import com.yorhp.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl,Integer>{
    //添加一些自定义的方法
    public List<Girl> findByCupSize(String cupSize);
}
