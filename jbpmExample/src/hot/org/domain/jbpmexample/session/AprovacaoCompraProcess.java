package org.domain.jbpmexample.session;

import java.util.Date;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.bpm.BeginTask;
import org.jboss.seam.annotations.bpm.CreateProcess;
import org.jboss.seam.annotations.bpm.EndTask;

@Name("aprovacaoCompraProcess")
@AutoCreate
public class AprovacaoCompraProcess {

	@In(scope = ScopeType.BUSINESS_PROCESS, required = false)
	@Out(scope = ScopeType.BUSINESS_PROCESS, required = false)
	private Double tamanhoCompra;

	@In(scope = ScopeType.BUSINESS_PROCESS, required = false)
	@Out(scope = ScopeType.BUSINESS_PROCESS, required = false)
	private Date dataInicioProcesso;

	@In(scope = ScopeType.BUSINESS_PROCESS, required = false)
	@Out(scope = ScopeType.BUSINESS_PROCESS, required = false)
	private String requisitante;

	@In(scope = ScopeType.BUSINESS_PROCESS, required = false)
	@Out(scope = ScopeType.BUSINESS_PROCESS, required = false)
	private String status;

	public Double getTamanhoCompra() {
		return tamanhoCompra;
	}

	public void setTamanhoCompra(Double tamanhoCompra) {
		this.tamanhoCompra = tamanhoCompra;
	}

	public Date getDataInicioProcesso() {
		return dataInicioProcesso;
	}

	public String getRequisitante() {
		return requisitante;
	}

	public void setRequisitante(String requisitante) {
		this.requisitante = requisitante;
	}

	@CreateProcess(definition = "AprovarCompra")
	public void iniciarProcesso() {
		if (tamanhoCompra == null) {
			throw new IllegalStateException(
					"Tentativa de iniciar o processo sem definir o tamanho da compra");
		}
		status = "CRIADA";
	}

	public void aprovar() {
		status = "APROVADA";
	}

	public void reprovar() {
		status = "REPROVADA";
	}

	public void cancelar() {
		status = "CANCELADA";
	}
	
	@BeginTask
	@EndTask
	public void comprar(){

	}

	public String getStatus() {
		return status;
	}

}
