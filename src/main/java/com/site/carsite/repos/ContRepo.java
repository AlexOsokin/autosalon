package com.site.carsite.repos;

import com.site.carsite.domain.Contract;
import com.site.carsite.domain.Tech;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ContRepo extends JpaRepository<Contract, Long> {
   // Contract findByName(String name);
   @Transactional
   Optional<Contract> deleteById(long id) ;
}