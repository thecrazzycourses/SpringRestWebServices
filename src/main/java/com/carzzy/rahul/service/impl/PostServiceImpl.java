package com.carzzy.rahul.service.impl;

import com.carzzy.rahul.entity.Post;
import com.carzzy.rahul.repository.PostRepository;
import com.carzzy.rahul.service.PostService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

}
