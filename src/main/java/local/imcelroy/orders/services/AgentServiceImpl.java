package local.imcelroy.orders.services;

import local.imcelroy.orders.models.Agents;
import local.imcelroy.orders.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service(value = "agentService")
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgentRepository agentrepo;

    @Override
    public Agents findAgentByID(long id) {
        return agentrepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agent " + id + " Not Found"));
    }
}
