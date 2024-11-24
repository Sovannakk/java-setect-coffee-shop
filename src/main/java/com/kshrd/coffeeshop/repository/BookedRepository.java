package com.kshrd.coffeeshop.repository;

import com.kshrd.coffeeshop.entity.Booked;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookedRepository extends JpaRepository<Booked, Long> {

}
