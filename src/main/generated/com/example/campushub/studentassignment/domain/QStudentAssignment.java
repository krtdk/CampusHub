package com.example.campushub.studentassignment.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStudentAssignment is a Querydsl query type for StudentAssignment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStudentAssignment extends EntityPathBase<StudentAssignment> {

    private static final long serialVersionUID = 887488781L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStudentAssignment studentAssignment = new QStudentAssignment("studentAssignment");

    public final com.example.campushub.assignment.domain.QAssignment assignment;

    public final StringPath courseContent = createString("courseContent");

    public final NumberPath<Integer> courseGrade = createNumber("courseGrade", Integer.class);

    public final StringPath courseTitle = createString("courseTitle");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.example.campushub.usercourse.domain.QUserCourse userCourse;

    public QStudentAssignment(String variable) {
        this(StudentAssignment.class, forVariable(variable), INITS);
    }

    public QStudentAssignment(Path<? extends StudentAssignment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStudentAssignment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStudentAssignment(PathMetadata metadata, PathInits inits) {
        this(StudentAssignment.class, metadata, inits);
    }

    public QStudentAssignment(Class<? extends StudentAssignment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.assignment = inits.isInitialized("assignment") ? new com.example.campushub.assignment.domain.QAssignment(forProperty("assignment"), inits.get("assignment")) : null;
        this.userCourse = inits.isInitialized("userCourse") ? new com.example.campushub.usercourse.domain.QUserCourse(forProperty("userCourse"), inits.get("userCourse")) : null;
    }

}

