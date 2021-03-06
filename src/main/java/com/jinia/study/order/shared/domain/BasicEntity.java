package com.jinia.study.order.shared.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
/*
    - auditing 용 추상 엔티티
*/
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
public abstract class BasicEntity implements Persistable<Object> {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime updatedDate;
    @Override
    public boolean isNew() {
        return createdDate == null;
    }
}
