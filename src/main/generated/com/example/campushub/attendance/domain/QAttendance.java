package com.example.campushub.attendance.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAttendance is a Querydsl query type for Attendance
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAttendance extends EntityPathBase<Attendance> {

    private static final long serialVersionUID = -1719347465L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAttendance attendance = new QAttendance("attendance");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.example.campushub.nweek.domain.QNWeek nWeek;

    public final EnumPath<AttendanceStatus> status = createEnum("status", AttendanceStatus.class);

    public final com.example.campushub.usercourse.domain.QUserCourse userCourse;

    public QAttendance(String variable) {
        this(Attendance.class, forVariable(variable), INITS);
    }

    public QAttendance(Path<? extends Attendance> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAttendance(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAttendance(PathMetadata metadata, PathInits inits) {
        this(Attendance.class, metadata, inits);
    }

    public QAttendance(Class<? extends Attendance> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.nWeek = inits.isInitialized("nWeek") ? new com.example.campushub.nweek.domain.QNWeek(forProperty("nWeek"), inits.get("nWeek")) : null;
        this.userCourse = inits.isInitialized("userCourse") ? new com.example.campushub.usercourse.domain.QUserCourse(forProperty("userCourse"), inits.get("userCourse")) : null;
    }

}

