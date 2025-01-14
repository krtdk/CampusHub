package com.example.campushub.usertuition.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserTuition is a Querydsl query type for UserTuition
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserTuition extends EntityPathBase<UserTuition> {

    private static final long serialVersionUID = -1490375507L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserTuition userTuition = new QUserTuition("userTuition");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.util.Date> paymentDate = createDateTime("paymentDate", java.util.Date.class);

    public final BooleanPath paymentStatus = createBoolean("paymentStatus");

    public final com.example.campushub.schoolyear.domain.QSchoolYear schoolYear;

    public final com.example.campushub.tuition.domain.QTuition tuition;

    public final com.example.campushub.user.domain.QUser user;

    public QUserTuition(String variable) {
        this(UserTuition.class, forVariable(variable), INITS);
    }

    public QUserTuition(Path<? extends UserTuition> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserTuition(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserTuition(PathMetadata metadata, PathInits inits) {
        this(UserTuition.class, metadata, inits);
    }

    public QUserTuition(Class<? extends UserTuition> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.schoolYear = inits.isInitialized("schoolYear") ? new com.example.campushub.schoolyear.domain.QSchoolYear(forProperty("schoolYear")) : null;
        this.tuition = inits.isInitialized("tuition") ? new com.example.campushub.tuition.domain.QTuition(forProperty("tuition"), inits.get("tuition")) : null;
        this.user = inits.isInitialized("user") ? new com.example.campushub.user.domain.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

