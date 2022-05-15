package innotech.springboot.dao.repository;

import innotech.springboot.dao.entitiy.Date;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateRepository extends CrudRepository<Date, Integer> {
}
