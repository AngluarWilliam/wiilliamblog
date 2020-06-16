package com.example.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.entity.MCategory;
import com.example.service.MCategoryService;
import com.example.service.MPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.List;

@Component
public class ContextStartup implements ApplicationRunner, ServletContextAware {

    @Autowired
    MCategoryService categoryService;

    ServletContext servletContext;

    @Autowired
    MPostService postService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<MCategory> categories = categoryService.list(new QueryWrapper<MCategory>()
                .eq("status", 0)
        );
        servletContext.setAttribute("categorys", categories);

        postService.initWeekRank();
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
