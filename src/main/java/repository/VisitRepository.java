package repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Visit;

public interface VisitRepository extends JpaRepository<Visit, Long> {

    List<Visit> findByCustomerId(Long customerId);

    List<Visit> findByNextRevisitDateBetween(
            LocalDate start,
            LocalDate end
    );
}