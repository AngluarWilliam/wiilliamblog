package com.example.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.MPost;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.search.SPost;
import com.example.vo.PostVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author WilliamYe
 * @since 2020-06-05
 */
public interface MPostMapper extends BaseMapper<MPost> {

    IPage<PostVo> selectPosts(Page page, @Param(Constants.WRAPPER) QueryWrapper wrapper);

    PostVo selectOnePost(@Param(Constants.WRAPPER)QueryWrapper<MPost> wrapper);

    @Select("select m.*,u.username authorName,u.avatar authorAvatar,c.name categoryName " +
            "from m_post m left join m_user u on m.user_id = u.id " +
            "left join m_category c on m.category_id = c.id " +
            "${ew.customSqlSegment}")
    List<SPost> getPage(Page page, @Param(Constants.WRAPPER)QueryWrapper<MPost> postQueryWrapper);
}
