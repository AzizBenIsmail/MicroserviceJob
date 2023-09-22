package com.esprit.job;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JobRepository extends JpaRepository<Job,Integer> {

    @Query("select j from Job j where j.nom like :name")
    public Page<Job> JobByNom (@Param("name") String n , Pageable pageable);

}
