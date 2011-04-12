package org.domain.jbpmexample.session;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.international.StatusMessages;
import org.jboss.seam.security.Identity;

@Name("solicitacaoPedidoManager")
public class SolicitacaoPedidoManager {

	@In
	private StatusMessages statusMessages;
	
	@In
	private AprovacaoCompraProcess aprovacaoCompraProcess;
	
	@In
	private Identity identity;

	public void solicitarCompra() {
		aprovacaoCompraProcess.setRequisitante(identity.getCredentials().getUsername());
		aprovacaoCompraProcess.iniciarProcesso();
		statusMessages.add("Processo de compra iniciado");
	}

}
