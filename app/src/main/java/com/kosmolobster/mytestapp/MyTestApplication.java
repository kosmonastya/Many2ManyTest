package com.kosmolobster.mytestapp;

import com.orm.SugarApp;

import com.kosmolobster.mytestapp.models.Company;
import com.kosmolobster.mytestapp.models.CompanyEmployee;
import com.kosmolobster.mytestapp.models.Employee;
import com.orm.SugarRecord;


public class MyTestApplication extends SugarApp {

    @Override
    public void onCreate() {
        super.onCreate();

        SugarRecord.deleteAll(Company.class);
        SugarRecord.deleteAll(Employee.class);
        SugarRecord.deleteAll(CompanyEmployee.class);

        Company company = new Company("Company");
        company.save();

        String[] values = getResources().getStringArray(R.array.employees_names);

        for (int i = 0; i < values.length - 1; ++i) {
            Employee employee = new Employee(values[i]);
            employee.save();

            CompanyEmployee companyEmployee = new CompanyEmployee(company.getName(), employee.getName());
            companyEmployee.save();
        }
    }
}
