package com.jinia.study.order.shared.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.util.Objects;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MemberId implements ValueObject<MemberId> {
    private Long id;

    @Override
    public boolean sameValueAs(MemberId o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return Objects.equals(id, o.id);
    }

    @Override
    public String toString() {
        return String.valueOf(this.id);
    }
}