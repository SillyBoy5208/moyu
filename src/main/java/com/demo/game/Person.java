package com.demo.game;

import com.demo.form.PKResponseForm;
import com.demo.service.PackageService;

public interface Person {
    String PK(Monster monster);
    PKResponseForm PK(PackageService packageService, int userId, Monster monster);
}
