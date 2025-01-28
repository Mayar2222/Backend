package com.example.RegisterLogin.Repository;

import com.example.RegisterLogin.Entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}