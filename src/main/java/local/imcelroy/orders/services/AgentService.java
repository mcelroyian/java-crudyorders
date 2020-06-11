package local.imcelroy.orders.services;

import local.imcelroy.orders.models.Agents;

public interface AgentService {

    Agents findAgentByID(long id);
}
