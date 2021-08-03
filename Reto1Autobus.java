public class Reto1Autobus {
    private String nombreConductor;
    private int nMaximoPasajeros;
    private boolean puertaAbierta;
    private int nPasajeros = 0;
    private double cantidadDinero = 0;
    private double localizacionX = 0;
    private double localizacionY = 0;
    private boolean aireAcondicionadoActivado = false;
    private boolean motorEncendido = false;
    private boolean wifiEncendido = false;
    private boolean enMarcha = false;

    //CONSTRUCTOR
    public Reto1Autobus (String nombreConductor, int nMaximoPasajeros, boolean puertaAbierta ){
        this.nombreConductor = nombreConductor;
        this.nMaximoPasajeros = nMaximoPasajeros;
        this.puertaAbierta = puertaAbierta;
    }

    // METHODS
    public void recogerPasajero (int estrato) {
        int pasaje;
        if ((this.puertaAbierta && (!this.enMarcha)) && (this.nPasajeros <= this.nMaximoPasajeros-1)){
            if (estrato < 3) {
                pasaje = 1500;
            }
            else if (estrato < 5){
                pasaje = 2600;
            }
            else {
                pasaje = 3000;
            }
            this.cantidadDinero += pasaje;
            this.nPasajeros ++;
        }
    }
    public void dejarPasajero (){
        if (this.puertaAbierta && (!this.enMarcha) && (this.nPasajeros) > 0){
            this.nPasajeros--;
        }
    }
    public double calcularDistanciaAcopio (){
        double distancia = Math.pow ((Math.pow(this.localizacionX, 2) + Math.pow(this.localizacionY, 2)), 0.5); 
        return distancia;
    }
    public void gestionarPuerta (){
        if (!this.enMarcha){
            this.puertaAbierta = (this.puertaAbierta == true) ? false:true;
        }
    }
    public void gestionarAireAcondicionado (){
        if (this.motorEncendido){
            this.aireAcondicionadoActivado = (this.aireAcondicionadoActivado == true) ? false:true;
        }
    }
    public void gestionarMotor (){
        this.motorEncendido = (this.motorEncendido == true) ? false:true;
        if (!this.motorEncendido) {
            this.wifiEncendido = false;
            this.aireAcondicionadoActivado = false;
        }
    }
    public void gestionarWifi (){
        if (this.motorEncendido) {
            this.wifiEncendido = (this.wifiEncendido == true) ? false:true;
        }
    }
    public void gestionarMarcha (){
        if (this.motorEncendido && (!this.puertaAbierta)){
            this.enMarcha = (this.enMarcha == true) ? false:true;
        }
    }
    public void moverDerecha (double d){
        if (this.enMarcha) {
            this.localizacionX += d;
        }
    }
    public void moverIzquierda (double d){
        if (this.enMarcha){
            this.localizacionX -= d;
        }
    }
    public void moverArriba (double d){
        if (this.enMarcha) {
            this.localizacionY += d;
        }
    }
    public void moverAbajo (double d){
        if (this.enMarcha) {
            this.localizacionY -= d;
        }
    }

    // GETTERS AND SETTERS
    public int getnPasajeros (){
        return this.nPasajeros;
    }
    public void setnPasajeros (int nPasajeros){
        this.nPasajeros = nPasajeros; 
    } 
    public int getnMaximoPasajeros (){
        return this.nMaximoPasajeros;
    }
    public void setnMaximoPasajeros (int nMaximoPasajeros){
        this.nMaximoPasajeros = nMaximoPasajeros;
    }
    public String getNombreConductor (){
        return this.nombreConductor;
    }
    public void setNombreConductor (String nombreConductor){
        this.nombreConductor = nombreConductor;
    }
    public double getCantidadDinero (){
        return this.cantidadDinero;
    }
    public void setCantidadDinero (double cantidadDinero){
        this.cantidadDinero = cantidadDinero;
    }
    public double getLocalizacionX (){
        return this.localizacionX;
    }
    public void setLocalizacionX (double localizacionX){
        this.localizacionX = localizacionX;
    }
    public double getLocalizacionY (){
        return this.localizacionY;
    }
    public void setLocalizacionY (double localizacionY){
        this.localizacionY = localizacionY;
    }
    public boolean isAireAcondicionadoActivado (){
        return this.aireAcondicionadoActivado;
    }
    public boolean isMotorEncendido(){
        return this.motorEncendido;
    }
    public boolean isWifiEncendido (){
        return this.wifiEncendido;
    }
    public boolean isEnMarcha (){
        return this.enMarcha;
    }
    public boolean isPuertaAbierta (){
        return this.puertaAbierta;
    }
}
