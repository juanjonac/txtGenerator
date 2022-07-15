package com.generatetxt.txtgenerator;

public class Insumo {
   public String nroBeneficiario;
   public String nroOp;
   public String ts;
   public String codigo;
   public String frecuencia;
   public String ocurrencia;
   @Override
   public String toString() {
      return "Insumo [codigo=" + codigo + ", frecuencia=" + frecuencia + ", nroBeneficiario=" + nroBeneficiario
            + ", nroOp=" + nroOp + ", ocurrencia=" + ocurrencia + ", ts=" + ts + "]";
   }

   

}
