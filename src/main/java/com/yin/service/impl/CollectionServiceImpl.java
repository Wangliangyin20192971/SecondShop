package com.yin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yin.domain.Collection;
import com.yin.entity.PageResult;
import com.yin.mapper.CollectionMapper;
import com.yin.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Classname CollectionServiceImpl
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/4/17 19:18
 * @Version 1.0
 **/
@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private CollectionMapper collectionMapper;

    @Override
    public PageResult showCollection(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<Collection> page= collectionMapper.showCollection();
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public Integer deleteCollection(Integer collId) { return collectionMapper.deleteCollection(collId); }

}
