package innotech.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import innotech.springboot.model.Date;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DateRepository extends JpaRepository<Date, Long> {
    @Override
    List<Date> findAll();
}
