package com.example.campushub.course.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCourse is a Querydsl query type for Course
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCourse extends EntityPathBase<Course> {

    private static final long serialVersionUID = 1615385947L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCourse course = new QCourse("course");

    public final NumberPath<Integer> assignScore = createNumber("assignScore", Integer.class);

    public final NumberPath<Integer> attScore = createNumber("attScore", Integer.class);

    public final StringPath courseName = createString("courseName");

    public final NumberPath<Integer> credits = createNumber("credits", Integer.class);

    public final StringPath day = createString("day");

    public final StringPath division = createString("division");

    public final NumberPath<Integer> end = createNumber("end", Integer.class);

    public final NumberPath<Integer> finalExam = createNumber("finalExam", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> midExam = createNumber("midExam", Integer.class);

    public final StringPath room = createString("room");

    public final NumberPath<Integer> start = createNumber("start", Integer.class);

    public final com.example.campushub.user.domain.QUser user;

    public QCourse(String variable) {
        this(Course.class, forVariable(variable), INITS);
    }

    public QCourse(Path<? extends Course> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCourse(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCourse(PathMetadata metadata, PathInits inits) {
        this(Course.class, metadata, inits);
    }

    public QCourse(Class<? extends Course> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new com.example.campushub.user.domain.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

