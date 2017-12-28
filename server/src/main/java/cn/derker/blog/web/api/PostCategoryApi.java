package cn.derker.blog.web.api;

import cn.derker.blog.annotation.Api;
import cn.derker.blog.annotation.ApiInclude;
import cn.derker.blog.domain.entity.PostCategory;
import cn.derker.blog.domain.model.ApiResult;
import cn.derker.blog.service.PostCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author derker
 * @date 2017-12-28 15：49
 */
@Controller
@Api
@RequestMapping("/post_categories")
public class PostCategoryApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostCategoryApi.class);

    @Autowired
    private PostCategoryService postCategoryService;


    /**
     * 获取所有的文章分类
     *
     * @return
     */
    @GetMapping
    @ApiInclude(clazz = PostCategory.class, fields = {"id", "name", "url"})
    public ApiResult allPostCategories() {
        return ApiResult.ok(postCategoryService.listPostCategory());
    }

    /**
     * 添加文章分类
     *
     * @return
     */
    @PostMapping
    @ApiInclude(clazz = PostCategory.class, fields = {"id", "name", "url"})
    public ApiResult savePostCategory(@RequestBody PostCategory postCategory) {
        Assert.hasLength(postCategory.getName(), "文章分类名称不能为空.");
        Assert.hasLength(postCategory.getUrl(), "文章分类url不能为空.");
        postCategoryService.savePostCategory(postCategory);
        return ApiResult.ok(postCategory);
    }
}
