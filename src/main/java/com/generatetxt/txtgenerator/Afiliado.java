package com.generatetxt.txtgenerator;

public class Afiliado {
   public String nroAfiliacion;
   public String dni;
   public String nombreAfiliado;
   public String fechaAfiliacion;
   public String tipoDocumento;
   public String domicilio;
   public String genero;
   public String fechaNacimiento;
   public String nroCalle;
   public String piso;

   @Override
   public String toString() {
      return "Afiliado [dni=" + dni + ", domicilio=" + domicilio + ", fechaAfiliacion=" + fechaAfiliacion
            + ", fechaNacimiento=" + fechaNacimiento + ", genero=" + genero + ", nombreAfiliado=" + nombreAfiliado
            + ", nroAfiliacion=" + nroAfiliacion + ", nroCalle=" + nroCalle + ", piso=" + piso + ", tipoDocumento="
            + tipoDocumento + "]";
   }

   public String getFechaNacimiento() {
      return fechaNacimiento;
   }

   public void setFechaNacimiento(String fechaNacimiento) {
      this.fechaNacimiento = fechaNacimiento;
   }

   
   public String getPiso() {
      return piso;
   }

   public void setPiso(String piso) {
      this.piso = piso;
   }

   public String getNroCalle() {
      return nroCalle;
   }

   public void setNroCalle(String nroCalle) {
      this.nroCalle = nroCalle;
   }

   

   public String getGenero() {
      return genero;
   }

   public void setGenero(String genero) {
      this.genero = genero;
   }

   public String getDomicilio() {
      return domicilio;
   }

   public void setDomicilio(String domicilio) {
      this.domicilio = domicilio;
   }

   public String getTipoDocumento() {
      return tipoDocumento;
   }

   public void setTipoDocumento(String tipoDocumento) {
      this.tipoDocumento = tipoDocumento;
   }

   public Afiliado() {
   }

   public String getNroAfiliacion() {
      return nroAfiliacion;
   }

   public void setNroAfiliacion(String nroAfiliacion) {
      this.nroAfiliacion = nroAfiliacion;
   }

   public String getDni() {
      return dni;
   }

   public void setDni(String dni) {
      this.dni = dni;
   }

   public String getNombreAfiliado() {
      return nombreAfiliado;
   }

   public void setNombreAfiliado(String nombreAfiliado) {
      this.nombreAfiliado = nombreAfiliado;
   }

   public String getFechaAfiliacion() {
      return fechaAfiliacion;
   }

   public void setFechaAfiliacion(String fechaAfiliacion) {
      this.fechaAfiliacion = fechaAfiliacion;
   };
}