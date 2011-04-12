package org.domain.jbpmexample.session;

import org.jboss.seam.annotations.Name;

@Name("compraService")
public class CompraService {

	public void registrarCompra(){
		System.out.println("REGISTRADO");
	}
}
