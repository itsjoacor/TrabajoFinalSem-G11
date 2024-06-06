
public abstract class AplicacionSEM {
	
	protected SistemaDeEstacionamientoMedido sistema;
	
	public AplicacionSEM(SistemaDeEstacionamientoMedido s) {
		sistema = s;
	}
	
	public SistemaDeEstacionamientoMedido getSistema() {
		return sistema;
	}
}
