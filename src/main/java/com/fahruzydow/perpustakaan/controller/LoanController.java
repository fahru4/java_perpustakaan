package com.fahruzydow.perpustakaan.controller;

import com.fahruzydow.perpustakaan.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("loans")
public class LoanController extends BaseController {
    @Autowired
    private LoanService service;

}
