package com.example.campushub.studentscore.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStudentScore is a Querydsl query type for StudentScore
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStudentScore extends EntityPathBase<StudentScore> {

    private static final long serialVersionUID = 2106562227L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStudentScore studentScore = new QStudentScore("studentScore");

    public final NumberPath<Integer> credit = createNumber("credit", Integer.class);

    public final StringPath grade = createString("grade");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> percentage = createNumber("percentage", Integer.class);

    public final NumberPath<Integer> totalScore = createNumber("totalScore", Integer.class);

    public final com.example.campushub.usercourse.domain.QUserCourse userCourse;

    public QStudentScore(String variable) {
        this(StudentScore.class, forVariable(variable), INITS);
    }

    public QStudentScore(Path<? extends StudentScore> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStudentScore(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStudentScore(PathMetadata metadata, PathInits inits) {
        this(StudentScore.class, metadata, inits);
    }

    public QStudentScore(Class<? extends StudentScore> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userCourse = inits.isInitialized("userCourse") ? new com.example.campushub.usercourse.domain.QUserCourse(forProperty("userCourse"), inits.get("userCourse")) : null;
    }

}

