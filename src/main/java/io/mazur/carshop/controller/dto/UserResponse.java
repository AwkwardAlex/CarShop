package io.mazur.carshop.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
public class UserResponse {

    private String message;

    @Singular
    private List<Map<String, Object>> infos;
}
