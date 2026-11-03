public class Main {

    public static void main(String[] args) {
        MaquinaExpendedora maquina = new MaquinaExpendedora(2);

        System.out.println("=== Máquina de café con patrón State ===\n");

        paso(maquina, "Seleccionar producto sin moneda", maquina::seleccionarProducto);
        paso(maquina, "Insertar moneda", maquina::insertarMoneda);
        paso(maquina, "Insertar otra moneda", maquina::insertarMoneda);
        paso(maquina, "Devolver moneda", maquina::devolverMoneda);
        paso(maquina, "Insertar moneda", maquina::insertarMoneda);
        paso(maquina, "Seleccionar producto", maquina::seleccionarProducto);
        paso(maquina, "Insertar moneda", maquina::insertarMoneda);
        paso(maquina, "Seleccionar producto (último café)", maquina::seleccionarProducto);
        paso(maquina, "Insertar moneda con máquina agotada", maquina::insertarMoneda);
        paso(maquina, "Rellenar con 5 cafés", () -> maquina.rellenar(5));
        paso(maquina, "Insertar moneda", maquina::insertarMoneda);
    }

    private static void paso(MaquinaExpendedora m, String accion, Runnable runnable) {
        System.out.println("-> " + accion);
        runnable.run();
        System.out.println("   [Estado actual: " + m.nombreEstado() + "]\n");
    }
}
