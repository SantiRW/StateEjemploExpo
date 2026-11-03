/** Estado: ya hay una moneda, se puede pedir el café o recuperar la moneda. */
public class EstadoConMoneda implements EstadoMaquina {

    private final MaquinaExpendedora maquina;

    public EstadoConMoneda(MaquinaExpendedora maquina) {
        this.maquina = maquina;
    }

    @Override
    public void insertarMoneda() {
        System.out.println("   Ya hay una moneda insertada.");
    }

    @Override
    public void seleccionarProducto() {
        System.out.println("   Preparando tu café...");
        maquina.entregarCafe();

        // Transición según el stock restante
        if (maquina.getStock() > 0) {
            maquina.setEstado(maquina.getSinMoneda());
        } else {
            System.out.println("   Se acabó el café.");
            maquina.setEstado(maquina.getAgotado());
        }
    }

    @Override
    public void devolverMoneda() {
        System.out.println("   Moneda devuelta.");
        maquina.setEstado(maquina.getSinMoneda());
    }

    @Override
    public void rellenar(int cantidad) {
        maquina.setStock(maquina.getStock() + cantidad);
        System.out.println("   Stock actualizado: " + maquina.getStock());
    }
}
