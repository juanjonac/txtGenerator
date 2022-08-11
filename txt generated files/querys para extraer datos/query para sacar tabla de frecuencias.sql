select  replace(header.patientId,"-","") as nroAfiliado, header.WO_id as nroOP ,type_of_service, frecuencias.codigoTXT,UPPER(frecuencias.frecuencia) frecuencia,frecuencias.ocurrencia,
serviceId  as estatico,"id frecuencia",
IFNULL((select fechas.fechaInicio from fechas_inicio_vto as fechas where fechas.beneficiario=replace(header.patientId,"-","") and fechas.nroOp=header.WO_id limit 1),'1/7/2022') as fechaInicio,
IFNULL((select fechas.fechaVencimiento from fechas_inicio_vto as fechas  where fechas.beneficiario=replace(header.patientId,"-","") and fechas.nroOp=header.WO_id  limit 1),'1/8/2022') as fechaVencimiento,
DATE_FORMAT(STR_TO_DATE('06/30/2022', '%m /%d /%Y'),'%d/%m/%Y') as  fechaLimiteVencimiento 
/*las primeras 3 columnas pueden repetirse*/
from wo_headers as header, wo_details as detail , frecuenciasmatcher as frecuencias
where header.WO_id=detail.WO_originalId and frecuencias.tipoServicio=detail.type_of_service and frecuencias.codigoEstatico=detail.serviceId 
and  IFNULL((select fechas.fechaVencimiento from fechas_inicio_vto as fechas  where replace(header.patientId,"-","")  like CONCAT('%', fechas.beneficiario, '%') and fechas.nroOp=header.WO_id  limit 1),'01/01/1900') !="01/01/1900"/*con esto se filtran los que no estan en la planilla vtos , el concat es para matchear los beneficiarios que no tienen todos los numeros en la planilla vtos o de colores*/
/*and  replace(header.patientId,"-","")="9092909500300"*/
group by header.patientId, nroOp,type_of_service,estatico

/*fecha de vencimiento convertido a fecha DATE_FORMAT(STR_TO_DATE(fechas.fechaVencimiento,'%d/%m/%Y'),'%d/%m/%Y') */
/*estos resultados hay que limpiarlos en el excel sacando las op ya vencidas*/