package com.mjc813.cookies.models.attach;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AttachService {
    private final AttachRepository attachRepository;
}
