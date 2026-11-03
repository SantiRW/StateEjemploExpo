/** Estado: no queda producto. Solo se puede rellenar. */
public class EstadoAgotado implements EstadoMaquina {

    private final MaquinaExpendedora maquina;

    public EstadoAgotado(MaquinaExpendedora maquina) {
        this.maquina = maquina;
    }

    @Override
    public void insertarMoneda() {
        System.out.println("   Máquina agotada, no se aceptan monedas.");
    }

    @Override
    public void seleccionarProducto() {
        System.out.println("   Máquina agotada.");
    }

    @Override
    public void devolverMoneda() {
        System.out.println("   No hay ninguna moneda para devolver.");
    }

    @Override
    public void rellenar(int cantidad) {
        maquina.setStock(cantidad);
        System.out.println("   Máquina rellenada con " + cantidad + " cafés.");
        maquina.setEstado(maquina.getSinMoneda());
    }
}
