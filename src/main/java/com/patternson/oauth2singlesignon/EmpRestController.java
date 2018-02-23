package com.patternson.oauth2singlesignon;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@EnableOAuth2Sso
public class EmpRestController extends WebSecurityConfigurerAdapter {

    Map<Integer, Employee> employeeMap = new HashMap<>();

    @RequestMapping(value="/employees", method= RequestMethod.GET)
    public Collection<Employee> getEmployees() {
        if (ObjectUtils.isEmpty(employeeMap)) {
            employeeMap.put(123, new Employee(123, "ram", 25, "ap"));
            employeeMap.put(456, new Employee(456, "sita", 26, "tn"));
            employeeMap.put(789, new Employee(789, "raju", 27, "kl"));
        }
        return employeeMap.values();
    }

    @RequestMapping(value="/employees/{id}", method= RequestMethod.GET)
    public Collection<Employee> saveEmployee(@PathVariable Integer id) {
        employeeMap.put(id, new Employee(id, "bala", 45, "tn"));
        return employeeMap.values();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/employees")
                .permitAll()
                .anyRequest()
                .authenticated();

    }
}
