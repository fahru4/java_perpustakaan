package com.fahruzydow.perpustakaan.controller;

import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("isFullyAuthenticated()")
public abstract class BaseController {
}
