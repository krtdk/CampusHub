package com.example.campushub.exam.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QExam is a Querydsl query type for Exam
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QExam extends EntityPathBase<Exam> {

    private static final long serialVersionUID = -150585949L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QExam exam = new QExam("exam");

    public final NumberPath<Integer> finalScore = createNumber("finalScore", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> midScore = createNumber("midScore", Integer.class);

    public final NumberPath<Integer> totalScore = createNumber("totalScore", Integer.class);

    public final com.example.campushub.usercourse.domain.QUserCourse userCourse;

    public QExam(String variable) {
        this(Exam.class, forVariable(variable), INITS);
    }

    public QExam(Path<? extends Exam> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QExam(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QExam(PathMetadata metadata, PathInits inits) {
        this(Exam.class, metadata, inits);
    }

    public QExam(Class<? extends Exam> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userCourse = inits.isInitialized("userCourse") ? new com.example.campushub.usercourse.domain.QUserCourse(forProperty("userCourse"), inits.get("userCourse")) : null;
    }

}

