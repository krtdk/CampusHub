package com.example.campushub.lecturetime.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLectureTime is a Querydsl query type for LectureTime
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLectureTime extends EntityPathBase<LectureTime> {

    private static final long serialVersionUID = 311240365L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLectureTime lectureTime1 = new QLectureTime("lectureTime1");

    public final com.example.campushub.course.domain.QCourse course;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.util.Date> lectureDay = createDateTime("lectureDay", java.util.Date.class);

    public final TimePath<java.sql.Time> lectureTime = createTime("lectureTime", java.sql.Time.class);

    public QLectureTime(String variable) {
        this(LectureTime.class, forVariable(variable), INITS);
    }

    public QLectureTime(Path<? extends LectureTime> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLectureTime(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLectureTime(PathMetadata metadata, PathInits inits) {
        this(LectureTime.class, metadata, inits);
    }

    public QLectureTime(Class<? extends LectureTime> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.course = inits.isInitialized("course") ? new com.example.campushub.course.domain.QCourse(forProperty("course"), inits.get("course")) : null;
    }

}

