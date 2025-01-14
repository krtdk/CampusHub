package com.example.campushub.tuition.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTuition is a Querydsl query type for Tuition
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTuition extends EntityPathBase<Tuition> {

    private static final long serialVersionUID = 1675072493L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTuition tuition = new QTuition("tuition");

    public final com.example.campushub.dept.domain.QDept dept;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> tuitionFee = createNumber("tuitionFee", Integer.class);

    public QTuition(String variable) {
        this(Tuition.class, forVariable(variable), INITS);
    }

    public QTuition(Path<? extends Tuition> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTuition(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTuition(PathMetadata metadata, PathInits inits) {
        this(Tuition.class, metadata, inits);
    }

    public QTuition(Class<? extends Tuition> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.dept = inits.isInitialized("dept") ? new com.example.campushub.dept.domain.QDept(forProperty("dept")) : null;
    }

}

