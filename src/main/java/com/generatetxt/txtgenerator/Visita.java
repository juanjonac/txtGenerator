package com.generatetxt.txtgenerator;

public class Visita {
   public String nroVisita;
   public String fechaComienzo;
   public String nroAfiliado;
   public String dniResponsableVisita;
   public String tipoServicio;
   public Integer codigoTipoServicio;
   public String uglEmpresaPrestadora;
   public String nroDeOp;
  

   public Visita(){}


   @Override
   public String toString() {
      return "Visita [dniResponsableVisita=" + dniResponsableVisita + ", fechaComienzo=" + fechaComienzo
            + ", nroAfiliado=" + nroAfiliado + ", nroVisita=" + nroVisita + ", tipoServicio=" + tipoServicio
            + ", uglEmpresaPrestadora=" + uglEmpresaPrestadora + "]";
   }

   
}
