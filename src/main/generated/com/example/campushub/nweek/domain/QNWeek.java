package com.example.campushub.nweek.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QNWeek is a Querydsl query type for NWeek
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QNWeek extends EntityPathBase<NWeek> {

    private static final long serialVersionUID = -812619699L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QNWeek nWeek = new QNWeek("nWeek");

    public final com.example.campushub.course.domain.QCourse course;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<Week> week = createEnum("week", Week.class);

    public QNWeek(String variable) {
        this(NWeek.class, forVariable(variable), INITS);
    }

    public QNWeek(Path<? extends NWeek> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QNWeek(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QNWeek(PathMetadata metadata, PathInits inits) {
        this(NWeek.class, metadata, inits);
    }

    public QNWeek(Class<? extends NWeek> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.course = inits.isInitialized("course") ? new com.example.campushub.course.domain.QCourse(forProperty("course"), inits.get("course")) : null;
    }

}

