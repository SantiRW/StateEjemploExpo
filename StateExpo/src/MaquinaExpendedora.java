/**
 * Contexto: mantiene una referencia al estado actual y le delega todo el trabajo
 * No tiene ningún if/else que dependa del estado.
 */
public class MaquinaExpendedora {

    private EstadoMaquina estadoActual;
    private int stock;

    // Estados disponibles (se crean una sola vez)
    private final EstadoMaquina sinMoneda;
    private final EstadoMaquina conMoneda;
    private final EstadoMaquina agotado;

    public MaquinaExpendedora(int stockInicial) {
        this.stock = stockInicial;
        this.sinMoneda = new EstadoSinMoneda(this);
        this.conMoneda = new EstadoConMoneda(this);
        this.agotado = new EstadoAgotado(this);

        this.estadoActual = (stockInicial > 0) ? sinMoneda : agotado;
    }

    // ---- Acciones delegadas al estado actual ----
    public void insertarMoneda()        { estadoActual.insertarMoneda(); }
    public void seleccionarProducto()   { estadoActual.seleccionarProducto(); }
    public void devolverMoneda()        { estadoActual.devolverMoneda(); }
    public void rellenar(int cantidad)  { estadoActual.rellenar(cantidad); }

    // ---- Métodos usados por los estados ----
    public void setEstado(EstadoMaquina nuevoEstado) { this.estadoActual = nuevoEstado; }

    public EstadoMaquina getSinMoneda() { return sinMoneda; }
    public EstadoMaquina getConMoneda() { return conMoneda; }
    public EstadoMaquina getAgotado()   { return agotado; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public void entregarCafe() {
        stock--;
        System.out.println("   ☕ ¡Aquí tienes tu café! (quedan " + stock + ")");
    }

    public String nombreEstado() {
        return estadoActual.getClass().getSimpleName();
    }
}
