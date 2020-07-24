package com.carzzy.rahul.api;

import com.carzzy.rahul.entity.Post;
import com.carzzy.rahul.entity.User;
import com.carzzy.rahul.exception.UserNotFoundException;
import com.carzzy.rahul.service.PostService;
import com.carzzy.rahul.service.UserService;
import com.carzzy.rahul.service.impl.PostServiceImpl;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/users")
public class UserApi {

    private UserService userService;
    private PostService postService;

    public UserApi(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @GetMapping("/{id}")
    public EntityModel<User> findById(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        if(!user.isPresent()) {
            throw new UserNotFoundException("User not found with ID: " + id);
        }

        // HATEOS : will send all users, Server Path : /users
        EntityModel<User> resource = EntityModel.of(user.get());
        Link link= WebMvcLinkBuilder.linkTo(methodOn(this.getClass()).findAll()).withRel("all-users");

        resource.add(link);
        return resource;
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody User user) {
        User savedUser = userService.save(user);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @PatchMapping
    public User update(@RequestBody User user) {
        return userService.save(user);
    }

    // User Posts
    @GetMapping("/{id}/posts")
    public List<Post> findAll(@PathVariable Long id) {
        Optional<User> byId = userService.findById(id);
        if(!byId.isPresent()) {
            throw new UserNotFoundException("User not found with ID: " + id);
        }
        return byId.get().getPosts();
    }

    @PostMapping("/{id}/posts")
    public ResponseEntity<Object> save(@PathVariable Long id, @RequestBody Post post) {
        Optional<User> byId = userService.findById(id);
        if(!byId.isPresent()) {
            throw new UserNotFoundException("User not found with ID: " + id);
        }

        User user = byId.get();
        post.setUser(user);
        postService.save(post);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
