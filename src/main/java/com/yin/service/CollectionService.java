package com.yin.service;

import com.yin.entity.PageResult;
import org.omg.PortableInterceptor.INACTIVE;

/**
 * @Classname CollectionService
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/4/17 19:18
 * @Version 1.0
 **/
public interface CollectionService {

    PageResult showCollection(Integer pageNum, Integer pageSize);

    Integer deleteCollection(Integer collId);


}
