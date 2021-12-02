package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.BaseCategory1;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 一级分类的service层
 */
public interface BaseCategory1Service extends IService<BaseCategory1> {

    /**
     * 条件查询
     * @param baseCategory1
     */
    List<BaseCategory1> search(BaseCategory1 baseCategory1);


    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    List<BaseCategory1> pageSearch(Integer page, Integer size);


    /**
     *根据条件分页查询
     * @param baseCategory1
     * @param page
     * @param size
     * @return
     */
    List<BaseCategory1> conditionSearch(BaseCategory1 baseCategory1, Integer page, Integer size);
}
