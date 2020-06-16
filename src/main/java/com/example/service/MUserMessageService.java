package com.example.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.MUserMessage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WilliamYe
 * @since 2020-06-05
 */
public interface MUserMessageService extends IService<MUserMessage> {

    IPage paging(Page page, QueryWrapper<MUserMessage> wrapper);

    void updateToReaded(List<Long> ids);
}
