package com.brillio.example.firstRestService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentDAO extends JpaRepository<StudentDTO,String> {

    public Optional<StudentDTO> findByFname(String fname);

    public List<StudentDTO> findAllByFnameAndLname(String fname, String lname);
}
