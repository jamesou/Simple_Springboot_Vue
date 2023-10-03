package com.jamesou.service.impl;

import com.jamesou.entity.Blog;
import com.jamesou.mapper.BlogMapper;
import com.jamesou.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *
 * @author JamesOu
 * @since 2020-05-24
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
