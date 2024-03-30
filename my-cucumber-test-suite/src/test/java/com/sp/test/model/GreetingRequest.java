package com.sp.test.model;

import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GreetingRequest {

    private String greeting;
    private String name;
    private String message;

}
