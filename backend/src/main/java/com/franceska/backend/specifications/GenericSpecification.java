package com.franceska.backend.specifications;

import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class GenericSpecification<T> implements Specification<T> {

    private final Map<String, Object> filters;

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (filters == null || filters.isEmpty()) {
            return cb.conjunction();
        }

        List<Predicate> predicates = new ArrayList<>();

        for (Map.Entry<String, Object> entry : filters.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (value == null) continue;

            // dacă e string => LIKE (pentru că vrem căutare parțială)
            if (value instanceof String str) {
                predicates.add(
                        cb.like(cb.lower(root.get(key).as(String.class)), "%" + str.toLowerCase() + "%")
                );
            }
            // altfel egalitate simplă
            else {
                predicates.add(cb.equal(root.get(key), value));
            }
        }

        // combinăm toate condițiile cu AND
        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
