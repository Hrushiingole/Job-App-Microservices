package com.project.JobApplication.company.Repository;

import com.project.JobApplication.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
