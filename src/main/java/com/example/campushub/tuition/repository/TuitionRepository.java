package com.example.campushub.tuition.repository;

import com.example.campushub.tuition.domain.Tuition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TuitionRepository extends JpaRepository<Tuition, Long>, TuitionRepositoryCustom {
    // 추가적인 쿼리 메서드가 필요할 경우 여기에 정의
}
