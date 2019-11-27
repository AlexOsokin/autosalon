package com.site.carsite.repos;

import com.site.carsite.domain.Tech;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface TechRepo extends CrudRepository<Tech, Integer> {//позволяет получить либо полный список полей либо найти по идентификатору
    List<Tech> findByName(String name);
    List<Tech> findByType(String type);

    @Query("select t  from Tech t where t.price <= ?1")
    List<Tech> findByPrice(int price) ;
    //Tech findById(String id);
     //Tech findByName(String name);
   // List<Tech> findById(String name);
    @Transactional
    Optional<Tech> deleteById(long id) ;
   // @Query("select * from tech_t ");
   List <Tech> findById(long id) ;

}
