package com.example.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.MComment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.vo.CommentVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author WilliamYe
 * @since 2020-06-05
 */
public interface MCommentMapper extends BaseMapper<MComment> {

    IPage<CommentVo> selectComments(Page page, @Param(Constants.WRAPPER) QueryWrapper<MComment> orderByDesc);
}
