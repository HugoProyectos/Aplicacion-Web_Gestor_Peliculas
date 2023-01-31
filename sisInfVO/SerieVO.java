package es.unizar.sisinf.grp1.model;
/**
 * tabla Series
 * @author sisinf
 *
 */
public class SerieVO {
private String Obra_id;
private int Inicio;
private int Final;

/**
 * Constructor
 * @param Obra_id
 * @param Inicio
 * @param Final
 */
public SerieVO(String Obra_id, int Inicio, int Final) {
 this.Obra_id = Obra_id;
 this.Inicio = Inicio;
 this.Final = Final;
}

public String getObra_id() {
 return Obra_id;
}
public void setObra_id(String Obra_id) {
 this.Obra_id = Obra_id;
}

public int getInicio() {
 return Inicio;
}
public void setInicio(int Inicio) {
 this.Inicio = Inicio;
}

public int getFinal() {
 return Final;
}
public void setFinal(int Final) {
 this.Final = Final;
}
}
