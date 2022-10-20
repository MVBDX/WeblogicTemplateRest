package ir.mvbdx.TemplateWeblogicRest.model.dto;

import lombok.Data;

@Data
public class UserDto {
    private Integer id;
    private String username;
    private String password;
    private String nam;
    private String famil;
}