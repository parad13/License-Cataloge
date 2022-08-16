package com.LicenseCataloge.license.controller;

import com.LicenseCataloge.license.entity.License;
import com.LicenseCataloge.license.service.LicenseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/licenses")
@Slf4j
public class LicenseController {

    @Autowired
    private LicenseService licenseService;

    @PostMapping("/")
    public String saveLicense(@RequestBody License license)
    {
        log.info("Inside saveLicense method of LicenseController");
        License l= licenseService.saveLicense(license);
        return "Created with licenseId:"+l.getLicenseId();
    }

    @GetMapping("{id}")
    public License findLicenseById(@PathVariable("id") Long licenseId) {
        log.info("Inside findLicenseById method of LicenseController");
        License checkLicense=licenseService.findLicenseById(licenseId);
        if (checkLicense == null) throw new ResourceNotFoundException();
        return checkLicense;
    }

    @GetMapping("/")
    public List<License> getAllLicense() {
        log.info("Inside findLicenseById method of LicenseController");
        return licenseService.getAll();
    }

    @DeleteMapping("{id}")
    public String deleteLicenseById(@PathVariable("id") Long licenseId) {
        log.info("Inside deleteLicenseById method of LicenseController");
        License checkLicense =licenseService.findLicenseById(licenseId);
        if (checkLicense == null) throw new ResourceNotFoundException();
        licenseService.deleteLicenseById(licenseId);
        return "Deleted licenseId :" + checkLicense.getLicenseId();
    }

    @PatchMapping("{id}")
    public License updateLicenseById(@PathVariable long id,@RequestBody License obj) {
        log.info("Inside updateLicenseById method of LicenseController");
        License checkLicense =licenseService.findLicenseById(id);
        if (checkLicense == null) throw new ResourceNotFoundException();
        return licenseService.updateLicenseById(obj,id);
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {
    }

}
