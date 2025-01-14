package com.example.campushub.userscholarship.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserScholarship is a Querydsl query type for UserScholarship
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserScholarship extends EntityPathBase<UserScholarship> {

    private static final long serialVersionUID = 2100890477L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserScholarship userScholarship = new QUserScholarship("userScholarship");

    public final DateTimePath<java.util.Date> confDate = createDateTime("confDate", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.example.campushub.scholarship.domain.QScholarship scholarship;

    public final com.example.campushub.schoolyear.domain.QSchoolYear schoolYear;

    public final com.example.campushub.user.domain.QUser user;

    public QUserScholarship(String variable) {
        this(UserScholarship.class, forVariable(variable), INITS);
    }

    public QUserScholarship(Path<? extends UserScholarship> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserScholarship(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserScholarship(PathMetadata metadata, PathInits inits) {
        this(UserScholarship.class, metadata, inits);
    }

    public QUserScholarship(Class<? extends UserScholarship> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.scholarship = inits.isInitialized("scholarship") ? new com.example.campushub.scholarship.domain.QScholarship(forProperty("scholarship")) : null;
        this.schoolYear = inits.isInitialized("schoolYear") ? new com.example.campushub.schoolyear.domain.QSchoolYear(forProperty("schoolYear")) : null;
        this.user = inits.isInitialized("user") ? new com.example.campushub.user.domain.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

