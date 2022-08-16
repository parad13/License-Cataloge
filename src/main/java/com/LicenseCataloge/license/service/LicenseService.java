package com.LicenseCataloge.license.service;

import com.LicenseCataloge.license.entity.License;
import com.LicenseCataloge.license.repository.LicenseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class LicenseService {

    @Autowired
    private LicenseRepository licenseRepository;

    public License saveLicense(License license) {
        log.info("Inside saveLicense of LicenseService");
        return licenseRepository.save(license);
    }

    public License findLicenseById(Long licenseId) {
        log.info("Inside findLicenseById of LicenseService");
        return licenseRepository.findById(licenseId).orElse(null);
    }

    public License deleteLicenseById(Long licenseId) {
        log.info("Inside deleteLicenseById of LicenseService");
        License deleteLicense =licenseRepository.findById(licenseId).orElse(null);
        if(deleteLicense==null)
            return null;
        licenseRepository.deleteById(licenseId);
        return deleteLicense;
    }

    public License updateLicenseById(License obj,long id) {
        log.info("Inside updateLicenseById of LicenseService");
        License updateLicense =licenseRepository.findById(id).orElse(null);
        if(updateLicense==null)
            return null;
        License temp =licenseRepository.findById(id).get();
        if(obj.getName()!=null)
            temp.setName(obj.getName());
        if(obj.getDescription()!=null)
            temp.setDescription(obj.getDescription());
        if(obj.getProductCode()!=null)
            temp.setProductCode(obj.getProductCode());
        return licenseRepository.save(temp);
    }

    public List<License> getAll() {
        return licenseRepository.findAll();
    }
}
