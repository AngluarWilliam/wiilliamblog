package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class IndexController extends BaseController{

    @RequestMapping({"", "/", "index"})
    public String index() {
        // 1分页信息 2分类 3用户 4置顶  5精选 6排序
        IPage results = postService.paging(getPage(), null, null, null, null, "created");

        req.setAttribute("pageData", results);
        req.setAttribute("currentCategoryId", 0);
        return "index";
    }

    @RequestMapping("/search")
    public String search(String q) {
        IPage pageData = searchService.search(getPage(), q);

        log.info("{}",pageData.getRecords());
        req.setAttribute("q", q);
        req.setAttribute("pageData", pageData);
        return "search";
    }

}
