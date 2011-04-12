package org.domain.jbpmexample.session;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.international.StatusMessages;

@Name("aprovarCompraManager")
public class AprovarCompraManager {

	@In
	StatusMessages statusMessages;

	@In
	private AprovacaoCompraProcess aprovacaoCompraProcess;

	public String aprovar() {
		statusMessages.add("Tarefa #{taskInstance.id} aprovada");
		aprovacaoCompraProcess.aprovar();
		return "aprovar";

	}

	public String reprovar() {
		statusMessages.add("Tarefa #{taskInstance.id} reprovada");
		aprovacaoCompraProcess.reprovar();
		return "reprovar";
	}

	public String cancelar() {
		statusMessages.add("Tarefa #{taskInstance.id} cancelada");
		aprovacaoCompraProcess.cancelar();
		return "cancelar";
	}

}
