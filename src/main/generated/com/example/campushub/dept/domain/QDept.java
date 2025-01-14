package com.example.campushub.dept.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QDept is a Querydsl query type for Dept
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDept extends EntityPathBase<Dept> {

    private static final long serialVersionUID = 733921519L;

    public static final QDept dept = new QDept("dept");

    public final StringPath deptName = createString("deptName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QDept(String variable) {
        super(Dept.class, forVariable(variable));
    }

    public QDept(Path<? extends Dept> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDept(PathMetadata metadata) {
        super(Dept.class, metadata);
    }

}

