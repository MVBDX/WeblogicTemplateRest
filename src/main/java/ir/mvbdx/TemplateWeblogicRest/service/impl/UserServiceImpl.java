package ir.mvbdx.TemplateWeblogicRest.service.impl;

import ir.mvbdx.TemplateWeblogicRest.model.dto.UserDto;
import ir.mvbdx.TemplateWeblogicRest.model.entity.User;
import ir.mvbdx.TemplateWeblogicRest.exception.EntityNotFoundException;
import ir.mvbdx.TemplateWeblogicRest.repository.UserDao;
import ir.mvbdx.TemplateWeblogicRest.model.request.UserRequest;
import ir.mvbdx.TemplateWeblogicRest.model.response.UserResponse;
import ir.mvbdx.TemplateWeblogicRest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final ModelMapper modelMapper;

    public UserResponse findUserById(UserRequest request) {
        User user = userDao.findById(request.getUserId()).orElseThrow(EntityNotFoundException::new);
        return new UserResponse(modelMapper.map(user, UserDto.class));
    }

}