package com.example.campushub.semsterschedule.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSemesterSchedule is a Querydsl query type for SemesterSchedule
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSemesterSchedule extends EntityPathBase<SemesterSchedule> {

    private static final long serialVersionUID = -932635806L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSemesterSchedule semesterSchedule = new QSemesterSchedule("semesterSchedule");

    public final BooleanPath dateCheck = createBoolean("dateCheck");

    public final DateTimePath<java.time.LocalDateTime> endDate = createDateTime("endDate", java.time.LocalDateTime.class);

    public final StringPath eventName = createString("eventName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<Schedule> schedule = createEnum("schedule", Schedule.class);

    public final com.example.campushub.schoolyear.domain.QSchoolYear schoolYear;

    public final DateTimePath<java.time.LocalDateTime> startDate = createDateTime("startDate", java.time.LocalDateTime.class);

    public QSemesterSchedule(String variable) {
        this(SemesterSchedule.class, forVariable(variable), INITS);
    }

    public QSemesterSchedule(Path<? extends SemesterSchedule> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSemesterSchedule(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSemesterSchedule(PathMetadata metadata, PathInits inits) {
        this(SemesterSchedule.class, metadata, inits);
    }

    public QSemesterSchedule(Class<? extends SemesterSchedule> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.schoolYear = inits.isInitialized("schoolYear") ? new com.example.campushub.schoolyear.domain.QSchoolYear(forProperty("schoolYear")) : null;
    }

}

