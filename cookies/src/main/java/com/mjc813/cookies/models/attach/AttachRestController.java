package com.mjc813.cookies.models.attach;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/attach")
@RequiredArgsConstructor
public class AttachRestController {
    private final AttachService attachService;
}
