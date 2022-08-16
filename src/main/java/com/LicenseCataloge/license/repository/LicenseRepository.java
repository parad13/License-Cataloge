package com.LicenseCataloge.license.repository;

import com.LicenseCataloge.license.entity.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenseRepository extends JpaRepository<License, Long> {
    License findByLicenseId(Long licenseId);

}
