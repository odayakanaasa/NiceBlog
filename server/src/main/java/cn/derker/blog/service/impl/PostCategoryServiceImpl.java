package cn.derker.blog.service.impl;

import cn.derker.blog.dao.mapper.PostCategoryMapper;
import cn.derker.blog.domain.entity.PostCategory;
import cn.derker.blog.service.PostCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author derker
 * @date 2017-12-28 15：47
 */
@Service
public class PostCategoryServiceImpl implements PostCategoryService {

    @Autowired
    private PostCategoryMapper postCategoryMapper;

    @Override
    public List<PostCategory> listPostCategory() {
        Example example = new Example(PostCategory.class);
        example.setOrderByClause("sort_value ASC");
        return postCategoryMapper.selectByExample(example);
    }

    @Override
    public int savePostCategory(PostCategory postCategory) {
        return postCategoryMapper.insert(postCategory);
    }
}