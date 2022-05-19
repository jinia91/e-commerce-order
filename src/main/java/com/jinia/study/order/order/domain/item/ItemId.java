package com.jinia.study.order.order.domain.item;

import com.jinia.study.order.shared.domain.ValueObject;
import lombok.*;

import javax.persistence.Embeddable;
import java.util.Objects;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ItemId implements ValueObject<ItemId> {
    private Long id;

    @Override
    public boolean sameValueAs(ItemId o) {
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
