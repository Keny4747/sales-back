package com.mitocode.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
@NoRepositoryBean
public interface IGenericRepo<T,ID> extends JpaRepository<T, ID> {
	//cuando se trabaja con genericos se trabaja con la calse padre (object)
	//por lo cual spring necesita crear instancia de la clase object
	//es por ello que debemos indicarle que no lo haga, con la anotación  @NoRepositoryBean para que lo considere simplemente como una clase de configuración
}
