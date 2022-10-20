package ir.mvbdx.TemplateWeblogicRest.service;

import ir.mvbdx.TemplateWeblogicRest.model.request.UserRequest;
import ir.mvbdx.TemplateWeblogicRest.model.response.UserResponse;

public interface UserService {
    UserResponse findUserById(UserRequest request);
}
