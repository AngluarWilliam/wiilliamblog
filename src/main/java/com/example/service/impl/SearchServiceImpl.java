package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.MPost;
import com.example.service.MPostService;
import com.example.service.SearchService;
import com.example.vo.PostVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class SearchServiceImpl implements SearchService {


    @Autowired
    MPostService postService;

    @Override
    public IPage search(Page page, String keyword) {
        // 分页信息 mybatis plus的page 转成 jpa的page
     /* Long current = page.getCurrent() - 1;
        Long size = page.getSize();
        Pageable pageable = PageRequest.of(current.intValue(), size.intValue());

        // 搜索es得到pageData
        MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery(keyword,
                "title", "authorName", "categoryName");

        org.springframework.data.domain.Page<PostDocment> docments = postRepository.search(multiMatchQueryBuilder, pageable);

        // 结果信息 jpa的pageData转成mybatis plus的pageData
        IPage pageData = new Page(page.getCurrent(), page.getSize(), docments.getTotalElements());
        pageData.setRecords(docments.getContent());*/
        QueryWrapper<MPost> postQueryWrapper = new QueryWrapper<>();
        postQueryWrapper.like("title",keyword);
        IPage postPage = page.setRecords(postService.getPage(page, postQueryWrapper));
        return postPage;
    }

    @Override
    public int initEsData(List<PostVo> records) {
        if(records == null || records.isEmpty()) {
            return 0;
        }

        /*List<PostDocment> documents = new ArrayList<>();
        for(PostVo vo : records) {
            // 映射转换
            PostDocment postDocment = modelMapper.map(vo, PostDocment.class);
            documents.add(postDocment);
        }
        postRepository.saveAll(documents);*/
        return 0;
    }


}
