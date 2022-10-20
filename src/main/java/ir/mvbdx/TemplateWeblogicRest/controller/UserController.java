package ir.mvbdx.TemplateWeblogicRest.controller;

import ir.mvbdx.TemplateWeblogicRest.model.request.UserRequest;
import ir.mvbdx.TemplateWeblogicRest.model.response.UserResponse;
import ir.mvbdx.TemplateWeblogicRest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/TemplateWeblogicRest")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/api")
    public ResponseEntity<UserResponse> getAshkhas(@Valid @RequestBody UserRequest request) {
        return new ResponseEntity<>(userService.findUserById(request), HttpStatus.OK);
    }

    @GetMapping("alive")
    public String imAlive() {
        return "I'm alive!";
    }

}