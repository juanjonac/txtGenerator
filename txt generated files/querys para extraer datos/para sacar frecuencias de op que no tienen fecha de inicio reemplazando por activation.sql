/*query para sacar tabla de frecuencias de op que no tienen  fecha de inicio reemplazando por fecha de activacion y calculando la fecha de vencimiento para los que no tienen*/
select  replace(header.patientId,"-","") as nroAfiliado, header.WO_id as nroOP ,type_of_service, frecuencias.codigoTXT,UPPER(frecuencias.frecuencia) frecuencia,frecuencias.ocurrencia,
serviceId  as estatico,"id frecuencia",
DATE_FORMAT( IFNULL(header.fechaInicio,header.activationDate),"%d/%m/%Y") as fechaInicio,/*si la fecha de inicio es null se pone la fecha de activacion */
DATE_FORMAT(IFNULL(header.endDate,DATE_ADD(header.activationDate, INTERVAL 3 MONTH)),"%d/%m/%Y") as fechaVencimiento,/*si la fecha de vencimiento es null se pone la fecha de activacion + 3 meses*/
DATE_FORMAT(STR_TO_DATE('06/30/2022', '%m /%d /%Y'),'%d/%m/%Y') as  fechaLimiteVencimiento ,
DATE_FORMAT(header.activationDate,"%d/%m/%Y") as fechaActivacion
/*las primeras 3 columnas pueden repetirse*/
from wo_headers as header, wo_details as detail , frecuenciasmatcher as frecuencias
where header.WO_id=detail.WO_originalId and frecuencias.tipoServicio=detail.type_of_service and frecuencias.codigoEstatico=detail.serviceId 
and IFNULL(header.fechaInicio,header.activationDate)  is not null/*con esto se filtran los que no estan en la planilla vtos , el concat es para matchear los beneficiarios que no tienen todos los numeros en la planilla vtos o de colores*/
/*and  replace(header.patientId,"-","")="90929095d00300"*/

group by header.patientId, nroOp,type_of_service,estatico

/*fecha de vencimiento convertido a fecha DATE_FORMAT(STR_TO_DATE(fechas.fechaVencimiento,'%d/%m/%Y'),'%d/%m/%Y') */
/*estos resultados hay que limpiarlos en el excel sacando las op ya vencidas*/