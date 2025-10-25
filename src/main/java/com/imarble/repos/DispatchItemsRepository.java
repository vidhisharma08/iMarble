package com.imarble.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imarble.entities.DispatchItems;
import com.imarble.entities.SalesDispatch;
@Repository
public interface DispatchItemsRepository extends JpaRepository<DispatchItems,Long> {

	List<DispatchItems> findByDispatch(SalesDispatch dispatch);

}
