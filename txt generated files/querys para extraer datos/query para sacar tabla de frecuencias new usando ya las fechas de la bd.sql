select  replace(header.patientId,"-","") as nroAfiliado, header.WO_id as nroOP ,type_of_service, frecuencias.codigoTXT,UPPER(frecuencias.frecuencia) frecuencia,frecuencias.ocurrencia,
serviceId  as estatico,"id frecuencia",
DATE_FORMAT(header.fechaInicio,"%d/%m/%Y") as fechaInicio,
DATE_FORMAT(header.endDate,"%d/%m/%Y") as fechaVencimiento,
DATE_FORMAT(STR_TO_DATE('06/30/2022', '%m /%d /%Y'),'%d/%m/%Y') as  fechaLimiteVencimiento ,
DATE_FORMAT(header.activationDate,"%d/%m/%Y") as fechaActivacion
/*las primeras 3 columnas pueden repetirse*/
from wo_headers as header, wo_details as detail , frecuenciasmatcher as frecuencias
where header.WO_id=detail.WO_originalId and frecuencias.tipoServicio=detail.type_of_service and frecuencias.codigoEstatico=detail.serviceId 
and IFNULL(header.fechaInicio,"") !=""/*con esto se filtran los que no estan en la planilla vtos , el concat es para matchear los beneficiarios que no tienen todos los numeros en la planilla vtos o de colores*/
/*and  replace(header.patientId,"-","")="9092909500300"*/

group by header.patientId, nroOp,type_of_service,estatico

/*fecha de vencimiento convertido a fecha DATE_FORMAT(STR_TO_DATE(fechas.fechaVencimiento,'%d/%m/%Y'),'%d/%m/%Y') */
/*estos resultados hay que limpiarlos en el excel sacando las op ya vencidas*/