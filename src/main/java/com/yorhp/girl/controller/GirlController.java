package com.yorhp.girl.controller;

import com.yorhp.girl.domain.Girl;
import com.yorhp.girl.domain.Result;
import com.yorhp.girl.repository.GirlRepository;
import com.yorhp.girl.service.GirlService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.yorhp.girl.util.ResultUtil;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    //依赖注入
    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生
     *
     * @return
     */
    @GetMapping(value = "/girls")
    public Result<List<Girl>> girlList() {
        return new Result(200, "Ok", girlRepository.findAll());
    }


    /**
     * 新增一个女生，验证表单
     *
     * @return
     */
    @PostMapping(value = "/girls")
    @ApiOperation(value = "新增一个女生")//接口文档说明
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.erro(201, bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(girlRepository.save(girl));
    }

    /**
     * 查找一个女生
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/id")
    public Result<Girl> girlFindOne(@RequestParam("id") Integer id) {
        return ResultUtil.success(girlRepository.findOne(id));
    }


    /**
     * 更新一个女生
     *
     * @param girl
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public Result<Girl> girlUpdate(Girl girl) {
        return ResultUtil.success(girlRepository.save(girl));
    }


    /**
     * 删除一个女生
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/girls/{id}")
    public Result<Girl> girlDeleteOne(@PathVariable("id") Integer id) {
        Girl girl = new Girl();
        girl.setId(id);
        girlRepository.delete(girl);
        return ResultUtil.success();
    }

    /**
     * 查找女生
     *
     * @param cupSize
     * @return
     */
    @GetMapping(value = "/girls/cupSize/{cupSize}")
    public Result<Girl> getListByCup(@PathVariable("cupSize") String cupSize) {
        return ResultUtil.success(girlRepository.findByCupSize(cupSize));
    }


    @GetMapping(value = "/girls/two")
    public Result<Girl> insertTwo() {
        girlService.insertTwo();
        return ResultUtil.success();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAges(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }

}
