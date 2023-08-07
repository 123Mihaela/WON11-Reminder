package org.fasttrackit.reminder.repository;

import org.fasttrackit.reminder.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <UserModel, Long> {

}
