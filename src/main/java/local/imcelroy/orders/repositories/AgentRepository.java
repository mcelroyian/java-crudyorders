package local.imcelroy.orders.repositories;

import local.imcelroy.orders.models.Agents;
import org.springframework.data.repository.CrudRepository;

public interface AgentRepository extends CrudRepository<Agents, Long> {
}
