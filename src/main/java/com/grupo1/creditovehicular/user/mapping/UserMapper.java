package com.grupo1.creditovehicular.user.mapping;

import com.grupo1.creditovehicular.shared.mapping.EnhancedModelMapper;
import com.grupo1.creditovehicular.user.domain.model.entity.User;
import com.grupo1.creditovehicular.user.resource.CreateUserResource;
import com.grupo1.creditovehicular.user.resource.UpdateUserResource;
import com.grupo1.creditovehicular.user.resource.UserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class UserMapper  implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public UserResource toResource(User model) {
        return mapper.map(model, UserResource.class);
    }

    public User toModel(CreateUserResource resource) {
        return mapper.map(resource, User.class);
    }

    public User toModel(UpdateUserResource resource) {
        return mapper.map(resource, User.class);
    }

    public Page<UserResource> modelListPage(List<User> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, UserResource.class), pageable, modelList.size());
    }
}
