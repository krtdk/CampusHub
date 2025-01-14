package com.example.campushub.schoolyear.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSchoolYear is a Querydsl query type for SchoolYear
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSchoolYear extends EntityPathBase<SchoolYear> {

    private static final long serialVersionUID = 1909683879L;

    public static final QSchoolYear schoolYear = new QSchoolYear("schoolYear");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath is_current = createBoolean("is_current");

    public final EnumPath<Semester> semester = createEnum("semester", Semester.class);

    public final DateTimePath<java.util.Date> year = createDateTime("year", java.util.Date.class);

    public QSchoolYear(String variable) {
        super(SchoolYear.class, forVariable(variable));
    }

    public QSchoolYear(Path<? extends SchoolYear> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSchoolYear(PathMetadata metadata) {
        super(SchoolYear.class, metadata);
    }

}

