package com.generatetxt.txtgenerator;

public class Frecuencia {
   public String idFrecuencia;
   public String nroAfiliado;
   public String nroOp;
   public String tipoServicio;
   public String codTipoServicio;
   public String frecuencia;
   public String ocurrencia;
   public String codigoEstatico;
   @Override
   public String toString() {
      return "Frecuencia [codTipoServicio=" + codTipoServicio + ", frecuencia=" + frecuencia + ", nroAfiliado="
            + nroAfiliado + ", nroOp=" + nroOp + ", ocurrencia=" + ocurrencia + ", tipoServicio=" + tipoServicio + "]";
   }
   
}
