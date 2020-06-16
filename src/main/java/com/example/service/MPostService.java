package com.example.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.MPost;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.search.SPost;
import com.example.vo.PostVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WilliamYe
 * @since 2020-06-05
 */
public interface MPostService extends IService<MPost> {

    IPage paging(Page page, Long categoryId, Long userId, Integer level, Boolean recommend, String order);

    PostVo selectOnePost(QueryWrapper<MPost> wrapper);

    void initWeekRank();

    void incrCommentCountAndUnionForWeekRank(long postId, boolean isIncr);

    void putViewCount(PostVo vo);

    List<SPost> getPage(Page page,QueryWrapper<MPost> postQueryWrapper);
}
