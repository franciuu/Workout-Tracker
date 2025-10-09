package com.franceska.backend.specification;

import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.*;

@RequiredArgsConstructor
public class GenericSpecification<T> implements Specification<T> {

    private final Map<String, Object> filters;

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        if (filters == null || filters.isEmpty()) {
            return cb.conjunction();
        }

        filters.forEach((key, value) -> {
            if (value == null) return;

            try {
                // dacă avem un câmp nested (ex: categories.name)
                if (key.contains(".")) {
                    String[] parts = key.split("\\.");
                    String relationName = parts[0];
                    String fieldName = parts[1];

                    Join<Object, Object> join = root.join(relationName);

                    if (value instanceof Iterable<?> iterable) {
                        List<Predicate> subPredicates = new ArrayList<>();
                        for (Object v : iterable) {
                            subPredicates.add(cb.equal(join.get(fieldName), v.toString()));
                        }
                        predicates.add(cb.or(subPredicates.toArray(new Predicate[0])));
                    } else {
                        predicates.add(cb.equal(join.get(fieldName), value.toString()));
                    }

                    return;
                }

                // verificăm dacă atributul e o colecție (ManyToMany / OneToMany)
                Class<?> attrType = root.getModel().getAttribute(key).getJavaType();
                boolean isCollection = Collection.class.isAssignableFrom(attrType);

                if (isCollection) {
                    Join<Object, Object> join = root.join(key);

                    if (value instanceof Iterable<?> iterable) {
                        List<Predicate> subPredicates = new ArrayList<>();
                        for (Object v : iterable) {
                            subPredicates.add(cb.equal(join.get("name"), v.toString()));
                        }
                        predicates.add(cb.or(subPredicates.toArray(new Predicate[0])));
                    } else {
                        predicates.add(cb.equal(join.get("name"), value.toString()));
                    }

                } else {
                    // câmp simplu
                    if (value instanceof String) {
                        predicates.add(cb.like(
                                cb.lower(root.get(key).as(String.class)),
                                "%" + value.toString().toLowerCase() + "%"
                        ));
                    } else {
                        predicates.add(cb.equal(root.get(key), value));
                    }
                }

            } catch (IllegalArgumentException e) {
                // câmp inexistent — îl ignorăm
            }
        });

        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
