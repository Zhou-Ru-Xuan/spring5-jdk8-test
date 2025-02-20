package com.example.spring5jdk8test.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary // 优先注入
public class BaseService {
}
