package br.com.dextraining.web.phaseListener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class phaseListenerLog implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent event) {
		System.out.println("Iniciando a fase: " + event.getPhaseId().getName());
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		System.out.println("Finalizando a fase" + event.getPhaseId().getName());
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}
}
