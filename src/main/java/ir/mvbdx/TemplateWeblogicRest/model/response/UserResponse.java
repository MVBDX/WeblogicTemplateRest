package ir.mvbdx.TemplateWeblogicRest.model.response;

import ir.mvbdx.TemplateWeblogicRest.model.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private UserDto user;
}
