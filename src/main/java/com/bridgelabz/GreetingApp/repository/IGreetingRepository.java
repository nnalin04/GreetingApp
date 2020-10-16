package com.bridgelabz.GreetingApp.repository;


import com.bridgelabz.GreetingApp.modle.GreetingMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGreetingRepository extends JpaRepository<GreetingMessage, Long> {
}
