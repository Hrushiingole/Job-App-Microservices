package com.project.JobApplication.company;

import java.util.List;

public interface Companyservice {
    Company createCompany(Company company);
    List<Company> getAllCompanies();

    Boolean updateCompany(Company company);
    Boolean deleteCompany(Long id);

    Company getCompanyById(Long id);
}
