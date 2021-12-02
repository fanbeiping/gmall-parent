package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseCategory1;
import com.atguigu.gmall.product.mapper.BaseCategory1Mapper;
import com.atguigu.gmall.product.service.BaseCategory1Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;


import java.util.List;


/**
 * 一级分类的service实现类
 */
@Service
public class BaseCategory1ServiceImpl extends ServiceImpl<BaseCategory1Mapper, BaseCategory1> implements BaseCategory1Service {

    /**
     * 注入一级分类的mapper层
     */
    @Autowired
    private BaseCategory1Mapper baseCategory1Mapper;


    /**
     * 条件查询
     * @param baseCategory1
     */
    @Override
    public List<BaseCategory1> search(BaseCategory1 baseCategory1) {
        //判断查询参数是否为空
        if (baseCategory1==null){
            //为空就查询全部数据
          return baseCategory1Mapper.selectList(null);
        }
        //查询
        LambdaQueryWrapper wrapper = getCondition1(baseCategory1);
        //查询结果
        List<BaseCategory1> list = baseCategory1Mapper.selectList(wrapper);
        //返回结果
        return list;
    }


    /**
     * 分页查询
     * @param page  第几页
     * @param size  每页条数
     * @return
     */
    @Override
    public List<BaseCategory1> pageSearch(Integer page, Integer size) {
        //查询
        IPage<BaseCategory1> result = baseCategory1Mapper.selectPage(new Page<>(page, size), null);
        //返回结果
        return result.getRecords();
    }


    /**
     * 根据条件分页查询
     * @param baseCategory1
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<BaseCategory1> conditionSearch(BaseCategory1 baseCategory1, Integer page, Integer size) {
        //调用查询方法
        LambdaQueryWrapper wrapper = getCondition1(baseCategory1);
        //根据条件查询
        IPage<BaseCategory1> iPage = baseCategory1Mapper.selectPage(new Page<>(page, size), wrapper);
        //返回结果
        return iPage.getRecords();
    }


    /**
     *构建条件查询方法
     * @param baseCategory1
     * @return
     */
    private LambdaQueryWrapper getCondition1(BaseCategory1 baseCategory1){
        //定义条件构造器
        LambdaQueryWrapper<BaseCategory1> wrapper = new LambdaQueryWrapper<>();
        //判断id是否为空
        if (baseCategory1.getId() != null){
            wrapper.eq(BaseCategory1::getId,baseCategory1.getId());
        }
        //判断name是否为空
        if (StringUtils.isNotEmpty(baseCategory1.getName())){
            wrapper.like(BaseCategory1::getName,baseCategory1.getName());
        }
        //返回结果
        return wrapper;
    }

}
