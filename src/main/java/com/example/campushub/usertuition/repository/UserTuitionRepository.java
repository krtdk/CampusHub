package com.example.campushub.usertuition.repository;

import com.example.campushub.user.domain.User;
import com.example.campushub.usertuition.domain.UserTuition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserTuitionRepository extends JpaRepository<UserTuition, Long> {

    @Query("select ut from UserTuition ut join fetch ut.user u where u.id in :userIds")
    List<UserTuition> findAllByUserIds(List<Long> userIds);

    UserTuition findByUser(User user);
    UserTuition findByUserAndTuitionId(User user, Long tuitionId);

}