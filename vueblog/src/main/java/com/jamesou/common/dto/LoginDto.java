package com.jamesou.common.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class LoginDto implements Serializable {

    @NotBlank(message = "username can not be allowed empty")
    private String username;

    @NotBlank(message = "password can not be allowed empty")
    private String password;
}
