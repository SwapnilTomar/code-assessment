package com.example.codeassessment.dao;

import com.example.codeassessment.entity.FlightData;
import com.example.codeassessment.repository.FlightDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class FlightDataDAOImpl implements FlightDataDAO{
    @PersistenceContext
    private EntityManager entityManger;
    @Autowired
    FlightDataRepository repository;
    @Override
    public List<FlightData> getFlightInfoByDay(String dayToBeSearch){
        CriteriaBuilder criteriaBuilder = entityManger.getCriteriaBuilder();
        CriteriaQuery<FlightData> criteriaQuery = criteriaBuilder.createQuery(FlightData.class);

        Root<FlightData> flightDataRoot = criteriaQuery.from(FlightData.class);
        criteriaQuery.select(flightDataRoot).where(criteriaBuilder.equal(flightDataRoot.get(dayToBeSearch), "x"));
        return entityManger.createQuery(criteriaQuery).getResultList();
    }
    @Override
    public void createFlightData(List<FlightData> flightDataList){
        getRepository().saveAll(flightDataList);
    }

    public FlightDataRepository getRepository() {
        return repository;
    }

    public void setRepository(FlightDataRepository repository) {
        this.repository = repository;
    }
}
