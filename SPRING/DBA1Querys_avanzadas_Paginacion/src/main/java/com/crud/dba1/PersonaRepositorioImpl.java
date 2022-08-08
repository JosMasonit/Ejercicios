package com.crud.dba1;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static com.crud.dba1.ControladorPersona1.*;

public class PersonaRepositorioImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public Page<PersonaEntity> getData(HashMap<String, Object> conditions, Pageable pageable){
        //int pageNumber = 1;
        //int pageSize = 10;
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        //Query de filtrado
        CriteriaQuery<PersonaEntity> query = cb.createQuery(PersonaEntity.class);
        Root<PersonaEntity> root = query.from(PersonaEntity.class);

        final String[] orden = new String[1];
        List<Predicate> predicates = new ArrayList();
        conditions.forEach((field, value) ->
        {
            switch(field)
            {
                case "usuario":
                    predicates.add(cb.like(root.get(field), "%"+(String)value+"%"));
                    break;
                case "name":
                    predicates.add(cb.like(root.get(field), "%"+(String)value+"%"));
                    break;
                case "surname":
                    predicates.add(cb.like(root.get(field), "%"+(String)value+"%"));
                    break;
                case "created_date":
                    String dateCondition = (String) conditions.get("dateCondition");
                    switch (dateCondition)
                    {
                        case GREATER_THAN:
                            predicates.add(cb.greaterThan(root.<Date>get(field), (Date)value));
                            break;
                        case LESS_THAN:
                            predicates.add(cb.lessThan(root.<Date>get(field), (Date)value));
                            break;
                        case EQUAL:
                            predicates.add(cb.equal(root.<Date>get(field), (Date)value));
                            break;
                    }
                    break;
                case "orden":
                    String order = (String) conditions.get("orden");
                    switch (order){
                        case "usuario":
                            orden[0] = "usuario";
                            break;
                        case "name":
                            orden[0] = "name";
                            break;
                        default:
                            orden[0] = "id_persona";
                    }
            }
        });

        query.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
        query.orderBy(cb.asc(root.get(orden[0])));

        // This query fetches the Books as per the Page Limit
        List<PersonaEntity> result = entityManager.createQuery(query).setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();
        // Create Count Query
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<PersonaEntity> rootCount = countQuery.from(PersonaEntity.class);
        countQuery.select(cb.count(rootCount)).where(cb.and(predicates.toArray(new Predicate[predicates.size()])));

        // Fetches the count of all Books as per given criteria
        Long count = entityManager.createQuery(countQuery).getSingleResult();

        query.select(root).where(predicates.toArray(new Predicate[predicates.size()])).orderBy(cb.asc(root.get(orden[0])));
        Page<PersonaEntity> result1 = new PageImpl<>(result, pageable, count);
        return result1;
    }
}
