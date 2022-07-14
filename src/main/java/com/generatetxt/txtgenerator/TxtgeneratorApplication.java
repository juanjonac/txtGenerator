package com.generatetxt.txtgenerator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.sun.mail.util.LineInputStream;

@SpringBootApplication
public class TxtgeneratorApplication {

	public static String basicPath = "C:\\Users\\juanj\\Downloads\\";
	public static String fileName = basicPath + "visitas JUNIO2022.xlsx";
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

	public static String buildCabecera() {
		String toReturn = CABECERA + "\n";
		toReturn += "30-70896790-0;;11/01/2022;12-21;JUNTOS EN CASA S.R.L.;1;UP30708967900;18779\n";
		toReturn += "RED\n";
		toReturn += "30-70896790-0;;;0;JUN;JUNTOS EN CASA S.R.L.;0;Av. Corrientes 2589;0;;;;\n";
		toReturn += "PROFESIONAL\n";
		toReturn += ";;;0;NAVARRO RAUL ESTEBAN;1;137819; ;DNI;30465573;23304655739;SIN SUMINISTRAR;0;;;;\n";
		toReturn += "PRESTADOR\n";
		toReturn += ";30-70896790-0;;;0;;;1;;0;info@juntosencasa.com.ar;01/07/2012;;;;0;0;0;JUNTOS EN CASA S.R.L.;Av. Corrientes 2589;0;;;;;\n";
		toReturn += "REL_PROFESIONALESXPRESTADOR\n";
		toReturn += ";30-70896790-0;137819;0;0;\n";
		toReturn += "BOCA_ATENCION\n";
		toReturn += ";30-70896790-0;;0;1;6;Av. Corrientes 2589;0;;17;;\n";
		toReturn += "REL_MODULOSXPRESTADOR\n";
		toReturn += ";30-70896790-0;;0;95;\n";
		toReturn += "REL_PRESTADORESXRED\n";
		toReturn += "30-70896790-0;30-70896790-0;;0;0;\n";
		return toReturn;
	}

	public static Frecuencia getFrecuencia(String nroAfiliado,String tipoServicio,List<Frecuencia> listFrecuencias){
		Frecuencia frecuenciaToReturn = null;
		for (Frecuencia frecuencia : listFrecuencias) {
			if(frecuencia.tipoServicio.equals(tipoServicio) && frecuencia.nroAfiliado.equals(nroAfiliado)){//aca se hace el match entre el excel de visitas con el excel de frecuencias donde esta el nro de op 
				//System.out.println("coincide la visita con la frecuencia");
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
				System.out.println("se encontro la frecuencia con un nro de op y un tipo de servicio");
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

	public static String buildAmbulatorio(List<Visita> listaVisitas,List<Frecuencia> listafrecuencias) {
		String toReturn="";
		Map<String,List<Visita>> mapAfiliadosVisitas=new HashMap<String,List<Visita>>();
		for (Visita visita1 : listaVisitas) {
			if(mapAfiliadosVisitas.get(visita1.nroAfiliado)  ==null){//si el afiliado no existe en el map
				mapAfiliadosVisitas.put(visita1.nroAfiliado, new ArrayList<Visita>());//se agrega el afiliado y se crea la lista de visitas para ese afiliado
				mapAfiliadosVisitas.get(visita1.nroAfiliado).add(visita1);//finalmente se agrega la visita a la lista de visitas para ese afiliado
			}else{//si ya existe el afiliado en el map
				mapAfiliadosVisitas.get(visita1.nroAfiliado).add(visita1);//se agrega esa visita a la lista de ese afiliado
			}
			
		}
		for (String s : mapAfiliadosVisitas.keySet()) {//recorro primero por afiliado el orden es : se recorre primero un afiliado hasta terminar todas las fechas y asi continuar con el siguiente
			for (Visita visita : mapAfiliadosVisitas.get(s)) {//por cada afiliado obtengo la lista de visitas
			toReturn += AMBULATORIO + "\n";
			//visita.nroAfiliado y visita.tipoServicio
			//
			String fechaVisitaSinHora=visita.fechaComienzo.split(" ")[0];
			String nroAfiliacionRecortado=visita.nroAfiliado.substring(0,visita.nroAfiliado.length()-2);//le sacamos los ultimos 2 digitos
			Frecuencia frecuencia=getFrecuencia(visita.nroAfiliado, visita.tipoServicio, listafrecuencias);
			if (frecuencia !=null) {
			toReturn+="30-70896790-0;;137819;0;0;0;1;0;"+fechaVisitaSinHora+";;;2;"+frecuencia.nroOp+";;"+nroAfiliacionRecortado+";00"+"\n";
			toReturn+=";;;0;1;I64;1\n";
			toReturn+=REL_PRACTICASREALIZADASXAMBULATORIO+"\n";
			toReturn+="linea que se se repite siempre solo cambia el codigo segun op"+";;;0;1;212001(solo este cambia);"+fechaVisitaSinHora+" 00:00"+";2;"+frecuencia.nroOp+"\n";
			//aca arranca la creacion dinamica de REL_PRACTICASREALIZADASXAMBULATORIO
			//tengo que traerme una lista de visitas de la misma fecha y del mismo afiliado y eso ponerlo en un ciclo para ir buscando si existe en la tabla de frecuencias para esa op
				for (Visita visitaFiltrada : getVisitasByFechaYAfiliado( fechaVisitaSinHora,visita.nroAfiliado, listaVisitas)) {
					Frecuencia frecuencia2=getFrecuenciaByNroOp(listafrecuencias, frecuencia.nroOp, visitaFiltrada.tipoServicio);
					if (frecuencia2 !=null) {//si esto pasa significa que esa visita existe en la lista de frecuencias entonces hay que ponerla en la lista pero cuidando las ocurrencias
						//frecuencia2.
						toReturn+=";;;0;1;"+frecuencia2.codTipoServicio+";"+fechaVisitaSinHora+" 00:00"+";1;2;"+frecuencia2.nroOp +"\n";
					}
				}
			}
			/*
			for (int i = 0; i < 2; i++) {
				//for por cada visita de esa fecha
			toReturn+=";;;0;1;223101(tipo de servicio);20/12/2021 00:00 (fecha detallada);1;2;9919898006" +"\n";
			}
			toReturn+=REL_PRACTICASSOLICITADASXAMBULATORIO+"\n";
			for (int i = 0; i < 2; i++) {
				//for por cada visita de esa fecha
				toReturn+=";;;0;1;223101(tipo de servicio);20/12/2021 00:00 (fecha detallada);1;0;1"+"\n";
			}
			*/
		toReturn+=FIN_AMBULATORIO+"\n";
	}
	}
		return toReturn;
	}

	public static String buildBeneficio(List<Afiliado> listAfiliados) {
		String toReturn = BENEFICIO + "\n";
		for (Afiliado afiliado : listAfiliados) {
			/*
			 * removevos los 2 ultimos caracteres del nro de afiliacion para hacer coincidir
			 * con el formato del txt en beneficio
			 */
			if (afiliado.getNroAfiliacion() != null && afiliado.getNombreAfiliado() != null) {
				toReturn += ";;;" + afiliado.getNroAfiliacion().substring(0, afiliado.getNroAfiliacion().length() - 2);
				String apellido = afiliado.getNombreAfiliado().split(" ")[0];
				String nombre = afiliado.getNombreAfiliado().split(" ")[1];
				toReturn += ";10;" + apellido + ", " + nombre + ";1;"
						+ "fecha de afiliacion (falta porque esta en otro excel)\n";
			} else {
				//System.out.println("nro afiliacion: " + afiliado.getNroAfiliacion() + " nombre afiliado : "+ afiliado.getNombreAfiliado());
			}
		}

		return toReturn;
	}

	public static String buildAfiliado(List<Afiliado> listAfiliados) {
		// formato PIZARRO, LUISA TERESA;DNI;3777932;1;1;1;SARMIENTO;265;6;;;66988654;16/07/1938;F;;;015020869111;00;;;;;;;;
		String toReturn = AFILIADO + "\n";
		for (Afiliado afiliado : listAfiliados) {
				afiliado.setTipoDocumento("tipo documento  a confirmar");
				afiliado.setDni("nro dni a confirmar");
				afiliado.setDomicilio("algun domicilio a confirmar");
				afiliado.setNroCalle("nro de calle a confirmar");
				afiliado.setGenero("M");
				afiliado.setFechaNacimiento("22/06/1995");
				if(afiliado.getPiso()==null){
					afiliado.setPiso("");
				}
			if (afiliado.getNroAfiliacion() != null && afiliado.getNombreAfiliado() != null && afiliado.getTipoDocumento()!=null && afiliado.getDni() !=null && afiliado.getDomicilio() !=null) {
				String nroAfiliacionCortado=afiliado.getNroAfiliacion().substring(0, afiliado.getNroAfiliacion().length() - 2);
				String apellido = afiliado.getNombreAfiliado().split(" ")[0];
				String nombre = afiliado.getNombreAfiliado().split(" ")[1];
				toReturn += apellido + ", " + nombre+";"+afiliado.getTipoDocumento()+";"+afiliado.getDni()+";1;1;1;"+afiliado.getDomicilio()+";"+afiliado.getNroCalle()+";"+afiliado.getPiso()+";;;";
				toReturn+="nro para consultar;"+afiliado.getFechaNacimiento()+";"+afiliado.getGenero()+";;;"+nroAfiliacionCortado+";00;;;;;;;;\n";
			} else {
				//System.out.println("nro afiliacion: " + afiliado.getNroAfiliacion() + " nombre afiliado : "+ afiliado.getNombreAfiliado());
			}
		}

		return toReturn;
	}

	public static Map<String, Integer> buildMapTipoServicio() {
		Map<String, Integer> toReturn = new HashMap<String, Integer>();
		toReturn.put("Médica/o", 229101);
		toReturn.put("Enfermera/o", 223101);
		toReturn.put("Kinesióloga/o", 223101);
		toReturn.put("Fonoaudióloga/o", 220011);
		toReturn.put("Terapista Ocupacional", 221101);
		toReturn.put("Cuidador/a", 227101);
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
	List<Frecuencia> listaFrecuencias=new ArrayList<Frecuencia>();
	Integer rowCounter=0;
	for (Row row : sheet) {// rows
		Frecuencia frecuencia=new Frecuencia();
		for (Cell cell : row) {// columns
			if (columnsToTake.contains(cell.getColumnIndex()) ) {
			switch (cell.getCellType()) {
				case STRING:
					processFrecuencia(frecuencia,cell.getStringCellValue(),cell.getColumnIndex());
					break;
				case NUMERIC:
					DataFormatter formatter = new DataFormatter(); // creating formatter using the default locale
					String formatedData = formatter.formatCellValue(cell); // Returns the formatted value of a cell	// as a String regardless of the cell// type.
					processFrecuencia(frecuencia,formatedData,cell.getColumnIndex());
					break;
				case BOOLEAN:
				System.out.println("boolean : "+ cell.getColumnIndex());
					// txtContent += cell.getBooleanCellValue() + ";";
					break;
				case FORMULA:
				System.out.println("formula : "+ cell.getColumnIndex());
					// txtContent += cell.getStringCellValue() + ";";
					break;
				default:
				//System.out.println("default : "+ cell.getColumnIndex());
				//System.out.println("value:"+ cell.getStringCellValue());
			}
		}
		if(rowCounter!=0 && rowCounter!=1){
			listaFrecuencias.add(frecuencia);
		}
		}
		rowCounter++;
	}
	return listaFrecuencias;
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
							System.out.println("formula : "+ cell.getColumnIndex());
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
					listaAfiliados.add(afiliado);
					listaVisitas.add(visita);
				}
				i++;
			}
			file2.close();//cerramos el archivo para leer otro
			// System.out.println(txtContent);
			if (listaAfiliados != null && !listaAfiliados.isEmpty()) {
				txtContent += buildBeneficio(listaAfiliados);
				txtContent+= buildAfiliado(listaAfiliados);
			}
			if (listaVisitas!=null && !listaVisitas.isEmpty()) {
				List<Frecuencia> listaFrecuencias=processFrecuenciaAndOp();
				if (listaFrecuencias !=null && !listaFrecuencias.isEmpty()) {
					txtContent+=PRESTACIONES+"\n";
					txtContent+=buildAmbulatorio(listaVisitas,listaFrecuencias);	
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
