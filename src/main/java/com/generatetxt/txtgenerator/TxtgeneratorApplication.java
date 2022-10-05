package com.generatetxt.txtgenerator;

import org.apache.commons.collections4.functors.IfTransformer;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
//import org.springframework.boot.SpringApplication;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ser.std.ClassSerializer;

//import com.sun.mail.util.LineInputStream;

@SpringBootApplication
public class TxtgeneratorApplication {

	public static String basicPath = "C:\\Users\\juanj\\OneDrive\\Documentos\\txtgenerator\\txtgenerator\\txt generated files\\planillas que se necesitan para generar el txt\\";
	public static String CABECERA = "CABECERA";
	public static String RED = "RED";
	public static String PROFESIONAL = "PROFESIONAL";
	public static String PRESTADOR = "PRESTADOR";
	public static String REL_PROFESIONALESXPRESTADOR = "REL_PROFESIONALESXPRESTADOR";
	public static String BOCA_ATENCION = "BOCA_ATENCION";
	public static String REL_MODULOSXPRESTADOR = "REL_MODULOSXPRESTADOR";
	public static String REL_PRESTADORESXRED = "REL_PRESTADORESXRED";
	public static String BENEFICIO = "BENEFICIO";
	public static String AFILIADO = "AFILIADO";
	public static String PRESTACIONES = "PRESTACIONES";
	public static String AMBULATORIO = "AMBULATORIO";
	public static String REL_PRACTICASREALIZADASXAMBULATORIO = "REL_PRACTICASREALIZADASXAMBULATORIO";
	public static String REL_PRACTICASSOLICITADASXAMBULATORIO = "REL_PRACTICASSOLICITADASXAMBULATORIO";
	public static String FIN_AMBULATORIO = "FIN AMBULATORIO";
	//variables que hay que cambiar todos los meses para poder generar *************************************************************************************************
	public static Integer diasDelMes=30;
	public static String primerDiaMes="01/09/2022";
	public static String ultimoDiaMes="30/09/2022";
	public static String fileName = basicPath + "visitas SEPTIEMBRE2022.xlsx";
	public static String selectedUgl="31";//06,10,11,31
	public static String mesAño="09-22";//se debe actualizar por cada mes a generar
	public static String fechaGeneracion="05/10/2022";//se debe actualizar por cada mes a generar
	//variables que hay que cambiar todos los meses para poder generar *************************************************************************************************

	

	

	public static String getCodigoAmbulatorioSegunUgl(String ugl) {
		String toReturn="";
		if(ugl.equals("10")){
			toReturn="137819";
		}else if(ugl.equals("11")){
			toReturn="34292";
		}else if(ugl.equals("31")){
			toReturn="62931";
		}else if(ugl.equals("06")){
			toReturn="35986";
		}
		return toReturn;
	}

	public static String buildCabecera() {
		String toReturn="";
		if(selectedUgl.equals("10")){
			toReturn=buildCabeceraUgl10();
		}else if(selectedUgl.equals("11")){
			toReturn=buildCabeceraUgl11();
		}else if(selectedUgl.equals("31")){
			toReturn=buildCabeceraUgl31();
		}else if(selectedUgl.equals("06")){
			toReturn=buildCabeceraUgl06();
		}
		return toReturn;
	}

	public static String buildCabeceraUgl06() {
		System.out.println("Building cabecera ugl 06");
		String toReturn = CABECERA + "\n";
		toReturn += "30-70896790-0;;"+fechaGeneracion+";"+mesAño+";JUNTOS EN CASA S.R.L.;1;UP30708967900N2;58342\n";
		toReturn+="RED"+"\n";
		toReturn+="30-70896790-0;;;0;JUN;JUNTOS EN CASA S.R.L.;0;Av. Corrientes 2589;0;;;;"+"\n";
		toReturn+="PROFESIONAL"+"\n";
		toReturn+=";;;0;PAGLILLA, JOSE MARIA;1;35986; ;DNI;4406216;20044062160;SIN SUMINISTRAR;0;;;;"+"\n";
		toReturn+="PRESTADOR"+"\n";
		toReturn+=";30-70896790-0;;;0;;;1;;0;info@juntosencasa.com.ar;15/02/2018;;;;0;0;0;JUNTOS EN CASA S.R.L.;Av. Corrientes 2589;0;;;;;"+"\n";
		toReturn+="REL_PROFESIONALESXPRESTADOR"+"\n";
		toReturn+=";30-70896790-0;"+getCodigoAmbulatorioSegunUgl(selectedUgl)+";0;0;"+"\n";
		toReturn+="BOCA_ATENCION"+"\n";
		toReturn+=";30-70896790-0;;0;1;6;Av. Corrientes 2589;0;;17;;"+"\n";
		toReturn+="REL_MODULOSXPRESTADOR"+"\n";
		toReturn+=";30-70896790-0;;0;95;"+"\n";
		toReturn+="REL_PRESTADORESXRED"+"\n";
		toReturn+="30-70896790-0;30-70896790-0;;0;0;"+"\n";
		return toReturn;
	}

	public static String buildCabeceraUgl31() {
		System.out.println("Building cabecera ugl 31");
		String toReturn = CABECERA + "\n";
		toReturn+="30-70896790-0;;10/01/2022;"+mesAño+";JUNTOS EN CASA S.R.L.;1;UP30708967900N1;49507"+"\n";
		toReturn+="RED"+"\n";
		toReturn+="30-70896790-0;;;0;JUN;JUNTOS EN CASA S.R.L.;0;Av. Corrientes 2589;0;;;;"+"\n";
		toReturn+="PROFESIONAL"+"\n";
		toReturn+=";;;0;OYHANARTE BELMONTE, FABIAN JUL;1;62931; ;DNI;21500612;20215006124;SIN SUMINISTRAR;0;;;;"+"\n";
		toReturn+="PRESTADOR"+"\n";
		toReturn+=";30-70896790-0;;;0;;;1;;0;info@juntosencasa.com.ar;16/04/2017;;;;0;0;0;JUNTOS EN CASA S.R.L.;Av. Corrientes 2589;0;;;;;"+"\n";
		toReturn+="REL_PROFESIONALESXPRESTADOR"+"\n";
		toReturn+=";30-70896790-0;"+getCodigoAmbulatorioSegunUgl(selectedUgl)+";0;0;"+"\n";
		toReturn+="BOCA_ATENCION"+"\n";
		toReturn+=";30-70896790-0;;0;1;6;Av. Corrientes 2589;0;;17;;"+"\n";
		toReturn+="REL_MODULOSXPRESTADOR"+"\n";
		toReturn+=";30-70896790-0;;0;95;"+"\n";
		toReturn+="REL_PRESTADORESXRED"+"\n";
		toReturn+="30-70896790-0;30-70896790-0;;0;0;"+"\n";
		return toReturn;
	}

	public static String buildCabeceraUgl11() {
		System.out.println("Building cabecera ugl 11");
		String toReturn = CABECERA + "\n";
		toReturn+="30-70896790-0;;11/01/2022;"+mesAño+";JUNTOS EN CASA S.R.L.;1;UP30708967900N6;61594"+"\n";
		toReturn+="RED"+"\n";
		toReturn+="30-70896790-0;;;0;JUN;JUNTOS EN CASA S.R.L.;0;Av. Corrientes 2589;0;;;;"+"\n";
		toReturn+="PROFESIONAL"+"\n";
		toReturn+=";;;0;CRESPO ENRIQUE LADISLAO;1;34292; ;DNI;5929263;20059292634;SIN SUMINISTRAR;0;;;;"+"\n";
		toReturn+="PRESTADOR"+"\n";
		toReturn+=";30-70896790-0;;;0;;;1;;0;info@juntosencasa.com.ar;15/01/2019;;;;0;0;0;JUNTOS EN CASA S.R.L.;Av. Corrientes 2589;0;;;;;"+"\n";
		toReturn+="REL_PROFESIONALESXPRESTADOR"+"\n";
		toReturn+=";30-70896790-0;"+getCodigoAmbulatorioSegunUgl(selectedUgl)+";0;0;"+"\n";
		toReturn+="BOCA_ATENCION"+"\n";
		toReturn+=";30-70896790-0;;0;1;6;Av. Corrientes 2589;0;;17;;"+"\n";
		toReturn+="REL_MODULOSXPRESTADOR"+"\n";
		toReturn+=";30-70896790-0;;0;95;"+"\n";
		toReturn+="REL_PRESTADORESXRED"+"\n";
		toReturn+="30-70896790-0;30-70896790-0;;0;0;"+"\n";
		return toReturn;
	}

	public static String buildCabeceraUgl10() {
		System.out.println("Building cabecera ugl 10");
		String toReturn = CABECERA + "\n";
		toReturn += "30-70896790-0;;11/01/2022;"+mesAño+";JUNTOS EN CASA S.R.L.;1;UP30708967900;18779\n";
		toReturn += "RED\n";
		toReturn += "30-70896790-0;;;0;JUN;JUNTOS EN CASA S.R.L.;0;Av. Corrientes 2589;0;;;;\n";
		toReturn += "PROFESIONAL\n";
		toReturn += ";;;0;NAVARRO RAUL ESTEBAN;1;137819; ;DNI;30465573;23304655739;SIN SUMINISTRAR;0;;;;\n";
		toReturn += "PRESTADOR\n";
		toReturn += ";30-70896790-0;;;0;;;1;;0;info@juntosencasa.com.ar;01/07/2012;;;;0;0;0;JUNTOS EN CASA S.R.L.;Av. Corrientes 2589;0;;;;;\n";
		toReturn += "REL_PROFESIONALESXPRESTADOR\n";
		toReturn += ";30-70896790-0;"+getCodigoAmbulatorioSegunUgl(selectedUgl)+";0;0;\n";
		toReturn += "BOCA_ATENCION\n";
		toReturn += ";30-70896790-0;;0;1;6;Av. Corrientes 2589;0;;17;;\n";
		toReturn += "REL_MODULOSXPRESTADOR\n";
		toReturn += ";30-70896790-0;;0;95;\n";
		toReturn += "REL_PRESTADORESXRED\n";
		toReturn += "30-70896790-0;30-70896790-0;;0;0;\n";
		return toReturn;
	}

	public static Set<String> buildCodigosEstaticosAEvitar(){
		Set<String> estaticosAEvitar=new HashSet<>();//aca se cargan los codigos estaticos que son invalidos en el txt
		estaticosAEvitar.add("223001");
		estaticosAEvitar.add("219003");
		estaticosAEvitar.add("221003");
		estaticosAEvitar.add("219006");
		estaticosAEvitar.add("221001");
		estaticosAEvitar.add("219002");
		estaticosAEvitar.add("219004");
		estaticosAEvitar.add("220001");
		estaticosAEvitar.add("220003");
		estaticosAEvitar.add("220002");
		estaticosAEvitar.add("221002");
		estaticosAEvitar.add("219001");
		estaticosAEvitar.add("219005");
		estaticosAEvitar.add("219008");
		estaticosAEvitar.add("223004");
		estaticosAEvitar.add("223005");
		estaticosAEvitar.add("223003");
		estaticosAEvitar.add("227002");
		estaticosAEvitar.add("223002");
		estaticosAEvitar.add("227001");
		estaticosAEvitar.add("231001");
		estaticosAEvitar.add("215001");
		estaticosAEvitar.add("215002");
		estaticosAEvitar.add("225001");
		estaticosAEvitar.add("224001");
		estaticosAEvitar.add("215004");
		estaticosAEvitar.add("215006");
		estaticosAEvitar.add("215003");
		estaticosAEvitar.add("231003");
		estaticosAEvitar.add("226001");
		estaticosAEvitar.add("215005");
		estaticosAEvitar.add("216001");
		estaticosAEvitar.add("216002");
		return estaticosAEvitar;
	}

	public static Frecuencia getFrecuencia(String nroAfiliado,String tipoServicio,List<Frecuencia> listFrecuenciasParam,String fechaVisitaParam){
		//System.out.println("get frecuencia***************************************************");
		Frecuencia frecuenciaToReturn = null;
		Set<String> estaticosAEvitar=new HashSet<>();//buildCodigosEstaticosAEvitar(); //comentado y se deja vacio porque voy a controlar los codigos estaticos en otro nivel
		//System.out.println("nroAfiliado: "+ nroAfiliado + " tipo servicio: "+ tipoServicio +" fecha visita: "+ fechaVisitaParam);
		for (int i=0;i<listFrecuenciasParam.size();i++) {
			Frecuencia frecuencia1=listFrecuenciasParam.get(i);
			//System.out.println(frecuencia1.toString());
			if(frecuencia1.tipoServicio.equals(tipoServicio) && frecuencia1.nroAfiliado.equals(nroAfiliado)){//aca se hace el match entre el excel de visitas con el excel de frecuencias donde esta el nro de op 
				Date fechaVisita=StringToDate(fechaVisitaParam);
				
				//System.out.println("coincide la visita con la frecuencia");
				Date frecuenciaFechaVencimiento=StringToDate(frecuencia1.fechaVencimiento);
				Date frecuenciaInicio=StringToDate(frecuencia1.fechaInicio);
				boolean skip=false;
				if (frecuenciaInicio.after(fechaVisita)) {//si la op inicio despues de la fecha de visita actual entonces hay que evitar la op
					skip=true;
				}
				if (!skip) {//evitar procesar ese registro
				if (!fechaVisita.after(frecuenciaFechaVencimiento)  ) {
					//System.out.println("coincide la visita con la frecuencia y la fecha es ok");
					
					if (fechaVisitaParam.equals(primerDiaMes)  ) {//si es el primer dia del mes tengo que evitar poner el codigo estatico que no es compatible en el txt
						//System.out.println("se encontro frecuencia: " + frecuencia1.toString());
						/*if ( !estaticosAEvitar.contains(frecuencia1.codigoEstatico) ) {*/
							frecuenciaToReturn=frecuencia1;
						//}comentado este if porque no evito la op simplemente no pongo el estatico de esa frecuencia
						
					}else{//si no es el primer dia del mes retornar sin problema
						//System.out.println("se encontro frecuencia: " + frecuencia1.toString());
						frecuenciaToReturn=frecuencia1;
					}
					
				break;
				}else{
					//System.out.println("fecha de visita paso la fecha de vencimiento de la op : "+ frecuencia1.fechaVencimiento +" fecha visita: "+ fechaVisitaParam +" op nro: "+ frecuencia1.nroOp);
				}
			}
				
			}
		}
		return frecuenciaToReturn;
	}

	public static Frecuencia getFrecuenciaParaEstaticos(String nroAfiliado,String tipoServicio,List<Frecuencia> listFrecuenciasParam,String fechaVisitaParam,Set<String> codigosEstaticosAEvitar,String opAFiltrar){
		//System.out.println("get frecuencia***************************************************");
		Frecuencia frecuenciaToReturn = null;
		Set<String> estaticosAEvitar=buildCodigosEstaticosAEvitar();//buildCodigosEstaticosAEvitar(); //comentado y se deja vacio porque voy a controlar los codigos estaticos en otro nivel
		//System.out.println("nroAfiliado: "+ nroAfiliado + " tipo servicio: "+ tipoServicio +" fecha visita: "+ fechaVisitaParam);
		for (int i=0;i<listFrecuenciasParam.size();i++) {
			Frecuencia frecuencia1=listFrecuenciasParam.get(i);
			//System.out.println(frecuencia1.toString());
			if(/*frecuencia1.tipoServicio.equals(tipoServicio) && comentado para que se pueda buscar otros tipos tambien*/ frecuencia1.nroAfiliado.equals(nroAfiliado) && frecuencia1.nroOp.equals(opAFiltrar)){//aca se hace el match entre el excel de visitas con el excel de frecuencias donde esta el nro de op aca se agrega opAFiltrar porque quiero que sea el codigo correcto pero de la misma op
				Date fechaVisita=StringToDate(fechaVisitaParam);
				
				//System.out.println("coincide la visita con la frecuencia");
				Date frecuenciaFechaVencimiento=StringToDate(frecuencia1.fechaVencimiento);
				Date frecuenciaInicio=StringToDate(frecuencia1.fechaInicio);
				boolean skip=false;
				if (frecuenciaInicio.after(fechaVisita)) {//si la op inicio despues de la fecha de visita actual entonces hay que evitar la op
					skip=true;
				}
				if (!skip) {//evitar procesar ese registro
				if (!fechaVisita.after(frecuenciaFechaVencimiento)  ) {
					//System.out.println("coincide la visita con la frecuencia y la fecha es ok");
					if (!codigosEstaticosAEvitar.contains(frecuencia1.codigoEstatico)) {//en este caso si no es uno de los codigos estaticos prohibidos por el validador retornamos la frecuencia para que tenga estatico principal
						System.out.println("se cambio frecuencia con exito  codigo : " +frecuencia1.codigoEstatico+" nro op: "+ frecuencia1.nroOp);
						frecuenciaToReturn=frecuencia1;
					}
			}
				
			}
		}
	}
		return frecuenciaToReturn;
	}


	public static List<Frecuencia> getFrecuenciasByNroAfiliadoYTipoServicio(List<Frecuencia> listFrecuencias,String nroAfiliadoParam,String tipoServicioParam,String fechaVisitaParam){
		List<Frecuencia> frecuenciasToReturn = new ArrayList<>();
		Set<String> idsFrecuencias=new HashSet<>();
		for (Frecuencia frecuencia : listFrecuencias) {
			if(frecuencia.nroAfiliado.equals(nroAfiliadoParam) && frecuencia.tipoServicio.equals(tipoServicioParam)){//aca se hace el match entre el excel de visitas con el excel de frecuencias donde esta el nro de op 
				//System.out.println("se encontro la frecuencia con un nro de op y un tipo de servicio");
				if (!idsFrecuencias.contains(frecuencia.idFrecuencia)) {
					Date fechaVisita=StringToDate(fechaVisitaParam);
				Date frecuenciaFechaVencimiento=StringToDate(frecuencia.fechaVencimiento);
				Date frecuenciaFechaInicio=StringToDate(frecuencia.fechaInicio);
				if (!fechaVisita.after(frecuenciaFechaVencimiento) && !frecuenciaFechaInicio.after(fechaVisita)) {//si la fecha de la visita no es mayor a la fecha de vencimiento y si la fecha de visita es mayor a la fecha de inicio
					frecuenciasToReturn.add(frecuencia);
				}
			}
		}
	}
		
		return frecuenciasToReturn;
	}

	public static Frecuencia getFrecuenciaV2(List<Frecuencia> listFrecuencias,String nroAfiliadoParam,String tipoServicioParam,Set<String> idsFrecuenciasParam){
		Frecuencia frecuenciaToReturn = null;
		for (Frecuencia frecuencia : listFrecuencias) {
			if(frecuencia.nroAfiliado.equals(nroAfiliadoParam) && frecuencia.tipoServicio.equals(tipoServicioParam) && !idsFrecuenciasParam.contains(frecuencia.idFrecuencia)){//aca se hace el match entre el excel de visitas con el excel de frecuencias donde esta el nro de op 
				//System.out.println("se encontro la frecuencia con un nro de op y un tipo de servicio");
				frecuenciaToReturn=frecuencia;
				break;
			}
		}
		
		return frecuenciaToReturn;
	}

	public static Frecuencia getFrecuenciaByNroOp(List<Frecuencia> listFrecuencias,String nroOpParam,String tipoServicioParam){
		Frecuencia frecuenciaToReturn = null;
		for (Frecuencia frecuencia : listFrecuencias) {
			if(frecuencia.nroOp.equals(nroOpParam) && frecuencia.tipoServicio.equals(tipoServicioParam)){//aca se hace el match entre el excel de visitas con el excel de frecuencias donde esta el nro de op 
				//System.out.println("se encontro la frecuencia con un nro de op y un tipo de servicio");
				frecuenciaToReturn=frecuencia;
				break;
			}
		}
		
		return frecuenciaToReturn;
	}

	public static List<Visita> getVisitasByFechaYAfiliado(String fechaParam,String nroAfiliadoParam,List<Visita> listaVisitaParam){
		List<Visita> listaVisitaToReturn=new ArrayList<Visita>();
		for (Visita visita : listaVisitaParam) {
			String fechaSinHora=visita.fechaComienzo.split(" ")[0];
			if (fechaSinHora.equals(fechaParam) && visita.nroAfiliado.equals(nroAfiliadoParam)) {//aca filtro todas las visitas de una fecha y un afiliado especificos
				listaVisitaToReturn.add(visita);
			}
		}
		return listaVisitaToReturn;
	}

	public static Integer calcularFrecuenciaMaxima(Frecuencia frecuenciaParam,String frecuencia,Integer ocurrencia,Map<String,Integer> mapCantidadCodigosTxt,String codigoTXT){
		try {
		Integer frecuenciaMaximaToReturn=0;
		Map<String,Integer>codigosFrecuenciasMaximasCasosEspeciales=codigosConFrecuenciasMaximas();
		if (codigosFrecuenciasMaximasCasosEspeciales.get(codigoTXT) !=null && codigoTXT.equals("223101") && codigosFrecuenciasMaximasCasosEspeciales.get(frecuenciaParam.codigoEstatico)!=null) {//si esta el codigo y si la cantidad es > 1 significa que hay 2 op con el mismo codigo por ende hay que retornar la maxima cantidad que se conto , se retorna la maxima cantidad en una sola op
				frecuenciaMaximaToReturn=codigosFrecuenciasMaximasCasosEspeciales.get(frecuenciaParam.codigoEstatico);//codigos especiales para obtener frecuencia exacta
				//System.out.println("return : " + frecuenciaMaximaToReturn +" codigo buscado: "+ codigoTXT+" estatico buscado: "+ frecuenciaParam.codigoEstatico+ " nro op : " +frecuenciaParam.nroOp);
		}else if(codigosFrecuenciasMaximasCasosEspeciales.get(codigoTXT) !=null){
			frecuenciaMaximaToReturn=codigosFrecuenciasMaximasCasosEspeciales.get(codigoTXT);
			//System.out.println("return : " + frecuenciaMaximaToReturn);
		}else{//si no esta el codigo se procede a calcular como siempre

		if(frecuencia.toUpperCase().equals("DIA")){
			frecuenciaMaximaToReturn=ocurrencia;
		}else if(frecuencia.toUpperCase().equals("MES")){
			frecuenciaMaximaToReturn=1;
		}else if(frecuencia.toUpperCase().equals("SEMANA")){
			frecuenciaMaximaToReturn=1;
		}
	}
		return frecuenciaMaximaToReturn;
	} catch (Exception e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
		return 0;
	}
	}

	public static List<Visita> getVisitasByFechaAndNroAfiliado(Set<String> fechasVisita,String nroAfiliado,List<Visita> listaVisitas){
		List<Visita> listaVisitastoReturn=new ArrayList<Visita>();
		for (Visita visita : listaVisitas) {
			String fechaRecortada=visita.fechaComienzo.substring(0,visita.fechaComienzo.length()-2);
			if(visita.nroAfiliado.equals(nroAfiliado) && fechasVisita.contains(fechaRecortada)){
				listaVisitastoReturn.add(visita);
			}
		}
		return listaVisitastoReturn;
	}

	public static List<Visita> groupVisitasByFecha(List<Visita> listaVisitasParam,List<Frecuencia> listaFrecuenciasParam){
		Set<String> fechas=new HashSet<String>();
		List<Visita> visitasToReturn = new ArrayList<Visita>();
		boolean tieneVisitasElPrimerDiaDelMes=false;
		for (Visita visita : listaVisitasParam) {
			String fechaVisitaRecortada=visita.fechaComienzo.split(" ")[0];
			if (fechaVisitaRecortada.equals(primerDiaMes)) {//si tiene visitas el 1 del mes poner en true el flag para no agregar nada
				tieneVisitasElPrimerDiaDelMes=true;
			}
			//System.out.println("fecha de visita cortada: "+ fechaVisitaRecortada);
			if (!fechas.contains(fechaVisitaRecortada)) {//aca lo que hago es agrupar y devolver solo visitas de fechas distintas porque en el txt se agrupa asi en ambulatorio
				//System.out.println("fecha para retornar: "+ fechaVisitaRecortada);
				Frecuencia frecuenciaAux=getFrecuencia(visita.nroAfiliado, visita.tipoServicio, listaFrecuenciasParam, fechaVisitaRecortada);
				if (frecuenciaAux!=null || visita.tipoServicio==null || visita.tipoServicio.equals("primer dia")) {//si tiene primer dia es que es fake y hay que dejarla pasar
					if (visita.tipoServicio==null || visita.tipoServicio.equals("")) {
						visita.tipoServicio="primer dia";
					}
					visitasToReturn.add(visita);
					fechas.add(fechaVisitaRecortada);//se agrega esa fecha para tomarla como unica y devolver solo fechas diferentes
				}
				
			}else{
				//System.out.println("fecha repetida: "+ fechaVisitaRecortada);
			}
		}
		/* comentado porque ya no van las visitas creadas en el primer dia ni los insumos , van directamente el primer dia que se hicieron  */
		if (!tieneVisitasElPrimerDiaDelMes) {//si no tiene visitas el primer dia del mes entonces agregar en la primera posicion
			//System.out.println("no tiene primer visitas el primer dia");
			List<Visita> visitasToReturnAux=new ArrayList<>();
			for (int i = 0; i < visitasToReturn.size(); i++) {
				if(i==0){//en la primera posicion agrego una visita fake sin nada para que despues ambulatorio lo tome y le ponga los estaticos aunque no haya visitas ese primer dia
					Visita visitaFake=new Visita();
					visitaFake.tipoServicio="primer dia";
					visitaFake.fechaComienzo=primerDiaMes;
					visitasToReturnAux.add(visitaFake);//primero se agrega la visita fake 
					visitasToReturnAux.add(visitasToReturn.get(i));//luego se agrega la visita normal
				}else{
					visitasToReturnAux.add(visitasToReturn.get(i));//luego de pasar por el primer lugar se agregan todos los demas de manera normal
				}
			}
			if (visitasToReturnAux!=null && !visitasToReturnAux.isEmpty()) {
				visitasToReturn=visitasToReturnAux;//se agrga la nueva lista con la visita fake en la primera posicion
			}
		}
		
		return visitasToReturn;
	}

	public static Date StringToDate(String fechaString){
		Date date1= new Date();
		try {
			//convertimos la fecha a date para hacer comparaciones
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			
			date1=new SimpleDateFormat("dd/MM/yyyy").parse(fechaString);
			return date1;
		} catch (Exception e) {
			System.out.println("fecha : "+ fechaString);
			//TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
			return date1;
		}
	}

	public static int calcularFrecuenciaEstaticos(Frecuencia frecuencia,String primerDiaMesParam,String fechaVisita){
		int daysToReturn=diasDelMes;
		if (frecuencia==null || frecuencia.fechaInicio==null || frecuencia.fechaInicio.equals("") || primerDiaMesParam==null || primerDiaMesParam.equals("")) {
			daysToReturn=diasDelMes;//por default le ponemos 30 si es que no se encontro fecha de inicio o frecuencia
		}else{
			Date fechaInicioOP=StringToDate(frecuencia.fechaInicio);
			Date primerdiaDelMes=StringToDate(primerDiaMesParam);
			if (fechaInicioOP.after(primerdiaDelMes) || fechaInicioOP== primerdiaDelMes) {//si la op se inicio despues del primer dia del mes
				//en este caso hay que restar el ultimo dia del mes con la fecha de inicio
				Date ultimoDiaMesDate=StringToDate(ultimoDiaMes);
				long days = Math.round((ultimoDiaMesDate.getTime() - fechaInicioOP.getTime()) / (double) 86400000)+1;//se convierte la diferencia en dias //se le suma un dia porque tambien se cuenta el mismo dia de inicio
					//System.out.println("la op se inicio despues del primer dia del mes o la fecha es igual al primer dia del mes: ultimo dia del mes: " + ultimoDiaMes+" fecha de inicio : "+ fechaInicioOP + " dias que se deben poner " + days);
					daysToReturn= (int) days;
			}else{
				
				if (frecuencia.fechaVencimiento ==null || frecuencia.fechaVencimiento.equals("")) {
					daysToReturn= diasDelMes;
				}else{
					Date fechaVencimiento =StringToDate(frecuencia.fechaVencimiento);
					long days = Math.round((fechaVencimiento.getTime() - primerdiaDelMes.getTime()) / (double) 86400000);//se convierte la diferencia en dias
					if (days+1 >= diasDelMes) {
						days=diasDelMes;
					}else{
						days=days+1;//se le agrea un dia porque se cuenta tambien ese dia de inicio
					}
					daysToReturn= (int) days;
					//System.out.println("la visita se realizo antes del primer dia del mes fecha de vencimiento: " + frecuencia.fechaVencimiento +" primer dia del mes: "+ primerDiaMes + " diferencia de dias : "+ days);
				}
			}
		}
		return daysToReturn;
	}

	public static Set<String> codigosEspecialesParaIntercalarOp(){
		Set<String> mySet=new HashSet<>();
		mySet.add("223105");//enfermeria de 8 horas diarias
		mySet.add("223104");//enfermeria de 4 horas diarias
		mySet.add("223101");//sesion de enfermeria
		mySet.add("227011");//cuidador de 8 horas por dia
		mySet.add("227012");//cuidador de 8 horas por dia

		mySet.add("220011");//Fonoaudióloga/o a veces se repite con este codigo y hay que intercalar
		mySet.add("219101");//Kinesióloga/o a veces se repite con este codigo y hay que intercalar
		mySet.add("219102");//Kinesióloga/o a veces se repite con este codigo y hay que intercalar

		//estos ultimos 3 corresponden al 223101 del txt pero los de abajo son sus codigos de submodulo
		mySet.add("223001");
		mySet.add("223002");
		mySet.add("223003");
		return mySet;
	}

	public static Map<String,Integer> codigosConFrecuenciasMaximas(){
		Map<String,Integer> myMap=new HashMap<>();
		myMap.put("223105",3);//enfermeria de 8 horas diarias
		myMap.put("223104",6);//enfermeria de 4 horas diarias
		myMap.put("223101",1);//sesion de enfermeria
		myMap.put("227011",3);//cuidador de 8 horas por dia
		myMap.put("227012",3);//cuidador de 8 horas por dia
		//estos ultimos 3 corresponden al 223101 del txt pero los de abajo son sus codigos de submodulo
		myMap.put("223001",1);
		myMap.put("223002",2);
		myMap.put("223003",3);
		return myMap;
	}

	public static String buildAmbulatorio(List<Visita> listaVisitas,List<Frecuencia> listafrecuenciasParamInAmbulatorio,Set<String> idsFrecuenciasParam) {
		System.out.println("Building ambulatorio");
		String toReturn="";
		Map<String,List<Visita>> mapAfiliadosVisitas=new HashMap<String,List<Visita>>();
		List<Insumo> listaInsumosEstaticos=processInsumosEstaticos();
		for (Visita visita1 : listaVisitas) {
			if(mapAfiliadosVisitas.get(visita1.nroAfiliado)  ==null){//si el afiliado no existe en el map
				mapAfiliadosVisitas.put(visita1.nroAfiliado, new ArrayList<Visita>());//se agrega el afiliado y se crea la lista de visitas para ese afiliado
				mapAfiliadosVisitas.get(visita1.nroAfiliado).add(visita1);//finalmente se agrega la visita a la lista de visitas para ese afiliado
			}else{//si ya existe el afiliado en el map
				mapAfiliadosVisitas.get(visita1.nroAfiliado).add(visita1);//se agrega esa visita a la lista de ese afiliado
			}
			
			
		}
		for (String s : mapAfiliadosVisitas.keySet()) {//recorro primero por afiliado el orden es : se recorre primero un afiliado hasta terminar todas las fechas y asi continuar con el siguiente
			boolean isPrimerDia=true;//para manejar los estaticos aun que no haya visitas
			Integer indiceOp=1;
			for (Visita visita : groupVisitasByFecha(mapAfiliadosVisitas.get(s),listafrecuenciasParamInAmbulatorio)) {//por cada afiliado obtengo la lista de visitas de fechas distintas
				String bloqueAmbulatorio="";
				
			if (isPrimerDia && visita.tipoServicio.equals("primer dia")) {
				//System.out.println("es el primer dia de este beneficiario pero fake");
				visita.nroAfiliado=s;//le cargo el nro de afiliado
				//visita.fechaComienzo=primerDiaMes; // comentado para que pueda tomar tambien los que no empiezan el primer dia del mes
			}
			
			//visita.nroAfiliado y visita.tipoServicio
			String fechaVisitaSinHora=visita.fechaComienzo.split(" ")[0];
			//convierto la fecha de string a date para obtener el nro de semana que es 
			if (fechaVisitaSinHora!=null) {
				try {
					Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(fechaVisitaSinHora);
					Calendar calendario = Calendar.getInstance();
					calendario.setTime(date1);
					//calendario.setFirstDayOfWeek(Calendar.SATURDAY);
					//System.out.println("fecha :" + fechaVisitaSinHora + " corresponde al nro de  semana : "+ calendario.get(Calendar.WEEK_OF_MONTH) + " el dia es : " +calendario.get(Calendar.DAY_OF_WEEK));
				} catch (Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
				
			}
			//convierto la fecha de string a date para obtener el nro de semana que es 
			boolean codigoEstaticoAEvitar=false; 
			boolean tieneVisitas=false; 
			boolean tieneInsumosEstaticos=false; 
			String nroAfiliacionRecortado=visita.nroAfiliado.substring(0,visita.nroAfiliado.length()-2);//le sacamos los ultimos 2 digitos
			nroAfiliacionRecortado=procesarNroAfiliacion(nroAfiliacionRecortado);//tambien se le agrega los 0 adelante que sean necesarios para completar 12 caracteres
			String ultimosNrosRecortados=visita.nroAfiliado.substring(visita.nroAfiliado.length()-2,visita.nroAfiliado.length());
			//el problema aca es que coincide el nro de afiliado con el tipo de servicio entonces en vez de tomar otra op toma la misma porque le coincide ejemplo op 9920935539 /****************************** */
			Frecuencia frecuencia=getFrecuencia(visita.nroAfiliado, visita.tipoServicio, listafrecuenciasParamInAmbulatorio,fechaVisitaSinHora);
			/*comentado ya no van visitas el primer dia si no hay*/
			if (isPrimerDia && visita.tipoServicio.equals("primer dia")) {//aca vuelvo a obtener la frecuencia estatica si es el primer dia y no tiene visitas
				//System.out.println("dia inventado para los estaticos este benef no tiene visitas el 1 benef: "+ visita.nroAfiliado);
				
				frecuencia=getFrecuenciaByNroAfiliadoParaEstaticosQueNoTieneVisitasElPrimerDia(visita.nroAfiliado,listafrecuenciasParamInAmbulatorio,fechaVisitaSinHora,listaInsumosEstaticos);
				if (visita.nroAfiliado.equals("15069308400100")) {
					System.out.println("is primer dia: "+ isPrimerDia+" visita datos: "+ visita.toString());
					if (frecuencia !=null) {
						System.out.println("frecuencia: "+ frecuencia.toString());
					}
				}
				if (frecuencia !=null) {
					//System.out.println("buscar esta frecuencia para control txt: " + frecuencia.nroAfiliado);
				}
			}
			 
			if (frecuencia !=null) {
				String practicasSolicitadas="";
				idsFrecuenciasParam.add(frecuencia.idFrecuencia);//se agrega al set para no tomar mas el las siguientes pasadas del build ambulatorio
				bloqueAmbulatorio += AMBULATORIO + "\n";
				bloqueAmbulatorio+="30-70896790-0;;"+getCodigoAmbulatorioSegunUgl(selectedUgl)+";0;0;0;1;0;"+fechaVisitaSinHora+";;;2;"+frecuencia.nroOp+";;"+nroAfiliacionRecortado+";"+ultimosNrosRecortados+"\n";
				bloqueAmbulatorio+=";;;0;1;I64;1\n";
				bloqueAmbulatorio+=REL_PRACTICASREALIZADASXAMBULATORIO+"\n";
				String insumosEstaticosParaPracticasSolicitadas="";
					Date fechaInicioOp=StringToDate(frecuencia.fechaInicio);
					Date fechaVisitaDate=StringToDate(fechaVisitaSinHora);
					if ((fechaInicioOp.before(fechaVisitaDate) && (fechaVisitaSinHora.equals(primerDiaMes) || isPrimerDia)) || frecuencia.fechaInicio.equals(fechaVisitaSinHora)) {//aca calcular si poner o no los estaticos // si la fecha de inicio es anterior  y es el primer dia del mes entonces poner los estaticos sin problema o si la fecha de inicio es igual a la fecha de la visita poner los estaticos ese dia
						if (frecuencia.nroOp.equals("9921325331")) {
							System.out.println("ver que es : "+ frecuencia.toString());
						}
					Frecuencia frecuenciaEstaticos=frecuencia;
					Set<String> codigosEstaticosAEvitar=buildCodigosEstaticosAEvitar();
					if (codigosEstaticosAEvitar.contains(frecuenciaEstaticos.codigoEstatico)) {
						System.out.println("para cambiar op: "+ frecuenciaEstaticos.nroOp+ " codigo: "+ frecuenciaEstaticos.codigoEstatico);
						//si contiene un codigo especiale buscar otra op para hacer los calculos porque esa no es para estatico
						Frecuencia frecuenciaAux=getFrecuenciaParaEstaticos(visita.nroAfiliado, visita.tipoServicio, listafrecuenciasParamInAmbulatorio,fechaVisitaSinHora,codigosEstaticosAEvitar,frecuencia.nroOp);
						if (frecuenciaAux !=null) {
							frecuenciaEstaticos = frecuenciaAux;
						}
						System.out.println("nueva op: "+ frecuenciaEstaticos.nroOp+ " nuevo codigo: "+ frecuenciaEstaticos.codigoEstatico);
					}
					Integer diasCalculadosParaEstaticos=calcularFrecuenciaEstaticos(frecuenciaEstaticos,primerDiaMes,fechaVisitaSinHora);
					
					if (!codigosEstaticosAEvitar.contains(frecuenciaEstaticos.codigoEstatico)) {//evitamos los codigos estaticos que no son admitidos en el txt
						bloqueAmbulatorio+=";;;0;1;"+frecuenciaEstaticos.codigoEstatico+";"+fechaVisitaSinHora+" 00:00"+";"+diasCalculadosParaEstaticos+";2;"+frecuenciaEstaticos.nroOp+"\n";//linea que se repite siempre tiene un codigo estatico
						practicasSolicitadas+=";;;0;1;"+frecuenciaEstaticos.codigoEstatico+";"+fechaVisitaSinHora+" 00:00"+";"+calcularFrecuenciaEstaticos(frecuenciaEstaticos,primerDiaMes,fechaVisitaSinHora)+";0;1"+"\n";
					}else{
						codigoEstaticoAEvitar=true;
					}
					//aca solo poner los insumos estaticos si es la misma de la fecha de inicio , si la fecha de inicio es menor entonces ponerla pero el dia 01 del mes
					for (Insumo insumo : getInsumosEstaticosByNroBeneficiarioAndNroOp(visita.nroAfiliado, frecuencia.nroOp, listaInsumosEstaticos,listafrecuenciasParamInAmbulatorio,fechaVisitaSinHora)) {//recorro todos los insumos estaticos para ese benef y nro de op
						Integer diasCalculadosParaEstaticosInsumos=calcularFrecuenciaEstaticos(insumo.frecuenciaObjeto,primerDiaMes,fechaVisitaSinHora);
						bloqueAmbulatorio+=";;;0;1;"+insumo.codigo+";"+fechaVisitaSinHora+" 00:00"+";"+diasCalculadosParaEstaticosInsumos+";2;"+insumo.nroOp+"\n";//linea que se repite siempre tiene un insumo estatico
						insumosEstaticosParaPracticasSolicitadas+=";;;0;1;"+insumo.codigo+";"+fechaVisitaSinHora+" 00:00"+";"+diasCalculadosParaEstaticosInsumos+";0;1"+"\n";
						tieneInsumosEstaticos=true;//se pone en false si es que tiene un insumo
					}
					if (insumosEstaticosParaPracticasSolicitadas!="") {
						practicasSolicitadas+=insumosEstaticosParaPracticasSolicitadas;
					}
				}
				//aca arranca la creacion dinamica de REL_PRACTICASREALIZADASXAMBULATORIO
			//tengo que traerme una lista de visitas de la misma fecha y del mismo afiliado y eso ponerlo en un ciclo para ir buscando si existe en la tabla de frecuencias para esa op
			Map<String,Integer> mapTipoServicioCantidad=new HashMap<String,Integer>();//este map es para contar cuantos servicios de cada tipo recibio un afiliado en una fecha determinada
			//REL_PRACTICASREALIZADASXAMBULATORIO
			//bloque para agrupar por tipo de servicio y saber ya cuantos hay de cada uno por dia
			for (Visita visitaFiltrada1 : getVisitasByFechaYAfiliado( fechaVisitaSinHora,visita.nroAfiliado, listaVisitas)) {
				//de alguna forma tengo que agrupar por el tipo de servicio y ponerlo solo en una linea
				if(mapTipoServicioCantidad.get(visitaFiltrada1.tipoServicio)!=null){
					Integer cantidadActual =mapTipoServicioCantidad.get(visitaFiltrada1.tipoServicio)+1;//se aumenta el contador para ese tipo de servicio
					mapTipoServicioCantidad.put(visitaFiltrada1.tipoServicio,cantidadActual);//se setea al map la nueva cantidad
				}else{//si ese tipo de servicio aun no existe
					mapTipoServicioCantidad.put(visitaFiltrada1.tipoServicio, 1);//se setea ya en uno porque por lo menos se econtro 1 vez ese tipo de servicio
				}
			}//cuando termina este for yo ya se cuantos hay de cada servicio
			//bloque para agrupar por tipo de servicio y saber ya cuantos hay de cada uno por dia
			Set<String> codigosUtilizados=new HashSet<>();
			Map<String,Integer> mapTipoServicioCantidadParaCasosEspeciales=new HashMap<String,Integer>();//este map es para contar cuantos servicios de cada tipo recibio un afiliado en una fecha determinada para casos especiales donde hay 2 op activas con el mismo codigo de servicio en ese caso vamos a poner solo un nro de op pero con la cantidad de la suma de los 2
			for (Visita visitaFiltrada : getVisitasByFechaYAfiliado( fechaVisitaSinHora,visita.nroAfiliado, listaVisitas)) {
				//Frecuencia frecuencia2=getFrecuenciaByNroOp(listafrecuenciasParamInAmbulatorio, frecuencia.nroOp, visitaFiltrada.tipoServicio); //comentado por el momento para meter todas las op
				//Frecuencia frecuencia2=getFrecuenciaV2(listafrecuenciasParamInAmbulatorio, visitaFiltrada.nroAfiliado, visitaFiltrada.tipoServicio, idsFrecuencia);
				//aca recorro todas las frecuencias para ver si hay algun codigo que se repite 2 veces y cargarlo por si deba ir
				
				//logica para intercarlar ops cuando tienen el mismo codigo , entonces lo que se hace es en una fecha se pone una y en otra fecha se pone otra op y asi sucesivamente
				Set<String> setCodigosEspecialesParaIntercalarOp= codigosEspecialesParaIntercalarOp();
				//Map<Integer,Frecuencia> mapPosicionesOp=new HashMap<>();
				Map<Integer,Frecuencia> mapPosicionesOp223105=new HashMap<>();//se crea un map para cada tipo de servicio para obtener mejor precision a la hora de intercalar
				Map<Integer,Frecuencia> mapPosicionesOp223104=new HashMap<>();//se crea un map para cada tipo de servicio para obtener mejor precision a la hora de intercalar
				Map<Integer,Frecuencia> mapPosicionesOp223101=new HashMap<>();//se crea un map para cada tipo de servicio para obtener mejor precision a la hora de intercalar
				Map<Integer,Frecuencia> mapPosicionesOp227011=new HashMap<>();//se crea un map para cada tipo de servicio para obtener mejor precision a la hora de intercalar
				Map<Integer,Frecuencia> mapPosicionesOp227012=new HashMap<>();//se crea un map para cada tipo de servicio para obtener mejor precision a la hora de intercalar
				Map<Integer,Frecuencia> mapPosicionesOp219102=new HashMap<>();//se crea un map para cada tipo de servicio para obtener mejor precision a la hora de intercalar
				Map<Integer,Frecuencia> mapPosicionesOp219101=new HashMap<>();//se crea un map para cada tipo de servicio para obtener mejor precision a la hora de intercalar
				Map<Integer,Frecuencia> mapPosicionesOp220011=new HashMap<>();//se crea un map para cada tipo de servicio para obtener mejor precision a la hora de intercalar
				Map<String,Map<Integer,Frecuencia>> listaDeMapsPosicionesOp=new HashMap<>();//se crea una lista de maps para pasar directamente este valor a la funcion de calculo y no pasar cada map
				listaDeMapsPosicionesOp.put("223105",mapPosicionesOp223105);//se le asiga cada map a la lista asi solo se pasa la lista
				listaDeMapsPosicionesOp.put("223104",mapPosicionesOp223104);//se le asiga cada map a la lista asi solo se pasa la lista
				listaDeMapsPosicionesOp.put("223101",mapPosicionesOp223101);//se le asiga cada map a la lista asi solo se pasa la lista
				listaDeMapsPosicionesOp.put("227011",mapPosicionesOp227011);//se le asiga cada map a la lista asi solo se pasa la lista
				listaDeMapsPosicionesOp.put("227012",mapPosicionesOp227012);//se le asiga cada map a la lista asi solo se pasa la lista
				listaDeMapsPosicionesOp.put("219102",mapPosicionesOp219102);//se le asiga cada map a la lista asi solo se pasa la lista
				listaDeMapsPosicionesOp.put("219101",mapPosicionesOp219101);//se le asiga cada map a la lista asi solo se pasa la lista
				listaDeMapsPosicionesOp.put("220011",mapPosicionesOp220011);//se le asiga cada map a la lista asi solo se pasa la lista
				Integer Indice223105=1;
				Integer Indice223104=1;
				Integer Indice223101=1;
				Integer Indice227011=1;
				Integer Indice227012	=1;
				Integer Indice219102=1;
				Integer Indice219101	=1;
				Integer Indice220011	=1;
				//logica para intercarlar ops cuando tienen el mismo codigo , entonces lo que se hace es en una fecha se pone una y en otra fecha se pone otra op y asi sucesivamente	
				for (Frecuencia frecuencia2Aux : getFrecuenciasByNroAfiliadoYTipoServicio(listafrecuenciasParamInAmbulatorio, visitaFiltrada.nroAfiliado, visitaFiltrada.tipoServicio,fechaVisitaSinHora)) {//este for es para cargar la cantidad visitas van por cada codigo
					if (mapTipoServicioCantidadParaCasosEspeciales.get(frecuencia2Aux.codTipoServicio )==null) {
						mapTipoServicioCantidadParaCasosEspeciales.put(frecuencia2Aux.codTipoServicio, 1);
					}else{//si ya existe ese codigo aumentar la cantidad
						Integer valor=mapTipoServicioCantidadParaCasosEspeciales.get(frecuencia2Aux.codTipoServicio )+1;
						mapTipoServicioCantidadParaCasosEspeciales.put(frecuencia2Aux.codTipoServicio, valor);
						//System.out.println("codigo : "+ frecuencia2Aux.codTipoServicio +" se repite : " + valor +" nroOp: "+ frecuencia2Aux.nroOp);
					}
					//logica para intercarlar ops cuando tienen el mismo codigo , entonces lo que se hace es en una fecha se pone una y en otra fecha se pone otra op y asi sucesivamente
					if (setCodigosEspecialesParaIntercalarOp.contains(frecuencia2Aux.codTipoServicio)) {//si contiene significa que es uno de los codigos especiales de enfermero o cuidador
						if (frecuencia2Aux.codTipoServicio.equals("223105")) {
							mapPosicionesOp223105.put(Indice223105, frecuencia2Aux);//se le da un indice a cada op para que cuando vaya recorriendo y veo que es ese codigo le asigne la frecuencia que le corresponde intercalando
							//System.out.println("el indice de la op " +frecuencia2Aux.nroOp+" "+ frecuencia2Aux.codTipoServicio +" es: "+ Indice223105+" en la fecha : "+ fechaVisitaSinHora);
							Indice223105++;
						}else if (frecuencia2Aux.codTipoServicio.equals("223104")) {
							mapPosicionesOp223104.put(Indice223104, frecuencia2Aux);//se le da un indice a cada op para que cuando vaya recorriendo y veo que es ese codigo le asigne la frecuencia que le corresponde intercalando
							//System.out.println("el indice de la op " +frecuencia2Aux.nroOp+" "+ frecuencia2Aux.codTipoServicio +" es: "+ Indice223104+" en la fecha : "+ fechaVisitaSinHora);
							Indice223104++;
						}else if (frecuencia2Aux.codTipoServicio.equals("223101")) {
							mapPosicionesOp223101.put(Indice223101, frecuencia2Aux);//se le da un indice a cada op para que cuando vaya recorriendo y veo que es ese codigo le asigne la frecuencia que le corresponde intercalando
							//System.out.println("el indice de la op " +frecuencia2Aux.nroOp+" "+ frecuencia2Aux.codTipoServicio +" es: "+ Indice223101+" en la fecha : "+ fechaVisitaSinHora);
							Indice223101++;
						}else if (frecuencia2Aux.codTipoServicio.equals("227011")) {
							mapPosicionesOp227011.put(Indice227011, frecuencia2Aux);//se le da un indice a cada op para que cuando vaya recorriendo y veo que es ese codigo le asigne la frecuencia que le corresponde intercalando
							//System.out.println("el indice de la op " +frecuencia2Aux.nroOp+" "+ frecuencia2Aux.codTipoServicio +" es: "+ Indice227011+" en la fecha : "+ fechaVisitaSinHora);
							Indice227011++;
						}else if (frecuencia2Aux.codTipoServicio.equals("227012")) {
							mapPosicionesOp227012.put(Indice227012, frecuencia2Aux);//se le da un indice a cada op para que cuando vaya recorriendo y veo que es ese codigo le asigne la frecuencia que le corresponde intercalando
							//System.out.println("el indice de la op " +frecuencia2Aux.nroOp+" "+ frecuencia2Aux.codTipoServicio +" es: "+ Indice227012+" en la fecha : "+ fechaVisitaSinHora);
							Indice227012++;
						}else if (frecuencia2Aux.codTipoServicio.equals("219102")) {
							mapPosicionesOp219102.put(Indice219102, frecuencia2Aux);//se le da un indice a cada op para que cuando vaya recorriendo y veo que es ese codigo le asigne la frecuencia que le corresponde intercalando
							//System.out.println("el indice de la op " +frecuencia2Aux.nroOp+" "+ frecuencia2Aux.codTipoServicio +" es: "+ Indice227012+" en la fecha : "+ fechaVisitaSinHora);
							Indice219102++;
						}else if (frecuencia2Aux.codTipoServicio.equals("219101")) {
							mapPosicionesOp219101.put(Indice219101, frecuencia2Aux);//se le da un indice a cada op para que cuando vaya recorriendo y veo que es ese codigo le asigne la frecuencia que le corresponde intercalando
							//System.out.println("el indice de la op " +frecuencia2Aux.nroOp+" "+ frecuencia2Aux.codTipoServicio +" es: "+ Indice227012+" en la fecha : "+ fechaVisitaSinHora);
							Indice219101++;
						}else if (frecuencia2Aux.codTipoServicio.equals("220011")) {
							mapPosicionesOp220011.put(Indice220011, frecuencia2Aux);//se le da un indice a cada op para que cuando vaya recorriendo y veo que es ese codigo le asigne la frecuencia que le corresponde intercalando
							//System.out.println("el indice de la op " +frecuencia2Aux.nroOp+" "+ frecuencia2Aux.codTipoServicio +" es: "+ Indice227012+" en la fecha : "+ fechaVisitaSinHora);
							Indice220011++;
						}
					}
					//logica para intercarlar ops cuando tienen el mismo codigo , entonces lo que se hace es en una fecha se pone una y en otra fecha se pone otra op y asi sucesivamente
				}

				for (Frecuencia frecuencia2 : getFrecuenciasByNroAfiliadoYTipoServicio(listafrecuenciasParamInAmbulatorio, visitaFiltrada.nroAfiliado, visitaFiltrada.tipoServicio,fechaVisitaSinHora)) {//aca listo todas las frecuencias que se encuentren de todas las op para esa fecha estoo se puede comentar para volver atras
					if (setCodigosEspecialesParaIntercalarOp.contains(frecuencia2.codTipoServicio)) {
						frecuencia2=calcularFrecuenciaIntercalada(indiceOp,frecuencia2,listaDeMapsPosicionesOp,fechaVisitaSinHora,mapTipoServicioCantidadParaCasosEspeciales.get(frecuencia2.codTipoServicio ));//aqui se decide si tengo que reemplazar la frecuencia actual por otra de igual tipo de servicio y codigo o si dejo la misma
					}
					if (!codigosUtilizados.contains(frecuencia2.codTipoServicio)) {//aca evito que se repita el codigo en el mismo bloque
				if (frecuencia2 !=null && mapTipoServicioCantidad !=null && mapTipoServicioCantidad.get(visitaFiltrada.tipoServicio) !=null ) {//si esto pasa significa que esa visita existe en la lista de frecuencias entonces hay que ponerla en la lista pero cuidando las ocurrencias que no sobre pase el limite
					if (mapTipoServicioCantidad.get(visitaFiltrada.tipoServicio) <= calcularFrecuenciaMaxima(frecuencia2,frecuencia2.frecuencia, Integer.valueOf(frecuencia2.ocurrencia),mapTipoServicioCantidadParaCasosEspeciales,frecuencia2.codTipoServicio) ) {//si la cantidad es menor o igual va la cantidad
						bloqueAmbulatorio+=";;;0;1;"+frecuencia2.codTipoServicio+";"+fechaVisitaSinHora+" 00:00"+";"+mapTipoServicioCantidad.get(visitaFiltrada.tipoServicio)+";2;"+frecuencia2.nroOp +"\n";
					practicasSolicitadas+=";;;0;1;"+frecuencia2.codTipoServicio+";"+fechaVisitaSinHora+" 00:00"+";"+mapTipoServicioCantidad.get(visitaFiltrada.tipoServicio)+";0;1"+"\n";//de paso ya creo las lineas de practicas solicitadas para no hacer otro for
					codigosUtilizados.add(frecuencia2.codTipoServicio);
					tieneVisitas=true;
					}else{
						//System.out.println("sobre paso la cantidad maxima: "+ "Cantidad de visitas es: "+ mapTipoServicioCantidad.get(visitaFiltrada.tipoServicio) +" maximo permitido es: "+calcularFrecuenciaMaxima(frecuencia2.frecuencia, Integer.valueOf(frecuencia2.ocurrencia) ));
						bloqueAmbulatorio+=";;;0;1;"+frecuencia2.codTipoServicio+";"+fechaVisitaSinHora+" 00:00"+";"+calcularFrecuenciaMaxima(frecuencia2,frecuencia2.frecuencia, Integer.valueOf(frecuencia2.ocurrencia),mapTipoServicioCantidadParaCasosEspeciales,frecuencia2.codTipoServicio)+";2;"+frecuencia2.nroOp +"\n";
					practicasSolicitadas+=";;;0;1;"+frecuencia2.codTipoServicio+";"+fechaVisitaSinHora+" 00:00"+";"+calcularFrecuenciaMaxima(frecuencia2,frecuencia2.frecuencia, Integer.valueOf(frecuencia2.ocurrencia),mapTipoServicioCantidadParaCasosEspeciales,frecuencia2.codTipoServicio)+";0;1"+"\n";//de paso ya creo las lineas de practicas solicitadas para no hacer otro for
					codigosUtilizados.add(frecuencia2.codTipoServicio);
					tieneVisitas=true;
					}
					if (fechaVisitaSinHora.equals(primerDiaMes) &&frecuencia2.codTipoServicio.equals("227012") && frecuencia2.nroOp.equals("9920794850")) {
						System.out.println("cantidades "+ "Cantidad de visitas es: "+ mapTipoServicioCantidad.get(visitaFiltrada.tipoServicio) +" maximo permitido es: "+calcularFrecuenciaMaxima(frecuencia2,frecuencia2.frecuencia, Integer.valueOf(frecuencia2.ocurrencia) ,mapTipoServicioCantidadParaCasosEspeciales,frecuencia2.codTipoServicio));
					}
					//listafrecuencias.remove(frecuencia2);//indicar que esa frecuencia ya la tome , ahora tomar otra
					//mapTipoServicioCantidad.remove(visitaFiltrada.tipoServicio);//de aca saco el servicio para ya no usarlo para ese dia , de esa forma va solo uno con el conteo gral
				}else{
					if (frecuencia2 !=null) {
						//System.out.println("sobre paso la cantidad maxima: "+ "Cantidad de visitas es: "+ mapTipoServicioCantidad.get(visitaFiltrada.tipoServicio) +" maximo permitido es: "+calcularFrecuenciaMaxima(frecuencia2.frecuencia, Integer.valueOf(frecuencia2.ocurrencia) ));
					}
				}
			}
			} //comentado del for de frencuencias 2
			
			}
			//REL_PRACTICASREALIZADASXAMBULATORIO
			isPrimerDia=false;//una vez todo procesado ya no es el primer dia de visita
			//REL_PRACTICASSOLICITADASXAMBULATORIO
			bloqueAmbulatorio+=REL_PRACTICASSOLICITADASXAMBULATORIO+"\n";
			bloqueAmbulatorio+=practicasSolicitadas;
			//REL_PRACTICASSOLICITADASXAMBULATORIO
		
			bloqueAmbulatorio+=FIN_AMBULATORIO+"\n";
			if (codigoEstaticoAEvitar && !tieneVisitas && !tieneInsumosEstaticos) {//si esto se cumple entonces hay que evitar este bloque
				System.out.println("si esto se cumple hay que evitar este bloque porque no se puede poner el estatico y tampoco tiene visitas");
				System.out.println(bloqueAmbulatorio);
			}else{
				toReturn+=bloqueAmbulatorio;//si es que no cumple con las condiciones para ignorar el bloque lo cargamos
			}
			}
			indiceOp++;
	}
	}
		return toReturn;
	}

	public static boolean frecuenciaEsValida(Frecuencia frecuenciaAValidaParam,String fechaVisitaSinHoraParam){
		boolean toReturn=false;
		if (frecuenciaAValidaParam!=null ) {
			Date fechaVisita=StringToDate(fechaVisitaSinHoraParam);
				Date frecuenciaFechaVencimiento=StringToDate(frecuenciaAValidaParam.fechaVencimiento);
				Date frecuenciaFechaInicio=StringToDate(frecuenciaAValidaParam.fechaInicio);
				if (!fechaVisita.after(frecuenciaFechaVencimiento) && !frecuenciaFechaInicio.after(fechaVisita)) {//si la fecha de la visita no es mayor a la fecha de vencimiento y si la fecha de visita es mayor a la fecha de inicio
					toReturn=true;//aca se valida la frecuencia segun fecha
				}
		}else{
			toReturn=false;
		}
		return toReturn;
	}

	public static Frecuencia calcularFrecuenciaIntercalada(Integer indiceOpParam,Frecuencia frecuenciaParamASustituir,Map<String,Map<Integer,Frecuencia>> listaDeMapsPosicionesOpParam,
																			String fechaVisitaSinHoraParam,Integer cantidadFrecuenciasConMismoCodigo){
		//System.out.println("calcularFrecuenciaIntercalada");
		Frecuencia frecuenciaToReturn=null;
		Integer aux=indiceOpParam;
		Integer cantidadFrecuenciasConMismoCodigoParaCalcular=2;
		
		
		Map<Integer,Frecuencia> mapAux=null;
		if (frecuenciaParamASustituir.codTipoServicio.equals("223105")) {
			mapAux=listaDeMapsPosicionesOpParam.get("223105");	
		}else if(frecuenciaParamASustituir.codTipoServicio.equals("223104")){
			mapAux=listaDeMapsPosicionesOpParam.get("223104");	
		}else if(frecuenciaParamASustituir.codTipoServicio.equals("223101")){
			mapAux=listaDeMapsPosicionesOpParam.get("223101");	
		}else if(frecuenciaParamASustituir.codTipoServicio.equals("227011")){
			mapAux=listaDeMapsPosicionesOpParam.get("227011");	
		}else if(frecuenciaParamASustituir.codTipoServicio.equals("227012")){
			mapAux=listaDeMapsPosicionesOpParam.get("227012");	
		}else if(frecuenciaParamASustituir.codTipoServicio.equals("219102")){
			mapAux=listaDeMapsPosicionesOpParam.get("219102");	
		}else if(frecuenciaParamASustituir.codTipoServicio.equals("219101")){
			mapAux=listaDeMapsPosicionesOpParam.get("219101");	
		}else if(frecuenciaParamASustituir.codTipoServicio.equals("220011")){
			mapAux=listaDeMapsPosicionesOpParam.get("220011");	
		}
		

		if(mapAux !=null && mapAux.size()>1){
			cantidadFrecuenciasConMismoCodigoParaCalcular=mapAux.size();//esto aplica para intercalar los que tienen 2 o mas
		}
		while (aux >cantidadFrecuenciasConMismoCodigoParaCalcular) {//calculo para llegar al indice de la frecuencia que me interesa intercalar
			aux=aux-cantidadFrecuenciasConMismoCodigoParaCalcular;
		}

		if (mapAux !=null && mapAux.get(aux) !=null && !mapAux.get(aux).nroOp.equals(frecuenciaParamASustituir.nroOp)) {//se comparan las op solo si son diferentes se sustiuye si es la misma no tiene caso
			if (frecuenciaEsValida(mapAux.get(aux),fechaVisitaSinHoraParam)) {//aca se valida si la frecuencia la tengo que traer o no segun fechas
					frecuenciaToReturn=mapAux.get(aux);//aca se devuelve la frecuencia sustituyendo la original por una que es similar y le corresponde al intercalar
				//System.out.println("frecuencia nueva: "+ frecuenciaToReturn.nroOp + " frecuencia original :"+ frecuenciaParamASustituir.nroOp+" en fecha :" +fechaVisitaSinHoraParam +" indice calculado:"+ aux +" indiceOpParam: "+ indiceOpParam);
			}else{
				frecuenciaToReturn=frecuenciaParamASustituir;//frecuencia que se quiso sustiuir no es valida por fechas
			}
		}else{
			frecuenciaToReturn=frecuenciaParamASustituir;//e
		}
		return frecuenciaToReturn;
	}

	private static List<Frecuencia> getFrecuenciasByNroAfiliadoParaInsumosEstaticos(String nroAfiliadoParam,List<Frecuencia> listafrecuencias,String fechaVisitaParam) {
		List<Frecuencia>  frecuenciaToReturn=new ArrayList<Frecuencia>();
		for (Frecuencia frecuencia : listafrecuencias) {
			if (frecuencia.nroAfiliado.equals(nroAfiliadoParam) && frecuencia.tipoServicio.equals("Otros") && frecuenciaEsValida(frecuencia, fechaVisitaParam)) {//si es una frecuencia de ese beneficiario y ademas es valida de fechas
				if (frecuencia.nroOp.equals("9920776208")) {
					System.out.println(frecuencia.toString());
				}
				frecuenciaToReturn.add(frecuencia);
			}
		}
		return frecuenciaToReturn;
	}
	private static Frecuencia getFrecuenciaByNroAfiliadoParaEstaticosQueNoTieneVisitasElPrimerDia(String nroAfiliadoParam,List<Frecuencia> listafrecuencias,String fechaVisitaParam,List<Insumo> insumosParaMatchear) {
		Frecuencia frecuenciaToReturn=null;
		
		for (Frecuencia frecuencia : listafrecuencias) {
			if (frecuencia.nroAfiliado.equals(nroAfiliadoParam)) {//se busca la frecuencia para obtener el codigo estatico y los insumos
				Date FechaInicioOp=StringToDate(frecuencia.fechaInicio);
				Date fechaVisitaDate=StringToDate(fechaVisitaParam);
				Date fechaVencimientoOp=StringToDate(frecuencia.fechaVencimiento);
					if ((FechaInicioOp.before(fechaVisitaDate) && fechaVisitaDate.before(fechaVencimientoOp)) || frecuencia.fechaInicio.equals(fechaVisitaParam) ) {//si la fecha de inicio es anterior a la fecha de la visita y la fecha de visita es anterior a la fecha de vencimiento entonces es op valida
						for (Insumo insumo : insumosParaMatchear) {
							if (insumo.nroBeneficiario.equals(nroAfiliadoParam) && insumo.nroOp.equals(frecuencia.nroOp)) {//si la op que es valida tiene insumos estaticos entonces retornar esa op
								frecuenciaToReturn=frecuencia;
							}
							
						}
						
					}
					
			}
		}
		return frecuenciaToReturn;
	}

	public static String procesarNroAfiliacion(String nroAfiliacionParaProcesar){
		String toReturn="";
		if (nroAfiliacionParaProcesar.length()<12) {
			if (nroAfiliacionParaProcesar.length() ==11) {
				toReturn="0"+nroAfiliacionParaProcesar;
			}else if(nroAfiliacionParaProcesar.length() ==10){
				toReturn="00"+nroAfiliacionParaProcesar;
			}else if(nroAfiliacionParaProcesar.length() ==9){
				toReturn="000"+nroAfiliacionParaProcesar;
			}else if(nroAfiliacionParaProcesar.length() ==8){
				toReturn="0000"+nroAfiliacionParaProcesar;
			}else if(nroAfiliacionParaProcesar.length() ==7){
				toReturn="00000"+nroAfiliacionParaProcesar;
			}
		}else{
			toReturn=nroAfiliacionParaProcesar;
		}
		return toReturn;
	}
	public static String procesarNroAfiliacionParaCorrectUgl(String nroAfiliacionParaProcesar){//esto es para corregir el nro de afiliacion que a veces se pasa mal al excel 
		String toReturn="";
		if (nroAfiliacionParaProcesar.length()<14) {
			if (nroAfiliacionParaProcesar.length() ==13) {
				toReturn="0"+nroAfiliacionParaProcesar;
			}else if(nroAfiliacionParaProcesar.length() ==12){
				toReturn="00"+nroAfiliacionParaProcesar;
			}else if(nroAfiliacionParaProcesar.length() ==11){
				toReturn="000"+nroAfiliacionParaProcesar;
			}else if(nroAfiliacionParaProcesar.length() ==10){
				toReturn="0000"+nroAfiliacionParaProcesar;
			}else if(nroAfiliacionParaProcesar.length() ==9){
				toReturn="00000"+nroAfiliacionParaProcesar;
			}
		}else{
			toReturn=nroAfiliacionParaProcesar;
		}
		return toReturn;
	}

	public static String buildBeneficio(List<Afiliado> listAfiliados) {
		System.out.println("Building beneficio");
		String toReturn = BENEFICIO + "\n";
		for (Afiliado afiliado : listAfiliados) {
			/*
			 * removevos los 2 ultimos caracteres del nro de afiliacion para hacer coincidir
			 * con el formato del txt en beneficio
			 */
			if (afiliado.getNroAfiliacion() != null && afiliado.getNombreAfiliado() != null ) {
				String fechaAfiliacion= afiliado.getFechaAfiliacion();
				if (fechaAfiliacion==null || fechaAfiliacion=="" || fechaAfiliacion=="null") {
					fechaAfiliacion=primerDiaMes;
				}
				
				String nroAfiliadoParaProcesar=afiliado.getNroAfiliacion().substring(0, afiliado.getNroAfiliacion().length() - 2);
				String nroAfiliacionProcesado=procesarNroAfiliacion( nroAfiliadoParaProcesar);
				toReturn += ";;;" + nroAfiliacionProcesado;
				String apellido = afiliado.getNombreAfiliado().split(" ")[0];
				String nombre = afiliado.getNombreAfiliado().split(" ")[1];
				toReturn += ";10;" + apellido + ", " + nombre + ";1;"+fechaAfiliacion +"\n";
				//System.out.println(";;;" + nroAfiliacionProcesado+";10;" + apellido + ", " + nombre + ";1;"+fechaAfiliacion +"\n");
			} else {
				
			}
		}

		return toReturn;
	}

	public static String buildAfiliado(List<Afiliado> listAfiliados) {
		System.out.println("Building afiliado");
		// formato PIZARRO, LUISA TERESA;DNI;3777932;1;1;1;SARMIENTO;265;6;;;66988654;16/07/1938;F;;;015020869111;00;;;;;;;;

		String toReturn = AFILIADO + "\n";
		for (Afiliado afiliado : listAfiliados) {
			
				if(afiliado.getPiso()==null){
					afiliado.setPiso("");
				}
				if(afiliado.getNroCalle()==null){
					afiliado.setNroCalle("0");
				}
				
			if (afiliado.getNroAfiliacion() != null && afiliado.getNombreAfiliado() != null && afiliado.getTipoDocumento()!=null && afiliado.getDni() !=null && afiliado.getDomicilio() !=null) {
			
				String nroAfiliacionCortado=afiliado.getNroAfiliacion().substring(0, afiliado.getNroAfiliacion().length() - 2);
				String ultimosNroCortatos=afiliado.getNroAfiliacion().substring(afiliado.getNroAfiliacion().length() - 2, afiliado.getNroAfiliacion().length());
				String nroAfiliacionProcesado=procesarNroAfiliacion( nroAfiliacionCortado);
				String apellido = afiliado.getNombreAfiliado().split(" ")[0];
				String nombre = afiliado.getNombreAfiliado().split(" ")[1];
				toReturn += apellido + ", " + nombre+";"+afiliado.getTipoDocumento().toUpperCase()+";"+afiliado.getDni()+";1;1;1;"+afiliado.getDomicilio()+";"+afiliado.getNroCalle()+";"+afiliado.getPiso()+";;;";
				toReturn+=";"+afiliado.getFechaNacimiento()+";"+afiliado.getGenero()+";;;"+nroAfiliacionProcesado+";"+ultimosNroCortatos+";;;;;;;;\n";
			} else {
				//System.out.println("nro afiliacion: " + afiliado.getNroAfiliacion() + " nombre afiliado : "+ afiliado.getNombreAfiliado());
			}
		}

		return toReturn;
	}

	public static Map<String, Integer> buildMapTipoServicio() {
		Map<String, Integer> toReturn = new HashMap<String, Integer>();
		toReturn.put("Médica/o", 229101		);
		toReturn.put("Enfermera/o", 223101		);
		toReturn.put("Kinesióloga/o", 219101);
		toReturn.put("Fonoaudióloga/o", 220011);
		toReturn.put("Terapista Ocupacional", 221101);
		toReturn.put("Cuidador/a", 227011);
		// toReturn.put("Cuidador/a", 227102);
		// toReturn.put("Kinesióloga/o", 219102);
		return toReturn;
	}

	public static void processXls(String fileName) {
		try {
			System.out.println("processXls************************************************************");
			// obtaining input bytes from a file
			FileInputStream fis = new FileInputStream(new File(fileName));
			// creating workbook instance that refers to .xls file
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			// creating a Sheet object to retrieve the object
			HSSFSheet sheet = wb.getSheetAt(0);
			// evaluating cell type
			FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
			for (Row row : sheet) { // iteration over row using for each loop
				for (Cell cell : row) { // iteration over cell using for each loop
					switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {
						case NUMERIC: // field that represents numeric cell type
							// getting the value of the cell as a number
							System.out.print(cell.getNumericCellValue() + "\t\t");
							break;
						case STRING: // field that represents string cell type
							// getting the value of the cell as a string
							System.out.print(cell.getStringCellValue() + "\t\t");
							break;
					}
				}
				System.out.println();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static void processVisitas(Integer columnIndex,Visita visita,String value){
			//handle visitas
			if (columnIndex == 0) {
					visita.nroVisita=value;
			}else if(columnIndex == 2){
				visita.fechaComienzo=value;
			}else if(columnIndex == 6){
				visita.nroAfiliado=value;
			}else if(columnIndex==8){
				visita.dniResponsableVisita=value;
			}else if(columnIndex==11){
				Map<String, Integer> mapDescripcionCodigoServicio=buildMapTipoServicio();
				if(mapDescripcionCodigoServicio.get(value)!=null){
					visita.tipoServicio=value;
					visita.codigoTipoServicio=mapDescripcionCodigoServicio.get(value);
				}
				

			}else if(columnIndex==15){
				visita.uglEmpresaPrestadora=value;
			}
			//handle visitas
	}

	public static void processAfiliados(Integer columnIndex,Afiliado afiliado,String value,Set<String> nrosAfiliados ){
		// Handle datos afiliado
		if (columnIndex == 7) {// 7 es nombre
			afiliado.setNombreAfiliado(value);
		} else if (columnIndex == 6) {
			if (!nrosAfiliados.contains(value)) { 
				nrosAfiliados.add(value);
				afiliado.setNroAfiliacion(value);
			}
		}
		// Handle datos afiliado
}

public static Sheet readFileXlsx(String filenameParam){
	try {
		System.out.println("reading file ****************************************************************  "+ filenameParam);
			// obtaining input bytes from a file
			FileInputStream fileToRead = new FileInputStream(new File(filenameParam));
			// creating workbook instance that refers to .xls file
			Workbook workbookToRead = new XSSFWorkbook(fileToRead);
			// creating a Sheet object to retrieve the object
			Sheet sheetToRead = workbookToRead.getSheetAt(0);
			fileToRead.close();
			return sheetToRead;
	} catch (Exception e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
		return null;
	}
	
}

public static void processFrecuencia(Frecuencia frecuencia,String  value,Integer columnIndex){
	if (columnIndex==0) {
		frecuencia.nroAfiliado=value;
	}else if(columnIndex==1){
		frecuencia.nroOp=value;
	}else if(columnIndex==2){
		frecuencia.tipoServicio=value;
	}else if(columnIndex==3){
		frecuencia.codTipoServicio=value;
	}else if(columnIndex==4){
		frecuencia.frecuencia=value;
	}else if(columnIndex==5){
		frecuencia.ocurrencia=value;
	}else if(columnIndex==6){
		frecuencia.codigoEstatico=value;
	}else if(columnIndex==7){
		frecuencia.idFrecuencia=value;//esta es una columna que agregue para tener in id en la frecuencia y no tomarla mas , porque hay mas de 1 frecuencia por nro de op y beneficiario
	}else if(columnIndex==8){
		frecuencia.fechaInicio=value;
	}else if(columnIndex==9){
		frecuencia.fechaVencimiento=value;
	}
}

public static List<Frecuencia> processFrecuenciaAndOp(){
	Sheet sheet =readFileXlsx(basicPath+"Benef_OP_TS_SM.xlsx");
	System.out.println("processFrecuenciaAndOp**********************************");
	List<Integer> columnsToTake=new ArrayList<Integer>();
	columnsToTake.add(0);//nro beneficiario
	columnsToTake.add(1);//nro op
	columnsToTake.add(2);//tipo servicio
	columnsToTake.add(3);//codigo tipo servicio
	columnsToTake.add(4);//frecuencia
	columnsToTake.add(5);//ocurrencia
	columnsToTake.add(6);//codigo estatico
	columnsToTake.add(7);//codigo estatico
	columnsToTake.add(8);//fecha inicio
	columnsToTake.add(9);//fecha vencimiento
	List<Frecuencia> listaFrecuencias=new ArrayList<Frecuencia>();
	Integer rowCounter=0;
	for (Row row : sheet) {// rows
		Frecuencia frecuencia=new Frecuencia();
		for (Cell cell : row) {// columns
			if (columnsToTake.contains(cell.getColumnIndex()) ) {
			switch (cell.getCellType()) {
				case STRING:
				String formatedDataString=cell.getStringCellValue();
				if ((cell.getColumnIndex()==8 || cell.getColumnIndex()==9 ) && rowCounter!=0) {//si es fecha de inicio o vencimiento
					try {
						DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
						Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(formatedDataString);    
						formatedDataString = dateFormat.format(date1); 
					} catch (Exception e) {
						System.out.println(e.getMessage());
						e.printStackTrace();
						System.out.println("row : "+ rowCounter);
					}
				}
					processFrecuencia(frecuencia,formatedDataString,cell.getColumnIndex());
					break;
				case NUMERIC:
					DataFormatter formatter = new DataFormatter(); // creating formatter using the default locale
					String formatedData = formatter.formatCellValue(cell); // Returns the formatted value of a cell	// as a String regardless of the cell// type.
					if (cell.getColumnIndex()==8 || cell.getColumnIndex()==9) {//si es fecha de inicio o vencimiento
						DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
						Date date=cell.getDateCellValue();
						formatedData = dateFormat.format(date); 
					}
					processFrecuencia(frecuencia,formatedData,cell.getColumnIndex());
					break;
				case BOOLEAN:
				System.out.println("boolean : "+ cell.getColumnIndex());
					// txtContent += cell.getBooleanCellValue() + ";";
					break;
				case FORMULA:
				System.out.println("formula  processFrecuenciaAndOp: "+ cell.getCellFormula());
				String value="";
				processFrecuencia(frecuencia,value,cell.getColumnIndex());
					break;
				default:
				//System.out.println("default : "+ cell.getColumnIndex());
				//System.out.println("value:"+ cell.getStringCellValue());
			}
		}
		
		}
		if(rowCounter!=0 ){
			listaFrecuencias.add(frecuencia);
		}
		rowCounter++;
	}
	return listaFrecuencias;
}




public static List<Insumo> getInsumosEstaticosByNroBeneficiarioAndNroOp(String nroBeneficiarioParam,String nroOpParam,List<Insumo> listaInsumos,List<Frecuencia> listafrecuencias,String fechaVisitaParam){
	//System.out.println("in getInsumosEstaticosByNroBeneficiarioAndNroOp");
	List<Insumo> insumosEstaticosToReturn=new ArrayList<>();
	Set<String> serviciosYaCargados=new HashSet<>();
	for (Insumo insumo : listaInsumos) {
		boolean retornarInsumo=false;
		//System.out.println("insumo nro beneficiario: "+ insumo.nroBeneficiario+ " insumo nroOP:"+ insumo.nroOp + " param nro beneficiario: "+ nroBeneficiarioParam+" nro op param:"+ nroOpParam);
		if (insumo.nroBeneficiario.equals(nroBeneficiarioParam) /*&& insumo.nroOp.equals(nroOpParam)*/) {//si encuentro el beneficiario y el op entonces debo retornar el insumo estatico en la lista pero cuidando de no repetir codigos de servicio porque hay duplicados
			List<Frecuencia> frecuenciaParaInsumosEstaticos=getFrecuenciasByNroAfiliadoParaInsumosEstaticos( nroBeneficiarioParam,listafrecuencias, fechaVisitaParam);
			for (Frecuencia FrecuenciaARecorrerInsumosEstaticos : frecuenciaParaInsumosEstaticos) {
				Date FechaInicioOp=StringToDate(FrecuenciaARecorrerInsumosEstaticos.fechaInicio);
				Date fechaVisitaParamDate=StringToDate(fechaVisitaParam);
				if (FrecuenciaARecorrerInsumosEstaticos.nroOp.equals(insumo.nroOp) && (FechaInicioOp.before(fechaVisitaParamDate) || fechaVisitaParam.equals(FrecuenciaARecorrerInsumosEstaticos.fechaInicio))) {//retornar ese insumo
					retornarInsumo=true;
					insumo.frecuenciaObjeto=FrecuenciaARecorrerInsumosEstaticos;
				}
			}
			if (!serviciosYaCargados.contains(insumo.codigo)&& retornarInsumo) {//si su codigo aun no fue cargado entonces si se debe retornar
				//System.out.println("insumo encontrado: "+ insumo.codigo);
				
				insumosEstaticosToReturn.add(insumo);//se agrega el insumo a la lista
				serviciosYaCargados.add(insumo.codigo);//se agrega tambien el codigo al set para ya no tomarlo para este beneficiario y op
			}
		}
	}
	return insumosEstaticosToReturn;
}

public static List<Insumo> processInsumosEstaticos(){
	Sheet sheet =readFileXlsx(basicPath+"insumos estaticos.xlsx");
	System.out.println("reading insumos estaticos**********************************");
	List<Integer> columnsToTake=new ArrayList<Integer>();
	columnsToTake.add(0);//nro beneficiario
	columnsToTake.add(1);//nro op
	columnsToTake.add(2);//tipo servicio
	columnsToTake.add(3);//codigo
	columnsToTake.add(4);//frecuencia
	columnsToTake.add(5);//ocurrencia
	List<Insumo> listaInsumosEstaticos=new ArrayList<Insumo>();
	Integer rowCounter=0;
	for (Row row : sheet) {// rows
		Insumo insumo=new Insumo();
		for (Cell cell : row) {// columns
			if (columnsToTake.contains(cell.getColumnIndex()) ) {
			switch (cell.getCellType()) {
				case STRING:
				//System.out.println("columna : "+ cell.getColumnIndex() + " tiene el valor: "+ cell.getStringCellValue());
				if (cell.getColumnIndex()==0) {
					insumo.nroBeneficiario=cell.getStringCellValue();
				}else	if (cell.getColumnIndex()==1) {
					insumo.nroOp=cell.getStringCellValue();
					}else if(cell.getColumnIndex()==2){//nro documento
						insumo.ts=cell.getStringCellValue();//tipo de servicio descripcion de insumo
					}else if(cell.getColumnIndex()==3){//nro documento
						insumo.codigo=cell.getStringCellValue();//codigo que van en el txt
					}else if(cell.getColumnIndex()==4){//nro documento
						insumo.frecuencia=cell.getStringCellValue();//frecuencia
					}else if(cell.getColumnIndex()==5){//ocurrencia
						insumo.ocurrencia=cell.getStringCellValue();//ocurrencia
					}
					break;
				case NUMERIC:
					DataFormatter formatter = new DataFormatter(); // creating formatter using the default locale
					String formatedData = formatter.formatCellValue(cell); // Returns the formatted value of a cell	// as a String regardless of the cell// type.
					//System.out.println("formated data: " +formatedData);
					if (cell.getColumnIndex()==0) {
						insumo.nroBeneficiario=formatedData;
					}else	if (cell.getColumnIndex()==1) {
						insumo.nroOp=formatedData;
						}else if(cell.getColumnIndex()==2){//nro documento
							insumo.ts=formatedData;//tipo de servicio descripcion de insumo
						}else if(cell.getColumnIndex()==3){//nro documento
							insumo.codigo=formatedData;//codigo que van en el txt
						}else if(cell.getColumnIndex()==4){//nro documento
							insumo.frecuencia=formatedData;//frecuencia
						}else if(cell.getColumnIndex()==5){//ocurrencia
							insumo.ocurrencia=formatedData;//ocurrencia
						}
					break;
				case BOOLEAN:
				System.out.println("boolean : "+ cell.getColumnIndex());
					// txtContent += cell.getBooleanCellValue() + ";";
					break;
				case FORMULA:
				System.out.println("formula matchDatosAfiliados: "+ cell.getColumnIndex());
					// txtContent += cell.getStringCellValue() + ";";
					break;
				default:
				//System.out.println("default : "+ cell.getColumnIndex());
				//System.out.println("value:"+ cell.getStringCellValue());
			}
		}
		
		
	}
	if(rowCounter!=0 ){
		if (insumo !=null && insumo.codigo!=null && insumo.frecuencia!=null && insumo.nroBeneficiario!=null && insumo.nroOp!=null && insumo.ocurrencia!=null && insumo.ts!=null) {//solo se agregan los insumos que se cargaron
			listaInsumosEstaticos.add(insumo);
		}
	}
	rowCounter++;
		}
		
		return listaInsumosEstaticos;
}

public static List<Afiliado> getAfiliadosByUgl(List<Visita> visitas,List<Afiliado> afiliadosParam){
	List<Afiliado> afiliadosToReturn=new ArrayList<>();
	Set<String> nroAfiliados=new HashSet<>();
	for (Visita visita : visitas) {
		for (Afiliado afiliado : afiliadosParam) {
		//por cada visita checkear si ese afiliado debe estar en la lista de afiliados segun ugl
		if (visita.nroAfiliado.equals(afiliado.nroAfiliacion) && !nroAfiliados.contains(afiliado.nroAfiliacion) ) { //si coincide el nro de afiliado de la visita tengo que agregar ese afiliado a la lista , la otra condicion es para evitar repetido			
			afiliadosToReturn.add(afiliado);
			nroAfiliados.add(afiliado.nroAfiliacion);
		}
		}
	}
	
	return afiliadosToReturn;

}


public static List<Afiliado>  matchDatosAfiliados(List<Afiliado> listAfiliadosParam){
	Sheet sheet =readFileXlsx(basicPath+"DATOS PERSONALES_TXT.xlsx");
	System.out.println("reading datos personales**********************************");
	List<Integer> columnsToTake=new ArrayList<Integer>();
	columnsToTake.add(0);//nombre del afiliado
	columnsToTake.add(1);//tipo de documento del afiliado
	columnsToTake.add(2);//documento
	columnsToTake.add(3);//direccion
	columnsToTake.add(4);//telefono
	columnsToTake.add(5);//fecha de nacimiento
	columnsToTake.add(6);//sexo
	columnsToTake.add(7);//nro afiliado
	List<Afiliado> listaAfiliados=new ArrayList<Afiliado>();
	Integer rowCounter=0;
	for (Row row : sheet) {// rows
		Afiliado afiliado=new Afiliado();
		for (Cell cell : row) {// columns
			if (columnsToTake.contains(cell.getColumnIndex()) ) {
			switch (cell.getCellType()) {
				case STRING:
					if (cell.getColumnIndex()==1) {
						afiliado.tipoDocumento=cell.getStringCellValue();
					}else if(cell.getColumnIndex()==2){//nro documento
						afiliado.dni=cell.getStringCellValue();
					}else if(cell.getColumnIndex()==3){//nro documento
						afiliado.domicilio=cell.getStringCellValue().replaceAll(",", "");
					}else if(cell.getColumnIndex()==4){//nro documento
						//afiliado.=cell.getStringCellValue();//telefono pero no lo procesamos
					}else if(cell.getColumnIndex()==5){//fecha nacimiento
						afiliado.fechaNacimiento=cell.getStringCellValue();
					}else if(cell.getColumnIndex()==6){//sexo
						afiliado.genero=cell.getStringCellValue();
					}else if(cell.getColumnIndex()==7){//sexo
						afiliado.nroAfiliacion=cell.getStringCellValue();
					}else if(cell.getColumnIndex()==0){//nombre
						afiliado.nombreAfiliado=cell.getStringCellValue();
					}
					break;
				case NUMERIC:
					DataFormatter formatter = new DataFormatter(); // creating formatter using the default locale
					String formatedData = formatter.formatCellValue(cell); // Returns the formatted value of a cell	// as a String regardless of the cell// type.
					if (cell.getColumnIndex()==1) {
						afiliado.tipoDocumento=formatedData;
					}else if(cell.getColumnIndex()==2){//nro documento
						afiliado.dni=formatedData;
					}else if(cell.getColumnIndex()==3){//nro documento
						afiliado.domicilio=formatedData.replaceAll(",", "");
					}else if(cell.getColumnIndex()==4){//nro documento
						//afiliado.=cell.getStringCellValue();//telefono pero no lo procesamos
					}else if(cell.getColumnIndex()==5){//fecha nacimiento
						DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
						Date date=cell.getDateCellValue();
						String strDate = dateFormat.format(date);  
						//System.out.println("cae en nro : "+ strDate);
						afiliado.fechaNacimiento=strDate;
					}else if(cell.getColumnIndex()==6){//sexo
						afiliado.genero=formatedData;
					}else if(cell.getColumnIndex()==7){//sexo
						afiliado.nroAfiliacion=formatedData;
					}
					break;
				case BOOLEAN:
				System.out.println("boolean : "+ cell.getColumnIndex());
					// txtContent += cell.getBooleanCellValue() + ";";
					break;
				case FORMULA:
				System.out.println("formula matchDatosAfiliados: "+ cell.getColumnIndex());
					// txtContent += cell.getStringCellValue() + ";";
					break;
				default:
				//System.out.println("default : "+ cell.getColumnIndex());
				//System.out.println("value:"+ cell.getStringCellValue());
			}
		}
		
		}
		if(rowCounter!=0 ){
			//System.out.println(afiliado);
			listaAfiliados.add(afiliado);
		}
		rowCounter++;
		if(listaAfiliados !=null && !listaAfiliados.isEmpty()){
			for (Afiliado afiliado2 : listAfiliadosParam) {//recorro todos los afiliados que vienen desde la planilla principal y empiezo a buscar con lo de datos personales para cargarles los datos
				for (Afiliado afiliado3 : listaAfiliados) {
					if (afiliado3.nroAfiliacion.equals(afiliado2.nroAfiliacion)) {
						//System.out.println("coincide por ende actualizar los datos restantes");
						if (afiliado2.nombreAfiliado==null || afiliado2.nombreAfiliado.equals("") || afiliado2.nombreAfiliado.equals("para completar") ) {
							if (afiliado2.nroAfiliacion.equals("15017703940700")) {
								System.out.println("set name: "+ afiliado3.toString());
								System.out.println("set name: "+ afiliado2.toString());
							}
							
							afiliado2.nombreAfiliado=afiliado3.nombreAfiliado;
						}
						afiliado2.tipoDocumento=afiliado3.tipoDocumento;
						afiliado2.dni=afiliado3.dni;
						afiliado2.domicilio=afiliado3.domicilio;
						afiliado2.fechaNacimiento=afiliado3.fechaNacimiento;
						afiliado2.genero=afiliado3.genero;
					}

				}
			}
		}
	}
	return listAfiliadosParam;
}
public static List<Afiliado>  matchFechaAfiliado(List<Afiliado> listAfiliadosParam){
	Sheet sheet =readFileXlsx(basicPath+"PACIENTES JUNTOS (FECHA INGRESO).xlsx");
	System.out.println("reading fecha afiliacion**********************************");
	List<Integer> columnsToTake=new ArrayList<Integer>();
	columnsToTake.add(1);//nro afiliado
	columnsToTake.add(2);//fecha afiliacion
	List<Afiliado> listaAfiliados=new ArrayList<Afiliado>();
	Integer rowCounter=0;
	for (Row row : sheet) {// rows
		Afiliado afiliado=new Afiliado();
		for (Cell cell : row) {// columns
			if (columnsToTake.contains(cell.getColumnIndex()) ) {
			switch (cell.getCellType()) {
				case STRING:
					if (cell.getColumnIndex()==1) {//nro de afiliacion para matchear con la lista general de afiliados
						afiliado.nroAfiliacion=cell.getStringCellValue();
					}else if(cell.getColumnIndex()==2){//fecha afiliacion 
						//System.out.println("es string: " + cell.getStringCellValue());
						afiliado.fechaAfiliacion=cell.getStringCellValue();
					}
					break;
				case NUMERIC:
					DataFormatter formatter = new DataFormatter(); // creating formatter using the default locale
					String formatedData = formatter.formatCellValue(cell); // Returns the formatted value of a cell	// as a String regardless of the cell// type.
					if (cell.getColumnIndex()==1) {//nro de afiliacion para matchear con la lista general de afiliados
						afiliado.nroAfiliacion=formatedData;
					}else if(cell.getColumnIndex()==2){//fecha afiliacion
						DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
						Date date=cell.getDateCellValue();
						String strDate = dateFormat.format(date); 
						afiliado.fechaAfiliacion=strDate;
					}
					break;
				case BOOLEAN:
				System.out.println("boolean : "+ cell.getColumnIndex());
					// txtContent += cell.getBooleanCellValue() + ";";
					break;
				case FORMULA:
				System.out.println("formula matchFechaAfiliado: "+ cell.getColumnIndex());
					// txtContent += cell.getStringCellValue() + ";";
					break;
				default:
				//System.out.println("default : "+ cell.getColumnIndex());
				//System.out.println("value:"+ cell.getStringCellValue());
			}
		}
		
		}
		if(rowCounter!=0 ){
			listaAfiliados.add(afiliado);
		}
		rowCounter++;
		if(listaAfiliados !=null && !listaAfiliados.isEmpty()){
			for (Afiliado afiliado2 : listAfiliadosParam) {//recorro todos los afiliados que vienen desde la planilla principal y empiezo a buscar con lo de datos personales para cargarles los datos
				for (Afiliado afiliado3 : listaAfiliados) {
					if (afiliado2!=null && afiliado2.nroAfiliacion!=null && !afiliado2.nroAfiliacion.equals("")) {
					if (afiliado3.nroAfiliacion.equals(afiliado2.nroAfiliacion) || afiliado3.nroAfiliacion.equals(afiliado2.nroAfiliacion.substring(0,afiliado2.nroAfiliacion.length()-2)) || afiliado3.nroAfiliacion.contains(afiliado2.nroAfiliacion )) {
						//System.out.println("cargando fecha de afiliacion");
						afiliado2.fechaAfiliacion=afiliado3.fechaAfiliacion;
					}
				}
				}
			}
		}
	}
	return listAfiliadosParam;
}

public static  Map<String,String>  readCorrectUgl(String filename){
	Map<String,String> toReturn=new HashMap<>();
	Sheet sheet =readFileXlsx(basicPath+filename);
	System.out.println("reading ugl correcta Benef_UGL.xlsx**********************************");
	List<Integer> columnsToTake=new ArrayList<Integer>();
	columnsToTake.add(0);//nro beneficiario
	columnsToTake.add(1);//ugl correcta
	Integer rowCounter=0;
	for (Row row : sheet) {// rows
		String clave=null;
		String clave2=null;//manejo 2 porque en algunos casos los nros de afiliados contienen 0 adelante en otros casos no es relativo
			String valor=null;
		for (Cell cell : row) {// columns
			
			if (columnsToTake.contains(cell.getColumnIndex()) ) {
			switch (cell.getCellType()) {
				case STRING:
				if (cell.getColumnIndex() ==0) {
					clave=procesarNroAfiliacionParaCorrectUgl(cell.getStringCellValue());
					clave2=cell.getStringCellValue();
				}else if(cell.getColumnIndex() ==1){
					if (cell.getStringCellValue().equals("6") || cell.getStringCellValue().equals("06")) {
						valor ="06";
					}else {
						valor =cell.getStringCellValue();//se setea la ugl
					}
				}
					break;
				case NUMERIC:
					DataFormatter formatter = new DataFormatter(); // creating formatter using the default locale
					String formatedData = formatter.formatCellValue(cell); // Returns the formatted value of a cell	// as a String regardless of the cell// type.
					if (cell.getColumnIndex() ==0) {
						clave=procesarNroAfiliacionParaCorrectUgl(formatedData);//se setea el nro de afiliado
						clave2=formatedData;
					}else if(cell.getColumnIndex() ==1){
						if (formatedData.equals("6") || formatedData.equals("06")) {
							valor ="06";//se setea la ugl
						}else {
							valor =formatedData;//se setea la ugl
						}
					}
					break;
				case BOOLEAN:
				System.out.println("boolean : "+ cell.getColumnIndex());
					// txtContent += cell.getBooleanCellValue() + ";";
					break;
				case FORMULA:
				System.out.println("formula  reading ugl correcta: "+ cell.getCellFormula());
								
					break;
				default:
				//System.out.println("default : "+ cell.getColumnIndex());
				//System.out.println("value:"+ cell.getStringCellValue());
			}
		}
		
		}
		if(rowCounter!=0 ){
			if (clave !=null && valor!=null ) {
				toReturn.put(clave, valor);
			}

			if(clave2!=null && valor!=null){
				toReturn.put(clave2, valor);
			}
		}
		rowCounter++;
	}
	
	return toReturn;
}

public static List<Visita> cleanVisitasByFechaVencimientoOp(List<Visita> visitas , List<Frecuencia> frecuencias){
	System.out.println("cleanVisitasByFechaVencimientoOp*************************************************************");
	List<Visita> toReturn = new ArrayList<>();
	for (Visita visita : visitas) {
		Frecuencia frecuencia=getFrecuencia(visita.nroAfiliado, visita.tipoServicio, frecuencias,"");
		if (frecuencia!=null) {//si encuentro la frecuencia verificar la fecha de vencimiento de la op , si esta vencida no va en la lista
			if (frecuencia.fechaVencimiento==null || frecuencia.fechaVencimiento.equals("")) {
				System.out.println("fecha vencimiento null poniendo ultimo dia mes");
				frecuencia.fechaVencimiento=ultimoDiaMes;//si no trajo valor le seteo por default el primer dia del mes
			}
			if (visita.fechaComienzo !=null) {
				try {
					String FechaSinHora=visita.fechaComienzo.split(" ")[0];
					Date fechaVisita=new SimpleDateFormat("dd/MM/yyyy").parse(FechaSinHora);
					Date fechaVencimientoOp=  new SimpleDateFormat("dd/MM/yyyy").parse(frecuencia.fechaVencimiento);
					if(!fechaVisita.after(fechaVencimientoOp)){//si la  fecha de visita no es mayor que la fecha de vencimiento significa que no vencio
						//System.out.println("visita no vencida  :" +visita.fechaComienzo + " fecha de vencimiento: "+ frecuencia.fechaVencimiento );
						toReturn.add(visita);//se agrega la visita porque no esta vencida
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();;
				}
			}
			//System.out.println("fecha de vencimiento op: "+ frecuencia.fechaVencimiento + " fecha de visita : "+ visita.fechaComienzo + " nro de op : "  + frecuencia.nroOp + " tipo de servicio: "+ frecuencia.nroAfiliado);
		}
	}
	
	return toReturn;
}

public static void processVisitasFakeParaEstaticos(List<Frecuencia> listaFrecuencias,Map<String,String> mapCorrectUgl,List<Visita>listaVisitas,List<Afiliado>listaAfiliados){
	//aca tengo que recorrer las visitas y ver que beneficiarios no aparece que si aparecen en las op para poner los estaticos
	Set<String> afiliadosSinVisitas=new HashSet<>();
	Set<String> afiliadosProcesados=new HashSet<>();
	for (Frecuencia frecuenciasAux : listaFrecuencias) {
		boolean tieneVisitas=false;
		Date fechaInicioOPDate=StringToDate(frecuenciasAux.fechaInicio);
		Date primerDiaDelMesDate=StringToDate(primerDiaMes);
		Date ultimoDiaDelMesDate=StringToDate(ultimoDiaMes);
		String fechaDondePonerVisita=primerDiaMes;
		if(!fechaInicioOPDate.before(primerDiaDelMesDate)){
			if (frecuenciasAux.fechaInicio.equals(primerDiaMes) || frecuenciasAux.fechaInicio.equals(ultimoDiaMes) || (fechaInicioOPDate.after(primerDiaDelMesDate) && fechaInicioOPDate.before(ultimoDiaDelMesDate))) {//aca checkear que la visita a colocar este dentro del mes que estamos procesando
				fechaDondePonerVisita=frecuenciasAux.fechaInicio;
			}
			
		}
		if (frecuenciaEsValida(frecuenciasAux, fechaDondePonerVisita)) {//a veces no pasa esta validacion cuando por ejemplo no hay visitas y la op inicia el 26/08 ejemplo 15069308400100 9921537524
			//System.out.println(frecuenciasAux.nroAfiliado+" op "+ frecuenciasAux.nroOp);
			if (!afiliadosProcesados.contains(frecuenciasAux.nroAfiliado) && mapCorrectUgl.get(frecuenciasAux.nroAfiliado).equals(selectedUgl)) {//si aun no procese ese nro afiliado y ademas es un afiliado de la ugl seleccionada para procesar
			for (Visita visitasAux : listaVisitas) {
				if (visitasAux.nroAfiliado.trim().equals(frecuenciasAux.nroAfiliado.trim())) {
					tieneVisitas=true;
				}
			}
			if (!tieneVisitas) {//aca deberia entrar cuando ya recorrio todas las visitas y ese beneficiario no esta
				if (!afiliadosSinVisitas.contains(frecuenciasAux.nroAfiliado)) {//para cargar solo una vez
					//System.out.println("beneficiario: "+ frecuenciasAux.nroAfiliado+" no tiene visitas");
					afiliadosSinVisitas.add(frecuenciasAux.nroAfiliado);
					//aca tengo que agregar una visita fake para simular que hay y ponga el estatico
					Visita nuevaVisitaFakeParaEstaticos=new Visita();
					nuevaVisitaFakeParaEstaticos.nroAfiliado=frecuenciasAux.nroAfiliado;
					nuevaVisitaFakeParaEstaticos.fechaComienzo=fechaDondePonerVisita+" "+"00:00:00";
					nuevaVisitaFakeParaEstaticos.tipoServicio="primer dia";
					Afiliado afiliadoNuevoACargar=new Afiliado();
					afiliadoNuevoACargar.nroAfiliacion=nuevaVisitaFakeParaEstaticos.nroAfiliado;
					afiliadoNuevoACargar.nombreAfiliado="para completar";
					listaAfiliados.add(afiliadoNuevoACargar);
					listaVisitas.add(nuevaVisitaFakeParaEstaticos);//agregada la visita fake para beneficiarios que no tienen visita alguna esto para los estaticos
				}
				//agregar a una lista los beneficiarios y agregar las visitas pero teniendo en cuenta las ugls tener cuidado con ugls
			}
		}
		afiliadosProcesados.add(frecuenciasAux.nroAfiliado);
	}
	}
	//aca tengo que recorrer las visitas y ver que beneficiarios no aparece que si aparecen en las op para poner los estaticos
}

	public static void processXlsx(String fileName) {
		try {
			System.out.println("processXlsx****************************************************************");
			// obtaining input bytes from a file
			FileInputStream file2 = new FileInputStream(new File(fileName));
			// creating workbook instance that refers to .xls file
			Workbook workbook2 = new XSSFWorkbook(file2);
			// creating a Sheet object to retrieve the object
			Sheet sheet2 = workbook2.getSheetAt(0);
			Map<Integer, List<String>> data = new HashMap<>();
			int i = 0;
			// File fileToGenerate = new File(basicPath + "txtGenerated.txt");
			List<Integer> columnsToTake = new ArrayList<Integer>();
			columnsToTake.add(0);//nro de visita
			columnsToTake.add(2);//fecha comienzo
			columnsToTake.add(6);//nro afiliacion
			columnsToTake.add(7);//nombre persona afiliada
			columnsToTake.add(8);//dni responsable visita
			columnsToTake.add(11);//tipo servicio
			columnsToTake.add(12);//email responsable visita
			columnsToTake.add(15);//ugl empresa prestadora
			String txtContent = buildCabecera();
			Map<String,String> mapCorrectUgl=readCorrectUgl("Benef_UGL.xlsx");//para las ugl correctas para los afiliados
			List<Afiliado> listaAfiliados = new ArrayList<Afiliado>();
			List<Visita> listaVisitas = new ArrayList<Visita>();
			Set<String> nrosAfiliados = new HashSet<String>();
			// columns that we need to process 0,2,6,7,8,11,12
			for (Row row2 : sheet2) {// rows
				Afiliado afiliado = new Afiliado();
				Visita visita=new Visita();
				data.put(i, new ArrayList<String>());
				// System.out.println("new row******************");
				Integer columnCounter = 0;
				for (Cell cell : row2) {// columns
					if (columnsToTake.contains(columnCounter) && i != 0) {// i!=0 we dont take the first row titles
						switch (cell.getCellType()) {
							case STRING:
							//process visitas
								processVisitas(cell.getColumnIndex(), visita, cell.getStringCellValue());
							//process visitas
							//process afiliados
							
							processAfiliados(cell.getColumnIndex(), afiliado, cell.getStringCellValue(), nrosAfiliados);
							//process afiliados
								break;
							case NUMERIC:
								DataFormatter formatter = new DataFormatter(); // creating formatter using the default locale
								String formatedData = formatter.formatCellValue(cell); // Returns the formatted value of a cell
																											// as a String regardless of the cell
																											// type.
								//process visitas
								processVisitas(cell.getColumnIndex(), visita, formatedData);
								//process visitas																			
								//process afiliados
								
								processAfiliados(cell.getColumnIndex(), afiliado, formatedData, nrosAfiliados);
								//process afiliados
								break;
							case BOOLEAN:
							System.out.println("boolean : "+ cell.getColumnIndex());
								// txtContent += cell.getBooleanCellValue() + ";";
								break;
							case FORMULA:
							System.out.println("formula processXlsx : "+ cell.getColumnIndex());
								// txtContent += cell.getStringCellValue() + ";";
								break;
							default:
							//System.out.println("default : "+ cell.getColumnIndex());
							//System.out.println("value:"+ cell.getStringCellValue());
								data.get(new Integer(i)).add(" ");
						}
					}
					columnCounter++;
				}
				if (i != 0) {
					//antes de cargar las visitas por ugl le asigno la ugl que le corresponde
					if (mapCorrectUgl.get(visita.nroAfiliado) !=null) {
						String uglCorrecta=mapCorrectUgl.get(visita.nroAfiliado);
						//System.out.println("poniendo ugl correcta actual:"+ visita.uglEmpresaPrestadora+ " la que corresponde: "+ uglCorrecta );
						if (!uglCorrecta.equals(visita.uglEmpresaPrestadora)) {
							//System.out.println("ugl distinta encontrada:"+ visita.uglEmpresaPrestadora+ " la que corresponde: "+ uglCorrecta +" afiliado: "  +visita.nroAfiliado);
							visita.uglEmpresaPrestadora=uglCorrecta;//si la ugl es distinta se impone la de la planilla de ugl
						}
					}else{//si no existe en el map quiere decir que no esta en la planilla y que no esta en la bd con lo cual se descarta
						//System.out.println("no existe en la tabla de ugls : "+ visita.nroAfiliado);
						visita.uglEmpresaPrestadora="00";//agregando esto se descarta y no se carga al bloque de ambulatorio
					}
					if(visita.uglEmpresaPrestadora.equals(selectedUgl)  /*&& visita.nroAfiliado.equals("15022477800800")*/){//06,10,11,31 ugl para generar distintos txt
						listaVisitas.add(visita);
					}
					if (afiliado.nroAfiliacion!=null) {
						listaAfiliados.add(afiliado);
					}
					
					
				}
				i++;
			}
			file2.close();//cerramos el archivo para leer otro

			
			// System.out.println(txtContent);
			
			if (listaVisitas!=null && !listaVisitas.isEmpty()) {
				
				List<Frecuencia> listaFrecuencias=processFrecuenciaAndOp();
				if (listaFrecuencias !=null && !listaFrecuencias.isEmpty()) {
					//aca tengo que hacer un clean de visitas vencidas para eso recorrer cada visita y cada op para asi obtener sus vencimientos
					//listaVisitas=cleanVisitasByFechaVencimientoOp(listaVisitas,listaFrecuencias); comentado porque el clean no es correcto a veces podemos tener visitas de otra op y esa ya no la vamos a poner para agosto si ira el clean para julio se quita

					//aca tengo que hacer un clean de visitas vencidas para eso recorrer cada visita y cada op para asi obtener sus vencimientos
					
					Set<String> idsFrecuencias=new HashSet<>();//este es un set para almacenar el id de las frecuencias ya asi a partir de la segunda pasada de visitas ya no tomo las de la primera
					processVisitasFakeParaEstaticos(listaFrecuencias, mapCorrectUgl,listaVisitas,listaAfiliados);
					if (listaAfiliados != null && !listaAfiliados.isEmpty()) {
						listaAfiliados=matchDatosAfiliados(listaAfiliados);//aca se buscan los datos personales restantes que estan en otro excel
						listaAfiliados=matchFechaAfiliado(listaAfiliados);//aca se buscala fecha de afiliacion de otro excel
					}
					//movi este bloque porque quiero que tambien aparezcan los beneficiarios con visitas fake
					//filtrar solo los afiliados de esa ugl
				System.out.println("cantidad de afiliados antes: " +listaAfiliados.size());
				listaAfiliados=getAfiliadosByUgl(listaVisitas, listaAfiliados);
				System.out.println("cantidad de afiliados despues: " +listaAfiliados.size());
				//filtrar solo los afiliados de esa ugl
				txtContent += buildBeneficio(listaAfiliados);
				txtContent+= buildAfiliado(listaAfiliados);
				//movi este bloque porque quiero que tambien aparezcan los beneficiarios con visitas fake
				txtContent+=PRESTACIONES+"\n";
					txtContent+=buildAmbulatorio(listaVisitas,listaFrecuencias,idsFrecuencias);
					/*comentado esto porque da error al tratar de volver a recorrer el 
					System.out.println("ids frecuencias size despues del primer ambulatorio: "+ idsFrecuencias.size());
					listaFrecuencias=cleanListaFrecuencias(listaFrecuencias,idsFrecuencias);
					txtContent+=buildAmbulatorio(listaVisitas,listaFrecuencias,idsFrecuencias);
					System.out.println("ids frecuencias size despues del segundo ambulatorio: "+ idsFrecuencias.size());
					 */
				}
			}
			
			FileOutputStream fos = new FileOutputStream(basicPath + "txtGenerated.txt", true); // true for append mode
			System.out.print("Enter file content: ");
			byte[] b = txtContent.getBytes(); // converts string into bytes
			fos.write(b); // writes bytes into file
			fos.close(); // close the file
			System.out.println("file saved.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	private static List<Frecuencia> cleanListaFrecuencias(List<Frecuencia> listaFrecuencias,Set<String> idsFrecuencias) {
		List<Frecuencia> frecuenciasToReturn=new ArrayList<>();
		for (Frecuencia frecuencia : listaFrecuencias) {
			if (!idsFrecuencias.contains(frecuencia.idFrecuencia)) {//si el set de frecuencias ya tomadas no contiene la frecuencia quiere decir que no se tomo aun y debe cargarse para ser tomada en el futuro
				frecuenciasToReturn.add(frecuencia);
			}
		}
		return frecuenciasToReturn;
	}

	public static void main(String[] args) throws IOException {

		// SpringApplication.run(TxtgeneratorApplication.class, args);
		System.out.println("starting txt generator********************* ");

		if (fileName.contains("xlsx")) {
			processXlsx(fileName);
		} else if (fileName.contains("xls")) {
			processXls(fileName);
		}

	}
}
