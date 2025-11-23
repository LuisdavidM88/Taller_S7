public class Avenger {
    private String id;
    private String nombre;
    private String mision;
    private int nivelPeligrosidad;
    private float pagoMensual;

    public Avenger(String id, String nombre, String mision, int nivelPeligrosidad, float pagoMensual) {
        this.id = id;
        this.nombre = nombre;
        this.mision = mision;
        this.nivelPeligrosidad = nivelPeligrosidad;
        this.pagoMensual = pagoMensual;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMision() {
        return mision;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public int getNivelPeligrosidad() {
        return nivelPeligrosidad;
    }

    public void setNivelPeligrosidad(int nivelPeligrosidad) {
        this.nivelPeligrosidad = nivelPeligrosidad;
    }

    public float getPagoMensual() {
        return pagoMensual;
    }

    public void setPagoMensual(float pagoMensual) {
        this.pagoMensual = pagoMensual;
    }

    public float calcularAporte(){
        return getPagoMensual() * 0.08f;
    }

    public float calcularImpuesto(){
        float pagoAnual = getPagoMensual() * 12;
        if(pagoAnual <= 50000){
            return 0;
        }else if(pagoAnual <= 100000){
            return (pagoAnual - 50000) * 0.1f;
        }else if(pagoAnual <= 200000){
            return (pagoAnual - 100000) * 0.2f;
        }else{
            return (pagoAnual - 200000) * 0.3f;
        }
    }

    public float pagoNeto(){
        return getPagoMensual() - calcularAporte() - (calcularImpuesto()/12);
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Nombre: " + nombre +
                ", Misión: " + mision +
                ", Nivel de Peligrosidad: " + nivelPeligrosidad +
                ", Pago Mensual: " + pagoMensual + "\n";
    }
}
