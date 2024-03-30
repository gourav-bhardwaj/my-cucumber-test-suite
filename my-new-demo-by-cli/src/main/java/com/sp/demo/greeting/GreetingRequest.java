package com.sp.demo.greeting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GreetingRequest {

    private String greeting;
    private String name;
    private String message;

}