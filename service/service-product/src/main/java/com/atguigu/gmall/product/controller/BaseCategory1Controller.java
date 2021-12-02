package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseCategory1;
import com.atguigu.gmall.product.service.BaseCategory1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 一级分类的controller层
 * @author FAN
 */
@RestController
@RequestMapping("/category1")
public class BaseCategory1Controller {

    /**
     * 注入一级分类的service层
     */
    @Autowired
    private BaseCategory1Service baseCategory1Service;


    /**
     * 根据id查询一级分类数据
     * @param id
     * @return
     */
    @GetMapping("/findById/{id}")
    public Result<BaseCategory1> findById(@PathVariable(value = "id") Long id){
        BaseCategory1 category1 = baseCategory1Service.getById(id);
        return Result.ok(category1);
    }


    /**
     * 查询所有的一级分类数据
     * @return
     */
    @GetMapping("/findAll")
    public Result<List<BaseCategory1>> findAll(){
        List<BaseCategory1> list = baseCategory1Service.list(null);
        return Result.ok(list);
    }


    /**
     * 新增数据
     * @param baseCategory1
     * @return
     */
    @PostMapping("/save")
    public Result save(@RequestBody BaseCategory1 baseCategory1){
        baseCategory1Service.save(baseCategory1);
        return Result.ok();
    }


    /**
     * 修改数据
     * @param baseCategory1
     * @return
     */
    @PutMapping("/update")
    public Result update(@RequestBody BaseCategory1 baseCategory1){
        return Result.ok(baseCategory1Service.updateById(baseCategory1));
    }


    /**
     * 删除数据
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable(value = "id") Long id){
        baseCategory1Service.removeById(id);
        return Result.ok();
    }


    /**
     * 根据条件查询数据
     * @param baseCategory1
     * @return
     */
    @PostMapping("/search")
    public Result<List<BaseCategory1>> search(@RequestBody BaseCategory1 baseCategory1){
        //调用service层方法
        baseCategory1Service.search(baseCategory1);
        return Result.ok();
    }


    /**
     * 分页查询
     * @param page 第几页
     * @param size 每页条数
     * @return
     */
    @GetMapping("/getPage/{page}/{size}")
    public Result<List<BaseCategory1>> getPage(
            @PathVariable("page") Integer page,
            @PathVariable("size") Integer size){

        //调用service层方法并返回结果
        List<BaseCategory1> pagingQuery  = baseCategory1Service.pageSearch(page, size);
        return Result.ok(pagingQuery );
    }


    /**
     * 根据条件分页查询
     * @param baseCategory1
     * @param page
     * @param size
     * @return
     */
    @PostMapping("/conditionSearch/{page}/{size}")
    public Result<List<BaseCategory1>> conditionSearch(
                    @RequestBody BaseCategory1 baseCategory1,
                    @PathVariable("page" )Integer page,
                    @PathVariable("size") Integer size){

       //调用service层方法  返回分页列表
        List<BaseCategory1> listPage = baseCategory1Service.conditionSearch(baseCategory1,page,size);
        return Result.ok(listPage);


    }



}

