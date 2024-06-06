package com.myapp.rest_client_DanVega.post;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class PostService {

    private final RestClient restClient;
    private final PostController postController;

    public PostService(PostController postController) {
        restClient = RestClient.builder()
                .baseUrl("http://jsonplaceholder.typicode.com")
                .build();
        this.postController = postController;
    }

    public List<Post> findAll() {
        return restClient.get()
                .uri("/posts")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Post>>() {}
                );
    }

    public Post findById(Integer id) {
        return restClient.get()
                .uri("posts/{id}", id)
                .retrieve()
                .body(Post.class);
    }

    public Post create(Post post) {
        return restClient.post()
                .uri("/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .body(post)
                .retrieve()
                .body(Post.class);
    }

    public Post update(Integer id, Post post) {
        return restClient.post()
                .uri("posts/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .body(post)
                .retrieve()
                .body(Post.class);
    }

    public void delete(Integer id) {
        restClient.delete()
                .uri("posts/{id}", id)
                .retrieve()
                .toBodilessEntity();
    }
}
