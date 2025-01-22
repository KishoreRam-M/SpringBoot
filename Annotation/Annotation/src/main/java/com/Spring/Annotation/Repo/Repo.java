package com.Spring.Annotation.Repo;

import com.Spring.Annotation.Model.HomeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<HomeModel,String> {

}
