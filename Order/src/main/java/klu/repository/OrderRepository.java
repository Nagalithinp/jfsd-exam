package klu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import klu.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>
{
	// Custom query to check if an order with a specific id exists
	@Query("select count(O) from Order O where O.id = :id")
	int validateOrderId(@Param("id") Long id);

}
