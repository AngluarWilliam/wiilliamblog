package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.MComment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.vo.CommentVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WilliamYe
 * @since 2020-06-05
 */
public interface MCommentService extends IService<MComment> {

    IPage<CommentVo> paing(Page page, Long postId, Long userId, String order);
}
