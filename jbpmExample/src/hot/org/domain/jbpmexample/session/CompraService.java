package org.domain.jbpmexample.session;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;

@Name("compraService")
public class CompraService {
    
    @Logger
    private Log log;
    
    @In
    @SuppressWarnings("unused")
    private AprovacaoCompraProcess aprovacaoCompraProcess;

	public void registrarCompra(){
		log.info("Compra registrada para o item com valor #{aprovacaoCompraProcess.tamanhoCompra}");
	}
}
