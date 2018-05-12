package airtel3.service;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import airtel3.bean.Csv;
 
@Repository
public interface CsvRepo extends CrudRepository<Csv ,String> {
/*	@Query("SELECT a FROM CSV a")
    public List<Object> findByTitle();*/
}
