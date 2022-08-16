package com.LicenseCataloge.license;

import static org.assertj.core.api.Assertions.assertThat;

import com.LicenseCataloge.license.entity.License;
import com.LicenseCataloge.license.repository.LicenseRepository;
import com.LicenseCataloge.license.service.LicenseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {LicenseApplicationTests.class})
class LicenseApplicationTests {

	@Mock
	LicenseRepository licenseRepository;

	@InjectMocks
	LicenseService licenseService;

	@DisplayName("JUnit test for saveLicense method")
	@Test
	public void test_saveLicense(){
		License license = new License(1L,"license","this is license","license-00");
		when(licenseRepository.save(license)).thenReturn(license);
		assertEquals(license,licenseService.saveLicense(license));
	}

	@DisplayName("JUnit test for deleteLicenseById method")
	@Test
	public void testDeleteUser() {
		long userId=1;
		licenseService.deleteLicenseById(userId);
		verify(licenseRepository,times(1)).deleteById(userId);
	}

	@DisplayName("JUnit test for findUserById method")
	@Test
	public void testFindUser() {
		long userId=1;
		licenseService.findLicenseById(userId);
		verify(licenseRepository,times(1)).findByLicenseId(userId);
	}

	@DisplayName("JUnit test for findUserById method")
	@Test
	public void testUpdateUser() {
		long userId=1;
		License license = new License(1L,"license","this is license","license-00");
		when(licenseRepository.save(license)).thenReturn(license);
		assertEquals(license,licenseService.saveLicense(license));
	}

}
