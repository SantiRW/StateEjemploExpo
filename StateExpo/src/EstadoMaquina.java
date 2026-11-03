/**
 * Interfaz State: define las acciones que el usuario puede hacer
 * sobre la máquina. Cada estado concreto las implementa a su manera.
 */
public interface EstadoMaquina {
    void insertarMoneda();
    void seleccionarProducto();
    void devolverMoneda();
    void rellenar(int cantidad);
}
