package com.crud.jva2;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static com.crud.jva2.ControladorPersona1.*;

public class PersonaRepositorioImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public List<PersonaEntity> getData(HashMap<String, Object> conditions){
        int pageNumber = 1;
        int pageSize = 10;
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
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

        query.select(root).where(predicates.toArray(new Predicate[predicates.size()])).orderBy(cb.asc(root.get(orden[0])));
        return entityManager.createQuery(query).getResultList();
    }
}
