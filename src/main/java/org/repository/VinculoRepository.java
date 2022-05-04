package org.repository;

import javax.enterprise.context.ApplicationScoped;
import org.model.Vinculo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class VinculoRepository implements PanacheRepository<Vinculo> {

 
}