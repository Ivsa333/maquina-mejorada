public class MaquinaExpendedoraMejorada {
    
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    int numeroBilletesVendidos;
    private int maquinaTipo;
    private int maximoBilletes;
    private int numeroPremio;
    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino,int premio1ONormal2, int numeroMaximoBilletes) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        numeroBilletesVendidos = 0;
        maximoBilletes = numeroMaximoBilletes;
        maquinaTipo = premio1ONormal2;
        numeroPremio = 1;
        if (maquinaTipo == 1) {
            maquinaTipo = 1;
        }
        else {
            maquinaTipo = 2;
        }
    }
    
    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int premio1ONormal2, int numeroMaximoBilletes) {
        precioBillete = 20;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = "Le�n";
        estacionDestino= "C�diz";
        numeroBilletesVendidos = 0;
        maximoBilletes = numeroMaximoBilletes;
        maquinaTipo = premio1ONormal2;
        numeroPremio = 1;
        if (maquinaTipo == 1) {
            maquinaTipo = 1;
        }
        else {
            maquinaTipo = 2;
        }
    }
    
    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (maximoBilletes > 0) {
            if (cantidadIntroducida > 0) {
            balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            else {
            System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            }        
        }
        else {
            System.out.println("No quedan billetes que comprar");
        }
    }  
    public int getVaciarDineroDeLaMaquina() {
        int valorADevolver;
        valorADevolver = totalDineroAcumulado + balanceClienteActual;
        if (balanceClienteActual == 0) {
            valorADevolver = totalDineroAcumulado + balanceClienteActual; 
            totalDineroAcumulado = 0;
            balanceClienteActual = 0;    
        }
        
        else {
            valorADevolver = -1;           
        }
        return valorADevolver;
    }

        /**
         * Imprime un billete para el cliente actual
         */
        public void imprimirBillete() {
        int cantidadDeDineroQueFalta= precioBillete - balanceClienteActual;
        int ventaBilletes;
        if (maximoBilletes > 0 ) {
              if (cantidadDeDineroQueFalta <= 0) {        
                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");
                System.out.println();         
    
                  // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                numeroBilletesVendidos = numeroBilletesVendidos + 1;
                maximoBilletes = maximoBilletes - 1;

                if (maquinaTipo == 1) {
                    if (numeroPremio == 3) {
                        System.out.println("Descuento de " +precioBillete * 0.1+ " euros para el Carrefour");
                        numeroPremio = 0;
                    }
                    else {
                        System.out.println("Gracias por su compra");
                    }
                    numeroPremio = numeroPremio + 1;
                }
                else {
                    System.out.println("Gracias por su compra");
                }
                    }
                else {
                System.out.println("Necesitas introducir " + (cantidadDeDineroQueFalta) + " euros m�s!");
                }
        }
        else {
        System.out.println("No quedan billetes disponibles");
        }
    }

    public int getNumeroBilletesVendidos () {
        return numeroBilletesVendidos;
    }
    
    public void imprimirNumeroBilletes() {
        System.out.println(numeroBilletesVendidos + " billetes han sido vendidos");
    }
    
        /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 
}
