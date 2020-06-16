package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.MComment;
import com.example.mapper.MCommentMapper;
import com.example.service.MCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WilliamYe
 * @since 2020-06-05
 */
@Service
public class MCommentServiceImpl extends ServiceImpl<MCommentMapper, MComment> implements MCommentService {

    @Autowired
    MCommentMapper commentMapper;

    @Override
    public IPage<CommentVo> paing(Page page, Long postId, Long userId, String order) {
        return commentMapper.selectComments(page, new QueryWrapper<MComment>()
                .eq(postId != null, "post_id", postId)
                .eq(userId != null, "user_id", userId)
                .orderByDesc(order != null, order)
        );
    }
}
