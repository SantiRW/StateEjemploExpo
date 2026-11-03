/** Estado: la máquina espera una moneda. */
public class EstadoSinMoneda implements EstadoMaquina {

    private final MaquinaExpendedora maquina;

    public EstadoSinMoneda(MaquinaExpendedora maquina) {
        this.maquina = maquina;
    }

    @Override
    public void insertarMoneda() {
        System.out.println("   Moneda aceptada.");
        maquina.setEstado(maquina.getConMoneda());
    }

    @Override
    public void seleccionarProducto() {
        System.out.println("   Primero debes insertar una moneda.");
    }

    @Override
    public void devolverMoneda() {
        System.out.println("   No hay ninguna moneda para devolver.");
    }

    @Override
    public void rellenar(int cantidad) {
        maquina.setStock(maquina.getStock() + cantidad);
        System.out.println("   Stock actualizado: " + maquina.getStock());
    }
}
